package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference
import com.example.model.SourceType

object ContentPack9PathwayExpansionC {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 10. PHILOSOPHICAL & LOGICAL PARADOXES ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "para_simpsons_paradox",
            name = "Simpson's Paradox (Yule–Simpson Effect)",
            alternativeNames = listOf("Yule–Simpson Effect", "Amalgamation Paradox", "Reversal Paradox"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Probability and Statistical Paradoxes", "Statistical and Probabilistic Reasoning Errors"),
            shortDefinition = "A statistical phenomenon in which a trend or correlation that appears inside every individual subgroup of data completely reverses direction when the subgroups are combined into a single aggregate dataset.",
            beginnerExplanation = "Imagine Hospital A has a higher survival rate than Hospital B for mild cases AND a higher survival rate for severe cases. Yet when you combine all patients together, Hospital A has a *lower* overall survival rate! How? Because Hospital A is a regional trauma centre that receives almost all the severe cases, while Hospital B mostly treats mild cases. Combining unequal groups hides the confounding variable (case severity).",
            detailedExplanation = "Described by Udny Yule (1903) and Edward H. Simpson (1951), and analysed via causal graphs by Judea Pearl (2000), Simpson's Paradox occurs when a lurking confounding variable unevenly weights the sample sizes of subgroups. Famous empirical examples include the 1973 UC Berkeley graduate admissions study (Bickel et al., 1975) and kidney stone treatment comparisons (Charig et al., 1986). Resolving whether to trust the partitioned or aggregated data requires understanding the causal DAG (Directed Acyclic Graph) rather than looking at correlation tables alone.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Medical Treatment Comparison (Charig et al., 1986)",
                    scenario = "Treatment A succeeds more often than Treatment B on small kidney stones (93% vs 87%) and on large kidney stones (73% vs 69%), yet Treatment B wins in the combined total (83% vs 78%) because doctors assigned nearly all difficult large stones to Treatment A.",
                    analysis = "Baseline severity acts as a confounder that reverses the aggregate comparison."
                ),
                EverydayExample(
                    context = "University Admissions (Bickel et al., 1975)",
                    scenario = "Aggregate university admission rates appeared lower for women, but department-by-department data showed women were admitted at equal or higher rates; women had applied disproportionately to the most competitive, low-acceptance departments.",
                    analysis = "Department competitiveness confounded the aggregate summary statistic."
                )
            ),
            howToRecognise = listOf(
                "Summary statistics that merge subgroups with vastly different baseline risks or sample sizes.",
                "Causal claims drawn from observational averages without checking for confounding variables.",
                "Trends that reverse sign when stratified by age, severity, or department."
            ),
            whyItOccurs = "Weighted averages of ratios do not preserve the inequality direction of unweighted subgroup ratios when denominator weights differ.",
            howToRespond = listOf(
                "Always ask: 'Is there a confounding variable (such as severity, age, or difficulty) that determined which group participants entered?'",
                "Draw the causal relationship (does the third variable cause both the assignment and the outcome?) before deciding whether to stratify.",
                "Request both stratified subgroup tables and aggregate totals."
            ),
            relatedConceptIds = listOf("ct_correlation_causation", "bias_base_rate_fallacy", "bias_survivorship", "ct_bayes_theorem"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formally proven in probability theory (Simpson, 1951) and empirical epidemiology (Bickel et al., 1975, Science; Pearl, 2014).",
            sources = listOf(
                SourceReference(
                    title = "Simpson's Paradox",
                    sourceName = "Stanford Encyclopedia of Philosophy (SEP)",
                    authorsOrYear = "Sprenger, J. & Weinberger, N. (2021)",
                    url = "https://plato.stanford.edu/entries/paradox-simpson/",
                    publicationYear = "2021",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "Sex Bias in Graduate Admissions: Data from Berkeley",
                    sourceName = "Science (PubMed)",
                    authorsOrYear = "Bickel, P. J., Hammel, E. A., & O'Connell, J. W. (1975)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/17835295/",
                    publicationYear = "1975",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            difficultyOverride = DifficultyLevel.ADVANCED,
            keywords = listOf("yule simpson", "confounding", "berkeley admissions", "aggregation", "pearl")
        ),

        ConceptArticle(
            id = "para_braess_paradox",
            name = "Braess's Paradox",
            alternativeNames = listOf("Network Capacity Paradox", "Non-Cooperative Routing Paradox"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Decision and Game-Theoretic Paradoxes", "Systems Thinking and Feedback Loops"),
            shortDefinition = "A counterintuitive phenomenon in transport, power, and communication networks where adding an extra high-capacity road or link to a congested network actually increases overall travel time for every single user.",
            beginnerExplanation = "Common sense says building a new shortcut road between two highways must make traffic faster. Yet Dietrich Braess proved mathematically in 1968 that when every driver selfishly takes the new shortcut, it creates bottlenecks at the merge points that leave *everyone* with a longer commute than before the shortcut existed.",
            detailedExplanation = "Discovered by German mathematician Dietrich Braess (1968), Braess's Paradox arises because selfishly optimising individual agents in a congestion network converge on a Nash Equilibrium that is not Pareto-optimal. Removing a link (as famously occurred when Seoul demolished the Cheonggyecheon elevated highway in 2003, or when New York closed 42nd Street for Earth Day in 1990) can paradoxically improve flow across the entire network.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Urban Highway Planning (Seoul & Stuttgart)",
                    scenario = "After Stuttgart invested millions adding a new downtown road link in 1969, traffic gridlock worsened until planners closed the new section; conversely, Seoul's removal of a major central expressway sped up citywide traffic flow.",
                    analysis = "Selfish routing through a high-capacity connector overloads shared entry and exit nodes."
                ),
                EverydayExample(
                    context = "Team Communication Channels",
                    scenario = "Adding an 'urgent shortcut' escalation chat channel causes everyone to bypass standard triage queues, slowing down resolution times for all tickets.",
                    analysis = "Shortcut channels induce Nash-equilibrium congestion."
                )
            ),
            howToRecognise = listOf(
                "Assuming that adding capacity to one segment of an interconnected system will linearly improve whole-system throughput.",
                "Shortcuts that draw every self-interested actor into the same downstream bottleneck.",
                "Systems where individual incentives conflict with global network flow."
            ),
            whyItOccurs = "In non-cooperative congestion games, the price of anarchy exceeds 1: individual Nash Equilibrium routing diverges from the global social optimum.",
            howToRespond = listOf(
                "Model whole-system bottlenecks and merge capacities before adding local shortcuts.",
                "Test whether restricting or pricing access to congested links improves overall throughput.",
                "Apply Second-Order Thinking to network design."
            ),
            relatedConceptIds = listOf("mm_second_order", "para_goodharts_law", "sp_bystander_effect", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formally proven in operations research (Braess, 1968; translated Nagurney & Wakolbinger, 2005) and verified in physical, electrical, and traffic networks (Steinberg & Zangwill, 1983).",
            sources = listOf(
                SourceReference(
                    title = "On a Paradox of Traffic Planning (Translation of 1968 paper)",
                    sourceName = "Transportation Science",
                    authorsOrYear = "Braess, D., Nagurney, A., & Wakolbinger, T. (2005)",
                    url = "https://scholar.google.com/scholar?q=Dietrich+Braess+Paradox+of+Traffic+Planning+2005",
                    publicationYear = "2005",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            difficultyOverride = DifficultyLevel.ADVANCED,
            keywords = listOf("traffic paradox", "nash equilibrium", "network theory", "congestion", "braess")
        ),

        // ==========================================
        // 11. DECISION-MAKING ERRORS ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "dme_opportunity_cost_neglect",
            name = "Opportunity Cost Neglect",
            alternativeNames = listOf("Implicit Foregone Alternative Blindness", "Isolated Option Evaluation"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Opportunity Cost Neglect", "Economic and Strategic Models"),
            shortDefinition = "Failing to spontaneously consider the best alternative use of money, time, or attention when evaluating a single attractive purchase or commitment in isolation.",
            beginnerExplanation = "When a salesperson asks 'Would you like to buy this £1,000 stereo?', most people ask themselves 'Do I like this stereo?' instead of 'What else could I do with £1,000?' Because the alternative uses of your money or time aren't printed on the price tag, the brain ignores them.",
            detailedExplanation = "Demonstrated experimentally by Shane Frederick, Nathan Novemsky, Jing Wang, Ravi Dhar, and Stephen Nowlis (2009) in the Journal of Consumer Research, Opportunity Cost Neglect is driven by WYSIATI (What You See Is All There Is): focal options are salient, while foregone alternatives must be actively generated from memory. In Frederick et al.'s study, simply changing the ‘Do Not Buy’ option wording from 'Not buy this video' to 'Keep the $14.99 for other purchases' dramatically reduced impulse buying by making opportunity costs explicit.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Consumer Impulse Purchases",
                    scenario = "Evaluating a $15 streaming add-on in isolation ('Should I get this?') without considering what $180 per year could fund instead.",
                    analysis = "Isolated choice framing conceals the foregone alternative."
                ),
                EverydayExample(
                    context = "Calendar & Meeting Commitments",
                    scenario = "Saying 'yes' to a low-priority 1-hour meeting because your calendar slot is technically blank, forgetting that accepting it displaces 1 hour of deep uninterrupted work.",
                    analysis = "Treats an open calendar slot as having zero opportunity cost."
                )
            ),
            howToRecognise = listOf(
                "Evaluating a proposal with a yes/no vote ('Is Project A good?') instead of a comparative choice ('Is Project A better than Project B and C?').",
                "Spending time or capital simply because it is available in a budget bucket.",
                "Forgetting that saying 'yes' to one commitment automatically says 'no' to every other use of that time."
            ),
            whyItOccurs = "Bounded attention focuses on attributes of the presented option rather than simulating unstated alternatives.",
            howToRespond = listOf(
                "Reframe every yes/no expenditure as an explicit trade-off: 'Would I rather have X, or keep the £Y / Z hours for [specific alternative]?'",
                "Require project proposals to list at least two alternative ways the same engineering hours could be deployed.",
                "Price time commitments using your effective hourly opportunity value."
            ),
            relatedConceptIds = listOf("dme_sunk_cost", "dme_status_quo_bias", "mm_second_order", "dme_escalation_commitment"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Replicated across consumer choice and budgeting experiments (Frederick et al., 2009; Spiller, 2011).",
            sources = listOf(
                SourceReference(
                    title = "Opportunity Cost Neglect",
                    sourceName = "Journal of Consumer Research",
                    authorsOrYear = "Frederick, S., Novemsky, N., Wang, J., Dhar, R., & Nowlis, S. (2009)",
                    url = "https://scholar.google.com/scholar?q=Frederick+Novemsky+2009+Opportunity+Cost+Neglect",
                    publicationYear = "2009",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("trade offs", "frederick", "foregone alternatives", "budgeting", "time management")
        ),

        ConceptArticle(
            id = "dme_status_quo_bias",
            name = "Status Quo Bias & Default Effect",
            alternativeNames = listOf("Default Inertia", "Preference for the Current State"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Status Quo and Default Inertia", "Choice Architecture and Nudging"),
            shortDefinition = "The disproportionate preference for keeping things as they currently are—or sticking with pre-selected default options—even when switching costs are tiny and alternative options are objectively superior.",
            beginnerExplanation = "When a software setting, pension plan, or organ-donation form comes with a pre-checked box, the vast majority of people never change it. Leaving things alone feels safe, while actively switching makes us feel responsible if the new choice goes wrong.",
            detailedExplanation = "Coined by William Samuelson and Richard Zeckhauser (1988) in the Journal of Risk and Uncertainty, Status Quo Bias is reinforced by three mechanisms: (1) Loss Aversion (Kahneman & Tversky) — any potential downside of switching looms twice as large as an equivalent upside; (2) Omission Bias — people feel more regret for bad outcomes caused by taking action than by doing nothing; and (3) Cognitive Effort Avoidance — sticking with the default requires zero decision energy (Johnson & Goldstein, 2003).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Organ Donation & Retirement Defaults (Johnson & Goldstein, 2003)",
                    scenario = "Countries with opt-in organ donation defaults had ~15% registration rates, whereas culturally similar countries with opt-out defaults had >90% registration rates.",
                    analysis = "The pre-set status quo dominates choice when decision effort or emotional friction is high."
                ),
                EverydayExample(
                    context = "Legacy Legacy Software & Subscriptions",
                    scenario = "Keeping an overpriced legacy bank account or insurances policy for a decade despite superior, easily switchable alternatives.",
                    analysis = "Inertia and perceived switching friction preserve suboptimal defaults."
                )
            ),
            howToRecognise = listOf(
                "Defending an existing workflow solely with 'That's how we've always done it.'",
                "Evaluating new proposals against an imaginary perfection standard while excusing the known flaws of the current system.",
                "Remaining on default settings or auto-renewing plans without periodic review."
            ),
            whyItOccurs = "Loss aversion around the current reference point combined with omission bias and decision fatigue.",
            howToRespond = listOf(
                "Apply the 'Zero-Base Inversion Test': ask 'If we were not already in this current state today, would we actively choose to enter it right now?'",
                "Design benevolent defaults (such as automatic savings enrollment) while auditing manipulative dark-pattern defaults.",
                "Schedule a semi-annual zero-based audit of recurring commitments and workflows."
            ),
            relatedConceptIds = listOf("dme_framing_effect", "dme_sunk_cost", "dme_opportunity_cost_neglect", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Extensively validated in behavioral economics and public policy (Samuelson & Zeckhauser, 1988; Johnson & Goldstein, 2003, Science).",
            sources = listOf(
                SourceReference(
                    title = "Status Quo Bias in Decision Making",
                    sourceName = "Journal of Risk and Uncertainty",
                    authorsOrYear = "Samuelson, W. & Zeckhauser, R. (1988)",
                    url = "https://scholar.google.com/scholar?q=Samuelson+Zeckhauser+1988+Status+Quo+Bias",
                    publicationYear = "1988",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Do Defaults Save Lives?",
                    sourceName = "Science (PubMed)",
                    authorsOrYear = "Johnson, E. J. & Goldstein, D. (2003)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/14631022/",
                    publicationYear = "2003",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("default effect", "inertia", "samuelson zeckhauser", "nudge", "zero base")
        ),

        // ==========================================
        // 12. MEMORY BIASES ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "mem_rosy_retrospection",
            name = "Rosy Retrospection & Declinism",
            alternativeNames = listOf("Fading Affect Bias", "Nostalgic Memory Filter", "The 'Good Old Days' Bias"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Nostalgia and Rosy Retrospection", "Emotional and Flashbulb Memory Distortions"),
            shortDefinition = "The tendency to remember past events and eras more fondly than we actually experienced them at the time, because minor annoyances fade from memory faster than positive highlights.",
            beginnerExplanation = "During a camping trip, you might spend half the week complaining about mosquitoes, rain, and a sore back. Six months later, you remember the trip as idyllic and magical. That is Rosy Retrospection. On a societal scale, it fuels 'Declinism'—the illusion that society is constantly deteriorating compared to an idealized golden past.",
            detailedExplanation = "Studied experimentally by Terence Mitchell, Leigh Thompson, Erika Peterson, and Randy Cronk (1997), Rosy Retrospection is closely linked to the Fading Affect Bias (Walker et al., 2003), in which negative emotions attached to autobiographical memories dissipate faster than positive emotions. While psychologically adaptive for personal mood regulation, it distorts repeat decision-making and fuels political nostalgia by erasing historical hardships.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Vacation & Travel Memories (Mitchell et al., 1997)",
                    scenario = "Cyclists and vacationers rated their trips significantly more positively weeks after returning home than they did during daily real-time diary check-ins on the trip itself.",
                    analysis = "Mundane discomforts fade while narrative highlights consolidate."
                ),
                EverydayExample(
                    context = "Generational Declinism",
                    scenario = "Believing that past decades had universally higher civility or simpler problems while forgetting the inflation, crime rates, or illnesses of those same years.",
                    analysis = "Compares an edited highlight reel of the past against the unedited raw footage of the present."
                )
            ),
            howToRecognise = listOf(
                "Idealizing a former job, relationship, or era whose daily frustrations you complained about at the time.",
                "Making repeat commitments without checking contemporaneous notes from the last iteration.",
                "Sweeping claims that 'everything used to be better.'"
            ),
            whyItOccurs = "Adaptive coping mechanisms cause negative emotional valence to decay faster than positive valence in healthy autobiographical memory (Fading Affect Bias).",
            howToRespond = listOf(
                "Keep real-time decision journals or post-project logs while an experience is actually happening.",
                "Compare current statistics against historical empirical baselines rather than nostalgic memory.",
                "Pair with Peak-End Rule awareness when evaluating past projects."
            ),
            relatedConceptIds = listOf("mem_peak_end_rule", "mem_hindsight_bias", "bias_survivorship", "mem_misinformation_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated in longitudinal diary studies (Mitchell et al., 1997, Journal of Experimental Social Psychology; Walker et al., 2003).",
            sources = listOf(
                SourceReference(
                    title = "Temporal Adjustments in the Evaluation of Events: The 'Rosy View'",
                    sourceName = "Journal of Experimental Social Psychology",
                    authorsOrYear = "Mitchell, T. R., Thompson, L., Peterson, E., & Cronk, R. (1997)",
                    url = "https://scholar.google.com/scholar?q=Mitchell+Thompson+1997+Rosy+View+Temporal+Adjustments",
                    publicationYear = "1997",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("nostalgia", "fading affect bias", "declinism", "mitchell", "autobiographical memory")
        ),

        ConceptArticle(
            id = "mem_zeigarnik_effect",
            name = "Zeigarnik Effect",
            alternativeNames = listOf("Interrupted Task Memory Advantage", "Open-Loop Cognitive Tension"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.PSYCHOLOGICAL_PHENOMENA),
            subcategories = listOf("Retrieval and Accessibility Biases", "Encoding and Attention Limits"),
            shortDefinition = "The tendency for interrupted, incomplete, or unresolved tasks to remain significantly more active and intrusive in working memory than tasks that have been completed.",
            beginnerExplanation = "Waiters in busy Vienna cafés could remember complex, unpaid orders across a dozen tables with pinpoint accuracy—yet the instant a bill was paid, they completely forgot what the table had ordered. Psychologist Bluma Zeigarnik discovered that starting a task creates a mental 'open loop' that keeps tugging at your attention until it reaches closure.",
            detailedExplanation = "Published by Soviet Gestalt psychologist Bluma Zeigarnik (1927) under the supervision of Kurt Lewin, the Zeigarnik Effect shows that initiating a goal-directed task establishes a state of quasi-need or cognitive tension that facilitates memory accessibility until the goal is discharged. Follow-up research by Baumeister and Masicampo (2011) revealed a crucial practical insight: you don't have to *finish* a massive project at midnight to silence intrusive Zeigarnik thoughts—writing down a concrete next-step plan satisfies the brain's closure mechanism.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Overcoming Procrastination",
                    scenario = "Committing to write for just 5 minutes on a dreaded report opens the cognitive loop, making your brain naturally continue thinking about the structure afterward.",
                    analysis = "Starting an incomplete task harnesses Zeigarnik tension to build momentum."
                ),
                EverydayExample(
                    context = "Late-Night Intrusive Work Thoughts (Masicampo & Baumeister, 2011)",
                    scenario = "Lying awake rehearsing tomorrow's unfinished tasks until you write them down into a concrete morning checklist.",
                    analysis = "Externalizing a specific plan discharges the cognitive burden on working memory."
                )
            ),
            howToRecognise = listOf(
                "Intrusive thoughts about unfinished chores or unanswered messages while trying to rest.",
                "Cliffhangers in television series that make an episode unforgettable compared to resolved storylines.",
                "Difficulty starting a project, followed by strong mental momentum once the first step is underway."
            ),
            whyItOccurs = "Goal activation maintains heightened sub-threshold accessibility of task-related schemas in prospective memory until closure or concrete planning occurs.",
            howToRespond = listOf(
                "To beat procrastination, start a task for just 3 minutes to open the Zeigarnik loop.",
                "To stop evening rumination, write a shutdown checklist specifying *when* and *how* you will resume each unfinished task tomorrow (Masicampo & Baumeister, 2011).",
                "Avoid leaving dozens of half-started tabs open simultaneously."
            ),
            relatedConceptIds = listOf("mem_peak_end_rule", "mem_source_amnesia", "phen_spotlight_effect", "dme_planning_fallacy"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Originating in Gestalt psychology (Zeigarnik, 1927) and refined by modern experimental research on goal planning and cognitive offloading (Masicampo & Baumeister, 2011, Journal of Personality and Social Psychology).",
            sources = listOf(
                SourceReference(
                    title = "Consider It Done! Plan Making Can Eliminate the Cognitive Effects of Unfulfilled Goals",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Masicampo, E. J. & Baumeister, R. F. (2011)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21688924/",
                    publicationYear = "2011",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("bluma zeigarnik", "open loops", "cliffhanger", "procrastination", "cognitive offloading")
        ),

        // ==========================================
        // 13. SOCIAL PSYCHOLOGY ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "sp_group_polarisation",
            name = "Group Polarisation",
            alternativeNames = listOf("Choice Shift", "Deliberative Extremification"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Groupthink and Polarisation", "Algorithmic Amplification and Echo Chambers"),
            shortDefinition = "The documented phenomenon in which, after deliberating inside a like-minded group, members shift toward a more extreme version of their initial shared inclination.",
            beginnerExplanation = "If you put six moderately cautious investors in a room to discuss a risky stock, their group consensus ends up *more* cautious than their average individual opinion. If you put six moderately risk-seeking investors together, the group ends up *more* reckless. Talking exclusively with people who already lean the same way amplifies the group's starting tilt.",
            detailedExplanation = "First discovered by James Stoner (1961) as the 'Risky Shift' and generalized by Serge Moscovici and Marisa Zavalloni (1969) and Cass Sunstein (2002), Group Polarisation operates through two mechanisms: (1) Persuasive Arguments Theory — inside a homogeneous group, members hear a skewed pool of new arguments that all point in the same direction, reinforcing certainty; and (2) Social Comparison — wanting to be perceived favourably by the ingroup, members shift slightly further toward the group's valued ideal than the perceived average.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Homogeneous Committees & Juries (Moscovici & Zavalloni, 1969)",
                    scenario = "Jury panels or investment committees that begin with a mild majority tilt routinely reach verdicts or capital allocations more extreme than the pre-discussion median of their members.",
                    analysis = "Skewed argument pools and one-upmanship shift the group norm outward."
                ),
                EverydayExample(
                    context = "Online Ideological Communities",
                    scenario = "Partisan forums where moderate remarks receive low engagement while increasingly strident versions of the group's consensus are rewarded.",
                    analysis = "Social comparison incentives drive progressive extremification."
                )
            ),
            howToRecognise = listOf(
                "Deliberating bodies where every participant starts on the same side of an issue.",
                "Meetings where moderate nuances are dropped and confidence increases without any new external counter-evidence.",
                "Feeling social pressure to signal purity by stating a stronger version of the group opinion."
            ),
            whyItOccurs = "Limited argument pools (informational influence) combined with normative one-upmanship (social comparison).",
            howToRespond = listOf(
                "Ensure deliberating teams include genuine viewpoint diversity and independent pre-meeting anonymous ballots.",
                "Assign a rotating Red Team or Devil's Advocate role before consensus solidifies.",
                "Expose the group to the strongest Steelman arguments from outside the group."
            ),
            relatedConceptIds = listOf("sp_groupthink", "prop_firehose_falsehood", "sp_bystander_effect", "sp_false_consensus"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated across hundreds of small-group deliberation studies (Moscovici & Zavalloni, 1969; Myers & Lamm, 1976; Sunstein, 2002).",
            sources = listOf(
                SourceReference(
                    title = "The Group as a Polarizer of Attitudes",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Moscovici, S. & Zavalloni, M. (1969)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/5796999/",
                    publicationYear = "1969",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "The Law of Group Polarization",
                    sourceName = "Journal of Political Philosophy",
                    authorsOrYear = "Sunstein, C. R. (2002)",
                    url = "https://scholar.google.com/scholar?q=Cass+Sunstein+2002+Law+of+Group+Polarization",
                    publicationYear = "2002",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("moscovici", "sunstein", "risky shift", "extremism", "deliberation")
        ),

        ConceptArticle(
            id = "sp_ingroup_bias",
            name = "Ingroup Favoritism & Outgroup Homogeneity",
            alternativeNames = listOf("Minimal Group Paradigm Effect", "Outgroup Homogeneity Bias", "Intergroup Bias"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Ingroup-Outgroup Dynamics and Prejudice", "Social Judgment"),
            shortDefinition = "The tendency to extend preferential trust, charity, and individuality to members of one's own group ('us') while perceiving members of outside groups ('them') as uniform and interchangeable ('they are all alike').",
            beginnerExplanation = "In classic experiments by Henri Tajfel, strangers were divided into two groups based on something completely meaningless—like a coin toss or whether they preferred two abstract painters. Within minutes, participants started awarding more money to their own arbitrary 'ingroup' and viewing the other group as less nuanced. Simultaneously, we see our own group as a rich collection of unique individuals, while assuming everyone in an outside group thinks and acts the same.",
            detailedExplanation = "Grounded in Social Identity Theory (Tajfel & Turner, 1979) and Outgroup Homogeneity research (Quattrone & Jones, 1980; Linville et al., 1989), intergroup bias emerges even in 'minimal groups' with no history of conflict. Furthermore, Thomas Pettigrew (1979) identified the 'Ultimate Attribution Error': attributing positive acts by ingroup members to their noble character, while dismissing identical positive acts by outgroup members as mere luck or an 'exception to the rule.'",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Corporate Silos & Mergers",
                    scenario = "Engineering and sales teams viewing their own department as diverse and reasonable while stereotyping the other department as a monolithic bloc.",
                    analysis = "Outgroup homogeneity compresses perceived variance among outsiders."
                ),
                EverydayExample(
                    context = "Sports & Civic Rivalries",
                    scenario = "Excusing a foul by a home-team player as 'accidental hustle' while condemning the exact same foul by a visiting player as 'dirty play.'",
                    analysis = "Demonstrates the Ultimate Attribution Error across group boundaries."
                )
            ),
            howToRecognise = listOf(
                "Saying 'They all think X' about an external group while insisting 'Our side is complex and varied.'",
                "Giving the benefit of the doubt to an ally for behavior you would immediately condemn in a rival.",
                "Forming tribal loyalties around arbitrary labels or divisions."
            ),
            whyItOccurs = "Self-esteem maintenance via Social Identity Theory combined with differential familiarity with ingroup vs. outgroup individuals.",
            howToRespond = listOf(
                "Apply the Double-Standard Swap Test: 'If an outgroup member did this exact action, how would I judge it?'",
                "Create superordinate shared goals and cross-functional teams (Muzafer Sherif's Robbers Cave principle and Allport's Intergroup Contact Hypothesis).",
                "Actively seek out diverse individual perspectives within outside groups."
            ),
            relatedConceptIds = listOf("sp_fundamental_attribution", "bias_halo_effect", "sp_false_consensus", "ct_steelmanning"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Foundation of modern social psychology (Tajfel et al., 1971; Tajfel & Turner, 1979; Pettigrew & Tropp, 2006 meta-analysis of 515 studies on intergroup contact).",
            sources = listOf(
                SourceReference(
                    title = "Social categorization and intergroup behaviour",
                    sourceName = "European Journal of Social Psychology",
                    authorsOrYear = "Tajfel, H., Billig, M. G., Bundy, R. P., & Flament, C. (1971)",
                    url = "https://scholar.google.com/scholar?q=Tajfel+1971+Social+categorization+and+intergroup+behaviour",
                    publicationYear = "1971",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "A meta-analytic test of intergroup contact theory",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Pettigrew, T. F. & Tropp, L. R. (2006)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/16737372/",
                    publicationYear = "2006",
                    sourceType = SourceType.META_ANALYSIS
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("tajfel", "social identity theory", "outgroup homogeneity", "minimal group", "tribalism")
        ),

        // ==========================================
        // 14. CRITICAL THINKING ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "ct_socratic_questioning",
            name = "Socratic Questioning",
            alternativeNames = listOf("Disciplined Maieutic Inquiry", "Socratic Elenchus"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Socratic Questioning and Assumption Auditing", "Epistemic Humility and Calibration"),
            shortDefinition = "A disciplined, systematic method of questioning that examines the definitions, hidden assumptions, evidence, implications, and counter-perspectives beneath a belief.",
            beginnerExplanation = "Instead of arguing by shouting counter-opinions, Socrates helped people test the strength of their own ideas by asking calm, structured questions: 'What do we mean by this word? What are we assuming must be true for this to work? What evidence would prove us wrong?'",
            detailedExplanation = "Originating in Plato's early Socratic dialogues (*Euthyphro*, *Meno*, *Theaetetus*) and codified for modern critical thinking education and cognitive therapy by Richard Paul and Linda Elder (2006) as well as Judith Beck (1995), Socratic Questioning operates across six systematic categories: (1) Clarifying concepts; (2) Probing underlying assumptions; (3) Probing evidence and reasons; (4) Questioning viewpoints and perspectives; (5) Probing implications and consequences; and (6) Questioning the original question itself.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Engineering Architecture Review",
                    scenario = "Instead of saying 'Your microservice plan will fail,' asking: 'What peak latency are we assuming between these two services, and what happens if network packet loss hits 2%?'",
                    analysis = "Surfaces hidden technical assumptions collaboratively without triggering defensive posturing."
                ),
                EverydayExample(
                    context = "Self-Reflective Belief Auditing",
                    scenario = "Asking yourself: 'How do I know this claim is true, and what specific evidence would cause me to revise my position?'",
                    analysis = "Applies structured epistemic inquiry to one's own beliefs."
                )
            ),
            howToRecognise = listOf(
                "Questions that clarify definitions ('How are we measuring X?') and unstated premises ('What has to be true for this plan to succeed?').",
                "Collaborative inquiry aimed at truth rather than 'gotcha' rhetorical traps.",
                "Examining the logical consequences of a principle across edge cases."
            ),
            whyItOccurs = "Human reasoning routinely relies on compressed, unexamined assumptions that only become visible when explicitly unpacked through structured inquiry.",
            howToRespond = listOf(
                "Use the 6 Socratic Question types: Clarify -> Probe Assumptions -> Probe Evidence -> Check Alternatives -> Trace Consequences -> Meta-check the Question.",
                "Ask questions with genuine curiosity rather than disguised hostility.",
                "Apply Socratic questioning to your own favoured conclusions first."
            ),
            relatedConceptIds = listOf("ct_steelmanning", "ct_falsifiability", "mm_first_principles", "rp_hanlons_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Foundational method of Western philosophy (Plato) and empirically validated in Cognitive Behavioural Therapy outcome research (Braun et al., 2015, Behaviour Research and Therapy).",
            sources = listOf(
                SourceReference(
                    title = "Socrates",
                    sourceName = "Stanford Encyclopedia of Philosophy (SEP)",
                    authorsOrYear = "Nails, D. & Monoson, S. (2022)",
                    url = "https://plato.stanford.edu/entries/socrates/",
                    publicationYear = "2022",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "Therapist use of Socratic questioning predicts session-to-session symptom change in cognitive therapy for depression",
                    sourceName = "Behaviour Research and Therapy (PubMed)",
                    authorsOrYear = "Braun, J. D., Strunk, D. R., Sasso, K. E., & Cooper, A. A. (2015)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/25989091/",
                    publicationYear = "2015",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            difficultyOverride = DifficultyLevel.BEGINNER,
            keywords = listOf("socrates", "elenchus", "assumptions", "paul elder", "inquiry")
        ),

        ConceptArticle(
            id = "ct_correlation_causation",
            name = "Correlation vs. Causation & Confounding",
            alternativeNames = listOf("Cum Hoc Ergo Propter Hoc", "Third-Variable Problem", "Reverse Causality Check"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Causal Inference and Confounding Variables", "Causal Fallacies"),
            shortDefinition = "The foundational critical-thinking principle that observing two variables moving together (correlation) does not prove that one causes the other, because a third hidden variable (confounder), reverse causality, or coincidence may explain the link.",
            beginnerExplanation = "Ice cream sales and shark attacks rise and fall together every year. Does eating ice cream attract sharks? No—hot summer weather (a third 'confounding' variable) causes more people both to buy ice cream and to swim in the ocean. Whenever a headline says 'Study finds X is linked to Y,' always ask whether X caused Y, Y caused X, or Z caused both.",
            detailedExplanation = "Formalised in epidemiology by Austin Bradford Hill (1965, 'The Environment and Disease: Association or Causation?') and in causal inference by Judea Pearl (2000) and Donald Rubin (1974), an observed correlation between A and B admits at least four distinct explanations: (1) Direct causation (A -> B); (2) Reverse causation (B -> A); (3) Common-cause confounding (Z -> A and Z -> B); or (4) Selection/collider bias (conditioning on a common effect C) or spurious coincidence.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Nutrition & Lifestyle Headlines",
                    scenario = "An observational study finds that people who drink a specific expensive herbal tea live 4 years longer—ignoring that buyers of that tea also have higher incomes, lower smoking rates, and better healthcare access.",
                    analysis = "Socioeconomic status and health consciousness act as unmeasured confounders."
                ),
                EverydayExample(
                    context = "Reverse Causality in Workplace Mood",
                    scenario = "Observing that depressed employees spend more time scrolling phones and concluding phones caused the depression, when low mood may also drive withdrawal into passive scrolling.",
                    analysis = "Bidirectional or reverse causation (B -> A) mimics simple forward causation."
                )
            ),
            howToRecognise = listOf(
                "Headlines that translate observational correlations ('is associated with', 'is linked to') into causal verbs ('boosts', 'causes', 'prevents').",
                "Studies without random assignment or rigorous control for socioeconomic and baseline health confounders.",
                "Ignoring the possibility of reverse causality."
            ),
            whyItOccurs = "Human perception evolved as an associative pattern detector that automatically links co-occurring events into causal narratives.",
            howToRespond = listOf(
                "Run the 4-Way Causal Audit on every 'X linked to Y' claim: Could Y cause X? Could a third factor Z cause both? Is there a randomized controlled trial (RCT)?",
                "Apply the Bradford Hill Criteria (strength, consistency, dose-response gradient, temporality, biological plausibility, experimental evidence).",
                "Watch out for Simpson's Paradox and Berkson's Paradox in observational data."
            ),
            relatedConceptIds = listOf("fallacy_texas_sharpshooter", "para_simpsons_paradox", "bias_survivorship", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Core methodological cornerstone of statistics, epidemiology, and econometrics (Hill, 1965; Pearl, 2009, *Causality*; Imbens & Rubin, 2015).",
            sources = listOf(
                SourceReference(
                    title = "The Environment and Disease: Association or Causation?",
                    sourceName = "Proceedings of the Royal Society of Medicine (PubMed)",
                    authorsOrYear = "Hill, A. B. (1965)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/14283879/",
                    publicationYear = "1965",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Causal Inference in Statistics: An Overview",
                    sourceName = "Statistics Surveys",
                    authorsOrYear = "Pearl, J. (2009)",
                    url = "https://scholar.google.com/scholar?q=Judea+Pearl+2009+Causal+Inference+in+Statistics",
                    publicationYear = "2009",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            difficultyOverride = DifficultyLevel.BEGINNER,
            keywords = listOf("bradford hill", "confounder", "cum hoc", "reverse causality", "causal inference")
        ),

        // ==========================================
        // 15. REASONING PRINCIPLES ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "rp_sagan_standard",
            name = "The Sagan Standard (Extraordinary Claims & Evidence)",
            alternativeNames = listOf("ECREE ('Extraordinary Claims Require Extraordinary Evidence')", "Laplace's Principle of Proportional Evidence"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Burden of Proof and Evidentiary Proportionality", "Bayesian Epistemology"),
            shortDefinition = "The epistemological principle that the weight of evidence required to accept a claim must be strictly proportional to how improbable or extraordinary that claim is relative to established prior knowledge.",
            beginnerExplanation = "If your colleague says 'I saw a pigeon in the park this morning,' you can take their casual word for it because pigeons are common. If they say 'I saw a living pterodactyl in the park this morning,' a casual anecdote is no longer enough—you need extraordinary, independently verified physical evidence. That is the Sagan Standard.",
            detailedExplanation = "Popularised by astronomer Carl Sagan in *Cosmos* (1980)—and traced back through sociologist Marcello Truzzi (1978), Pierre-Simon Laplace (1814, 'The weight of evidence for an extraordinary claim must be proportioned to its strangeness'), and David Hume (1748, *Of Miracles*)—the Sagan Standard is a direct consequence of Bayes' Theorem. When a hypothesis has an extremely low prior probability P(H) because it contradicts vast bodies of tested physical law, weak or noisy evidence (which has a non-trivial false-positive rate) cannot push the posterior probability above 50%.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Evaluating Medical & Financial Claims",
                    scenario = "Demanding peer-reviewed, multi-centre randomized controlled trials before believing a supplement cures an incurable disease, while accepting a minor ergonomic tip on simple plausibility.",
                    analysis = "Scales evidentiary thresholds to match the prior improbability and stakes of the claim."
                ),
                EverydayExample(
                    context = "Software Root-Cause Debugging",
                    scenario = "Requiring ironclad packet-level proof before blaming a bug on a cosmic ray flipping a CPU register rather than a typo in yesterday's code commit.",
                    analysis = "Low-prior hypotheses require correspondingly rigorous evidence."
                )
            ),
            howToRecognise = listOf(
                "Revolutionary claims backed only by personal anecdotes, blurry screenshots, or small unblinded studies.",
                "Demanding the same low bar of proof for a law-defying claim as for a mundane everyday report.",
                "Forgetting that test error or observer mistake is often more probable than a miracle."
            ),
            whyItOccurs = "Human narrative intuition treats vivid stories as persuasive regardless of base rates.",
            howToRespond = listOf(
                "Ask Hume's Question: 'Is it more probable that the reporter is mistaken/deceived, or that the established laws of nature have been suspended?'",
                "Translate the Sagan Standard into Bayesian terms: compare the prior odds against the likelihood ratio of the evidence.",
                "Demand pre-registered, independent replication for high-surprise findings."
            ),
            relatedConceptIds = listOf("ct_bayes_theorem", "rp_hitchens_razor", "rp_occams_razor", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formally grounded in Bayesian probability theory (Laplace, 1814; Hume, 1748; Wagenmakers et al., 2011).",
            sources = listOf(
                SourceReference(
                    title = "Miracles",
                    sourceName = "Stanford Encyclopedia of Philosophy (SEP)",
                    authorsOrYear = "McGrew, T. (2019)",
                    url = "https://plato.stanford.edu/entries/miracles/",
                    publicationYear = "2019",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "On the Extraordinary: An Attempt at Clarification",
                    sourceName = "Zetetic Scholar",
                    authorsOrYear = "Truzzi, M. (1978)",
                    url = "https://scholar.google.com/scholar?q=Marcello+Truzzi+1978+On+the+Extraordinary",
                    publicationYear = "1978",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("carl sagan", "laplace", "david hume", "extraordinary claims", "bayesian prior")
        ),

        ConceptArticle(
            id = "rp_inference_best_explanation",
            name = "Inference to the Best Explanation (Abductive Reasoning)",
            alternativeNames = listOf("Abduction", "Peircean Abductive Inference", "Diagnostic Reasoning"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.MENTAL_MODELS),
            subcategories = listOf("Deductive, Inductive, and Abductive Logic", "Scientific Method and Hypothesis Testing"),
            shortDefinition = "The third major mode of logical inference (alongside deduction and induction), in which we compare competing hypotheses and provisionally adopt the one that would, if true, best explain the totality of the observed evidence.",
            beginnerExplanation = "When a doctor examines your symptoms or a detective inspects a crime scene, they aren't doing pure deductive math (`All A are B`), nor are they just counting pennies (`100 swans were white`). They are doing *Abduction*—asking: 'Out of all possible explanations, which single hypothesis best accounts for all the clues with the fewest ad-hoc excuses?'",
            detailedExplanation = "Introduced into modern logic by American philosopher Charles Sanders Peirce (1903) as 'Abduction' and developed as 'Inference to the Best Explanation' (IBE) by Gilbert Harman (1965) and Peter Lipton (2004, *Inference to the Best Explanation*), abductive reasoning evaluates candidate hypotheses on explanatory virtues: (1) Explanatory Scope (how many independent facts it unifies); (2) Simplicity / Parsimony (Occam's Razor); (3) Mechanism Plausibility; (4) Absence of ad-hoc immunisations; and (5) Predictive Fertility (generating new testable predictions).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Medical Differential Diagnosis",
                    scenario = "A patient presents with fever, joint pain, and a bull's-eye rash after hiking in wooded Connecticut; Lyme disease is inferred as the best unifying explanation over three separate unrelated ailments.",
                    analysis = "Unifies multiple independent clues under a single known causal mechanism."
                ),
                EverydayExample(
                    context = "Scientific Discovery (Darwin & Plate Tectonics)",
                    scenario = "Inferring continental drift because it simultaneously explains matching coastal geometries, identical fossil strata across oceans, and paleomagnetic stripes.",
                    analysis = "Consilience of inductions provides powerful abductive support."
                )
            ),
            howToRecognise = listOf(
                "Diagnostic situations where multiple clues must be synthesized into a coherent causal story.",
                "Competing explanations where one theory unifies all observations naturally while its rival requires five separate coincidences.",
                "Remembering that the 'best available explanation' is still provisional and must be tested via new predictions."
            ),
            whyItOccurs = "Real-world scientific and diagnostic reasoning is underdetermined by raw data alone; explanatory virtues guide rational hypothesis selection.",
            howToRespond = listOf(
                "Always generate at least three competing hypotheses before crowning a 'best' explanation (Chamberlin's Method of Multiple Working Hypotheses, 1890).",
                "Score competing explanations on Scope, Parsimony, Mechanism, and Testable Predictions.",
                "Never confuse an unfalsifiable conspiracy that explains everything via ad-hoc excuses with a genuine best explanation."
            ),
            relatedConceptIds = listOf("rp_occams_razor", "ct_bayes_theorem", "ct_falsifiability", "rp_hitchens_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Central pillar of philosophy of science and diagnostic methodology (Peirce, 1903; Harman, 1965; Lipton, 2004; Douven, SEP 2021).",
            sources = listOf(
                SourceReference(
                    title = "Abduction",
                    sourceName = "Stanford Encyclopedia of Philosophy (SEP)",
                    authorsOrYear = "Douven, I. (2021)",
                    url = "https://plato.stanford.edu/entries/abduction/",
                    publicationYear = "2021",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "The Inference to the Best Explanation",
                    sourceName = "The Philosophical Review",
                    authorsOrYear = "Harman, G. H. (1965)",
                    url = "https://scholar.google.com/scholar?q=Gilbert+Harman+1965+Inference+to+the+Best+Explanation",
                    publicationYear = "1965",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            difficultyOverride = DifficultyLevel.INTERMEDIATE,
            keywords = listOf("abduction", "peirce", "lipton", "harman", "differential diagnosis", "consilience")
        )
    )
}
