package com.example.data.content

import com.example.model.AuthoritativeSourceRegistryEntry
import com.example.model.CollectionCategory
import com.example.model.LearningPathway

object SourceRegistryAndPathways {

    val authoritativeSources: List<AuthoritativeSourceRegistryEntry> = listOf(
        AuthoritativeSourceRegistryEntry(
            id = "src_sep",
            name = "Stanford Encyclopedia of Philosophy (SEP)",
            domainArea = "Philosophy & Logical Reasoning",
            baseUrl = "https://plato.stanford.edu/",
            description = "Peer-reviewed digital reference work maintained by Stanford University covering formal logic, fallacies, epistemology, and paradoxes.",
            licenseNote = "Academic citation & fair educational reference."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_iep",
            name = "Internet Encyclopedia of Philosophy (IEP)",
            domainArea = "Philosophy & Logical Reasoning",
            baseUrl = "https://iep.utm.edu/",
            description = "Peer-reviewed academic resource providing detailed articles on deductive/inductive reasoning and argument analysis.",
            licenseNote = "Open-access scholarly reference."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_openstax",
            name = "OpenStax Psychology & Humanities",
            domainArea = "Psychology & Open Educational Materials",
            baseUrl = "https://openstax.org/subjects/psychology",
            description = "Peer-reviewed, open-licensed university textbooks published by Rice University.",
            licenseNote = "Creative Commons Attribution 4.0 International (CC BY 4.0)."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_noba",
            name = "Noba Project Psychology",
            domainArea = "Psychology & Human Behaviour",
            baseUrl = "https://nobaproject.com/",
            description = "Open-educational psychology modules authored by leading university researchers.",
            licenseNote = "Creative Commons Attribution-NonCommercial-ShareAlike (CC BY-NC-SA)."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_apa",
            name = "American Psychological Association (APA)",
            domainArea = "Psychology & Human Behaviour",
            baseUrl = "https://www.apa.org/",
            description = "Primary scientific and professional organisation for psychological research, journals, and clinical constructs.",
            licenseNote = "Scholarly bibliographic reference."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_aps",
            name = "Association for Psychological Science (APS)",
            domainArea = "Psychology & Human Behaviour",
            baseUrl = "https://www.psychologicalscience.org/",
            description = "International organisation advancing empirical psychological science and replication standards.",
            licenseNote = "Scholarly bibliographic reference."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_pubmed",
            name = "PubMed / National Library of Medicine",
            domainArea = "Original Research & Systematic Reviews",
            baseUrl = "https://pubmed.ncbi.nlm.nih.gov/",
            description = "Biomedical, cognitive science, and clinical psychology peer-reviewed index.",
            licenseNote = "Public domain bibliographic metadata (NLM/NIH)."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_scholar",
            name = "Google Scholar",
            domainArea = "Original Research & Citations",
            baseUrl = "https://scholar.google.com/",
            description = "Cross-disciplinary index of peer-reviewed papers, books, and replication audits.",
            licenseNote = "Bibliographic verification index."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_crossref",
            name = "Crossref DOI Registry",
            domainArea = "Original Research & Evidence",
            baseUrl = "https://search.crossref.org/",
            description = "Official Digital Object Identifier (DOI) registration agency for scholarly publications.",
            licenseNote = "Open scholarly metadata."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_semanticscholar",
            name = "Semantic Scholar",
            domainArea = "Original Research & Evidence",
            baseUrl = "https://www.semanticscholar.org/",
            description = "Scientific literature research index maintained by the Allen Institute for AI.",
            licenseNote = "Open research metadata."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_tdl",
            name = "The Decision Lab",
            domainArea = "Cognitive Biases & Behavioural Economics",
            baseUrl = "https://thedecisionlab.com/biases",
            description = "Applied behavioural science catalogue used for concept discovery and cross-referencing alongside primary research.",
            licenseNote = "Educational cross-reference."
        ),
        AuthoritativeSourceRegistryEntry(
            id = "src_unesco",
            name = "UNESCO Media and Information Literacy",
            domainArea = "Media Literacy & Misinformation",
            baseUrl = "https://www.unesco.org/",
            description = "Global curriculum and research frameworks on media literacy, disinformation, and public verification.",
            licenseNote = "Open-access educational policy frameworks."
        )
    )

    val learningPathways: List<LearningPathway>
        get() = structuredLearningPathways

    val structuredLearningPathways: List<LearningPathway> = listOf(
        LearningPathway(
            id = "path_critical_thinking",
            title = "Critical Thinking & Epistemic Calibration Path",
            category = CollectionCategory.CRITICAL_THINKING,
            subtitle = "From evaluating claims and charitable interpretation to Popperian falsifiability and Bayesian belief revision.",
            stages = listOf(
                "Claims and Evidence",
                "Charitable Interpretation & Steelmanning",
                "Deductive and Inductive Reasoning",
                "Common Logical Fallacies",
                "Cognitive Biases & Heuristics",
                "Evaluating Sources",
                "Probability and Uncertainty (Bayes)",
                "Scientific Reasoning & Falsifiability",
                "Independent Judgment & Humility"
            ),
            articleIdsInOrder = listOf(
                "ct_principle_of_charity",
                "ct_steelmanning",
                "ct_socratic_questioning",
                "rp_burden_of_proof",
                "ct_falsifiability",
                "ct_bayes_theorem",
                "ct_correlation_causation",
                "ct_intellectual_humility"
            )
        ),
        LearningPathway(
            id = "path_cognitive_biases",
            title = "Cognitive Biases & Judgment Under Uncertainty Path",
            category = CollectionCategory.COGNITIVE_BIASES,
            subtitle = "How attention, memory, probability shortcuts, and social projection systematically shape human judgment.",
            stages = listOf(
                "How Judgment Works",
                "Attention and Perception",
                "Memory and Belief Formation",
                "Common Cognitive Biases",
                "Heuristics & Shortcuts",
                "Overconfidence & Blind Spots",
                "Decision-Making Under Uncertainty",
                "Bias Mitigation & Limits"
            ),
            articleIdsInOrder = listOf(
                "bias_confirmation",
                "bias_anchoring",
                "bias_halo_effect",
                "bias_survivorship",
                "bias_base_rate_fallacy",
                "bias_belief_perseverance",
                "bias_cognitive_dissonance",
                "bias_optimism",
                "bias_blind_spot"
            )
        ),
        LearningPathway(
            id = "path_media_literacy",
            title = "Media Literacy & Information Verification Path",
            category = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            subtitle = "Recognising framing, repetition effects, information flooding, and mastering lateral source verification.",
            stages = listOf(
                "How Information is Framed",
                "Source Evaluation & Lateral Reading",
                "Evidence and Claims",
                "Misinformation and Disinformation",
                "Propaganda Techniques",
                "Statistical Distortion",
                "Online Information Verification"
            ),
            articleIdsInOrder = listOf(
                "prop_lateral_reading",
                "pr_framing",
                "prop_illusory_truth",
                "prop_firehose_falsehood",
                "prop_whataboutism",
                "prop_cherry_picking",
                "prop_astroturfing"
            )
        ),
        LearningPathway(
            id = "path_logical_fallacies",
            title = "Logical Fallacies & Argument Analysis Path",
            category = CollectionCategory.LOGICAL_FALLACIES,
            subtitle = "Master formal deductive validity alongside informal relevance, ambiguity, and statistical fallacies.",
            stages = listOf(
                "Deductive Structure vs. Converse Errors",
                "Relevance Fallacies (Ad Hominem & Straw Man)",
                "False Dilemmas & Slippery Slopes",
                "Strategic Equivocation (Motte-and-Bailey)",
                "Causal & Statistical Fallacies"
            ),
            articleIdsInOrder = listOf(
                "fallacy_affirming_consequent",
                "fallacy_denying_antecedent",
                "fallacy_ad_hominem",
                "fallacy_straw_man",
                "fallacy_false_dilemma",
                "fallacy_slippery_slope",
                "fallacy_motte_and_bailey",
                "fallacy_texas_sharpshooter",
                "fallacy_no_true_scotsman"
            )
        ),
        LearningPathway(
            id = "path_manipulation_boundaries",
            title = "Psychological Manipulation & Boundary Recognition Path",
            category = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            subtitle = "Identify reality distortion, blame reversal, intermittent conditioning, and healthy boundary responses.",
            stages = listOf(
                "Reality Distortion & Gaslighting",
                "Defensive Reversal (DARVO)",
                "Emotional Pressure (FOG)",
                "Behavioral Conditioning Loops",
                "Deceptive Digital Interfaces"
            ),
            articleIdsInOrder = listOf(
                "manip_gaslighting",
                "manip_darvo",
                "manip_emotional_blackmail",
                "manip_intermittent_reinforcement",
                "manip_love_bombing",
                "manip_moving_goalposts"
            )
        ),
        LearningPathway(
            id = "path_mental_models",
            title = "Mental Models & Systems Reasoning Path",
            category = CollectionCategory.MENTAL_MODELS,
            subtitle = "Cross-disciplinary thinking tools from First Principles and Inversion to Second-Order Consequences.",
            stages = listOf(
                "First Principles Decomposition",
                "Inversion & Pre-Mortems",
                "Second-Order Systems Thinking",
                "Map vs. Territory Abstractions",
                "Circle of Competence & Margin of Safety"
            ),
            articleIdsInOrder = listOf(
                "mm_first_principles",
                "mm_inversion",
                "mm_second_order",
                "mm_map_not_territory",
                "mm_circle_of_competence",
                "mm_pareto_principle",
                "mm_margin_of_safety"
            )
        ),
        LearningPathway(
            id = "path_heuristics",
            title = "Heuristics & Bounded Rationality Path",
            category = CollectionCategory.HEURISTICS,
            subtitle = "Understand when fast-and-frugal mental shortcuts serve us well and when they misfire.",
            stages = listOf(
                "Ease of Recall (Availability)",
                "Prototype Matching (Representativeness)",
                "Risk-as-Feelings (Affect)",
                "Bounded Rationality & Satisficing",
                "Fluency & Recognition Shortcuts"
            ),
            articleIdsInOrder = listOf(
                "heur_availability",
                "heur_representativeness",
                "heur_affect",
                "heur_satisficing",
                "heur_recognition",
                "heur_fluency"
            )
        ),
        LearningPathway(
            id = "path_persuasion",
            title = "Persuasion, Rhetoric & Compliance Path",
            category = CollectionCategory.PERSUASION_AND_RHETORIC,
            subtitle = "Explore sequential request dynamics, framing architecture, and inoculation against undue influence.",
            stages = listOf(
                "Gradual Commitment (Foot-in-the-Door)",
                "Reciprocal Concessions (Door-in-the-Face)",
                "Conceptual & Metaphorical Framing",
                "Social Proof & Authority Cues",
                "Psychological Inoculation"
            ),
            articleIdsInOrder = listOf(
                "pr_foot_in_the_door",
                "pr_door_in_the_face",
                "pr_framing",
                "pr_social_proof",
                "pr_inoculation_theory"
            )
        ),
        LearningPathway(
            id = "path_paradoxes",
            title = "Philosophical & Logical Paradoxes Path",
            category = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            subtitle = "Probe the boundaries of identity, vagueness, choice, metrics, and statistical aggregation.",
            stages = listOf(
                "Diachronic Identity (Ship of Theseus)",
                "Vagueness & Continua (Sorites)",
                "Decision & Choice Overload",
                "Metric Corruption (Goodhart's Law)",
                "Statistical Reversal (Simpson's Paradox)"
            ),
            articleIdsInOrder = listOf(
                "para_ship_of_theseus",
                "para_sorites",
                "para_paradox_of_choice",
                "para_goodharts_law",
                "para_simpsons_paradox",
                "para_braess_paradox"
            )
        ),
        LearningPathway(
            id = "path_decision_errors",
            title = "Decision-Making Errors & Resource Allocation Path",
            category = CollectionCategory.DECISION_MAKING_ERRORS,
            subtitle = "Overcome sunk costs, commitment escalation, inside-view planning fallacies, and status quo inertia.",
            stages = listOf(
                "Irrecoverable Investments (Sunk Cost)",
                "Ego & Doubling Down (Escalation)",
                "Reference Class Forecasting (Planning Fallacy)",
                "Gain-Loss Valence Framing",
                "Opportunity Cost & Status Quo Traps"
            ),
            articleIdsInOrder = listOf(
                "dme_sunk_cost",
                "dme_escalation_commitment",
                "dme_planning_fallacy",
                "dme_framing_effect",
                "dme_opportunity_cost_neglect",
                "dme_status_quo_bias"
            )
        ),
        LearningPathway(
            id = "path_memory_biases",
            title = "Memory Biases & Reconstructive Recall Path",
            category = CollectionCategory.MEMORY_BIASES,
            subtitle = "How post-event suggestions, outcome knowledge, and peak-end snapshots reshape our past.",
            stages = listOf(
                "Creeping Determinism (Hindsight Bias)",
                "Post-Event Contamination (Misinformation Effect)",
                "Duration Neglect (Peak–End Rule)",
                "Source Amnesia & Cryptomnesia",
                "Rosy Retrospection & Zeigarnik Tension"
            ),
            articleIdsInOrder = listOf(
                "mem_hindsight_bias",
                "mem_misinformation_effect",
                "mem_peak_end_rule",
                "mem_source_amnesia",
                "mem_rosy_retrospection",
                "mem_zeigarnik_effect"
            )
        ),
        LearningPathway(
            id = "path_social_psychology",
            title = "Social Psychology & Collective Dynamics Path",
            category = CollectionCategory.SOCIAL_PSYCHOLOGY,
            subtitle = "Understand situational attribution, bystander diffusion, groupthink, and pluralistic ignorance.",
            stages = listOf(
                "Dispositional vs. Situational Attribution",
                "Diffusion of Responsibility (Bystander Effect)",
                "Consensus Seeking (Groupthink)",
                "Egocentric Projection (False Consensus)",
                "Group Polarisation & In-Group Bias"
            ),
            articleIdsInOrder = listOf(
                "sp_fundamental_attribution",
                "sp_bystander_effect",
                "sp_groupthink",
                "sp_false_consensus",
                "sp_group_polarisation",
                "sp_ingroup_bias"
            )
        ),
        LearningPathway(
            id = "path_psychological_phenomena",
            title = "Psychological Phenomena & Behavioural Effects Path",
            category = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            subtitle = "Explore metacognitive blind spots, interpersonal expectancy, hedonic adaptation, and attention.",
            stages = listOf(
                "Metacognitive Calibration (Dunning–Kruger)",
                "Interpersonal Expectancy (Pygmalion)",
                "Egocentric Salience (Spotlight Effect)",
                "Affective Baseline (Hedonic Treadmill)",
                "Observation & Placebo Mechanisms"
            ),
            articleIdsInOrder = listOf(
                "phen_dunning_kruger",
                "phen_pygmalion_effect",
                "phen_spotlight_effect",
                "phen_hedonic_treadmill",
                "phen_hawthorne_effect",
                "phen_baader_meinhof"
            )
        ),
        LearningPathway(
            id = "path_cognitive_distortions",
            title = "Cognitive Distortions & Reframing Path",
            category = CollectionCategory.COGNITIVE_DISTORTIONS,
            subtitle = "Identify automatic unhelpful thought patterns and apply structured cognitive restructuring.",
            stages = listOf(
                "Polarised Filtering (All-or-Nothing)",
                "Worst-Case Leaps (Catastrophizing)",
                "Affect as Proof (Emotional Reasoning)",
                "Interpersonal Projection (Mind Reading)",
                "Overgeneralisation & Personalisation"
            ),
            articleIdsInOrder = listOf(
                "cd_all_or_nothing",
                "cd_catastrophizing",
                "cd_emotional_reasoning",
                "cd_mind_reading",
                "cd_overgeneralisation",
                "cd_personalisation"
            )
        ),
        LearningPathway(
            id = "path_reasoning_principles",
            title = "Foundational Reasoning Principles & Razors Path",
            category = CollectionCategory.REASONING_PRINCIPLES,
            subtitle = "Apply philosophical razors, parsimony, burden of proof, and structural conservation rules.",
            stages = listOf(
                "Ontological Parsimony (Occam's Razor)",
                "Charitable Attribution (Hanlon's Razor)",
                "Epistemic Responsibility (Burden of Proof)",
                "Dismissing Bare Assertions (Hitchens's Razor)",
                "Systemic Conservation (Chesterton's Fence)"
            ),
            articleIdsInOrder = listOf(
                "rp_occams_razor",
                "rp_hanlons_razor",
                "rp_burden_of_proof",
                "rp_hitchens_razor",
                "rp_chestertons_fence",
                "rp_sagan_standard",
                "rp_inference_best_explanation"
            )
        )
    )
}
