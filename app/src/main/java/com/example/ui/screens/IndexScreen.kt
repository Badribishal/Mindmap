package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.content.EncyclopediaContentPipeline
import com.example.model.CollectionCategory
import com.example.model.DifficultyLevel
import com.example.model.ReadFilter
import com.example.ui.components.ArticleSummaryCard
import com.example.ui.components.DifficultyFilterRow
import com.example.ui.components.EditorialSearchBar
import com.example.ui.components.ReadFilterRow

@Composable
fun IndexScreen(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    selectedLetter: Char?,
    onSelectLetter: (Char?) -> Unit,
    selectedCategory: CollectionCategory?,
    onSelectCategory: (CollectionCategory?) -> Unit,
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
    modifier: Modifier = Modifier
) {
    val allArticles = EncyclopediaContentPipeline.allArticles
    val availableLetters = remember(allArticles) {
        ('A'..'Z').toList()
    }

    val baseSearchArticles = remember(searchQuery, selectedCategory, selectedLetter, difficultyFilter) {
        val queried = if (searchQuery.isBlank()) {
            allArticles
        } else {
            EncyclopediaContentPipeline.searchArticles(searchQuery, difficultyFilter)
        }
        queried.filter { article ->
            val matchesCat = selectedCategory == null ||
                article.primaryCategory == selectedCategory ||
                selectedCategory in article.secondaryCategories
            val matchesLetter = selectedLetter == null ||
                article.name.firstOrNull()?.uppercaseChar() == selectedLetter
            val matchesDiff = difficultyFilter == null ||
                article.resolvedDifficulty == difficultyFilter
            matchesCat && matchesLetter && matchesDiff
        }
    }

    val totalMatching = baseSearchArticles.size
    val readMatching = remember(baseSearchArticles, readArticleIds) {
        baseSearchArticles.count { it.id in readArticleIds }
    }
    val unreadMatching = (totalMatching - readMatching).coerceAtLeast(0)

    val finalArticles = remember(baseSearchArticles, readFilter, readArticleIds) {
        baseSearchArticles.filter { article ->
            val isRead = article.id in readArticleIds
            when (readFilter) {
                ReadFilter.ALL -> true
                ReadFilter.READ -> isRead
                ReadFilter.UNREAD -> !isRead
            }
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("index_screen_list")
    ) {
        item(key = "index_header") {
            Column {
                Text(
                    text = "ALPHABETICAL ENCYCLOPEDIA",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "A–Z Master Index",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Browse all ${allArticles.size} unique canonical concepts alphabetically, filter by collection, difficulty level, or reading status.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        item(key = "index_search") {
            EditorialSearchBar(
                query = searchQuery,
                onQueryChange = onSearchQueryChange,
                placeholder = "Search index by concept, synonym, author, or keyword…",
                testTag = "index_search_input"
            )
        }

        // A-Z Horizontal Selector Bar
        item(key = "az_bar") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (selectedLetter == null) "FILTER BY INITIAL (ALL A–Z)" else "INITIAL: $selectedLetter",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    if (selectedLetter != null || selectedCategory != null || readFilter != ReadFilter.ALL || difficultyFilter != null || searchQuery.isNotBlank()) {
                        Spacer(modifier = Modifier.size(8.dp))
                        TextButton(
                            onClick = {
                                onSelectLetter(null)
                                onSelectCategory(null)
                                onSelectReadFilter(ReadFilter.ALL)
                                onSelectDifficultyFilter(null)
                                onSearchQueryChange("")
                            }
                        ) {
                            Text("Reset All Filters", style = MaterialTheme.typography.labelLarge, maxLines = 1, softWrap = false)
                        }
                    }
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        Surface(
                            color = if (selectedLetter == null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            contentColor = if (selectedLetter == null) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .height(38.dp)
                                .clickable { onSelectLetter(null) }
                                .padding(horizontal = 4.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(horizontal = 12.dp)
                            ) {
                                Text(
                                    text = "All",
                                    style = MaterialTheme.typography.labelLarge,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                    items(availableLetters) { letter ->
                        val isSelected = selectedLetter == letter
                        val hasEntries = allArticles.any { it.name.firstOrNull()?.uppercaseChar() == letter }
                        Surface(
                            color = when {
                                isSelected -> MaterialTheme.colorScheme.primary
                                hasEntries -> MaterialTheme.colorScheme.surface
                                else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                            },
                            contentColor = when {
                                isSelected -> MaterialTheme.colorScheme.onPrimary
                                hasEntries -> MaterialTheme.colorScheme.onSurface
                                else -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                            },
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                            ),
                            shape = CircleShape,
                            modifier = Modifier
                                .size(38.dp)
                                .clickable(enabled = hasEntries) { onSelectLetter(letter) }
                                .testTag("index_letter_$letter")
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = letter.toString(),
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }
        }

        // Category Filter Row
        item(key = "index_category_filter") {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    FilterChip(
                        selected = selectedCategory == null,
                        onClick = { onSelectCategory(null) },
                        label = { Text("All 15 Collections", style = MaterialTheme.typography.labelLarge) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
                items(CollectionCategory.entries) { cat ->
                    FilterChip(
                        selected = selectedCategory == cat,
                        onClick = { onSelectCategory(if (selectedCategory == cat) null else cat) },
                        label = { Text("${cat.number}. ${cat.shortTitle}", style = MaterialTheme.typography.labelLarge) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }
        }

        // Difficulty Filter Row
        item(key = "index_difficulty_filter") {
            DifficultyFilterRow(
                selectedDifficulty = difficultyFilter,
                onSelectDifficulty = onSelectDifficultyFilter
            )
        }

        // Read / Unread Filter Row
        item(key = "index_read_filter") {
            ReadFilterRow(
                selectedFilter = readFilter,
                onSelectFilter = onSelectReadFilter,
                totalCount = totalMatching,
                readCount = readMatching,
                unreadCount = unreadMatching
            )
        }

        if (finalArticles.isEmpty()) {
            item(key = "index_empty") {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "No entries match these index filters",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Tap 'Reset All Filters' above to view all ${allArticles.size} entries in the encyclopedia.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        } else {
            items(finalArticles, key = { "idx_${it.id}" }) { article ->
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
