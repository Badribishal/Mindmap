package com.example.data.content

import com.example.model.AuthoritativeSourceRegistryEntry
import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.LearningPathway
import com.example.model.ReviewStatus
import kotlin.math.abs
import kotlin.random.Random

data class CategoryAuditRow(
    val category: CollectionCategory,
    val primaryCount: Int,
    val crossReferencedCount: Int,
    val totalCategoryMemberships: Int,
    val verifiedCount: Int,
    val awaitingReviewCount: Int,
    val targetCount: Int = 500,
    val remainingToTarget: Int = (500 - totalCategoryMemberships).coerceAtLeast(0)
)

data class PipelineValidationReport(
    val totalArticles: Int,
    val totalCategoryMemberships: Int,
    val verifiedArticlesCount: Int,
    val totalPrimaryCategoriesCovered: Int,
    val duplicateIdsDetected: List<String>,
    val brokenRelatedLinks: List<Pair<String, String>>,
    val unverifiedEntriesCount: Int,
    val overallTargetMemberships: Int = 7500,
    val remainingToOverallTarget: Int = (7500 - totalCategoryMemberships).coerceAtLeast(0),
    val perCategoryAudit: List<CategoryAuditRow> = emptyList(),
    val isValid: Boolean
)

object EncyclopediaContentPipeline {

    private val rawPacks: List<List<ConceptArticle>> = listOf(
        ContentPack1FallaciesAndBiases.articles,
        ContentPack2PsychologyAndDistortions.articles,
        ContentPack3ModelsHeuristicsPersuasion.articles,
        ContentPack4PropagandaParadoxesDecisions.articles,
        ContentPack5MemorySocialCriticalReasoning.articles,
        ContentPack6ExtendedEncyclopedia.articles,
        ContentPack7PathwayExpansion.articles,
        ContentPack8PathwayExpansionB.articles,
        ContentPack9PathwayExpansionC.articles
    )

    val sourceRegistry: List<AuthoritativeSourceRegistryEntry>
        get() = SourceRegistryAndPathways.authoritativeSources

    val learningPathways: List<LearningPathway>
        get() = SourceRegistryAndPathways.learningPathways

    val allArticles: List<ConceptArticle> by lazy {
        val seenIds = mutableSetOf<String>()
        val deduplicated = mutableListOf<ConceptArticle>()
        for (pack in rawPacks) {
            for (article in pack) {
                if (article.id.isNotBlank() && article.name.isNotBlank() && seenIds.add(article.id)) {
                    deduplicated.add(article)
                }
            }
        }
        deduplicated.sortedBy { it.name.lowercase() }
    }

    val articleById: Map<String, ConceptArticle> by lazy {
        allArticles.associateBy { it.id }
    }

    val totalCategoryMembershipsCount: Int by lazy {
        CollectionCategory.entries.sumOf { cat ->
            getArticlesForCategory(cat, includeCrossReferences = true).size
        }
    }

    /**
     * Computes incoming knowledge-graph links so that if Article A links to Article B,
     * Article B also knows Article A references it (bidirectional knowledge graph).
     */
    val incomingLinksByArticleId: Map<String, List<ConceptArticle>> by lazy {
        val map = mutableMapOf<String, MutableList<ConceptArticle>>()
        for (article in allArticles) {
            for (targetId in article.relatedConceptIds) {
                if (articleById.containsKey(targetId) && targetId != article.id) {
                    map.getOrPut(targetId) { mutableListOf() }.add(article)
                }
            }
        }
        map
    }

    fun getArticle(id: String): ConceptArticle? = articleById[id]

    fun getLearningPathwayForCategory(category: CollectionCategory): LearningPathway? {
        return learningPathways.firstOrNull { it.category == category }
    }

    fun getOutgoingRelatedArticles(article: ConceptArticle): List<ConceptArticle> {
        return article.relatedConceptIds.mapNotNull { articleById[it] }.distinctBy { it.id }
    }

    fun getIncomingRelatedArticles(article: ConceptArticle): List<ConceptArticle> {
        val outgoingIds = article.relatedConceptIds.toSet()
        return (incomingLinksByArticleId[article.id] ?: emptyList())
            .filter { it.id !in outgoingIds }
            .distinctBy { it.id }
    }

    /**
     * Determines the best Suggested Next Topic for progressive learning:
     * 1. Explicit suggestedNextTopicId if valid
     * 2. Next article in the category's Structured Learning Path
     * 3. First unread related article in relatedConceptIds
     * 4. First related article in relatedConceptIds
     */
    fun getSuggestedNextArticle(
        article: ConceptArticle,
        readArticleIds: Set<String> = emptySet()
    ): ConceptArticle? {
        if (article.suggestedNextTopicId.isNotBlank()) {
            articleById[article.suggestedNextTopicId]?.let { return it }
        }
        val pathway = getLearningPathwayForCategory(article.primaryCategory)
        if (pathway != null) {
            val idx = pathway.orderedArticleIds.indexOf(article.id)
            if (idx >= 0 && idx + 1 < pathway.orderedArticleIds.size) {
                articleById[pathway.orderedArticleIds[idx + 1]]?.let { return it }
            }
        }
        val related = getOutgoingRelatedArticles(article)
        return related.firstOrNull { it.id !in readArticleIds } ?: related.firstOrNull()
    }

    /**
     * Deterministic Daily Topic Recommendation that rotates daily and prefers unread articles.
     */
    fun getDailyRecommendedArticle(
        readArticleIds: Set<String>,
        daySeed: Long = System.currentTimeMillis() / (1000L * 60 * 60 * 24)
    ): ConceptArticle {
        val unreadPool = allArticles.filter { it.id !in readArticleIds }
        val pool = if (unreadPool.isNotEmpty()) unreadPool else allArticles
        val index = (abs(daySeed * 31L + 7L) % pool.size).toInt()
        return pool[index]
    }

    /**
     * Returns all articles belonging to a collection (either as primary category or cross-referenced secondary category).
     */
    fun getArticlesForCategory(
        category: CollectionCategory,
        includeCrossReferences: Boolean = true
    ): List<ConceptArticle> {
        return allArticles.filter { article ->
            article.primaryCategory == category ||
                (includeCrossReferences && category in article.secondaryCategories)
        }
    }

    /**
     * Universal offline search across name, alternative names, keywords, category, subcategory,
     * short definition, beginner explanation, detailed explanation,historical background,
     * misconceptions, and everyday + public discourse examples.
     */
    fun searchArticles(
        query: String,
        difficultyFilter: DifficultyLevel? = null
    ): List<ConceptArticle> {
        val baseList = if (difficultyFilter == null) {
            allArticles
        } else {
            allArticles.filter { it.resolvedDifficulty == difficultyFilter }
        }

        val trimmed = query.trim()
        if (trimmed.isEmpty()) return baseList

        val terms = trimmed.lowercase().split(Regex("\\s+")).filter { it.isNotEmpty() }

        return baseList
            .mapNotNull { article ->
                var score = 0
                val nameLower = article.name.lowercase()
                val altLower = article.alternativeNames.joinToString(" ").lowercase()
                val keywordsLower = article.keywords.joinToString(" ").lowercase()
                val catLower = (article.primaryCategory.title + " " +
                    article.secondaryCategories.joinToString(" ") { it.title } + " " +
                    article.subcategories.joinToString(" ")).lowercase()
                val defLower = article.shortDefinition.lowercase()
                val beginnerLower = article.beginnerExplanation.lowercase()
                val detailedLower = article.detailedExplanation.lowercase()
                val examplesLower = (article.everydayExamples + article.resolvedMediaAndPublicExamples).joinToString(" ") {
                    "${it.context} ${it.scenario} ${it.analysis}"
                }.lowercase()
                val sourcesLower = article.sources.joinToString(" ") {
                    "${it.title} ${it.sourceName} ${it.authorsOrYear}"
                }.lowercase()

                var allTermsMatchSomewhere = true
                for (term in terms) {
                    var termMatched = false
                    if (nameLower == term) {
                        score += 120
                        termMatched = true
                    } else if (nameLower.startsWith(term)) {
                        score += 80
                        termMatched = true
                    } else if (nameLower.contains(term)) {
                        score += 55
                        termMatched = true
                    }

                    if (altLower.contains(term)) {
                        score += 45
                        termMatched = true
                    }
                    if (keywordsLower.contains(term)) {
                        score += 40
                        termMatched = true
                    }
                    if (catLower.contains(term)) {
                        score += 25
                        termMatched = true
                    }
                    if (defLower.contains(term)) {
                        score += 20
                        termMatched = true
                    }
                    if (examplesLower.contains(term)) {
                        score += 15
                        termMatched = true
                    }
                    if (sourcesLower.contains(term)) {
                        score += 12
                        termMatched = true
                    }
                    if (beginnerLower.contains(term) || detailedLower.contains(term)) {
                        score += 10
                        termMatched = true
                    }

                    if (!termMatched) {
                        allTermsMatchSomewhere = false
                    }
                }

                if (allTermsMatchSomewhere && score > 0) {
                    article to score
                } else {
                    null
                }
            }
            .sortedWith(compareByDescending<Pair<ConceptArticle, Int>> { it.second }.thenBy { it.first.name })
            .map { it.first }
    }

    /**
     * Selects a random valid article:
     * - Prefers unread articles.
     * - Selects across all available categories.
     * - Avoids choosing the same article twice consecutively (via lastSelectedId).
     * - If all articles have been marked read, chooses from the entire available library.
     */
    fun selectRandomTopic(
        readArticleIds: Set<String>,
        lastSelectedArticleId: String?,
        random: Random = Random.Default
    ): ConceptArticle {
        val validPool = allArticles.filter { it.id.isNotBlank() && it.name.isNotBlank() }
        check(validPool.isNotEmpty()) { "Encyclopedia content pool cannot be empty" }

        val unreadPool = validPool.filter { it.id !in readArticleIds }
        val baseCandidatePool = if (unreadPool.isNotEmpty()) unreadPool else validPool

        val nonRepeatingPool = if (baseCandidatePool.size > 1 && lastSelectedArticleId != null) {
            baseCandidatePool.filter { it.id != lastSelectedArticleId }
        } else if (validPool.size > 1 && lastSelectedArticleId != null && baseCandidatePool.size == 1 && baseCandidatePool.first().id == lastSelectedArticleId) {
            validPool.filter { it.id != lastSelectedArticleId }
        } else {
            baseCandidatePool
        }

        val finalPool = if (nonRepeatingPool.isNotEmpty()) nonRepeatingPool else validPool
        return finalPool[random.nextInt(finalPool.size)]
    }

    fun validatePipeline(): PipelineValidationReport {
        val allRaw = rawPacks.flatten()
        val seen = mutableSetOf<String>()
        val duplicates = mutableListOf<String>()
        for (a in allRaw) {
            if (!seen.add(a.id)) {
                duplicates.add(a.id)
            }
        }

        val brokenLinks = mutableListOf<Pair<String, String>>()
        for (a in allArticles) {
            for (relId in a.relatedConceptIds) {
                if (!articleById.containsKey(relId)) {
                    brokenLinks.add(a.id to relId)
                }
            }
        }

        val perCategory = CollectionCategory.entries.map { cat ->
            val primary = allArticles.filter { it.primaryCategory == cat }
            val crossRef = allArticles.filter { it.primaryCategory != cat && cat in it.secondaryCategories }
            val combined = primary + crossRef
            val verified = combined.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC }
            val awaiting = combined.size - verified
            CategoryAuditRow(
                category = cat,
                primaryCount = primary.size,
                crossReferencedCount = crossRef.size,
                totalCategoryMemberships = combined.size,
                verifiedCount = verified,
                awaitingReviewCount = awaiting,
                targetCount = 500,
                remainingToTarget = (500 - combined.size).coerceAtLeast(0)
            )
        }

        val totalMemberships = perCategory.sumOf { it.totalCategoryMemberships }
        val verifiedTotal = allArticles.count { it.reviewStatus == ReviewStatus.VERIFIED_ACADEMIC }
        val unverifiedTotal = allArticles.size - verifiedTotal
        val categoriesCovered = allArticles.map { it.primaryCategory }.distinct().size

        return PipelineValidationReport(
            totalArticles = allArticles.size,
            totalCategoryMemberships = totalMemberships,
            verifiedArticlesCount = verifiedTotal,
            totalPrimaryCategoriesCovered = categoriesCovered,
            duplicateIdsDetected = duplicates,
            brokenRelatedLinks = brokenLinks,
            unverifiedEntriesCount = unverifiedTotal,
            overallTargetMemberships = 7500,
            remainingToOverallTarget = (7500 - totalMemberships).coerceAtLeast(0),
            perCategoryAudit = perCategory,
            isValid = duplicates.isEmpty() && brokenLinks.isEmpty() && categoriesCovered == CollectionCategory.entries.size
        )
    }
}
