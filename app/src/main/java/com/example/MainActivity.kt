package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.automirrored.outlined.LibraryBooks
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SortByAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.content.EncyclopediaContentPipeline
import com.example.ui.components.RandomDiscoveryFab
import com.example.ui.screens.ArticleReaderScreen
import com.example.ui.screens.CategoryDetailScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.IndexScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.SavedScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.theme.MindtrapTheme
import com.example.viewmodel.MainDestination
import com.example.viewmodel.MindtrapViewModel
import com.example.viewmodel.ScreenState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val viewModel: MindtrapViewModel = viewModel(
                factory = MindtrapViewModel.provideFactory(context)
            )
            MindtrapApp(viewModel = viewModel)
        }
    }
}

@Composable
fun MindtrapApp(
    viewModel: MindtrapViewModel
) {
    val preferences by viewModel.preferencesState.collectAsStateWithLifecycle()
    val currentTab by viewModel.currentTab.collectAsStateWithLifecycle()
    val navigationStack by viewModel.navigationStack.collectAsStateWithLifecycle()
    val currentScreen = navigationStack.lastOrNull() ?: ScreenState.MainTabs

    val universalSearchQuery by viewModel.universalSearchQuery.collectAsStateWithLifecycle()
    val searchHistory by viewModel.searchHistory.collectAsStateWithLifecycle()
    val categorySearchQuery by viewModel.categorySearchQuery.collectAsStateWithLifecycle()
    val categoryReadFilter by viewModel.categoryReadFilter.collectAsStateWithLifecycle()
    val categoryDifficultyFilter by viewModel.categoryDifficultyFilter.collectAsStateWithLifecycle()
    val selectedSubcategory by viewModel.selectedSubcategory.collectAsStateWithLifecycle()

    val indexSearchQuery by viewModel.indexSearchQuery.collectAsStateWithLifecycle()
    val indexLetterFilter by viewModel.indexLetterFilter.collectAsStateWithLifecycle()
    val indexCategoryFilter by viewModel.indexCategoryFilter.collectAsStateWithLifecycle()
    val indexReadFilter by viewModel.indexReadFilter.collectAsStateWithLifecycle()
    val indexDifficultyFilter by viewModel.indexDifficultyFilter.collectAsStateWithLifecycle()

    val readArticleIds by viewModel.readArticleIds.collectAsStateWithLifecycle()
    val todayReadCount by viewModel.todayReadCount.collectAsStateWithLifecycle()
    val bookmarkedArticleIds by viewModel.bookmarkedArticleIds.collectAsStateWithLifecycle()
    val bookmarkedArticles by viewModel.bookmarkedArticles.collectAsStateWithLifecycle()
    val notesByArticleId by viewModel.notesByArticleId.collectAsStateWithLifecycle()
    val readingHistoryArticles by viewModel.readingHistoryArticles.collectAsStateWithLifecycle()
    val overallProgress by viewModel.overallProgress.collectAsStateWithLifecycle()
    val userCollections by viewModel.userCollections.collectAsStateWithLifecycle()
    val backupDialogJson by viewModel.backupDialogJson.collectAsStateWithLifecycle()
    val statusBannerMessage by viewModel.statusBannerMessage.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(statusBannerMessage) {
        statusBannerMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg)
            viewModel.clearStatusBanner()
        }
    }

    BackHandler(enabled = navigationStack.size > 1 || currentTab != MainDestination.HOME) {
        viewModel.navigateBack()
    }

    MindtrapTheme(
        themeMode = preferences.themeMode,
        readingFontSize = preferences.readingFontSize
    ) {
        val showRandomFab = currentScreen is ScreenState.MainTabs &&
            (currentTab == MainDestination.HOME || currentTab == MainDestination.LIBRARY)

        Scaffold(
            contentWindowInsets = WindowInsets.safeDrawing,
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                if (showRandomFab) {
                    RandomDiscoveryFab(
                        onClick = { viewModel.openRandomTopic() }
                    )
                }
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 0.dp,
                    modifier = Modifier.testTag("bottom_navigation_bar")
                ) {
                    MainDestination.entries.forEach { destination ->
                        val isSelected = currentTab == destination
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { viewModel.selectMainTab(destination) },
                            icon = {
                                Icon(
                                    imageVector = destination.icon(isSelected),
                                    contentDescription = destination.label
                                )
                            },
                            label = {
                                Text(
                                    text = destination.label,
                                    style = MaterialTheme.typography.labelMedium,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier.testTag("nav_tab_${destination.route}")
                        )
                    }
                }
            },
            containerColor = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Crossfade(
                    targetState = currentScreen,
                    label = "screen_transition"
                ) { screen ->
                    when (screen) {
                        is ScreenState.MainTabs -> {
                            when (currentTab) {
                                MainDestination.HOME -> {
                                    HomeScreen(
                                        searchQuery = universalSearchQuery,
                                        onSearchQueryChange = viewModel::updateUniversalSearchQuery,
                                        searchHistory = searchHistory,
                                        onClearSearchHistory = viewModel::clearSearchHistory,
                                        featuredArticle = viewModel.featuredArticle,
                                        continueReadingArticles = readingHistoryArticles,
                                        overallProgress = overallProgress,
                                        readArticleIds = readArticleIds,
                                        bookmarkedArticleIds = bookmarkedArticleIds,
                                        dailyReadingGoal = preferences.dailyReadingGoal,
                                        todayReadCount = todayReadCount,
                                        showEvidenceBadges = preferences.showEvidenceBadgesInLists,
                                        onOpenArticle = viewModel::openArticle,
                                        onOpenCategory = { cat -> viewModel.openCategory(cat, null) },
                                        onNavigateToLibrary = { viewModel.selectMainTab(MainDestination.LIBRARY) },
                                        onNavigateToIndex = { viewModel.selectMainTab(MainDestination.INDEX) },
                                        onToggleBookmark = viewModel::toggleBookmark,
                                        onToggleRead = viewModel::toggleArticleReadStatus
                                    )
                                }

                                MainDestination.LIBRARY -> {
                                    LibraryScreen(
                                        overallProgress = overallProgress,
                                        onOpenCategory = { cat, sub -> viewModel.openCategory(cat, sub) }
                                    )
                                }

                                MainDestination.INDEX -> {
                                    IndexScreen(
                                        searchQuery = indexSearchQuery,
                                        onSearchQueryChange = viewModel::updateIndexSearchQuery,
                                        selectedLetter = indexLetterFilter,
                                        onSelectLetter = viewModel::updateIndexLetterFilter,
                                        selectedCategory = indexCategoryFilter,
                                        onSelectCategory = viewModel::updateIndexCategoryFilter,
                                        readFilter = indexReadFilter,
                                        onSelectReadFilter = viewModel::updateIndexReadFilter,
                                        difficultyFilter = indexDifficultyFilter,
                                        onSelectDifficultyFilter = viewModel::updateIndexDifficultyFilter,
                                        readArticleIds = readArticleIds,
                                        bookmarkedArticleIds = bookmarkedArticleIds,
                                        showEvidenceBadges = preferences.showEvidenceBadgesInLists,
                                        onOpenArticle = viewModel::openArticle,
                                        onToggleBookmark = viewModel::toggleBookmark,
                                        onToggleRead = viewModel::toggleArticleReadStatus
                                    )
                                }

                                MainDestination.SAVED -> {
                                    SavedScreen(
                                        bookmarkedArticles = bookmarkedArticles,
                                        notesByArticleId = notesByArticleId,
                                        userCollections = userCollections,
                                        readArticleIds = readArticleIds,
                                        bookmarkedArticleIds = bookmarkedArticleIds,
                                        showEvidenceBadges = preferences.showEvidenceBadgesInLists,
                                        onOpenArticle = viewModel::openArticle,
                                        onToggleBookmark = viewModel::toggleBookmark,
                                        onToggleRead = viewModel::toggleArticleReadStatus,
                                        onCreateCollection = viewModel::createCollection,
                                        onDeleteCollection = viewModel::deleteCollection,
                                        onRemoveFromCollection = { colId, artId ->
                                            viewModel.toggleArticleInCollection(colId, artId, true)
                                        }
                                    )
                                }

                                MainDestination.SETTINGS -> {
                                    SettingsScreen(
                                        preferences = preferences,
                                        overallProgress = overallProgress,
                                        bookmarksCount = bookmarkedArticleIds.size,
                                        notesCount = notesByArticleId.size,
                                        collectionsCount = userCollections.size,
                                        exportJsonText = backupDialogJson,
                                        onSetThemeMode = viewModel::setThemeMode,
                                        onSetFontSize = viewModel::setReadingFontSize,
                                        onSetShowEvidenceBadges = viewModel::setShowEvidenceBadges,
                                        onSetDailyReadingGoal = viewModel::setDailyReadingGoal,
                                        onPrepareExport = viewModel::prepareExportJson,
                                        onDismissExportDialog = viewModel::dismissBackupDialog,
                                        onImportJson = { json -> viewModel.importBackupJson(json) },
                                        onResetAllPersonalData = viewModel::resetAllPersonalData
                                    )
                                }
                            }
                        }

                        is ScreenState.CategoryDetail -> {
                            CategoryDetailScreen(
                                category = screen.category,
                                searchQuery = categorySearchQuery,
                                onSearchQueryChange = viewModel::updateCategorySearchQuery,
                                selectedSubcategory = selectedSubcategory,
                                onSelectSubcategory = viewModel::updateSelectedSubcategory,
                                readFilter = categoryReadFilter,
                                onSelectReadFilter = viewModel::updateCategoryReadFilter,
                                difficultyFilter = categoryDifficultyFilter,
                                onSelectDifficultyFilter = viewModel::updateCategoryDifficultyFilter,
                                readArticleIds = readArticleIds,
                                bookmarkedArticleIds = bookmarkedArticleIds,
                                showEvidenceBadges = preferences.showEvidenceBadgesInLists,
                                onOpenArticle = viewModel::openArticle,
                                onToggleBookmark = viewModel::toggleBookmark,
                                onToggleRead = viewModel::toggleArticleReadStatus,
                                onBack = { viewModel.navigateBack() }
                            )
                        }

                        is ScreenState.ArticleReader -> {
                            val article = EncyclopediaContentPipeline.getArticle(screen.articleId)
                                ?: viewModel.featuredArticle
                            ArticleReaderScreen(
                                article = article,
                                isRead = article.id in readArticleIds,
                                readArticleIds = readArticleIds,
                                isBookmarked = article.id in bookmarkedArticleIds,
                                savedNoteText = notesByArticleId[article.id]?.noteText ?: "",
                                userCollections = userCollections,
                                currentFontSize = preferences.readingFontSize,
                                onChangeFontSize = viewModel::setReadingFontSize,
                                onToggleRead = { viewModel.toggleArticleReadStatus(article.id) },
                                onToggleBookmark = { viewModel.toggleBookmark(article.id) },
                                onSaveNote = { text -> viewModel.saveNote(article.id, text) },
                                onCreateCollection = viewModel::createCollection,
                                onToggleArticleInCollection = viewModel::toggleArticleInCollection,
                                onOpenRelatedArticle = viewModel::openArticle,
                                onOpenCategory = { cat -> viewModel.openCategory(cat, null) },
                                onSurpriseMeAgain = viewModel::openRandomTopic,
                                onBack = { viewModel.navigateBack() }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun MainDestination.icon(selected: Boolean): ImageVector {
    return when (this) {
        MainDestination.HOME -> if (selected) Icons.Filled.Home else Icons.Outlined.Home
        MainDestination.LIBRARY -> if (selected) Icons.AutoMirrored.Filled.LibraryBooks else Icons.AutoMirrored.Outlined.LibraryBooks
        MainDestination.INDEX -> if (selected) Icons.Filled.SortByAlpha else Icons.Outlined.SortByAlpha
        MainDestination.SAVED -> if (selected) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder
        MainDestination.SETTINGS -> if (selected) Icons.Filled.Settings else Icons.Outlined.Settings
    }
}
