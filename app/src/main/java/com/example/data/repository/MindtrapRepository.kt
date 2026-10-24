package com.example.data.repository

import com.example.data.content.EncyclopediaContentPipeline
import com.example.data.local.ArticleNoteEntity
import com.example.data.local.ArticleReadStatusEntity
import com.example.data.local.BookmarkEntity
import com.example.data.local.CollectionArticleCrossRef
import com.example.data.local.MindtrapDao
import com.example.data.local.PreferencesManager
import com.example.data.local.ReadingHistoryEntity
import com.example.data.local.SearchHistoryEntity
import com.example.data.local.UserCollectionEntity
import com.example.data.local.UserPreferencesState
import com.example.model.CategoryProgress
import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.OverallProgress
import com.example.model.ReviewStatus
import com.example.ui.theme.ReadingFontSize
import com.example.ui.theme.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import org.json.JSONObject

data class UserCollectionWithArticles(
    val collection: UserCollectionEntity,
    val articles: List<ConceptArticle>
)

data class BackupImportResult(
    val success: Boolean,
    val message: String,
    val readImported: Int = 0,
    val bookmarksImported: Int = 0,
    val notesImported: Int = 0,
    val collectionsImported: Int = 0
)

class MindtrapRepository(
    private val dao: MindtrapDao,
    private val preferencesManager: PreferencesManager
) {
    val allArticles: List<ConceptArticle>
        get() = EncyclopediaContentPipeline.allArticles

    val preferencesFlow: Flow<UserPreferencesState> = preferencesManager.preferencesFlow

    val readArticleIdsFlow: Flow<Set<String>> = dao.observeReadArticles().map { list ->
        val validIds = EncyclopediaContentPipeline.articleById.keys
        list.filter { it.isRead && it.articleId in validIds }.map { it.articleId }.toSet()
    }

    val todayReadCountFlow: Flow<Int> = dao.observeReadArticles().map { list ->
        val validIds = EncyclopediaContentPipeline.articleById.keys
        val dayCutoff = System.currentTimeMillis() - (24L * 60L * 60L * 1000L)
        list.count { it.isRead && it.articleId in validIds && it.updatedAt >= dayCutoff }
    }

    val bookmarkedArticleIdsFlow: Flow<Set<String>> = dao.observeBookmarks().map { list ->
        list.map { it.articleId }.toSet()
    }

    val bookmarkedArticlesFlow: Flow<List<ConceptArticle>> = dao.observeBookmarks().map { list ->
        list.mapNotNull { EncyclopediaContentPipeline.getArticle(it.articleId) }
    }

    val notesByArticleIdFlow: Flow<Map<String, ArticleNoteEntity>> = dao.observeAllNotes().map { list ->
        list.filter { it.noteText.isNotBlank() }.associateBy { it.articleId }
    }

    val readingHistoryArticlesFlow: Flow<List<ConceptArticle>> = dao.observeReadingHistory().map { list ->
        list.mapNotNull { EncyclopediaContentPipeline.getArticle(it.articleId) }
    }

    val searchHistoryFlow: Flow<List<String>> = dao.observeSearchHistory().map { list ->
        list.map { it.query }
    }

    val overallProgressFlow: Flow<OverallProgress> = readArticleIdsFlow.map { readIds ->
        val all = EncyclopediaContentPipeline.allArticles
        val breakdown = CollectionCategory.entries.map { category ->
            val primaryArticles = EncyclopediaContentPipeline.getArticlesForCategory(category, includeCrossReferences = false)
            val allCategoryMemberships = EncyclopediaContentPipeline.getArticlesForCategory(category, includeCrossReferences = true)
            val crossRefCount = (allCategoryMemberships.size - primaryArticles.size).coerceAtLeast(0)
            val verifiedCount = allCategoryMemberships.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC }
            val awaitingCount = (allCategoryMemberships.size - verifiedCount).coerceAtLeast(0)
            val readCount = primaryArticles.count { it.id in readIds }
            CategoryProgress(
                category = category,
                totalArticles = primaryArticles.size,
                crossReferencedArticles = crossRefCount,
                verifiedArticles = verifiedCount,
                awaitingReviewArticles = awaitingCount,
                readArticles = readCount,
                targetArticles = 500
            )
        }
        val totalMemberships = breakdown.sumOf { it.totalCategoryMemberships }
        val verifiedUnique = all.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC }
        val awaitingUnique = (all.size - verifiedUnique).coerceAtLeast(0)
        OverallProgress(
            totalArticles = all.size,
            totalCategoryMemberships = totalMemberships,
            verifiedArticles = verifiedUnique,
            awaitingReviewArticles = awaitingUnique,
            readArticles = all.count { it.id in readIds },
            overallTargetMemberships = 7500,
            categoryBreakdown = breakdown
        )
    }

    fun observeUserCollectionsWithArticles(): Flow<List<UserCollectionWithArticles>> {
        return kotlinx.coroutines.flow.combine(
            dao.observeUserCollections(),
            dao.observeAllCollectionCrossRefs()
        ) { collections, crossRefs ->
            val refsByCollection = crossRefs.groupBy { it.collectionId }
            collections.map { col ->
                val refs = refsByCollection[col.collectionId] ?: emptyList()
                val articles = refs.mapNotNull { EncyclopediaContentPipeline.getArticle(it.articleId) }
                UserCollectionWithArticles(collection = col, articles = articles)
            }
        }
    }

    // --- Manual Reading Status (Never auto-marked on open) ---
    suspend fun setArticleReadStatus(articleId: String, isRead: Boolean) {
        dao.upsertReadStatus(
            ArticleReadStatusEntity(
                articleId = articleId,
                isRead = isRead,
                updatedAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun toggleArticleReadStatus(articleId: String, currentlyRead: Boolean) {
        setArticleReadStatus(articleId, !currentlyRead)
    }

    // --- Reading History (Separated from Read Status) ---
    suspend fun recordArticleOpened(articleId: String) {
        val existing = dao.getHistoryForArticle(articleId)
        val nextCount = (existing?.openCount ?: 0) + 1
        dao.upsertReadingHistory(
            ReadingHistoryEntity(
                articleId = articleId,
                lastOpenedAt = System.currentTimeMillis(),
                openCount = nextCount
            )
        )
    }

    // --- Search History ---
    suspend fun recordSearchQuery(query: String) {
        val trimmed = query.trim()
        if (trimmed.length >= 2) {
            dao.upsertSearchQuery(
                SearchHistoryEntity(
                    query = trimmed,
                    searchedAt = System.currentTimeMillis()
                )
            )
        }
    }

    suspend fun deleteSearchQuery(query: String) {
        dao.deleteSearchQuery(query)
    }

    suspend fun clearSearchHistory() {
        dao.clearSearchHistory()
    }

    // --- Bookmarks ---
    suspend fun toggleBookmark(articleId: String, currentlyBookmarked: Boolean) {
        if (currentlyBookmarked) {
            dao.removeBookmark(articleId)
        } else {
            dao.insertBookmark(BookmarkEntity(articleId = articleId))
        }
    }

    // --- Personal Notes ---
    suspend fun saveArticleNote(articleId: String, text: String) {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) {
            dao.deleteNote(articleId)
        } else {
            dao.upsertNote(
                ArticleNoteEntity(
                    articleId = articleId,
                    noteText = trimmed,
                    updatedAt = System.currentTimeMillis()
                )
            )
        }
    }

    // --- User Collections ---
    suspend fun createUserCollection(name: String, description: String): Long {
        return dao.insertUserCollection(
            UserCollectionEntity(
                name = name.trim(),
                description = description.trim()
            )
        )
    }

    suspend fun deleteUserCollection(collectionId: Long) {
        dao.removeUserCollectionCompletely(collectionId)
    }

    suspend fun addArticleToUserCollection(collectionId: Long, articleId: String) {
        dao.insertCollectionCrossRef(
            CollectionArticleCrossRef(
                collectionId = collectionId,
                articleId = articleId
            )
        )
    }

    suspend fun removeArticleFromUserCollection(collectionId: Long, articleId: String) {
        dao.removeArticleFromCollection(collectionId, articleId)
    }

    // --- Theme & Reading Preferences ---
    suspend fun setThemeMode(mode: ThemeMode) = preferencesManager.setThemeMode(mode)
    suspend fun setReadingFontSize(size: ReadingFontSize) = preferencesManager.setReadingFontSize(size)
    suspend fun setShowEvidenceBadges(show: Boolean) = preferencesManager.setShowEvidenceBadges(show)
    suspend fun setExpandExamplesByDefault(expand: Boolean) = preferencesManager.setExpandExamplesByDefault(expand)
    suspend fun setDailyReadingGoal(goal: Int) = preferencesManager.setDailyReadingGoal(goal)

    // --- Local Data Management (Export, Import & Reset) ---
    suspend fun exportPersonalDataJson(): String {
        val root = JSONObject()
        root.put("schemaVersion", 2)
        root.put("app", "MINDTRAP")
        root.put("exportedAt", System.currentTimeMillis())

        val readArray = JSONArray()
        for (status in dao.getAllReadStatuses().filter { it.isRead }) {
            val obj = JSONObject()
            obj.put("articleId", status.articleId)
            obj.put("updatedAt", status.updatedAt)
            readArray.put(obj)
        }
        root.put("readArticles", readArray)

        val bookmarksArray = JSONArray()
        for (bm in dao.getAllBookmarks()) {
            val obj = JSONObject()
            obj.put("articleId", bm.articleId)
            obj.put("savedAt", bm.savedAt)
            bookmarksArray.put(obj)
        }
        root.put("bookmarks", bookmarksArray)

        val notesArray = JSONArray()
        for (note in dao.getAllNotes()) {
            val obj = JSONObject()
            obj.put("articleId", note.articleId)
            obj.put("noteText", note.noteText)
            obj.put("updatedAt", note.updatedAt)
            notesArray.put(obj)
        }
        root.put("notes", notesArray)

        val collectionsArray = JSONArray()
        val allCols = dao.getAllUserCollections()
        val allRefs = dao.getAllCollectionCrossRefs().groupBy { it.collectionId }
        for (col in allCols) {
            val obj = JSONObject()
            obj.put("name", col.name)
            obj.put("description", col.description)
            val artIds = JSONArray()
            (allRefs[col.collectionId] ?: emptyList()).forEach { artIds.put(it.articleId) }
            obj.put("articleIds", artIds)
            collectionsArray.put(obj)
        }
        root.put("userCollections", collectionsArray)

        return root.toString(2)
    }

    suspend fun importPersonalDataJson(rawJson: String): BackupImportResult {
        return try {
            val root = JSONObject(rawJson.trim())
            if (root.optString("app") != "MINDTRAP" && !root.has("readArticles") && !root.has("bookmarks") && !root.has("notes")) {
                return BackupImportResult(
                    success = false,
                    message = "Invalid backup format: missing MINDTRAP backup fields."
                )
            }

            val validArticleIds = EncyclopediaContentPipeline.articleById.keys
            var readCount = 0
            var bookmarkCount = 0
            var noteCount = 0
            var collectionCount = 0

            val readArray = root.optJSONArray("readArticles")
            if (readArray != null) {
                val entities = mutableListOf<ArticleReadStatusEntity>()
                for (i in 0 until readArray.length()) {
                    val item = readArray.optJSONObject(i) ?: continue
                    val id = item.optString("articleId")
                    if (id in validArticleIds) {
                        entities.add(
                            ArticleReadStatusEntity(
                                articleId = id,
                                isRead = true,
                                updatedAt = item.optLong("updatedAt", System.currentTimeMillis())
                            )
                        )
                        readCount++
                    }
                }
                if (entities.isNotEmpty()) {
                    dao.upsertAllReadStatuses(entities)
                }
            }

            val bookmarksArray = root.optJSONArray("bookmarks")
            if (bookmarksArray != null) {
                val entities = mutableListOf<BookmarkEntity>()
                for (i in 0 until bookmarksArray.length()) {
                    val item = bookmarksArray.optJSONObject(i) ?: continue
                    val id = item.optString("articleId")
                    if (id in validArticleIds) {
                        entities.add(
                            BookmarkEntity(
                                articleId = id,
                                savedAt = item.optLong("savedAt", System.currentTimeMillis())
                            )
                        )
                        bookmarkCount++
                    }
                }
                if (entities.isNotEmpty()) {
                    dao.insertAllBookmarks(entities)
                }
            }

            val notesArray = root.optJSONArray("notes")
            if (notesArray != null) {
                val entities = mutableListOf<ArticleNoteEntity>()
                for (i in 0 until notesArray.length()) {
                    val item = notesArray.optJSONObject(i) ?: continue
                    val id = item.optString("articleId")
                    val text = item.optString("noteText").trim()
                    if (id in validArticleIds && text.isNotEmpty()) {
                        entities.add(
                            ArticleNoteEntity(
                                articleId = id,
                                noteText = text,
                                updatedAt = item.optLong("updatedAt", System.currentTimeMillis())
                            )
                        )
                        noteCount++
                    }
                }
                if (entities.isNotEmpty()) {
                    dao.upsertAllNotes(entities)
                }
            }

            val collectionsArray = root.optJSONArray("userCollections")
            if (collectionsArray != null) {
                val existingNames = dao.getAllUserCollections().associateBy { it.name.lowercase() }
                for (i in 0 until collectionsArray.length()) {
                    val item = collectionsArray.optJSONObject(i) ?: continue
                    val name = item.optString("name").trim()
                    if (name.isEmpty()) continue
                    val desc = item.optString("description").trim()
                    val colId = existingNames[name.lowercase()]?.collectionId
                        ?: dao.insertUserCollection(UserCollectionEntity(name = name, description = desc))
                    val artIds = item.optJSONArray("articleIds")
                    if (artIds != null) {
                        for (j in 0 until artIds.length()) {
                            val artId = artIds.optString(j)
                            if (artId in validArticleIds) {
                                dao.insertCollectionCrossRef(CollectionArticleCrossRef(collectionId = colId, articleId = artId))
                            }
                        }
                    }
                    collectionCount++
                }
            }

            BackupImportResult(
                success = true,
                message = "Imported $readCount read statuses, $bookmarkCount bookmarks, $noteCount notes, and $collectionCount collections.",
                readImported = readCount,
                bookmarksImported = bookmarkCount,
                notesImported = noteCount,
                collectionsImported = collectionCount
            )
        } catch (e: Exception) {
            BackupImportResult(
                success = false,
                message = "Could not parse backup JSON: ${e.localizedMessage ?: "Invalid syntax"}"
            )
        }
    }

    suspend fun clearAllPersonalData() {
        dao.clearAllReadStatuses()
        dao.clearAllBookmarks()
        dao.clearAllNotes()
        dao.clearReadingHistory()
        dao.clearSearchHistory()
        dao.clearAllCollectionCrossRefs()
        dao.clearAllUserCollections()
    }
}
