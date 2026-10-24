package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack3ModelsHeuristicsPersuasion {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 6. MENTAL MODELS
        // ==========================================
        ConceptArticle(
            id = "mm_first_principles",
            name = "First Principles Thinking",
            alternativeNames = listOf("Reasoning from First Principles", "Foundational Decomposition"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Foundational Reasoning Models"),
            shortDefinition = "Breaking a complex problem down to its most fundamental, undeniable truths and reasoning upward from there, rather than reasoning by analogy to how others currently do things.",
            beginnerExplanation = "Most of the time we reason by analogy: copying existing templates with slight tweaks because 'that's how the industry does it.' First Principles thinking strips away every inherited assumption until only basic physical or logical facts remain, then rebuilds a solution from scratch.",
            detailedExplanation = "Rooted in Aristotle's Metaphysics (where a 'first principle' or arche is 'the first basis from which a thing is known') and René Descartes' method of systematic doubt, First Principles thinking contrasts foundational deduction with mimetic analogy. Reasoning by analogy is efficient for routine tasks, but it locks in legacy inefficiencies and historical constraints that may no longer apply. By asking 'What are we completely sure is true here, independent of convention?' and 'What are the actual physical, mathematical, or economic components of this problem?', practitioners uncover solutions invisible to incremental benchmarking.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Engineering & Cost Analysis",
                    scenario = "Instead of accepting that a specialised laboratory instrument must cost $10,000 because all catalog vendors charge $10,000, a researcher lists its raw optical and electronic parts, sees they cost $400 on open markets, and assembles an open-source version.",
                    analysis = "Separates the historical market price (analogy) from the fundamental bill of materials (first principles)."
                ),
                EverydayExample(
                    context = "Team Workflow Redesign",
                    scenario = "Instead of shortening a tedious 15-page weekly status report to 10 pages, asking: 'What specific decision does this report actually enable on Monday morning?' and replacing it with a 3-line automated dashboard.",
                    analysis = "Questions the foundational purpose of the artifact rather than optimising its surface form."
                )
            ),
            howToRecognise = listOf(
                "Deconstructing a problem using Socratic questioning: 'Why do we assume X is required?'",
                "Separating laws of physics or formal logic from industry habits and legacy rules.",
                "Building estimates from fundamental components upward rather than adjusting a competitor's price."
            ),
            whyItOccurs = "Reasoning by analogy is our default heuristic because it saves energy and leverages collective experience. Deliberately switching to First Principles requires overriding social conformity and anchoring biases.",
            howToRespond = listOf(
                "Use a 3-step Socratic audit: (1) Identify your current assumptions, (2) Break the problem down to its fundamental truths, (3) Create new solutions from scratch.",
                "Ask 'If we were starting this project today with a blank sheet of paper, would we design it this way?'",
                "Balance First Principles with Chesterton's Fence—understand why a convention existed before discarding it."
            ),
            relatedConceptIds = listOf("mm_second_order", "rp_chestertons_fence", "bias_anchoring", "mm_inversion"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A classical epistemological method originating in Aristotle (Posterior Analytics; Metaphysics) and Descartes, widely studied in engineering design theory and problem-solving research (Cross, 2006).",
            sources = listOf(
                SourceReference(
                    title = "Aristotle's Psychology and Epistemology (First Principles)",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Shields, C. (2020)",
                    url = "https://plato.stanford.edu/entries/aristotle/"
                ),
                SourceReference(
                    title = "Designerly Ways of Knowing",
                    sourceName = "Springer Design Research",
                    authorsOrYear = "Cross, N. (2006)",
                    url = "https://scholar.google.com/scholar?q=Nigel+Cross+2006+Designerly+Ways+of+Knowing"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("aristotle", "analogy", "deconstruction", "foundations", "innovation")
        ),

        ConceptArticle(
            id = "mm_second_order",
            name = "Second-Order Thinking",
            alternativeNames = listOf("Higher-Order Consequence Mapping", "And-Then-What Thinking"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Systems & Strategic Thinking"),
            shortDefinition = "Evaluating not just the immediate, obvious result of an action (first-order effect), but tracing the subsequent chain reactions, incentives, and feedback loops that follow ('And then what?').",
            beginnerExplanation = "First-order thinking only looks at the first domino: 'I want to fix this immediate problem.' Second-order thinking looks at the second, third, and fourth dominoes: 'Once I make this change, how will people adapt, and what new problems will that create six months from now?'",
            detailedExplanation = "In systems theory, economics (Bastiat, 1850), and ecology, complex systems rarely respond linearly to simple interventions. First-order effects are almost always visible, immediate, and aligned with the decision-maker's intent. Second- and third-order effects are delayed, distributed across the system, and often run counter to the original goal—a phenomenon closely linked to the Cobra Effect (perverse incentives). When colonial officials in Delhi offered a bounty for dead cobras (first-order goal: reduce snakes), enterprising residents began breeding cobras in captivity for the bounty; when the program was cancelled, breeders released the snakes, leaving more cobras than before.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Engineering Metrics",
                    scenario = "Management announces bonuses based on the number of bug tickets closed per week (First-order goal: fix more bugs). Developers respond by splitting every tiny change into five separate tickets and avoiding hard architectural bugs (Second-order effect).",
                    analysis = "Goodhart's Law in action: when a measure becomes a target, human adaptation alters the system."
                ),
                EverydayExample(
                    context = "Personal Time Management",
                    scenario = "Skipping two hours of sleep to finish a slide deck tonight (First-order gain: deck is done), which causes brain fog and poor judgment during the actual client presentation tomorrow (Second-order cost).",
                    analysis = "Immediate task completion trades off against next-day cognitive performance."
                )
            ),
            howToRecognise = listOf(
                "Proposals that present a single intervention without discussing how participants or competitors will react.",
                "Metrics or incentives that assume human behaviour will remain static after rules change.",
                "Short-term relief options that steadily compound long-term maintenance costs."
            ),
            whyItOccurs = "Immediate outcomes are concrete and temporally close (Hyperbolic Discounting and WYSIATI), whereas tracing multi-step feedback loops across time requires sustained working memory and systems modeling.",
            howToRespond = listOf(
                "Ask 'And then what?' across three time horizons: 10 days, 10 months, and 10 years.",
                "Map how intelligent participants might game or adapt to a new rule or incentive.",
                "Pair every new policy proposal with a monitoring plan for unintended side effects."
            ),
            relatedConceptIds = listOf("rp_chestertons_fence", "mm_inversion", "mm_first_principles", "dme_planning_fallacy"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Rooted in Frédéric Bastiat's 'That Which is Seen, and That Which is Not Seen' (1850), Robert K. Merton's 'Unanticipated Consequences of Purposive Social Action' (1936), and Donella Meadows' systems dynamics research.",
            sources = listOf(
                SourceReference(
                    title = "The Unanticipated Consequences of Purposive Social Action",
                    sourceName = "American Sociological Review",
                    authorsOrYear = "Merton, R. K. (1936)",
                    url = "https://scholar.google.com/scholar?q=Robert+Merton+1936+Unanticipated+Consequences+of+Purposive+Social+Action"
                ),
                SourceReference(
                    title = "Thinking in Systems: A Primer",
                    sourceName = "Chelsea Green Publishing",
                    authorsOrYear = "Meadows, D. H. (2008)",
                    url = "https://scholar.google.com/scholar?q=Donella+Meadows+2008+Thinking+in+Systems"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("unintended consequences", "systems thinking", "cobra effect", "goodharts law", "feedback loops")
        ),

        ConceptArticle(
            id = "mm_inversion",
            name = "Inversion",
            alternativeNames = listOf("Invert, Always Invert", "Via Negativa", "Backward Reasoning"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Foundational Reasoning Models", "Epistemic Boundaries & Risk"),
            shortDefinition = "Solving a difficult problem or pursuing a goal by turning it upside down—asking what would guarantee failure and systematically avoiding those pitfalls.",
            beginnerExplanation = "Instead of only asking 'How do I achieve a brilliant outcome?', Inversion asks 'What would guarantee a terrible outcome?' Avoiding obvious traps and self-sabotage is often much clearer and more reliable than trying to invent brilliance.",
            detailedExplanation = "Inspired by the 19th-century German mathematician Carl Gustav Jacob Jacobi's maxim 'man muss immer umkehren' ('invert, always invert') and Ancient Stoic premeditatio malorum, Inversion approaches problems from the opposite direction. In mathematics, proving a theorem by contradiction or working backward from the desired endpoint often unlocks intractable proofs. In practical decision-making, humans frequently struggle to guarantee extraordinary success, yet can easily list the five behaviours that reliably destroy a project, marriage, or budget. Removing failure modes (Via Negativa) raises baseline performance immediately.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Project Management",
                    scenario = "Before launching a product, the team holds a 'Pre-Mortem' session: 'Imagine it is six months from now and this launch failed completely. Write down the top three reasons why it failed.'",
                    analysis = "Inverting the question frees team members from optimism bias and surfaces hidden risks early."
                ),
                EverydayExample(
                    context = "Personal Productivity",
                    scenario = "Instead of searching for the 'ultimate productivity hack,' listing what guarantees a wasted morning (sleeping with the phone by the bed, skipping breakfast, opening email before deep work) and eliminating those three triggers.",
                    analysis = "Subtracting guaranteed obstacles outperforms adding complex routines."
                )
            ),
            howToRecognise = listOf(
                "Brainstorming sessions that focus exclusively on best-case growth without listing single points of failure.",
                "Feeling stuck on a forward-facing creative question ('How do we delight users?') when the inverse ('What currently frustrates users most?') has obvious answers.",
                "Complex plans that rely on every single step going right."
            ),
            whyItOccurs = "Positive goal-framing activates Confirmation Bias and the Planning Fallacy, causing people to mentally simulate only smooth execution paths.",
            howToRespond = listOf(
                "For any major goal, write two columns: 'How to Succeed' and 'How to Guarantee Failure'—then build guardrails against the second column first.",
                "Run Gary Klein's Pre-Mortem exercise at the kickoff of major initiatives.",
                "Combine forward planning with Via Negativa (improvement by subtraction)."
            ),
            relatedConceptIds = listOf("dme_planning_fallacy", "ct_falsifiability", "mm_second_order", "mm_circle_of_competence"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "The cognitive efficacy of prospective hindsight and 'Pre-Mortem' inversion was experimentally validated by Mitchell, Russo, & Pennington (1989) and operationalised by Gary Klein (2007), showing a 30% increase in ability to identify reasons for future outcomes.",
            sources = listOf(
                SourceReference(
                    title = "Back to the future: Temporal perspective in the explanation of events",
                    sourceName = "Journal of Behavioral Decision Making",
                    authorsOrYear = "Mitchell, D. J., Russo, J. E., & Pennington, N. (1989)",
                    url = "https://scholar.google.com/scholar?q=Mitchell+Russo+Pennington+1989+Back+to+the+future+Temporal+perspective"
                ),
                SourceReference(
                    title = "Performing a Project Premortem",
                    sourceName = "Harvard Business Review",
                    authorsOrYear = "Klein, G. (2007)",
                    url = "https://scholar.google.com/scholar?q=Gary+Klein+2007+Performing+a+Project+Premortem"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("premortem", "jacobi", "via negativa", "avoiding stupidity", "backward reasoning")
        ),

        ConceptArticle(
            id = "mm_circle_of_competence",
            name = "Circle of Competence",
            alternativeNames = listOf("Epistemic Boundary Mapping", "Domain Boundary Discipline"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Epistemic Boundaries & Risk"),
            shortDefinition = "Understanding the precise boundary between domains where you possess deep, tested expertise and domains where you only hold surface familiarity.",
            beginnerExplanation = "The size of your Circle of Competence matters much less than knowing exactly where its perimeter lies. Trouble rarely comes from what you know you don't know—it comes from mistaking a topic you've read two articles about for something inside your circle.",
            detailedExplanation = "Popularised in decision analysis and investment philosophy (Buffett, 1996) and grounded in research on domain-specific expertise (Ericsson, Krampe, & Tesch-Römer, 1993; Kahneman & Klein, 2009), the Circle of Competence distinguishes earned structural intuition from casual opinion. Psychological research confirms that expertise does not automatically transfer across domains: a world-class surgeon or physicist is still a novice when evaluating macroeconomics or software architecture unless they have invested deliberate study and feedback cycles in that second domain.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Cross-Domain Overconfidence",
                    scenario = "A senior software engineer who excels at distributed systems assumes they can easily day-trade biotech stocks without understanding clinical trial design or FDA regulatory phases.",
                    analysis = "High competence in one analytical domain creates a false sense of general invulnerability."
                ),
                EverydayExample(
                    context = "Professional Collaboration",
                    scenario = "A product manager clearly states in a meeting: 'I can speak to user workflow metrics, but for encryption standards I defer to our security architect.'",
                    analysis = "Explicitly marking the edge of one's circle builds trust and prevents costly blind spots."
                )
            ),
            howToRecognise = listOf(
                "Using jargon learned last week with the same confidence as concepts tested over ten years of practice.",
                "Inability to explain what would falsify your thesis or what the strongest counter-argument in that field is.",
                "Relying on prestige in Field A to settle technical debates in Field B."
            ),
            whyItOccurs = "The Illusion of Explanatory Depth (Rozenblit & Keil, 2002) causes people to feel they understand complex systems deeply until they are asked to explain the step-by-step mechanism in detail.",
            howToRespond = listOf(
                "Test your understanding against the Illusion of Explanatory Depth: write down step-by-step how a system works and see where your explanation turns vague.",
                "Maintain three explicit buckets: 'Inside My Circle', 'Learning / Expanding', and 'Outside My Circle'.",
                "When operating outside your circle, rely on base rates, checklists, and verified domain specialists."
            ),
            relatedConceptIds = listOf("phen_dunning_kruger", "ct_intellectual_humility", "mm_map_not_territory", "bias_halo_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Supported by cognitive science research on the domain-specificity of expert intuition (Kahneman & Klein, 2009) and the Illusion of Explanatory Depth (Rozenblit & Keil, 2002).",
            sources = listOf(
                SourceReference(
                    title = "The misunderstood limits of folk science: an illusion of explanatory depth",
                    sourceName = "Cognitive Science (PubMed)",
                    authorsOrYear = "Rozenblit, L. & Keil, F. (2002)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21442007/"
                ),
                SourceReference(
                    title = "Conditions for intuitive expertise: A failure to disagree",
                    sourceName = "American Psychologist (PubMed)",
                    authorsOrYear = "Kahneman, D. & Klein, G. (2009)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/19739881/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("expertise", "explanatory depth", "humility", "boundaries", "specialist")
        ),

        ConceptArticle(
            id = "mm_map_not_territory",
            name = "The Map Is Not the Territory",
            alternativeNames = listOf("Model-Reality Distinction", "Fallacy of Misplaced Concreteness"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Epistemic Boundaries & Risk", "Foundational Reasoning Models"),
            shortDefinition = "Remembering that every model, metric, summary, or theory is a simplified abstraction of reality—never reality itself.",
            beginnerExplanation = "A paper road map is useful precisely because it leaves out every blade of grass and pebble. If it included everything at 1:1 scale, it would be the size of the country and impossible to fold. Problems start when we stare so hard at our spreadsheets, KPIs, or theories that we forget what they left out.",
            detailedExplanation = "Formulated by Alfred Korzybski in 1931 ('A map is not the territory it represents, but, if correct, it has a similar structure to the territory, which accounts for its usefulness') and echoed by statistician George Box ('All models are wrong, but some are useful') and philosopher Alfred North Whitehead ('Fallacy of Misplaced Concreteness'), this model warns against mistaking abstract representations for concrete reality. When organisations optimise purely for a proxy metric (the map)—such as standardized test scores, lines of code, or hospital wait-time averages—they often degrade the underlying reality (the territory) when the map fails to capture vital nuances.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Customer Service Metrics",
                    scenario = "A support centre measures success purely by 'Average Call Duration under 3 minutes.' Agents hit the target by hanging up on complex customer problems before they are solved.",
                    analysis = "The dashboard metric (the map) looks green while actual customer satisfaction (the territory) collapses."
                ),
                EverydayExample(
                    context = "Financial & Weather Modeling",
                    scenario = "Trusting a risk model that assumes daily market moves follow a neat bell curve, ignoring extreme tail events that were excluded from the model's assumptions.",
                    analysis = "Mistakes the mathematical elegance of a model for a guarantee about the real world."
                )
            ),
            howToRecognise = listOf(
                "Dismissing direct frontline observations or user feedback because 'the dashboard says everything is fine.'",
                "Treating a rough diagnostic category or personality quiz score as a complete definition of a human being.",
                "Forgetting the simplifying assumptions baked into a forecast or spreadsheet."
            ),
            whyItOccurs = "Abstractions are clean, quantifiable, and controllable in working memory, whereas the real world is noisy and high-dimensional.",
            howToRespond = listOf(
                "Ask regularly: 'What important aspect of reality did we have to leave out to make this metric or model simple?'",
                "Pair quantitative metrics (the map) with direct qualitative observation of the real environment (walking the territory).",
                "Update your mental maps promptly when the territory changes."
            ),
            relatedConceptIds = listOf("mm_second_order", "mm_circle_of_competence", "ct_intellectual_humility", "bias_base_rate_fallacy"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Formulated by Alfred Korzybski (1933, Science and Sanity) and formalised in statistical modeling philosophy by George E. P. Box (1976, Journal of the American Statistical Association).",
            sources = listOf(
                SourceReference(
                    title = "Science and Statistics",
                    sourceName = "Journal of the American Statistical Association",
                    authorsOrYear = "Box, G. E. P. (1976)",
                    url = "https://scholar.google.com/scholar?q=George+Box+1976+Science+and+Statistics+All+models+are+wrong"
                ),
                SourceReference(
                    title = "Models in Science",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Frigg, R. & Hartmann, S. (2020)",
                    url = "https://plato.stanford.edu/entries/models-science/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("korzybski", "abstraction", "metrics", "george box", "models")
        ),

        // ==========================================
        // 7. HEURISTICS
        // ==========================================
        ConceptArticle(
            id = "heur_availability",
            name = "Availability Heuristic",
            alternativeNames = listOf("Ease-of-Recall Shortcut", "Salience Heuristic"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Judgment & Frequency Shortcuts"),
            shortDefinition = "Estimating the frequency or probability of an event based on how easily and vividly examples of it come to mind.",
            beginnerExplanation = "Instead of looking up statistics, our brain judges how common something is by asking: 'How fast can I think of an example?' Because dramatic, emotional, or recent events pop into memory instantly, we overestimate dramatic risks and underestimate quiet, everyday ones.",
            detailedExplanation = "Introduced by Amos Tversky and Daniel Kahneman in 1973, the Availability Heuristic is a mental shortcut that substitutes 'ease of retrieval from memory' for 'objective statistical frequency.' In many natural environments, this shortcut works well because common events are indeed easier to remember than rare ones. However, memory retrieval is also heavily skewed by media coverage, vividness, emotional shock, and recency. Notably, Norbert Schwarz and colleagues (1991) demonstrated that it is the subjective *ease* of recall—not just the number of examples—that drives the effect: people asked to list 6 examples of when they were assertive rated themselves as *more* assertive than people asked to list 12 examples (because struggling to think of #11 and #12 made assertiveness feel rare).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Travel & Risk Perception",
                    scenario = "Feeling nervous about flying after seeing a plane crash on the evening news, and choosing to drive 800 miles instead—even though highway driving carries a vastly higher statistical fatality rate per mile.",
                    analysis = "Plane crashes receive intense, vivid news coverage, making them cognitively available despite extreme statistical rarity."
                ),
                EverydayExample(
                    context = "Performance Reviews",
                    scenario = "Evaluating an employee's entire year based almost entirely on a project that happened in the last two weeks before the review.",
                    analysis = "Recent events are much easier to retrieve from memory than steady contributions from nine months ago."
                )
            ),
            howToRecognise = listOf(
                "Estimating risk right after watching a dramatic news report, documentary, or viral video.",
                "Using a single vivid personal story ('My uncle smoked until 95') to dismiss population statistics.",
                "Assuming that because you haven't personally seen a security breach recently, the risk is near zero."
            ),
            whyItOccurs = "Attribute substitution: the hard statistical question ('What is the objective probability per 100,000 cases?') is automatically replaced by an easy memory question ('How effortlessly can I picture an instance?').",
            howToRespond = listOf(
                "Ask: 'Is this event actually common, or is it just vivid, recent, and newsworthy?'",
                "Look up objective base-rate tables before making insurance, health, or policy choices.",
                "Keep a year-round log of accomplishments and decisions to prevent recency-driven availability during reviews."
            ),
            relatedConceptIds = listOf("bias_base_rate_fallacy", "bias_survivorship", "heur_affect", "heur_representativeness"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Tversky & Kahneman (1973), Lichtenstein et al. (1978) on lethal event risk estimation, and Schwarz et al. (1991) on ease-of-retrieval metacognition.",
            sources = listOf(
                SourceReference(
                    title = "Availability: A heuristic for judging frequency and probability",
                    sourceName = "Cognitive Psychology",
                    authorsOrYear = "Tversky, A. & Kahneman, D. (1973)",
                    url = "https://scholar.google.com/scholar?q=Tversky+Kahneman+1973+Availability+heuristic+judging+frequency"
                ),
                SourceReference(
                    title = "Ease of retrieval as information: Another look at the availability heuristic",
                    sourceName = "Journal of Personality and Social Psychology",
                    authorsOrYear = "Schwarz, N. et al. (1991)",
                    url = "https://scholar.google.com/scholar?q=Schwarz+1991+Ease+of+retrieval+as+information"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("vividness", "recency", "news media", "risk perception", "tversky")
        ),

        ConceptArticle(
            id = "heur_representativeness",
            name = "Representativeness Heuristic",
            alternativeNames = listOf("Prototype Similarity Shortcut", "Conjunction Fallacy Driver"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Judgment & Frequency Shortcuts"),
            shortDefinition = "Judging the probability that a person, object, or event belongs to a category based on how closely it resembles our mental stereotype of that category, while ignoring statistical rules.",
            beginnerExplanation = "When something 'looks the part,' we assume it is the part. Because our brain matches patterns by similarity rather than math, we can even be tricked into thinking that two specific things happening together is more likely than just one of them happening alone.",
            detailedExplanation = "Formulated by Kahneman and Tversky (1972, 1983), the Representativeness Heuristic evaluates probabilities by the degree to which A resembles B. While similarity is often a useful clue in daily life, relying on it blindly causes several classic probability errors: Base Rate Neglect, Insensitivity to Sample Size (believing a 5-person survey is just as reliable as a 5,000-person survey), the Gambler's Fallacy (expecting a short sequence of coin flips to 'look random' by alternating H-T-H-T), and the famous Conjunction Fallacy ('Linda the Bank Teller'). In the Linda problem, participants read about an outspoken philosophy major concerned with social justice and rate 'Linda is a bank teller AND active in the feminist movement' as more probable than 'Linda is a bank teller'—violating the fundamental mathematical law that a subset P(A and B) can never exceed P(A).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "The Conjunction Fallacy (Linda Problem)",
                    scenario = "Believing a detailed, plausible 4-step geopolitical forecast ('Interest rates rise AND tech stocks dip AND Company X merges with Y') is more likely to happen than just 'Company X merges with Y.'",
                    analysis = "Adding plausible details makes a story feel more representative and coherent, even though each added condition mathematically multiplies the chance of failure."
                ),
                EverydayExample(
                    context = "Gambler's Fallacy in Random Sequences",
                    scenario = "Seeing a roulette wheel land on red six times in a row and betting heavily on black because 'black is due to balance it out.'",
                    analysis = "Expecting a tiny sample of 7 spins to look representative of the 50/50 long-run average."
                )
            ),
            howToRecognise = listOf(
                "A detailed, cinematic scenario feels more probable than a simple, broader category.",
                "Judging a startup's viability by whether the founder dresses and talks like a famous tech CEO rather than inspecting unit economics.",
                "Drawing sweeping conclusions from a tiny sample size of two or three customers."
            ),
            whyItOccurs = "Similarity judgment is an automatic, perceptual System 1 operation, whereas extensional set logic and sample-size variance require deliberate mathematical training.",
            howToRespond = listOf(
                "Remember the Conjunction Rule: adding more 'AND' conditions to a prediction always lowers its probability, no matter how believable the story sounds.",
                "Check sample size and base rates before trusting a pattern.",
                "Distinguish narrative plausibility from statistical probability."
            ),
            relatedConceptIds = listOf("bias_base_rate_fallacy", "heur_availability", "ct_bayes_theorem", "bias_halo_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated in Tversky & Kahneman's (1983) landmark Psychological Review paper on extensional versus intuitive reasoning and replicated across decades of judgment and decision-making research.",
            sources = listOf(
                SourceReference(
                    title = "Extensional versus intuitive reasoning: The conjunction fallacy in probability judgment",
                    sourceName = "Psychological Review",
                    authorsOrYear = "Tversky, A. & Kahneman, D. (1983)",
                    url = "https://scholar.google.com/scholar?q=Tversky+Kahneman+1983+Extensional+versus+intuitive+reasoning+conjunction+fallacy"
                ),
                SourceReference(
                    title = "Subjective probability: A judgment of representativeness",
                    sourceName = "Cognitive Psychology",
                    authorsOrYear = "Kahneman, D. & Tversky, A. (1972)",
                    url = "https://scholar.google.com/scholar?q=Kahneman+Tversky+1972+Subjective+probability+representativeness"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("linda problem", "conjunction fallacy", "gamblers fallacy", "stereotype", "sample size")
        ),

        ConceptArticle(
            id = "heur_affect",
            name = "Affect Heuristic",
            alternativeNames = listOf("Gut-Feeling Shortcut", "Risk-as-Feelings Heuristic"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_DISTORTIONS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Emotional & Value Substitution"),
            shortDefinition = "Making rapid judgments about the risks and benefits of an activity or technology based on an immediate, automatic feeling of 'good' or 'bad' associated with it.",
            beginnerExplanation = "In the real world, high-benefit things often carry high risks, and low-risk things have modest benefits. In our minds, however, the Affect Heuristic flips this: if we emotionally like something, we judge its benefits as huge and its risks as tiny; if we dislike it, we judge it as both high-risk and useless.",
            detailedExplanation = "Researched extensively by Paul Slovic, Melissa Finucane, and colleagues (2000, 2002), the Affect Heuristic shows that mental representations of objects and events are tagged with varying degrees of positive or negative affect ('affective tags'). When asked to evaluate complex trade-offs, people consult this affective pool. Strikingly, Finucane et al. (2000) found that while risks and benefits are positively correlated in the objective environment (e.g., potent medical treatments carry side-effect risks), they are *negatively* correlated in human minds. Furthermore, providing people with new information that increases their perceived benefit of a technology automatically causes them to lower their estimate of its physical risk, even when no safety data were mentioned.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Financial Investment Decisions",
                    scenario = "An investor loves a consumer brand's products and therefore assumes its stock is both a high-return opportunity and a low-risk safe haven, without reading its balance sheet.",
                    analysis = "Warm brand affect inflates perceived return while compressing perceived financial risk."
                ),
                EverydayExample(
                    context = "Policy & Technology Assessment",
                    scenario = "Evaluating a new energy source under time pressure: if the name evokes dread, people rate it as having zero economic benefit and catastrophic risk.",
                    analysis = "Time pressure amplifies reliance on the affective tag over analytical trade-off evaluation."
                )
            ),
            howToRecognise = listOf(
                "Believing an option you favour has all the advantages and zero downsides, while an option you oppose is both dangerous and completely ineffective.",
                "Making high-stakes choices under time pressure or emotional arousal.",
                "Reacting strongly to loaded terminology or imagery before inspecting numerical data."
            ),
            whyItOccurs = "The limbic affective system processes stimuli milliseconds faster than conscious prefrontal analysis, providing an immediate approach-or-avoid signal that enabled rapid survival decisions in ancestral environments.",
            howToRespond = listOf(
                "Force an independent audit: if you like an option, deliberately list three genuine risks it carries; if you dislike an option, list two genuine benefits it provides.",
                "Remove time pressure whenever evaluating complex financial, medical, or policy trade-offs.",
                "Check whether risk and benefit are being conflated by your initial emotional reaction."
            ),
            relatedConceptIds = listOf("cd_emotional_reasoning", "bias_halo_effect", "heur_availability", "dme_framing_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Validated by Finucane, Alhakami, Slovic, & Johnson (2000) in the Journal of Behavioral Decision Making and included in Kahneman's dual-process synthesis (2011).",
            sources = listOf(
                SourceReference(
                    title = "The affect heuristic in judgments of risks and benefits",
                    sourceName = "Journal of Behavioral Decision Making",
                    authorsOrYear = "Finucane, M. L., Alhakami, A., Slovic, P., & Johnson, S. M. (2000)",
                    url = "https://scholar.google.com/scholar?q=Finucane+Alhakami+Slovic+2000+affect+heuristic+risks+benefits"
                ),
                SourceReference(
                    title = "Risk as analysis and risk as feelings: Some thoughts about affect, reason, risk, and rationality",
                    sourceName = "Risk Analysis (PubMed)",
                    authorsOrYear = "Slovic, P., Finucane, M. L., Peters, E., & MacGregor, D. G. (2004)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/15074746/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("paul slovic", "risk perception", "gut feeling", "emotion", "risk vs benefit")
        ),

        ConceptArticle(
            id = "heur_satisficing",
            name = "Satisficing",
            alternativeNames = listOf("Bounded Rationality Threshold", "Good-Enough Search Strategy"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Choice & Satisficing Heuristics"),
            shortDefinition = "A decision-making heuristic that searches through available options until finding one that meets an acceptable threshold of criteria ('good enough'), rather than exhaustively searching for the theoretical optimum ('maximising').",
            beginnerExplanation = "A 'maximiser' reads 400 reviews for three weeks to find the single best toaster on Earth, and still worries they picked the wrong one. A 'satisficer' sets three clear requirements (toasts evenly, under $40, fits the counter), buys the first toaster that meets all three, and moves on with their life.",
            detailedExplanation = "Coined by Nobel laureate Herbert A. Simon in 1956 (blending 'satisfy' and 'suffice') as the cornerstone of Bounded Rationality, satisficing recognises that human beings in the real world have finite time, finite attention, and incomplete information. Classical economic models assumed rational agents compute the global maximum across all possible choices, but Simon proved that the computational cost of exhaustive search often exceeds the marginal benefit of a slightly better option. Later psychological research by Barry Schwartz and colleagues (2002) demonstrated that chronic 'maximisers' frequently experience more regret, perfectionistic stress, and lower satisfaction with their choices than 'satisficers'—even when maximisers achieve slightly better objective outcomes.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Consumer & Software Selection",
                    scenario = "Defining four must-have requirements for a note-taking app, testing two apps, and adopting the first one that satisfies all four criteria rather than testing 35 alternatives.",
                    analysis = "Preserves cognitive energy and time for actually writing notes rather than endlessly comparing tools."
                ),
                EverydayExample(
                    context = "Apartment Hunting",
                    scenario = "Setting a clear budget, commute time limit, and natural light requirement, then signing a lease as soon as an apartment meets that bar.",
                    analysis = "Prevents analysis paralysis in a sequential search market."
                )
            ),
            howToRecognise = listOf(
                "Defining an explicit 'aspiration level' (minimum acceptable standard) before starting a search.",
                "Stopping the search immediately once an option clears every required bar.",
                "Contrast with Maximising: keeping 45 browser tabs open for days over a minor reversible decision."
            ),
            whyItOccurs = "Bounded Rationality: in environments with thousands of options and search costs, adaptive heuristics that conserve time and computational bandwidth outperform unbounded optimisation.",
            howToRespond = listOf(
                "Distinguish high-stakes, irreversible decisions (where deeper search pays off) from low-stakes, reversible decisions (where satisficing is optimal).",
                "Write down your 3 to 4 non-negotiable criteria *before* browsing options so you recognise a 'good enough' match when you see it.",
                "Adopt a time-box limit for routine research tasks."
            ),
            relatedConceptIds = listOf("para_paradox_of_choice", "cd_all_or_nothing", "mm_second_order", "rp_occams_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Herbert Simon (1955, 1956) in Psychological Review and empirically extended to individual differences in well-being by Schwartz et al. (2002).",
            sources = listOf(
                SourceReference(
                    title = "Rational choice and the structure of the environment",
                    sourceName = "Psychological Review",
                    authorsOrYear = "Simon, H. A. (1956)",
                    url = "https://scholar.google.com/scholar?q=Herbert+Simon+1956+Rational+choice+structure+of+the+environment"
                ),
                SourceReference(
                    title = "Maximizing versus satisficing: Happiness is a matter of choice",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Schwartz, B. et al. (2002)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/12416921/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("herbert simon", "bounded rationality", "maximizing", "good enough", "analysis paralysis")
        ),

        // ==========================================
        // 8. PERSUASION AND RHETORIC
        // ==========================================
        ConceptArticle(
            id = "pr_foot_in_the_door",
            name = "Foot-in-the-Door Technique",
            alternativeNames = listOf("Gradual Commitment Compliance", "Sequential Request Consistency"),
            primaryCategory = CollectionCategory.PERSUASION_AND_RHETORIC,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Sequential Request Tactics"),
            shortDefinition = "A sequential persuasion strategy in which gaining agreement to a small, nearly effortless initial request significantly increases the likelihood that the person will later agree to a much larger related request.",
            beginnerExplanation = "If someone asks you for a huge favour out of the blue, you will likely say no. If they first ask you for a tiny 30-second favour—and you say yes—you begin to see yourself as 'the kind of helpful person who cares about this cause,' making it much harder to turn down their big request next week.",
            detailedExplanation = "Demonstrated in a landmark field experiment by Jonathan Freedman and Scott Fraser at Stanford University (1966), the Foot-in-the-Door (FITD) effect tests how small commitments reshape self-perception. When researchers asked California homeowners out of the blue to allow a giant, poorly lettered 'Drive Carefully' billboard to be installed on their front lawn, only 17% agreed. However, among homeowners who had been asked two weeks earlier simply to place a tiny 3-inch 'Be a Safe Driver' sticker in their window (which nearly everyone agreed to), a remarkable 76% agreed to the giant lawn sign. Daryl Bem's Self-Perception Theory explains the mechanism: people observe their own initial voluntary action and infer, 'I must be a civic-minded citizen who acts on public safety,' which then drives consistency on future requests.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software & Subscription Onboarding",
                    scenario = "Asking a visitor to complete a 10-second, 1-click quiz before asking them to create an account, and later offering an annual subscription.",
                    analysis = "Each micro-commitment builds psychological momentum and investment."
                ),
                EverydayExample(
                    context = "Community Volunteering",
                    scenario = "Asking neighbours to sign a brief petition supporting a neighbourhood park, then inviting signers two weeks later to volunteer for a Saturday cleanup crew.",
                    analysis = "Signing the petition shifts self-identity toward active supporter."
                )
            ),
            howToRecognise = listOf(
                "A sequence of requests that starts with a trivial 'yes' ('Do you have 30 seconds?', 'Would you sign this card?') before escalating.",
                "Feeling an internal pressure to stay consistent with a small favour you agreed to earlier.",
                "Sales or fundraising scripts designed around micro-agreements."
            ),
            whyItOccurs = "Driven by Self-Perception Theory (Bem, 1972) and the psychological desire for internal consistency (Cialdini, 1984): we align our future actions with our past voluntary commitments to maintain a coherent self-image.",
            howToRespond = listOf(
                "Evaluate every new request on its own independent merits and costs, regardless of whether you said yes to a smaller request earlier.",
                "Remember Ralph Waldo Emerson's observation that 'a foolish consistency is the hobgoblin of little minds' when a small courtesy is leveraged into an unreasonable demand.",
                "In positive habit building, use this principle constructively on yourself by starting with a tiny 2-minute daily habit."
            ),
            relatedConceptIds = listOf("pr_door_in_the_face", "dme_escalation_commitment", "dme_sunk_cost", "bias_anchoring"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "First demonstrated by Freedman & Fraser (1966) and confirmed across multiple meta-analyses (Burger, 1999), which note that the effect is strongest when the initial compliance is perceived as purely voluntary and prosocial.",
            sources = listOf(
                SourceReference(
                    title = "Compliance without pressure: The foot-in-the-door technique",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Freedman, J. L. & Fraser, S. C. (1966)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/5969145/"
                ),
                SourceReference(
                    title = "The Foot-in-the-Door Compliance Procedure: A Multiple-Process Analysis and Review",
                    sourceName = "Personality and Social Psychology Review",
                    authorsOrYear = "Burger, J. M. (1999)",
                    url = "https://scholar.google.com/scholar?q=Jerry+Burger+1999+Foot+in+the+Door+Multiple+Process+Review"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("compliance", "consistency", "cialdini", "freedman fraser", "small request")
        ),

        ConceptArticle(
            id = "pr_door_in_the_face",
            name = "Door-in-the-Face Technique",
            alternativeNames = listOf("Reciprocal Concessions Strategy", "Rejection-Then-Retreat"),
            primaryCategory = CollectionCategory.PERSUASION_AND_RHETORIC,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY, CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Sequential Request Tactics"),
            shortDefinition = "Making an extreme initial request that is almost certain to be refused, followed immediately by a much more moderate target request that is perceived as a cooperative concession.",
            beginnerExplanation = "Unlike Foot-in-the-Door (which starts small and builds up), Door-in-the-Face starts huge so that you slam the door on the first request—and then immediately retreats to the real, smaller request. Because the requester 'backed down,' social norms of reciprocity pressure you to meet them halfway.",
            detailedExplanation = "Investigated by Robert Cialdini and colleagues (1975), the Door-in-the-Face (DITF) technique operates on two synergistic mechanisms: (1) The Norm of Reciprocal Concessions — when one party retreats from a high demand to a moderate one, social norms frame that retreat as a concession that obligates the other party to reciprocate by agreeing; and (2) Perceptual Contrast (Anchoring) — next to an exorbitant two-year commitment, a single two-hour afternoon shift looks remarkably light. In Cialdini's classic study, only 17% of students agreed when asked directly to chaperone a 2-hour zoo trip; however, when first asked to volunteer for 2 hours every week for two full years (which 100% refused) and then immediately asked for just the single 2-hour trip, compliance tripled to 50%.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Budget & Scope Negotiations",
                    scenario = "A department requests $100,000 and three new hires, knowing leadership will decline, and immediately follows up with: 'In that case, could we at least approve $15,000 for contractor support?'",
                    analysis = "The $15,000 request feels both modest by contrast and fair as a compromise."
                ),
                EverydayExample(
                    context = "Everyday Favours",
                    scenario = "'Could you help me move all my furniture this Saturday and Sunday? No? Totally understand—could you just give me a 20-minute ride to pick up the rental van on Saturday morning?'",
                    analysis = "Refusing the weekend-long request triggers mild social discomfort that is relieved by accepting the 20-minute ride."
                )
            ),
            howToRecognise = listOf(
                "An initial proposal is unusually large or burdensome, followed without hesitation by a ready-made fallback option.",
                "Phrases such as 'Okay, if we can't do that, the least we can do is...'",
                "Feeling obligated to say yes to Option B solely because you just said no to Option A."
            ),
            whyItOccurs = "Combines the universal social norm of reciprocity (Gouldner, 1960; Cialdini, 1975) with perceptual contrast and numerical anchoring.",
            howToRespond = listOf(
                "Mentally strip away the rejected extreme offer and ask: 'If they had walked up and asked ONLY for this second request first, would I have said yes?'",
                "Recognise that retreating from an artificially inflated demand is not a genuine sacrifice that requires reciprocation.",
                "Anchor on objective market value or your actual schedule capacity."
            ),
            relatedConceptIds = listOf("pr_foot_in_the_door", "bias_anchoring", "dme_framing_effect", "pr_framing"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Cialdini et al. (1975) in the Journal of Personality and Social Psychology and supported by meta-analyses (O'Keefe & Hale, 1998), which show the effect requires the same requester to make both requests in quick succession.",
            sources = listOf(
                SourceReference(
                    title = "Reciprocal concessions procedure for inducing compliance: The door-in-the-face technique",
                    sourceName = "Journal of Personality and Social Psychology",
                    authorsOrYear = "Cialdini, R. B. et al. (1975)",
                    url = "https://scholar.google.com/scholar?q=Cialdini+1975+Reciprocal+concessions+door+in+the+face"
                ),
                SourceReference(
                    title = "The Door-in-the-Face Influence Strategy: A Random-Effects Meta-Analytic Review",
                    sourceName = "Communication Yearbook",
                    authorsOrYear = "O'Keefe, D. J. & Hale, S. L. (1998)",
                    url = "https://scholar.google.com/scholar?q=OKeefe+Hale+1998+Door+in+the+Face+Meta+Analytic+Review"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("cialdini", "reciprocity", "concession", "contrast principle", "negotiation")
        ),

        ConceptArticle(
            id = "pr_framing",
            name = "Rhetorical Framing & Metaphor",
            alternativeNames = listOf("Conceptual Framing", "Spin & Semantic Architecture"),
            primaryCategory = CollectionCategory.PERSUASION_AND_RHETORIC,
            secondaryCategories = listOf(CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Framing & Context Architecture"),
            shortDefinition = "Selecting specific words, metaphors, and narrative lenses to highlight certain aspects of a reality while pushing other aspects out of view, shaping how an audience defines a problem and its moral remedies.",
            beginnerExplanation = "Like a picture frame that chooses which part of a landscape stays inside the border and which part gets cropped out, rhetorical framing shapes what people think a debate is about before a single argument is even made.",
            detailedExplanation = "In communication studies, cognitive linguistics (Lakoff & Johnson, 1980), and political sociology (Entman, 1993), framing means selecting some aspects of a perceived reality and making them more salient in a communicating text so as to promote a particular problem definition, causal interpretation, moral evaluation, and treatment recommendation. In a classic experiment by Paul Thibodeau and Lera Boroditsky (2011), participants read identical crime statistics for a fictional city, except one paragraph described crime as a 'wild beast preying on the city' while the other described crime as a 'virus infecting the city.' The 'beast' metaphor led readers to propose enforcement and cages (prisons), whereas the 'virus' metaphor led readers to propose root-cause diagnosis and social reform—even though almost no participant noticed the single metaphor word when asked why they chose their policy.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Public Policy Vocabulary",
                    scenario = "Describing the exact same fiscal policy as 'tax relief' (which frames taxes as an affliction from which citizens need rescue) versus 'public investment revenue' (which frames taxes as shared infrastructure capital).",
                    analysis = "The vocabulary chosen activates an entire moral and causal schema before numbers are discussed."
                ),
                EverydayExample(
                    context = "Consumer Food Labeling",
                    scenario = "Labeling ground beef as '75% Lean' rather than '25% Fat.'",
                    analysis = "Attribute framing highlights the desirable dimension, reliably shifting consumer quality ratings."
                )
            ),
            howToRecognise = listOf(
                "Metaphors drawn from war ('battle', 'target'), illness ('contagion', 'remedy'), or nature ('flood', 'wave') used to describe social or economic issues.",
                "Loaded nouns or adjectives that smuggle a value judgment into a factual description.",
                "Statistics presented exclusively as relative changes ('risk doubled!') while hiding tiny absolute numbers ('from 1 in 10,000 to 2 in 10,000')."
            ),
            whyItOccurs = "Human conceptual thought is heavily metaphorical and associative; activating a source frame in memory automatically primes its associated inference rules while inhibiting competing frames.",
            howToRespond = listOf(
                "Restate any claim in flat, neutral, literal language stripped of metaphor and emotional adjectives.",
                "Invert the frame: if a statistic is presented as a positive percentage ('90% uptime'), immediately translate it into its complement ('10% downtime—36 days per year').",
                "Ask: 'What is left outside the border of this particular frame?'"
            ),
            relatedConceptIds = listOf("dme_framing_effect", "heur_affect", "prop_illusory_truth", "fallacy_motte_and_bailey"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Established in media theory by Entman (1993) and cognitive linguistics by Lakoff & Johnson (1980). Note: While framing effects are well supported overall, the magnitude of subtle single-word metaphor primes (e.g., Thibodeau & Boroditsky, 2011) has seen smaller effect sizes in large-scale replications (Steen et al., 2014).",
            sources = listOf(
                SourceReference(
                    title = "Framing: Toward Clarification of a Fractured Paradigm",
                    sourceName = "Journal of Communication",
                    authorsOrYear = "Entman, R. M. (1993)",
                    url = "https://scholar.google.com/scholar?q=Robert+Entman+1993+Framing+Toward+Clarification+of+a+Fractured+Paradigm"
                ),
                SourceReference(
                    title = "Metaphors We Live By",
                    sourceName = "University of Chicago Press",
                    authorsOrYear = "Lakoff, G. & Johnson, M. (1980)",
                    url = "https://scholar.google.com/scholar?q=Lakoff+Johnson+1980+Metaphors+We+Live+By"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("metaphor", "lakoff", "entman", "spin", "loaded language")
        )
    )
}
