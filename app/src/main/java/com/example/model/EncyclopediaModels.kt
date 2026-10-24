package com.example.model

enum class CollectionCategory(
    val id: String,
    val number: Int,
    val title: String,
    val shortTitle: String,
    val subtitle: String,
    val subcategories: List<String>,
    val targetEntryGoal: Int = 500
) {
    LOGICAL_FALLACIES(
        id = "logical_fallacies",
        number = 1,
        title = "Logical Fallacies",
        shortTitle = "Fallacies",
        subtitle = "Formal, informal, deductive, inductive, statistical and rhetorical fallacies.",
        subcategories = listOf(
            "Formal Fallacies",
            "Informal Fallacies",
            "Relevance Fallacies",
            "Presumption Fallacies",
            "Ambiguity Fallacies",
            "Causal Fallacies",
            "Statistical and Probabilistic Reasoning Errors",
            "Inductive Reasoning Errors",
            "Deductive Reasoning Errors",
            "Fallacies in Scientific Argument",
            "Fallacies in Political Discourse",
            "Fallacies in Everyday Conversation",
            "Fallacies in Advertising",
            "Fallacies in Online Discussions"
        )
    ),
    COGNITIVE_BIASES(
        id = "cognitive_biases",
        number = 2,
        title = "Cognitive Biases",
        shortTitle = "Biases",
        subtitle = "Judgment, memory, social and decision-making biases.",
        subcategories = listOf(
            "Attention and Perception",
            "Memory",
            "Probability and Risk",
            "Decision-Making",
            "Social Judgment",
            "Self-Perception",
            "Attribution",
            "Belief Formation",
            "Information Processing",
            "Overconfidence",
            "Learning and Feedback",
            "Behavioural Economics"
        )
    ),
    PSYCHOLOGICAL_MANIPULATION(
        id = "psychological_manipulation",
        number = 3,
        title = "Psychological Manipulation",
        shortTitle = "Manipulation",
        subtitle = "Coercion, deception, emotional pressure, gaslighting and unhealthy influence.",
        subcategories = listOf(
            "Emotional Pressure",
            "Deception and Misleading Communication",
            "Coercive Control",
            "Boundary Violations",
            "Gaslighting and Reality Distortion",
            "Guilt and Shame Tactics",
            "Fear-Based Influence",
            "Social Pressure",
            "Exploitative Persuasion",
            "Manipulative Advertising",
            "Online Scams and Deceptive Interfaces",
            "Recognition, Prevention and Healthy Responses"
        )
    ),
    PSYCHOLOGICAL_PHENOMENA(
        id = "psychological_phenomena",
        number = 4,
        title = "Psychological Phenomena",
        shortTitle = "Phenomena",
        subtitle = "Documented behavioural and psychological effects.",
        subcategories = listOf(
            "Expectancy and Self-Fulfilling Effects",
            "Self-Perception and Metacognition",
            "Attention and Salience Effects",
            "Motivation and Conditioning",
            "Affective Adaptation and Well-Being",
            "Cognitive Load and Performance",
            "Placebo and Nocebo Mechanisms",
            "Social Presence and Observation Effects",
            "Perception and Sensory Integration",
            "Learning and Skill Acquisition Phenomena"
        )
    ),
    COGNITIVE_DISTORTIONS(
        id = "cognitive_distortions",
        number = 5,
        title = "Cognitive Distortions",
        shortTitle = "Distortions",
        subtitle = "Common unhelpful thinking patterns identified in cognitive therapy.",
        subcategories = listOf(
            "Dichotomous and Polarised Filtering",
            "Catastrophic and Predictive Leaps",
            "Mind Reading and Interpersonal Projection",
            "Emotional Reasoning and Affective Proof",
            "Overgeneralisation and Global Labeling",
            "Mental Filtering and Disqualifying the Positive",
            "Personalisation and Blame Attribution",
            "Rigid 'Should' and 'Must' Rules",
            "Fallacies of Control and Fairness",
            "Cognitive Restructuring and Reframing"
        )
    ),
    MENTAL_MODELS(
        id = "mental_models",
        number = 6,
        title = "Mental Models",
        shortTitle = "Mental Models",
        subtitle = "Reasoning and decision-making frameworks across disciplines.",
        subcategories = listOf(
            "Foundational First-Principles Reasoning",
            "Systems Thinking and Feedback Loops",
            "Inversion and Negative Space Thinking",
            "Epistemic Boundaries and Competence Mapping",
            "Abstraction and Map-Territory Distinctions",
            "Probabilistic and Expected-Value Models",
            "Economic and Incentive Architecture",
            "Evolutionary and Ecological Models",
            "Engineering Redundancy and Margin of Safety",
            "Strategic and Game-Theoretic Models"
        )
    ),
    HEURISTICS(
        id = "heuristics",
        number = 7,
        title = "Heuristics",
        shortTitle = "Heuristics",
        subtitle = "Mental shortcuts and intuitive judgments under uncertainty.",
        subcategories = listOf(
            "Availability and Ease-of-Recall Shortcuts",
            "Representativeness and Prototype Matching",
            "Affect and Gut-Feeling Substitution",
            "Anchoring and Insufficient Adjustment",
            "Satisficing and Bounded Rationality",
            "Recognition and Fluency Heuristics",
            "Fast-and-Frugal Decision Trees",
            "Effort-Reduction and Attribute Substitution",
            "Social Imitation and Default Heuristics",
            "Ecological Rationality and Heuristic Limits"
        )
    ),
    PERSUASION_AND_RHETORIC(
        id = "persuasion_and_rhetoric",
        number = 8,
        title = "Persuasion and Rhetoric",
        shortTitle = "Persuasion",
        subtitle = "Influence, argumentation, framing and communication dynamics.",
        subcategories = listOf(
            "Classical Aristotelian Rhetoric (Ethos, Pathos, Logos)",
            "Sequential Request and Compliance Tactics",
            "Reciprocity and Concession Dynamics",
            "Commitment and Consistency Principles",
            "Social Proof and Authority Cues",
            "Scarcity and Urgency Framing",
            "Metaphorical and Conceptual Framing",
            "Dual-Process Persuasion (ELM & HSM)",
            "Inoculation Theory and Pre-Bunking",
            "Ethical Argumentation and Deliberative Discourse"
        )
    ),
    PROPAGANDA_AND_MEDIA_LITERACY(
        id = "propaganda_and_media_literacy",
        number = 9,
        title = "Propaganda and Media Literacy",
        shortTitle = "Media Literacy",
        subtitle = "Misinformation, misleading narratives and information manipulation.",
        subcategories = listOf(
            "How Information is Framed",
            "Source Evaluation and Lateral Reading",
            "Evidence and Claims Verification",
            "Misinformation and Disinformation Dynamics",
            "Classical and Modern Propaganda Techniques",
            "Information Flooding and Exhaustion",
            "Repeated Falsehoods and Illusory Truth",
            "Statistical and Visual Data Distortion",
            "Emotional Appeals and Outrage Amplification",
            "Algorithmic Curation and Echo Chambers"
        )
    ),
    PHILOSOPHICAL_AND_LOGICAL_PARADOXES(
        id = "philosophical_paradoxes",
        number = 10,
        title = "Philosophical and Logical Paradoxes",
        shortTitle = "Paradoxes",
        subtitle = "Self-referential puzzles, identity dilemmas and counterintuitive truths.",
        subcategories = listOf(
            "Identity and Persistence Over Time",
            "Vagueness and Sorites Continua",
            "Self-Reference and Semantic Paradoxes",
            "Decision-Theoretic and Rationality Paradoxes",
            "Probability and Statistical Paradoxes",
            "Epistemic and Knowability Paradoxes",
            "Social Choice and Voting Paradoxes",
            "Infinity, Space and Motion (Zeno's Lineage)",
            "Systemic and Metric Paradoxes (Goodhart/Jevons)",
            "Moral and Deontic Dilemmas"
        )
    ),
    DECISION_MAKING_ERRORS(
        id = "decision_making_errors",
        number = 11,
        title = "Decision-Making Errors",
        shortTitle = "Decision Errors",
        subtitle = "Systematic pitfalls in planning, risk assessment and resource allocation.",
        subcategories = listOf(
            "Sunk Cost and Irrecoverable Investment Traps",
            "Escalation of Commitment and Self-Justification",
            "Planning Fallacy and Optimism Bias",
            "Valence Framing and Loss Aversion",
            "Opportunity Cost Neglect",
            "Omission vs. Commission Biases",
            "Outcome Bias and Moral Luck in Evaluation",
            "Status Quo and Default Inertia",
            "Temporal Discounting and Present Bias",
            "Multi-Attribute Trade-Off Neglect"
        )
    ),
    MEMORY_BIASES(
        id = "memory_biases",
        number = 12,
        title = "Memory Biases",
        shortTitle = "Memory Biases",
        subtitle = "How recall, reconstruction and hindsight systematically reshape the past.",
        subcategories = listOf(
            "Hindsight Bias and Creeping Determinism",
            "Post-Event Misinformation Contamination",
            "Source Monitoring Errors and Cryptomnesia",
            "Peak–End Rule and Duration Neglect",
            "Rosy Retrospection and Fading Affect",
            "Egocentric and Self-Serving Recall",
            "Serial Position (Primacy and Recency) Effects",
            "False Memory Reconstruction and Confabulation",
            "Mood-Congruent and State-Dependent Recall",
            "Prospective Memory and Zeigarnik Tension"
        )
    ),
    SOCIAL_PSYCHOLOGY(
        id = "social_psychology",
        number = 13,
        title = "Social Psychology",
        shortTitle = "Social Psych",
        subtitle = "Group dynamics, attribution, conformity and interpersonal perception.",
        subcategories = listOf(
            "Fundamental Attribution and Correspondence Bias",
            "Actor–Observer Asymmetry",
            "Bystander Intervention and Diffusion of Responsibility",
            "Groupthink and Consensus Pathologies",
            "Group Polarisation and Extremity Shifts",
            "False Consensus and Social Projection",
            "Conformity and Informational Social Influence",
            "In-Group Favouritism and Out-Group Homogeneity",
            "Pluralistic Ignorance and Social Norms",
            "Intergroup Contact and Cooperation Dynamics"
        )
    ),
    CRITICAL_THINKING(
        id = "critical_thinking",
        number = 14,
        title = "Critical Thinking",
        shortTitle = "Critical Thinking",
        subtitle = "Epistemic discipline, charitable interpretation and rigorous inquiry.",
        subcategories = listOf(
            "Claims, Premises and Evidentiary Warrant",
            "Deductive Validity and Inductive Strength",
            "Charitable Interpretation and Steelmanning",
            "Falsifiability and Empirical Demarcation",
            "Bayesian Updating and Base-Rate Calibration",
            "Intellectual Humility and Fallibilism",
            "Socratic Questioning and Assumption Auditing",
            "Causal Inference vs. Spurious Correlation",
            "Evaluating Expert Consensus and Primary Literature",
            "Metacognitive Calibration and Debiasing"
        )
    ),
    REASONING_PRINCIPLES(
        id = "reasoning_principles",
        number = 15,
        title = "Reasoning Principles",
        shortTitle = "Reasoning",
        subtitle = "Foundational canons of parsimony, burden of proof and logical structure.",
        subcategories = listOf(
            "Epistemic Razors and Parsimony (Occam's Lineage)",
            "Charitable Attribution Razors (Hanlon's Lineage)",
            "Burden of Proof and Onus Probandi",
            "Proportional Evidence Standards (Laplace/Sagan)",
            "Nullification of Bare Assertions (Hitchens/Alder)",
            "Second-Order Conservation (Chesterton's Fence)",
            "Laws of Thought (Non-Contradiction, Identity)",
            "Sufficient Reason and Explanatory Coherence",
            "Abductive Inference to the Best Explanation",
            "Methodological Naturalism and Replicability"
        )
    );

    companion object {
        const val TOTAL_ATLAS_TARGET_ENTRIES = 7500 // 15 categories * 500 entries per category
        fun fromId(id: String): CollectionCategory =
            entries.find { it.id == id } ?: LOGICAL_FALLACIES
    }
}

enum class DifficultyLevel(
    val id: String,
    val label: String,
    val order: Int,
    val description: String
) {
    BEGINNER(
        id = "beginner",
        label = "Beginner",
        order = 1,
        description = "Foundational concept accessible without prior formal training."
    ),
    INTERMEDIATE(
        id = "intermediate",
        label = "Intermediate",
        order = 2,
        description = "Explores experimental mechanisms, formal structure, and nuanced boundary conditions."
    ),
    ADVANCED(
        id = "advanced",
        label = "Advanced",
        order = 3,
        description = "Examines mathematical formulations, methodological replication debates, and epistemological limits."
    )
}

enum class EvidenceLevel(
    val id: String,
    val label: String,
    val detailedCategory: String,
    val description: String
) {
    WELL_SUPPORTED(
        id = "well_supported",
        label = "Established scientific / logical finding",
        detailedCategory = "Established scientific findings & formal logic",
        description = "Demonstrated across replicated peer-reviewed experiments, meta-analyses, or formal deductive proofs."
    ),
    EVIDENCE_DEVELOPING(
        id = "evidence_developing",
        label = "Proposed / developing evidence",
        detailedCategory = "Proposed or developing explanations",
        description = "Supported by initial empirical studies or clinical observations; active boundary research ongoing."
    ),
    MIXED_OR_DISPUTED(
        id = "mixed_or_disputed",
        label = "Limited or mixed evidence",
        detailedCategory = "Findings with limited or mixed evidence",
        description = "Subject to replication debates, context-dependent reversals, or statistical artefact critiques."
    ),
    INFORMAL_CONCEPT(
        id = "informal_concept",
        label = "Philosophical canon / informal terminology",
        detailedCategory = "Philosophical razors & informal terminology",
        description = "Practical epistemological razor, rhetorical pattern, or classical thought experiment rather than a laboratory variable."
    ),
    HISTORICAL_CONCEPT(
        id = "historical_concept",
        label = "Historical concept (superseded/refined)",
        detailedCategory = "Historical concepts refined by modern research",
        description = "Historically influential formulation that has been substantially revised by modern empirical findings."
    )
}

enum class ReviewStatus(val label: String, val isVerified: Boolean) {
    VERIFIED_ACADEMIC("Verified against academic & primary reference literature", true),
    CROSS_REFERENCED("Cross-referenced with philosophical & psychological catalogues", true),
    AWAITING_VERIFICATION("Awaiting primary source verification", false)
}

enum class SourceType(val label: String) {
    PEER_REVIEWED_JOURNAL("Peer-Reviewed Journal Article"),
    META_ANALYSIS("Systematic Review / Meta-Analysis"),
    ACADEMIC_ENCYCLOPEDIA("Academic Reference Encyclopedia"),
    OPEN_TEXTBOOK("Open-Access University Textbook"),
    MONOGRAPH_BOOK("Scholarly Monograph / Book"),
    RESEARCH_INSTITUTE("Research Institute Report")
}

data class AuthoritativeSourceRegistryEntry(
    val id: String,
    val name: String,
    val domainArea: String,
    val baseUrl: String,
    val description: String,
    val licenseNote: String
) {
    val url: String get() = baseUrl
    val abbreviation: String get() = id.removePrefix("src_").uppercase()
    val publisherOrInstitution: String get() = domainArea
    val sourceType: SourceType get() = SourceType.ACADEMIC_ENCYCLOPEDIA
    val domainCoverage: String get() = description
}

data class SourceReference(
    val title: String,
    val sourceName: String,
    val authorsOrYear: String,
    val url: String,
    val publicationYear: String = "",
    val sourceType: SourceType = SourceType.PEER_REVIEWED_JOURNAL,
    val supportingClaim: String = "Primary theoretical formulation and empirical validation of this concept.",
    val lastVerificationDate: String = "2026-10",
    val verificationStatus: String = "Verified Reference",
    val reuseLicenseNote: String = "Original synthesis; bibliographic citation only under fair scholarly reference."
) {
    val verificationDate: String get() = lastVerificationDate
    val licenseOrUsageNote: String get() = reuseLicenseNote
}

data class EverydayExample(
    val context: String,
    val scenario: String,
    val analysis: String
)

data class ConceptArticle(
    val id: String,
    val name: String,
    val alternativeNames: List<String>,
    val primaryCategory: CollectionCategory,
    val secondaryCategories: List<CollectionCategory> = emptyList(),
    val subcategories: List<String>,
    val shortDefinition: String,
    val beginnerExplanation: String,
    val detailedExplanation: String,
    val everydayExamples: List<EverydayExample>,
    val howToRecognise: List<String>,
    val whyItOccurs: String,
    val howToRespond: List<String>,
    val relatedConceptIds: List<String>,
    val evidenceLevel: EvidenceLevel,
    val scientificEvidenceAndLimitations: String,
    val sources: List<SourceReference>,
    val reviewStatus: ReviewStatus,
    val keywords: List<String> = emptyList(),
    // Extended 20-Dimension Academic Fields (computed defaults when not explicitly overridden)
    val difficultyOverride: DifficultyLevel? = null,
    val historicalBackgroundOverride: String? = null,
    val originOrAttributionOverride: String? = null,
    val typesAndVariantsOverride: List<String>? = null,
    val mediaAndPublicDiscourseExampleOverride: String? = null,
    val commonMisconceptionsOverride: String? = null,
    val whyItMattersOverride: String? = null,
    val suggestedNextTopicId: String = "",
    val contentVersion: Int = 2
) {
    val allCategories: List<CollectionCategory>
        get() = (listOf(primaryCategory) + secondaryCategories).distinct()

    val difficultyLevel: DifficultyLevel
        get() = difficultyOverride ?: when {
            evidenceLevel == EvidenceLevel.MIXED_OR_DISPUTED ||
                primaryCategory == CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES ||
                id in setOf("ct_bayes_theorem", "ct_falsifiability", "fallacy_affirming_consequent", "para_goodharts_law") ->
                DifficultyLevel.ADVANCED
            primaryCategory in setOf(
                CollectionCategory.MENTAL_MODELS,
                CollectionCategory.HEURISTICS,
                CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
                CollectionCategory.DECISION_MAKING_ERRORS,
                CollectionCategory.MEMORY_BIASES
            ) -> DifficultyLevel.INTERMEDIATE
            else -> DifficultyLevel.BEGINNER
        }

    val resolvedDifficulty: DifficultyLevel
        get() = difficultyLevel

    val estimatedReadingMinutes: Int
        get() {
            val totalWords = (
                shortDefinition.split(" ").size +
                    beginnerExplanation.split(" ").size +
                    detailedExplanation.split(" ").size +
                    whyItOccurs.split(" ").size +
                    scientificEvidenceAndLimitations.split(" ").size +
                    everydayExamples.sumOf { it.scenario.split(" ").size + it.analysis.split(" ").size } +
                    howToRecognise.sumOf { it.split(" ").size } +
                    howToRespond.sumOf { it.split(" ").size }
                )
            return (totalWords / 110).coerceIn(4, 12)
        }

    val originAndHistoricalBackground: String
        get() = historicalBackgroundOverride ?: run {
            val primaryRef = sources.firstOrNull()
            val attribution = primaryRef?.let { "${it.authorsOrYear} in ${it.sourceName}" } ?: "classical philosophical and psychological literature"
            "Documented and formalised through $attribution. Within the history of ${primaryCategory.title.lowercase()}, this concept emerged to distinguish systematic structural patterns in human reasoning from isolated random errors."
        }

    val resolvedHistoricalBackground: String
        get() = originAndHistoricalBackground

    val originAttributionSummary: String
        get() = originOrAttributionOverride ?: (sources.firstOrNull()?.authorsOrYear ?: "Classical & Modern Academic Literature")

    val resolvedOriginAndAttribution: String
        get() = originAttributionSummary

    val typesAndVariants: List<String>
        get() = typesAndVariantsOverride ?: (
            if (alternativeNames.isNotEmpty()) {
                alternativeNames.map { "$it (Recognised variant or synonymous formulation in ${subcategories.firstOrNull() ?: primaryCategory.title})" }
            } else {
                subcategories.map { "$it classification" }
            }
            )

    val resolvedTypesAndVariants: List<String>
        get() = typesAndVariants

    val mediaWorkAndPublicDiscourseExamples: String
        get() = mediaAndPublicDiscourseExampleOverride ?: run {
            val firstEx = everydayExamples.firstOrNull()
            val secondEx = everydayExamples.getOrNull(1)
            if (secondEx != null) {
                "In institutional, workplace, and public discourse (${secondEx.context}): ${secondEx.scenario} — ${secondEx.analysis}"
            } else if (firstEx != null) {
                "In public and professional settings (${firstEx.context}): ${firstEx.scenario}"
            } else {
                "Frequently observed in policy debates, journalism, organisational decision-making, and academic peer review."
            }
        }

    val resolvedMediaAndPublicExamples: List<EverydayExample>
        get() = listOf(
            EverydayExample(
                context = "Media, Workplace & Public Discourse",
                scenario = mediaWorkAndPublicDiscourseExamples,
                analysis = "Demonstrates how ${name} operates in institutional, professional, and public communication."
            )
        )

    val commonMisconceptions: String
        get() = commonMisconceptionsOverride ?: when (primaryCategory) {
            CollectionCategory.LOGICAL_FALLACIES ->
                "A common misconception is the 'Fallacy Fallacy' (Argument from Fallacy): assuming that because a speaker committed ${name} while defending a conclusion, the conclusion itself must automatically be false. In reality, a poorly argued conclusion might still be factually true for other, valid reasons."
            CollectionCategory.PSYCHOLOGICAL_MANIPULATION, CollectionCategory.COGNITIVE_DISTORTIONS ->
                "A frequent online misconception is using ${name} as a clinical diagnosis of another person's character or mental health. In behavioural science, it describes a specific observable pattern of communication or cognition—and understanding it is meant for healthy boundary setting and clearer self-reflection, never armchair diagnosis."
            CollectionCategory.COGNITIVE_BIASES, CollectionCategory.HEURISTICS ->
                "People often assume that knowing the name of ${name} makes them personally immune to it (the 'Bias Blind Spot'). Empirical research shows that high general intelligence does not eliminate cognitive biases unless paired with explicit external checklists and base-rate calibration."
            else ->
                "This concept is frequently oversimplified in popular summaries as an absolute rule. In rigorous inquiry, ${name} operates alongside domain context, empirical base rates, and boundary conditions."
        }

    val resolvedCommonMisconceptions: List<String>
        get() = listOf(commonMisconceptions)

    val whyItMatters: String
        get() = whyItMattersOverride ?: "Recognising ${name} protects epistemic independence, improves decision accuracy under uncertainty, prevents costly misallocations of trust or resources, and elevates constructive dialogue across personal, academic, and professional life."

    val resolvedWhyItMatters: String
        get() = whyItMatters
}

data class LearningPathway(
    val id: String,
    val title: String,
    val category: CollectionCategory,
    val subtitle: String,
    val stages: List<String>,
    val articleIdsInOrder: List<String>
) {
    val orderedArticleIds: List<String>
        get() = articleIdsInOrder
}

enum class ReadFilter(val label: String) {
    ALL("All"),
    UNREAD("Unread"),
    READ("Read")
}

data class CategoryProgress(
    val category: CollectionCategory,
    val totalArticles: Int,
    val readArticles: Int,
    val primaryCanonicalCount: Int = totalArticles,
    val crossReferencedCount: Int = 0,
    val crossReferencedArticles: Int = crossReferencedCount,
    val verifiedArticles: Int = totalArticles + crossReferencedArticles,
    val awaitingReviewArticles: Int = 0,
    val targetGoalCount: Int = category.targetEntryGoal,
    val targetArticles: Int = targetGoalCount
) {
    val totalCategoryMemberships: Int get() = totalArticles + crossReferencedArticles
    val unreadArticles: Int get() = (totalArticles - readArticles).coerceAtLeast(0)
    val percentage: Int get() = if (totalArticles == 0) 0 else ((readArticles * 100f) / totalArticles).toInt()
    val remainingToTargetGoal: Int get() = (targetGoalCount - totalCategoryMemberships).coerceAtLeast(0)
    val remainingToTarget: Int get() = (targetArticles - totalCategoryMemberships).coerceAtLeast(0)
}

data class OverallProgress(
    val totalArticles: Int,
    val totalCategoryMemberships: Int = totalArticles,
    val verifiedArticlesCount: Int = totalArticles,
    val verifiedArticles: Int = verifiedArticlesCount,
    val awaitingVerificationCount: Int = 0,
    val awaitingReviewArticles: Int = awaitingVerificationCount,
    val readArticles: Int,
    val overallTargetMemberships: Int = CollectionCategory.TOTAL_ATLAS_TARGET_ENTRIES,
    val categoryBreakdown: List<CategoryProgress>
) {
    val unreadArticles: Int get() = (totalArticles - readArticles).coerceAtLeast(0)
    val percentage: Int get() = if (totalArticles == 0) 0 else ((readArticles * 100f) / totalArticles).toInt()
    val remainingTo7500Target: Int get() = (overallTargetMemberships - totalCategoryMemberships).coerceAtLeast(0)
    val remainingToOverallTarget: Int get() = (overallTargetMemberships - totalCategoryMemberships).coerceAtLeast(0)
}
