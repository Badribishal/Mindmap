package com.example.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.content.EncyclopediaContentPipeline
import com.example.data.local.ArticleNoteEntity
import com.example.data.local.MindtrapDatabase
import com.example.data.local.PreferencesManager
import com.example.data.local.UserPreferencesState
import com.example.data.repository.BackupImportResult
import com.example.data.repository.MindtrapRepository
import com.example.data.repository.UserCollectionWithArticles
import com.example.model.AuthoritativeSourceRegistryEntry
import com.example.model.CategoryProgress
import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.LearningPathway
import com.example.model.OverallProgress
import com.example.model.ReadFilter
import com.example.model.ReviewStatus
import com.example.ui.theme.ReadingFontSize
import com.example.ui.theme.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class MainDestination(val route: String, val label: String) {
    HOME("home", "Home"),
    LIBRARY("library", "Library"),
    INDEX("index", "Index"),
    SAVED("saved", "Saved"),
    SETTINGS("settings", "Settings")
}

sealed class ScreenState {
    data object MainTabs : ScreenState()
    data class CategoryDetail(
        val category: CollectionCategory,
        val initialSubcategory: String? = null
    ) : ScreenState()
    data class ArticleReader(
        val articleId: String
    ) : ScreenState()
}

class MindtrapViewModel(
    private val repository: MindtrapRepository
) : ViewModel() {

    // --- Navigation & Backstack ---
    private val _currentTab = MutableStateFlow(MainDestination.HOME)
    val currentTab: StateFlow<MainDestination> = _currentTab.asStateFlow()

    private val _navigationStack = MutableStateFlow<List<ScreenState>>(listOf(ScreenState.MainTabs))
    val navigationStack: StateFlow<List<ScreenState>> = _navigationStack.asStateFlow()

    val currentScreen: StateFlow<ScreenState> = MutableStateFlow<ScreenState>(ScreenState.MainTabs).also { flow ->
        viewModelScope.launch {
            _navigationStack.collect { stack ->
                flow.value = stack.lastOrNull() ?: ScreenState.MainTabs
            }
        }
    }

    // --- Search & Filter States ---
    private val _universalSearchQuery = MutableStateFlow("")
    val universalSearchQuery: StateFlow<String> = _universalSearchQuery.asStateFlow()

    private val _categorySearchQuery = MutableStateFlow("")
    val categorySearchQuery: StateFlow<String> = _categorySearchQuery.asStateFlow()

    private val _categoryReadFilter = MutableStateFlow(ReadFilter.ALL)
    val categoryReadFilter: StateFlow<ReadFilter> = _categoryReadFilter.asStateFlow()

    private val _categoryDifficultyFilter = MutableStateFlow<DifficultyLevel?>(null)
    val categoryDifficultyFilter: StateFlow<DifficultyLevel?> = _categoryDifficultyFilter.asStateFlow()

    private val _selectedSubcategory = MutableStateFlow<String?>(null)
    val selectedSubcategory: StateFlow<String?> = _selectedSubcategory.asStateFlow()

    private val _indexSearchQuery = MutableStateFlow("")
    val indexSearchQuery: StateFlow<String> = _indexSearchQuery.asStateFlow()

    private val _indexLetterFilter = MutableStateFlow<Char?>(null)
    val indexLetterFilter: StateFlow<Char?> = _indexLetterFilter.asStateFlow()

    private val _indexCategoryFilter = MutableStateFlow<CollectionCategory?>(null)
    val indexCategoryFilter: StateFlow<CollectionCategory?> = _indexCategoryFilter.asStateFlow()

    private val _indexReadFilter = MutableStateFlow(ReadFilter.ALL)
    val indexReadFilter: StateFlow<ReadFilter> = _indexReadFilter.asStateFlow()

    private val _indexDifficultyFilter = MutableStateFlow<DifficultyLevel?>(null)
    val indexDifficultyFilter: StateFlow<DifficultyLevel?> = _indexDifficultyFilter.asStateFlow()

    // --- Random Discovery Memory ---
    private var lastRandomArticleId: String? = null

    // --- Static Reference Data ---
    val learningPathways: List<LearningPathway>
        get() = EncyclopediaContentPipeline.learningPathways

    val authoritativeSources: List<AuthoritativeSourceRegistryEntry>
        get() = EncyclopediaContentPipeline.sourceRegistry

    // --- Reactive Data Streams ---
    val preferencesState: StateFlow<UserPreferencesState> = repository.preferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UserPreferencesState()
    )

    val readArticleIds: StateFlow<Set<String>> = repository.readArticleIdsFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    val todayReadCount: StateFlow<Int> = repository.todayReadCountFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )

    val bookmarkedArticleIds: StateFlow<Set<String>> = repository.bookmarkedArticleIdsFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    val bookmarkedArticles: StateFlow<List<ConceptArticle>> = repository.bookmarkedArticlesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val notesByArticleId: StateFlow<Map<String, ArticleNoteEntity>> = repository.notesByArticleIdFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyMap()
    )

    val readingHistoryArticles: StateFlow<List<ConceptArticle>> = repository.readingHistoryArticlesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val searchHistory: StateFlow<List<String>> = repository.searchHistoryFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val overallProgress: StateFlow<OverallProgress> = repository.overallProgressFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = OverallProgress(
            totalArticles = EncyclopediaContentPipeline.allArticles.size,
            totalCategoryMemberships = EncyclopediaContentPipeline.totalCategoryMembershipsCount,
            verifiedArticles = EncyclopediaContentPipeline.allArticles.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC },
            awaitingReviewArticles = 0,
            readArticles = 0,
            overallTargetMemberships = 7500,
            categoryBreakdown = CollectionCategory.entries.map { cat ->
                val primary = EncyclopediaContentPipeline.getArticlesForCategory(cat, false)
                val allInCat = EncyclopediaContentPipeline.getArticlesForCategory(cat, true)
                CategoryProgress(
                    category = cat,
                    totalArticles = primary.size,
                    crossReferencedArticles = (allInCat.size - primary.size).coerceAtLeast(0),
                    verifiedArticles = allInCat.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC },
                    awaitingReviewArticles = 0,
                    readArticles = 0,
                    targetArticles = 500
                )
            }
        )
    )

    val userCollections: StateFlow<List<UserCollectionWithArticles>> =
        repository.observeUserCollectionsWithArticles().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _backupDialogJson = MutableStateFlow<String?>(null)
    val backupDialogJson: StateFlow<String?> = _backupDialogJson.asStateFlow()

    private val _statusBannerMessage = MutableStateFlow<String?>(null)
    val statusBannerMessage: StateFlow<String?> = _statusBannerMessage.asStateFlow()

    val featuredArticle: ConceptArticle =
        EncyclopediaContentPipeline.getArticle("bias_confirmation")
            ?: EncyclopediaContentPipeline.allArticles.first()

    // --- Navigation Actions ---
    fun selectMainTab(tab: MainDestination) {
        _currentTab.value = tab
        _navigationStack.value = listOf(ScreenState.MainTabs)
    }

    fun openCategory(category: CollectionCategory, subcategory: String? = null) {
        _categorySearchQuery.value = ""
        _categoryReadFilter.value = ReadFilter.ALL
        _categoryDifficultyFilter.value = null
        _selectedSubcategory.value = subcategory
        _navigationStack.value = _navigationStack.value + ScreenState.CategoryDetail(category, subcategory)
    }

    /**
     * Opens an article and records it in Reading History.
     * CRITICAL REQUIREMENT: Opening an article MUST NOT automatically mark it as read.
     */
    fun openArticle(articleId: String) {
        val validArticle = EncyclopediaContentPipeline.getArticle(articleId) ?: return
        val activeSearch = _universalSearchQuery.value.trim().ifEmpty { _indexSearchQuery.value.trim() }
        viewModelScope.launch {
            repository.recordArticleOpened(validArticle.id)
            if (activeSearch.length >= 2) {
                repository.recordSearchQuery(activeSearch)
            }
        }
        val currentStack = _navigationStack.value
        val top = currentStack.lastOrNull()
        if (top is ScreenState.ArticleReader && top.articleId == validArticle.id) {
            return
        }
        _navigationStack.value = currentStack + ScreenState.ArticleReader(validArticle.id)
    }

    fun navigateBack(): Boolean {
        val currentStack = _navigationStack.value
        if (currentStack.size > 1) {
            _navigationStack.value = currentStack.dropLast(1)
            return true
        }
        if (_currentTab.value != MainDestination.HOME) {
            _currentTab.value = MainDestination.HOME
            return true
        }
        return false
    }

    // --- Random Topic Discovery ---
    fun openRandomTopic() {
        val currentArticleInReader = (_navigationStack.value.lastOrNull() as? ScreenState.ArticleReader)?.articleId
        val avoidId = currentArticleInReader ?: lastRandomArticleId
        val selected = EncyclopediaContentPipeline.selectRandomTopic(
            readArticleIds = readArticleIds.value,
            lastSelectedArticleId = avoidId
        )
        lastRandomArticleId = selected.id
        openArticle(selected.id)
    }

    // --- Search & Filter Setters ---
    fun updateUniversalSearchQuery(query: String) {
        _universalSearchQuery.value = query
    }

    fun submitSearchQueryToHistory(query: String) {
        viewModelScope.launch {
            repository.recordSearchQuery(query)
        }
    }

    fun deleteSearchHistoryItem(query: String) {
        viewModelScope.launch {
            repository.deleteSearchQuery(query)
        }
    }

    fun clearSearchHistory() {
        viewModelScope.launch {
            repository.clearSearchHistory()
        }
    }

    fun updateCategorySearchQuery(query: String) {
        _categorySearchQuery.value = query
    }

    fun updateCategoryReadFilter(filter: ReadFilter) {
        _categoryReadFilter.value = filter
    }

    fun updateCategoryDifficultyFilter(difficulty: DifficultyLevel?) {
        _categoryDifficultyFilter.value = difficulty
    }

    fun updateSelectedSubcategory(subcategory: String?) {
        _selectedSubcategory.value = subcategory
    }

    fun updateIndexSearchQuery(query: String) {
        _indexSearchQuery.value = query
    }

    fun updateIndexLetterFilter(letter: Char?) {
        _indexLetterFilter.value = if (_indexLetterFilter.value == letter) null else letter
    }

    fun updateIndexCategoryFilter(category: CollectionCategory?) {
        _indexCategoryFilter.value = category
    }

    fun updateIndexReadFilter(filter: ReadFilter) {
        _indexReadFilter.value = filter
    }

    fun updateIndexDifficultyFilter(difficulty: DifficultyLevel?) {
        _indexDifficultyFilter.value = difficulty
    }

    // --- Reading Status, Bookmarks, Notes & Collections ---
    fun toggleArticleReadStatus(articleId: String) {
        val currentlyRead = articleId in readArticleIds.value
        viewModelScope.launch {
            repository.toggleArticleReadStatus(articleId, currentlyRead)
        }
    }

    fun setArticleReadStatus(articleId: String, isRead: Boolean) {
        viewModelScope.launch {
            repository.setArticleReadStatus(articleId, isRead)
        }
    }

    fun toggleBookmark(articleId: String) {
        val currentlyBookmarked = articleId in bookmarkedArticleIds.value
        viewModelScope.launch {
            repository.toggleBookmark(articleId, currentlyBookmarked)
        }
    }

    fun saveNote(articleId: String, noteText: String) {
        viewModelScope.launch {
            repository.saveArticleNote(articleId, noteText)
            _statusBannerMessage.value = if (noteText.isBlank()) "Personal note cleared." else "Personal note saved locally."
        }
    }

    fun createCollection(name: String, description: String) {
        if (name.isBlank()) return
        viewModelScope.launch {
            repository.createUserCollection(name, description)
            _statusBannerMessage.value = "Collection '${name.trim()}' created."
        }
    }

    fun deleteCollection(collectionId: Long) {
        viewModelScope.launch {
            repository.deleteUserCollection(collectionId)
            _statusBannerMessage.value = "Collection removed."
        }
    }

    fun toggleArticleInCollection(collectionId: Long, articleId: String, currentlyInCollection: Boolean) {
        viewModelScope.launch {
            if (currentlyInCollection) {
                repository.removeArticleFromUserCollection(collectionId, articleId)
            } else {
                repository.addArticleToUserCollection(collectionId, articleId)
            }
        }
    }

    // --- Preferences & Data Management ---
    fun setThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            repository.setThemeMode(mode)
        }
    }

    fun setReadingFontSize(size: ReadingFontSize) {
        viewModelScope.launch {
            repository.setReadingFontSize(size)
        }
    }

    fun setShowEvidenceBadges(show: Boolean) {
        viewModelScope.launch {
            repository.setShowEvidenceBadges(show)
        }
    }

    fun setExpandExamplesByDefault(expand: Boolean) {
        viewModelScope.launch {
            repository.setExpandExamplesByDefault(expand)
        }
    }

    fun setDailyReadingGoal(goal: Int) {
        viewModelScope.launch {
            repository.setDailyReadingGoal(goal)
        }
    }

    fun prepareExportJson() {
        viewModelScope.launch {
            _backupDialogJson.value = repository.exportPersonalDataJson()
        }
    }

    fun dismissBackupDialog() {
        _backupDialogJson.value = null
    }

    fun importBackupJson(jsonString: String, onResult: (BackupImportResult) -> Unit = {}) {
        viewModelScope.launch {
            val result = repository.importPersonalDataJson(jsonString)
            _statusBannerMessage.value = result.message
            onResult(result)
        }
    }

    fun resetAllPersonalData() {
        viewModelScope.launch {
            repository.clearAllPersonalData()
            _statusBannerMessage.value = "All personal reading statuses, bookmarks, notes, search history, and collections have been reset."
        }
    }

    fun clearStatusBanner() {
        _statusBannerMessage.value = null
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val appContext = context.applicationContext
                    val db = MindtrapDatabase.getInstance(appContext)
                    val prefs = PreferencesManager(appContext)
                    val repo = MindtrapRepository(db.mindtrapDao(), prefs)
                    return MindtrapViewModel(repo) as T
                }
            }
        }
    }
}
