package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Route
import androidx.compose.material.icons.outlined.SearchOff
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.content.EncyclopediaContentPipeline
import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.LearningPathway
import com.example.model.OverallProgress
import com.example.ui.components.ArticleSummaryCard
import com.example.ui.components.CategoryCollectionCard
import com.example.ui.components.DifficultyBadge
import com.example.ui.components.EditorialSearchBar
import com.example.ui.components.EstimatedReadingTimeBadge
import com.example.ui.components.EvidenceBadge
import com.example.ui.components.ReadStatusBadge

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    searchHistory: List<String>,
    onClearSearchHistory: () -> Unit,
    featuredArticle: ConceptArticle,
    continueReadingArticles: List<ConceptArticle>,
    overallProgress: OverallProgress,
    readArticleIds: Set<String>,
    bookmarkedArticleIds: Set<String>,
    dailyReadingGoal: Int,
    todayReadCount: Int,
    showEvidenceBadges: Boolean,
    onOpenArticle: (String) -> Unit,
    onOpenCategory: (CollectionCategory) -> Unit,
    onNavigateToLibrary: () -> Unit,
    onNavigateToIndex: () -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleRead: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val searchResults = remember(searchQuery) {
        if (searchQuery.isBlank()) emptyList() else EncyclopediaContentPipeline.searchArticles(searchQuery)
    }

    val dailyTopic = remember(readArticleIds) {
        EncyclopediaContentPipeline.getDailyRecommendedArticle(readArticleIds)
    }

    val pathways = remember {
        EncyclopediaContentPipeline.learningPathways
    }

    val readAgainArticles = remember(readArticleIds) {
        EncyclopediaContentPipeline.allArticles.filter { it.id in readArticleIds }.take(6)
    }

    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen_list")
    ) {
        // 1. MINDTRAP Masthead Header with Subtle Cartographic Emblem
        item(key = "masthead") {
            EditorialMasthead(
                totalArticles = overallProgress.totalArticles,
                totalMemberships = overallProgress.totalCategoryMemberships
            )
        }

        // 2. Universal Search + Recent Search History
        item(key = "universal_search") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                EditorialSearchBar(
                    query = searchQuery,
                    onQueryChange = onSearchQueryChange,
                    placeholder = "Search fallacies, biases, situations, citations…",
                    testTag = "home_universal_search"
                )
                if (searchQuery.isBlank() && searchHistory.isNotEmpty()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.History,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Recent Searches",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        TextButton(onClick = onClearSearchHistory) {
                            Text("Clear History", style = MaterialTheme.typography.labelLarge, maxLines = 1, softWrap = false)
                        }
                    }
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(searchHistory, key = { "hist_q_$it" }) { pastQuery ->
                            SuggestionChip(
                                onClick = { onSearchQueryChange(pastQuery) },
                                label = { Text(pastQuery, style = MaterialTheme.typography.labelMedium, maxLines = 1, softWrap = false) }
                            )
                        }
                    }
                }
            }
        }

        // If user is actively searching, display Universal Search Results
        if (searchQuery.isNotBlank()) {
            item(key = "search_results_header") {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "SEARCH RESULTS (${searchResults.size})",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(onClick = { onSearchQueryChange("") }) {
                        Text("Clear", style = MaterialTheme.typography.labelLarge, maxLines = 1, softWrap = false)
                    }
                }
            }

            if (searchResults.isEmpty()) {
                item(key = "search_empty_state") {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.SearchOff,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(36.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "No matching concepts found for \"$searchQuery\"",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Try searching by everyday situations or try one of these foundational topics:",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                listOf("Confirmation", "Gaslighting", "Sunk Cost", "Straw Man", "Bayes", "Simpson").forEach { suggestion ->
                                    SuggestionChip(
                                        onClick = { onSearchQueryChange(suggestion) },
                                        label = { Text(suggestion, style = MaterialTheme.typography.labelMedium) }
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                items(searchResults, key = { "search_${it.id}" }) { article ->
                    ArticleSummaryCard(
                        article = article,
                        isRead = article.id in readArticleIds,
                        isBookmarked = article.id in bookmarkedArticleIds,
                        showEvidenceBadge = showEvidenceBadges,
                        onOpenArticle = { onOpenArticle(article.id) },
                        onToggleBookmark = { onToggleBookmark(article.id) },
                        onToggleRead = { onToggleRead(article.id) }
                    )
                }
            }
        } else {
            // 3. Reading Progress & 7,500-Target Transparency Overview Card
            item(key = "reading_progress_card") {
                ReadingProgressOverviewCard(
                    progress = overallProgress,
                    dailyReadingGoal = dailyReadingGoal,
                    todayReadCount = todayReadCount
                )
            }

            // 4. Daily Topic Recommendation (Rotates Daily, Prefers Unread)
            item(key = "daily_topic_recommendation") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Today,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "DAILY STUDY TOPIC",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (dailyTopic.id in readArticleIds) "Completed" else "Recommended Today",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                    FeaturedConceptCard(
                        article = dailyTopic,
                        isRead = dailyTopic.id in readArticleIds,
                        showEvidenceBadge = showEvidenceBadges,
                        onOpen = { onOpenArticle(dailyTopic.id) }
                    )
                }
            }

            // 5. Structured Learning Paths (15 Progressive Curricula)
            item(key = "structured_learning_paths") {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Outlined.Route,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "STRUCTURED LEARNING PATHS (15 CURRICULA)",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            Text(
                                text = "Progressive sequences from beginner foundations to advanced analysis",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("learning_pathways_row")
                    ) {
                        items(pathways, key = { it.id }) { pathway ->
                            LearningPathwayCard(
                                pathway = pathway,
                                readArticleIds = readArticleIds,
                                onOpenNextArticle = onOpenArticle,
                                onOpenCategory = onOpenCategory
                            )
                        }
                    }
                }
            }

            // 6. Continue Reading (Opened but Unread) & Starting Points
            item(key = "continue_reading_section") {
                val unreadOpened = continueReadingArticles.filter { it.id !in readArticleIds }
                val listToShow = if (unreadOpened.isNotEmpty()) {
                    unreadOpened.take(6)
                } else if (continueReadingArticles.isNotEmpty()) {
                    continueReadingArticles.take(6)
                } else {
                    EncyclopediaContentPipeline.allArticles.filter { it.id !in readArticleIds }.take(5)
                }
                val sectionTitle = when {
                    unreadOpened.isNotEmpty() -> "CONTINUE READING (IN PROGRESS)"
                    continueReadingArticles.isNotEmpty() -> "RECENTLY OPENED ENTRIES"
                    else -> "UNREAD STARTING POINTS"
                }

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = sectionTitle,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = onNavigateToIndex) {
                            Text("Full Index", style = MaterialTheme.typography.labelLarge, maxLines = 1, softWrap = false)
                        }
                    }

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(listToShow, key = { "cont_${it.id}" }) { article ->
                            ContinueReadingMiniCard(
                                article = article,
                                isRead = article.id in readArticleIds,
                                onClick = { onOpenArticle(article.id) }
                            )
                        }
                    }
                }
            }

            // 7. Read Again (Spaced Review of Completed Concepts)
            if (readAgainArticles.isNotEmpty()) {
                item(key = "read_again_section") {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "READ AGAIN · COMPLETED CONCEPTS FOR REVIEW",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(readAgainArticles, key = { "read_again_${it.id}" }) { article ->
                                ContinueReadingMiniCard(
                                    article = article,
                                    isRead = true,
                                    onClick = { onOpenArticle(article.id) }
                                )
                            }
                        }
                    }
                }
            }

            // 8. Browse All 15 Categories
            item(key = "browse_categories_header") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "BROWSE THE 15 COLLECTIONS",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Target: 500 entries per collection (7,500 total category memberships)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(
                        onClick = onNavigateToLibrary,
                        modifier = Modifier.testTag("home_view_all_collections_btn")
                    ) {
                        Text("Library", style = MaterialTheme.typography.labelLarge, maxLines = 1, softWrap = false)
                    }
                }
            }

            items(overallProgress.categoryBreakdown, key = { "home_cat_${it.category.id}" }) { catProgress ->
                CategoryCollectionCard(
                    progress = catProgress,
                    onClick = { onOpenCategory(catProgress.category) }
                )
            }
        }
    }
}

@Composable
private fun EditorialMasthead(
    totalArticles: Int,
    totalMemberships: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            val accentColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.14f)
            Canvas(
                modifier = Modifier
                    .matchParentSize()
            ) {
                val center = Offset(size.width * 0.88f, size.height * 0.5f)
                drawCircle(
                    color = accentColor,
                    radius = size.minDimension * 0.42f,
                    center = center,
                    style = Stroke(width = 1.5f)
                )
                drawCircle(
                    color = accentColor,
                    radius = size.minDimension * 0.26f,
                    center = center,
                    style = Stroke(width = 1.2f)
                )
                drawLine(
                    color = accentColor,
                    start = Offset(center.x - size.minDimension * 0.48f, center.y),
                    end = Offset(center.x + size.minDimension * 0.48f, center.y),
                    strokeWidth = 1f
                )
                drawLine(
                    color = accentColor,
                    start = Offset(center.x, center.y - size.minDimension * 0.48f),
                    end = Offset(center.x, center.y + size.minDimension * 0.48f),
                    strokeWidth = 1f
                )
            }

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "15 COLLECTIONS · $totalArticles CANONICAL ENTRIES · $totalMemberships CATEGORY LINKS",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "MINDTRAP",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "An Atlas of Human Thinking",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "A research-backed reference library and long-term learning system exploring logical fallacies, cognitive biases, psychological phenomena, persuasion, mental models, and critical reasoning.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ReadingProgressOverviewCard(
    progress: OverallProgress,
    dailyReadingGoal: Int,
    todayReadCount: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("home_progress_card")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "READING PROGRESS & LIBRARY AUDIT",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${progress.percentage}% of Verified Read",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    softWrap = false
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = { if (progress.totalArticles == 0) 0f else progress.readArticles.toFloat() / progress.totalArticles },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeCap = StrokeCap.Round,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                ProgressMetricColumn(
                    label = "Verified Canonical",
                    value = progress.verifiedArticles.toString(),
                    modifier = Modifier.weight(1f)
                )
                ProgressMetricColumn(
                    label = "Marked as Read",
                    value = progress.readArticles.toString(),
                    modifier = Modifier.weight(1f)
                )
                ProgressMetricColumn(
                    label = "Remaining Unread",
                    value = progress.unreadArticles.toString(),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "7,500-Entry Expansion Pipeline: ${progress.totalCategoryMemberships} / ${progress.overallTargetMemberships} verified category memberships (${progress.remainingToOverallTarget} remaining toward 500/category target).",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (dailyReadingGoal > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.55f),
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Optional Daily Pace: $todayReadCount / $dailyReadingGoal entries studied today",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (todayReadCount >= dailyReadingGoal) "Goal Met" else "At Your Own Pace",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProgressMetricColumn(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun LearningPathwayCard(
    pathway: LearningPathway,
    readArticleIds: Set<String>,
    onOpenNextArticle: (String) -> Unit,
    onOpenCategory: (CollectionCategory) -> Unit
) {
    val validArticles = remember(pathway) {
        pathway.orderedArticleIds.mapNotNull { EncyclopediaContentPipeline.getArticle(it) }
    }
    val completedCount = validArticles.count { it.id in readArticleIds }
    val nextArticle = validArticles.firstOrNull { it.id !in readArticleIds } ?: validArticles.firstOrNull()

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(290.dp)
            .clickable {
                if (nextArticle != null) {
                    onOpenNextArticle(nextArticle.id)
                } else {
                    onOpenCategory(pathway.category)
                }
            }
            .testTag("pathway_card_${pathway.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PATH ${pathway.category.number.toString().padStart(2, '0')}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$completedCount/${validArticles.size} Completed",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    softWrap = false
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = pathway.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = pathway.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
            LinearProgressIndicator(
                progress = { if (validArticles.isEmpty()) 0f else completedCount.toFloat() / validArticles.size },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeCap = StrokeCap.Round,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            if (nextArticle != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = if (completedCount == validArticles.size) {
                        "Review: ${nextArticle.name}"
                    } else {
                        "Next Up: ${nextArticle.name}"
                    },
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FeaturedConceptCard(
    article: ConceptArticle,
    isRead: Boolean,
    showEvidenceBadge: Boolean,
    onOpen: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpen() }
            .testTag("featured_concept_card")
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = article.primaryCategory.title.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ReadStatusBadge(isRead = isRead)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.shortDefinition,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                DifficultyBadge(difficulty = article.resolvedDifficulty)
                EstimatedReadingTimeBadge(minutes = article.estimatedReadingMinutes)
                if (showEvidenceBadge) {
                    EvidenceBadge(evidenceLevel = article.evidenceLevel)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Study Concept",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    softWrap = false
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
private fun ContinueReadingMiniCard(
    article: ConceptArticle,
    isRead: Boolean,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(250.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = article.primaryCategory.shortTitle.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ReadStatusBadge(isRead = isRead)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.shortDefinition,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
