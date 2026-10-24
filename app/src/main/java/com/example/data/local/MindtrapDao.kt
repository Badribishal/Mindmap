package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface MindtrapDao {

    // --- Reading Status ---
    @Query("SELECT * FROM article_read_status WHERE isRead = 1")
    fun observeReadArticles(): Flow<List<ArticleReadStatusEntity>>

    @Query("SELECT * FROM article_read_status")
    suspend fun getAllReadStatuses(): List<ArticleReadStatusEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertReadStatus(entity: ArticleReadStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAllReadStatuses(entities: List<ArticleReadStatusEntity>)

    @Query("DELETE FROM article_read_status")
    suspend fun clearAllReadStatuses()

    // --- Bookmarks ---
    @Query("SELECT * FROM bookmarks ORDER BY savedAt DESC")
    fun observeBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT * FROM bookmarks")
    suspend fun getAllBookmarks(): List<BookmarkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBookmarks(bookmarks: List<BookmarkEntity>)

    @Query("DELETE FROM bookmarks WHERE articleId = :articleId")
    suspend fun removeBookmark(articleId: String)

    @Query("DELETE FROM bookmarks")
    suspend fun clearAllBookmarks()

    // --- Personal Notes ---
    @Query("SELECT * FROM article_notes ORDER BY updatedAt DESC")
    fun observeAllNotes(): Flow<List<ArticleNoteEntity>>

    @Query("SELECT * FROM article_notes")
    suspend fun getAllNotes(): List<ArticleNoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNote(note: ArticleNoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAllNotes(notes: List<ArticleNoteEntity>)

    @Query("DELETE FROM article_notes WHERE articleId = :articleId")
    suspend fun deleteNote(articleId: String)

    @Query("DELETE FROM article_notes")
    suspend fun clearAllNotes()

    // --- Reading History ---
    @Query("SELECT * FROM reading_history ORDER BY lastOpenedAt DESC")
    fun observeReadingHistory(): Flow<List<ReadingHistoryEntity>>

    @Query("SELECT * FROM reading_history WHERE articleId = :articleId LIMIT 1")
    suspend fun getHistoryForArticle(articleId: String): ReadingHistoryEntity?

    @Query("SELECT * FROM reading_history")
    suspend fun getAllHistory(): List<ReadingHistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertReadingHistory(history: ReadingHistoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAllHistory(histories: List<ReadingHistoryEntity>)

    @Query("DELETE FROM reading_history")
    suspend fun clearReadingHistory()

    // --- Search History ---
    @Query("SELECT * FROM search_history ORDER BY searchedAt DESC LIMIT 12")
    fun observeSearchHistory(): Flow<List<SearchHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSearchQuery(entry: SearchHistoryEntity)

    @Query("DELETE FROM search_history WHERE query = :query")
    suspend fun deleteSearchQuery(query: String)

    @Query("DELETE FROM search_history")
    suspend fun clearSearchHistory()

    // --- User-Created Collections ---
    @Query("SELECT * FROM user_collections ORDER BY createdAt DESC")
    fun observeUserCollections(): Flow<List<UserCollectionEntity>>

    @Query("SELECT * FROM user_collections")
    suspend fun getAllUserCollections(): List<UserCollectionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserCollection(collection: UserCollectionEntity): Long

    @Query("DELETE FROM user_collections WHERE collectionId = :collectionId")
    suspend fun deleteUserCollection(collectionId: Long)

    @Query("DELETE FROM collection_articles WHERE collectionId = :collectionId")
    suspend fun deleteCrossRefsForCollection(collectionId: Long)

    @Query("SELECT * FROM collection_articles")
    fun observeAllCollectionCrossRefs(): Flow<List<CollectionArticleCrossRef>>

    @Query("SELECT * FROM collection_articles")
    suspend fun getAllCollectionCrossRefs(): List<CollectionArticleCrossRef>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollectionCrossRef(crossRef: CollectionArticleCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCollectionCrossRefs(crossRefs: List<CollectionArticleCrossRef>)

    @Query("DELETE FROM collection_articles WHERE collectionId = :collectionId AND articleId = :articleId")
    suspend fun removeArticleFromCollection(collectionId: Long, articleId: String)

    @Query("DELETE FROM user_collections")
    suspend fun clearAllUserCollections()

    @Query("DELETE FROM collection_articles")
    suspend fun clearAllCollectionCrossRefs()

    @Transaction
    suspend fun removeUserCollectionCompletely(collectionId: Long) {
        deleteCrossRefsForCollection(collectionId)
        deleteUserCollection(collectionId)
    }
}
