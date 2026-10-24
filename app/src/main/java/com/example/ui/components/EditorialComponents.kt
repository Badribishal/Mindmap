package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Balance
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.automirrored.outlined.CompareArrows
import androidx.compose.material.icons.automirrored.outlined.FactCheck
import androidx.compose.material.icons.automirrored.outlined.Rule
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.FilterTiltShift
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.HistoryEdu
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.model.CategoryProgress
import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.EvidenceLevel
import com.example.model.ReadFilter
import com.example.ui.theme.EvidenceDevelopingBgDark
import com.example.ui.theme.EvidenceDevelopingBgLight
import com.example.ui.theme.EvidenceDevelopingTextDark
import com.example.ui.theme.EvidenceDevelopingTextLight
import com.example.ui.theme.EvidenceInformalBgDark
import com.example.ui.theme.EvidenceInformalBgLight
import com.example.ui.theme.EvidenceInformalTextDark
import com.example.ui.theme.EvidenceInformalTextLight
import com.example.ui.theme.EvidenceMixedBgDark
import com.example.ui.theme.EvidenceMixedBgLight
import com.example.ui.theme.EvidenceMixedTextDark
import com.example.ui.theme.EvidenceMixedTextLight
import com.example.ui.theme.EvidenceSupportedBgDark
import com.example.ui.theme.EvidenceSupportedBgLight
import com.example.ui.theme.EvidenceSupportedTextDark
import com.example.ui.theme.EvidenceSupportedTextLight
import com.example.ui.theme.LocalIsDarkTheme

fun CollectionCategory.icon(): ImageVector {
    return when (this) {
        CollectionCategory.LOGICAL_FALLACIES -> Icons.Outlined.Balance
        CollectionCategory.COGNITIVE_BIASES -> Icons.Outlined.Psychology
        CollectionCategory.PSYCHOLOGICAL_MANIPULATION -> Icons.Outlined.Shield
        CollectionCategory.PSYCHOLOGICAL_PHENOMENA -> Icons.Outlined.AutoAwesome
        CollectionCategory.COGNITIVE_DISTORTIONS -> Icons.Outlined.FilterTiltShift
        CollectionCategory.MENTAL_MODELS -> Icons.Outlined.AccountTree
        CollectionCategory.HEURISTICS -> Icons.Outlined.Bolt
        CollectionCategory.PERSUASION_AND_RHETORIC -> Icons.Outlined.Forum
        CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY -> Icons.Outlined.Public
        CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES -> Icons.AutoMirrored.Outlined.CompareArrows
        CollectionCategory.DECISION_MAKING_ERRORS -> Icons.Outlined.Explore
        CollectionCategory.MEMORY_BIASES -> Icons.Outlined.HistoryEdu
        CollectionCategory.SOCIAL_PSYCHOLOGY -> Icons.Outlined.Groups
        CollectionCategory.CRITICAL_THINKING -> Icons.AutoMirrored.Outlined.FactCheck
        CollectionCategory.REASONING_PRINCIPLES -> Icons.AutoMirrored.Outlined.Rule
    }
}

@Composable
fun EvidenceBadge(
    evidenceLevel: EvidenceLevel,
    modifier: Modifier = Modifier
) {
    val isDark = LocalIsDarkTheme.current
    val (bgColor, textColor) = when (evidenceLevel) {
        EvidenceLevel.WELL_SUPPORTED -> if (isDark) {
            EvidenceSupportedBgDark to EvidenceSupportedTextDark
        } else {
            EvidenceSupportedBgLight to EvidenceSupportedTextLight
        }
        EvidenceLevel.EVIDENCE_DEVELOPING -> if (isDark) {
            EvidenceDevelopingBgDark to EvidenceDevelopingTextDark
        } else {
            EvidenceDevelopingBgLight to EvidenceDevelopingTextLight
        }
        EvidenceLevel.MIXED_OR_DISPUTED -> if (isDark) {
            EvidenceMixedBgDark to EvidenceMixedTextDark
        } else {
            EvidenceMixedBgLight to EvidenceMixedTextLight
        }
        EvidenceLevel.INFORMAL_CONCEPT, EvidenceLevel.HISTORICAL_CONCEPT -> if (isDark) {
            EvidenceInformalBgDark to EvidenceInformalTextDark
        } else {
            EvidenceInformalBgLight to EvidenceInformalTextLight
        }
    }

    Surface(
        color = bgColor,
        contentColor = textColor,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Text(
            text = evidenceLevel.label,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            softWrap = false,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun DifficultyBadge(
    difficulty: DifficultyLevel,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f),
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Text(
            text = difficulty.label,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            softWrap = false,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun EstimatedReadingTimeBadge(
    minutes: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Schedule,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "$minutes min read",
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}

@Composable
fun ReadStatusBadge(
    isRead: Boolean,
    onToggle: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val containerColor = if (isRead) {
        MaterialTheme.colorScheme.secondaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
    val contentColor = if (isRead) {
        MaterialTheme.colorScheme.onSecondaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        color = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier.then(
            if (onToggle != null) {
                Modifier.clickable { onToggle() }
            } else {
                Modifier
            }
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        ) {
            Icon(
                imageVector = if (isRead) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircleOutline,
                contentDescription = if (isRead) "Read" else "Unread",
                modifier = Modifier.size(13.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = if (isRead) "Read" else "Unread",
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ArticleSummaryCard(
    article: ConceptArticle,
    isRead: Boolean,
    isBookmarked: Boolean,
    showEvidenceBadge: Boolean,
    onOpenArticle: () -> Unit,
    onToggleBookmark: () -> Unit,
    onToggleRead: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onOpenArticle() }
            .testTag("article_card_${article.id}")
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${article.primaryCategory.number.toString().padStart(2, '0')} · ${article.primaryCategory.title.uppercase()}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ReadStatusBadge(
                    isRead = isRead,
                    onToggle = onToggleRead
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = article.name,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (article.alternativeNames.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Also known as: ${article.alternativeNames.take(2).joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                IconButton(
                    onClick = onToggleBookmark,
                    modifier = Modifier
                        .size(48.dp)
                        .testTag("bookmark_btn_${article.id}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Remove Bookmark" else "Bookmark Concept",
                        tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = article.shortDefinition,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
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
                article.subcategories.firstOrNull()?.let { sub ->
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = sub,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryCollectionCard(
    progress: CategoryProgress,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val category = progress.category
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("category_card_${category.id}")
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = category.icon(),
                            contentDescription = category.title,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "COLLECTION ${category.number.toString().padStart(2, '0')} · ${category.subcategories.size} SUBFIELDS",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "${progress.readArticles}/${progress.totalArticles} Read",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        softWrap = false,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = category.subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${progress.verifiedArticles} verified (${progress.totalArticles}P + ${progress.crossReferencedArticles}X)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${progress.remainingToTarget} to ${progress.targetArticles} target",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    softWrap = false
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { if (progress.totalArticles == 0) 0f else progress.readArticles.toFloat() / progress.totalArticles },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeCap = StrokeCap.Round,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
        }
    }
}

@Composable
fun EditorialSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    testTag: String = "universal_search_input"
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Clear search",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier
            .fillMaxWidth()
            .testTag(testTag)
    )
}

@Composable
fun ReadFilterRow(
    selectedFilter: ReadFilter,
    onSelectFilter: (ReadFilter) -> Unit,
    totalCount: Int,
    readCount: Int,
    unreadCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        ReadFilter.entries.forEach { filter ->
            val count = when (filter) {
                ReadFilter.ALL -> totalCount
                ReadFilter.UNREAD -> unreadCount
                ReadFilter.READ -> readCount
            }
            val selected = selectedFilter == filter
            FilterChip(
                selected = selected,
                onClick = { onSelectFilter(filter) },
                label = {
                    Text(
                        text = "${filter.label} ($count)",
                        style = MaterialTheme.typography.labelLarge
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                modifier = Modifier.testTag("filter_chip_${filter.name.lowercase()}")
            )
        }
    }
}

@Composable
fun DifficultyFilterRow(
    selectedDifficulty: DifficultyLevel?,
    onSelectDifficulty: (DifficultyLevel?) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        FilterChip(
            selected = selectedDifficulty == null,
            onClick = { onSelectDifficulty(null) },
            label = { Text("All Levels", style = MaterialTheme.typography.labelLarge) },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            modifier = Modifier.testTag("difficulty_chip_all")
        )
        DifficultyLevel.entries.forEach { level ->
            FilterChip(
                selected = selectedDifficulty == level,
                onClick = { onSelectDifficulty(if (selectedDifficulty == level) null else level) },
                label = { Text(level.label, style = MaterialTheme.typography.labelLarge) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier.testTag("difficulty_chip_${level.name.lowercase()}")
            )
        }
    }
}

@Composable
fun RandomDiscoveryFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        icon = {
            Icon(
                imageVector = Icons.Filled.Shuffle,
                contentDescription = "Discover Random Concept"
            )
        },
        text = {
            Text(
                text = "Random Concept",
                style = MaterialTheme.typography.labelLarge
            )
        },
        modifier = modifier.testTag("random_discovery_fab")
    )
}
