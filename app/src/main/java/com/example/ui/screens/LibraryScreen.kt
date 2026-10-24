package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.Route
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.content.EncyclopediaContentPipeline
import com.example.model.CollectionCategory
import com.example.model.DifficultyLevel
import com.example.model.OverallProgress
import com.example.model.ReadFilter
import com.example.model.ReviewStatus
import com.example.ui.components.ArticleSummaryCard
import com.example.ui.components.CategoryCollectionCard
import com.example.ui.components.DifficultyFilterRow
import com.example.ui.components.EditorialSearchBar
import com.example.ui.components.ReadFilterRow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LibraryScreen(
    overallProgress: OverallProgress,
    onOpenCategory: (CollectionCategory, String?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("library_screen_list")
    ) {
        item(key = "library_header") {
            Column {
                Text(
                    text = "ENCYCLOPEDIA LIBRARY · 15 COLLECTIONS",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "15 Primary Collections",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Explore ${overallProgress.totalArticles} unique canonical concepts (${overallProgress.totalCategoryMemberships} category-specific memberships across 180+ academic subfields). Target: 500 entries per collection (7,500 total; ${overallProgress.remainingToOverallTarget} remaining to target).",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        items(overallProgress.categoryBreakdown, key = { "lib_cat_${it.category.id}" }) { catProgress ->
            val category = catProgress.category
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CategoryCollectionCard(
                    progress = catProgress,
                    onClick = { onOpenCategory(category, null) }
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    category.subcategories.forEach { sub ->
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            shape = RoundedCornerShape(6.dp),
                            onClick = { onOpenCategory(category, sub) }
                        ) {
                            Text(
                                text = sub,
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryDetailScreen(
    category: CollectionCategory,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    selectedSubcategory: String?,
    onSelectSubcategory: (String?) -> Unit,
    readFilter: ReadFilter,
    onSelectReadFilter: (ReadFilter) -> Unit,
    difficultyFilter: DifficultyLevel?,
    onSelectDifficultyFilter: (DifficultyLevel?) -> Unit,
    readArticleIds: Set<String>,
    bookmarkedArticleIds: Set<String>,
    showEvidenceBadges: Boolean,
    onOpenArticle: (String) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleRead: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    val primaryArticles = remember(category) {
        EncyclopediaContentPipeline.getArticlesForCategory(category, includeCrossReferences = false)
    }
    val allCategoryArticles = remember(category) {
        EncyclopediaContentPipeline.getArticlesForCategory(category, includeCrossReferences = true)
    }
    val pathway = remember(category) {
        EncyclopediaContentPipeline.getLearningPathwayForCategory(category)
    }

    val readCount = remember(allCategoryArticles, readArticleIds) {
        allCategoryArticles.count { it.id in readArticleIds }
    }
    val totalCount = allCategoryArticles.size
    val verifiedCount = remember(allCategoryArticles) {
        allCategoryArticles.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC }
    }
    val crossRefCount = (totalCount - primaryArticles.size).coerceAtLeast(0)
    val remainingTo500 = (500 - totalCount).coerceAtLeast(0)
    val unreadCount = (totalCount - readCount).coerceAtLeast(0)
    val completionPercent = if (totalCount == 0) 0 else ((readCount * 100f) / totalCount).toInt()

    val filteredArticles = remember(
        allCategoryArticles,
        searchQuery,
        selectedSubcategory,
        readFilter,
        difficultyFilter,
        readArticleIds
    ) {
        allCategoryArticles.filter { article ->
            val matchesSub = selectedSubcategory == null || selectedSubcategory in article.subcategories
            val isRead = article.id in readArticleIds
            val matchesRead = when (readFilter) {
                ReadFilter.ALL -> true
                ReadFilter.READ -> isRead
                ReadFilter.UNREAD -> !isRead
            }
            val matchesDiff = difficultyFilter == null || article.resolvedDifficulty == difficultyFilter
            val matchesQuery = if (searchQuery.isBlank()) {
                true
            } else {
                val q = searchQuery.trim().lowercase()
                article.name.lowercase().contains(q) ||
                    article.alternativeNames.any { it.lowercase().contains(q) } ||
                    article.shortDefinition.lowercase().contains(q) ||
                    article.keywords.any { it.lowercase().contains(q) }
            }
            matchesSub && matchesRead && matchesDiff && matchesQuery
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("category_detail_screen")
    ) {
        item(key = "cat_top_bar") {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.testTag("category_back_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "COLLECTION ${category.number.toString().padStart(2, '0')} · ${category.subcategories.size} SUBFIELDS",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        item(key = "cat_progress_header") {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = category.subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Target Audit: $verifiedCount / 500 verified (${primaryArticles.size} canonical primary + $crossRefCount cross-referenced · $remainingTo500 remaining toward 500-entry category target).",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Reading Progress: $readCount of $totalCount Read ($unreadCount Unread)",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "$completionPercent%",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { if (totalCount == 0) 0f else readCount.toFloat() / totalCount },
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                    )
                }
            }
        }

        // Structured Learning Pathway for this Category
        if (pathway != null) {
            item(key = "cat_learning_pathway") {
                val steps = remember(pathway) {
                    pathway.orderedArticleIds.mapNotNull { EncyclopediaContentPipeline.getArticle(it) }
                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Route,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "STRUCTURED LEARNING PATH · ${pathway.title.uppercase()}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = pathway.subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(steps.size) { index ->
                                val stepArticle = steps[index]
                                val stepRead = stepArticle.id in readArticleIds
                                Surface(
                                    color = if (stepRead) {
                                        MaterialTheme.colorScheme.secondaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.surface
                                    },
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .width(210.dp)
                                        .clickable { onOpenArticle(stepArticle.id) }
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (stepRead) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircleOutline,
                                            contentDescription = null,
                                            tint = if (stepRead) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "Step ${index + 1} · ${stepArticle.resolvedDifficulty.label}",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.primary,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = stepArticle.name,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurface,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        item(key = "cat_search_and_filters") {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                EditorialSearchBar(
                    query = searchQuery,
                    onQueryChange = onSearchQueryChange,
                    placeholder = "Search within ${category.shortTitle}…",
                    testTag = "category_search_input"
                )

                // Subcategory filter chips
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        FilterChip(
                            selected = selectedSubcategory == null,
                            onClick = { onSelectSubcategory(null) },
                            label = {
                                Text(
                                    text = "All ${category.subcategories.size} Subfields",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                    items(category.subcategories) { sub ->
                        FilterChip(
                            selected = selectedSubcategory == sub,
                            onClick = {
                                onSelectSubcategory(if (selectedSubcategory == sub) null else sub)
                            },
                            label = { Text(text = sub, style = MaterialTheme.typography.labelLarge) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }

                // Difficulty filter chips
                DifficultyFilterRow(
                    selectedDifficulty = difficultyFilter,
                    onSelectDifficulty = onSelectDifficultyFilter
                )

                // All / Unread / Read filter chips
                ReadFilterRow(
                    selectedFilter = readFilter,
                    onSelectFilter = onSelectReadFilter,
                    totalCount = totalCount,
                    readCount = readCount,
                    unreadCount = unreadCount
                )
            }
        }

        if (filteredArticles.isEmpty()) {
            item(key = "cat_empty") {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "No entries match your active filters",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Try switching the Read/Unread or Difficulty filter to 'All', or clearing the subfield filter.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        } else {
            items(filteredArticles, key = { "cat_art_${it.id}" }) { article ->
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
    }
}
