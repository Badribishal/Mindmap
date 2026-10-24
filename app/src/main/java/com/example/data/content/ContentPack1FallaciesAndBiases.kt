package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack1FallaciesAndBiases {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 1. LOGICAL FALLACIES
        // ==========================================
        ConceptArticle(
            id = "fallacy_ad_hominem",
            name = "Ad Hominem",
            alternativeNames = listOf("Argumentum ad Hominem", "Personal Attack Fallacy", "Circumstantial Ad Hominem"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Informal Relevance Fallacies"),
            shortDefinition = "Rejecting a claim or argument by attacking the character, motive, or personal attribute of the person making it rather than addressing the substance of the argument itself.",
            beginnerExplanation = "Instead of responding to the actual points someone raises, an Ad Hominem shifts the conversation onto the speaker as a person. Even if a speaker has personal flaws or mixed motives, their logical reasoning or factual evidence might still be completely valid.",
            detailedExplanation = "In informal logic, an argumentum ad hominem occurs when irrelevant personal characteristics are substituted for a rebuttal of the premises or inferential link of an argument. Philosophers distinguish several variants: Abusive Ad Hominem (direct disparagement of character), Circumstantial Ad Hominem (dismissing an argument solely because the speaker stands to benefit from its conclusion), and Tu Quoque ('you too' — accusing the speaker of hypocrisy). Note that questioning a witness's credibility or disclosing a financial conflict of interest is not fallacious when the claim rests purely on the speaker's personal testimony; it becomes a fallacy when used to dismiss independent evidence or valid deduction.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Policy Debate",
                    scenario = "During a software architecture review, Maya presents benchmark data showing a memory leak. A colleague responds, 'Maya only joined the team two months ago and used to work at a startup that failed—why are we listening to her?'",
                    analysis = "The colleague attacks Maya's tenure and past employer while ignoring the objective benchmark data she provided."
                ),
                EverydayExample(
                    context = "Consumer Health Discussion",
                    scenario = "A physician explains the clinical evidence for regular sleep hygiene. A listener replies, 'You work 60-hour hospital shifts and drink three espressos a day, so your advice on sleep is worthless.'",
                    analysis = "This is the Tu Quoque variant: whether the physician personally practices ideal sleep habits does not alter the physiological evidence regarding sleep."
                )
            ),
            howToRecognise = listOf(
                "The response focuses on the speaker's background, identity, past mistakes, or alleged motives rather than the premises of their argument.",
                "Logical evidence, data, or reasoning remains completely unaddressed after the criticism is made.",
                "Phrases such as 'Of course you would say that, you...' or 'How can you talk about X when you...' dominate the rebuttal."
            ),
            whyItOccurs = "Evaluating complex arguments requires cognitive effort (System 2 processing), whereas assessing social status, group membership, or personal likability is fast and automatic. Derailing an opponent's credibility also serves as a rhetorical shortcut to win over an audience without engaging difficult counter-evidence.",
            howToRespond = listOf(
                "Separate the messenger from the message: explicitly ask, 'Setting aside my background, what do you think of the data itself?'",
                "Acknowledge valid conflict-of-interest disclosures transparently while redirecting focus to independent verification.",
                "Apply the Principle of Charity by restating the core premise stripped of personal identity."
            ),
            relatedConceptIds = listOf("fallacy_straw_man", "prop_whataboutism", "ct_steelmanning", "ct_principle_of_charity"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Documented since Aristotle's Sophistical Refutations and formalised by John Locke (1690) and Douglas Walton (1998). In argumentation theory, scholars note that character considerations are sometimes epistemically relevant when assessing expert testimony, so context determines whether an ad hominem is strictly fallacious.",
            sources = listOf(
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/"
                ),
                SourceReference(
                    title = "Ad Hominem Arguments",
                    sourceName = "University of Alabama Press",
                    authorsOrYear = "Walton, D. (1998)",
                    url = "https://scholar.google.com/scholar?q=Walton+1998+Ad+Hominem+Arguments"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("personal attack", "tu quoque", "hypocrisy", "character assassination", "relevance fallacy")
        ),

        ConceptArticle(
            id = "fallacy_straw_man",
            name = "Straw Man Fallacy",
            alternativeNames = listOf("Strawman Argument", "Aunt Sally", "Hollow Man Fallacy"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Informal Relevance Fallacies", "Rhetorical & Ambiguity Fallacies"),
            shortDefinition = "Distorting, exaggerating, or oversimplifying an opponent's actual position so that it becomes easy to refute, then claiming to have defeated the original argument.",
            beginnerExplanation = "Imagine replacing a sturdy opponent with a figure stuffed with straw, knocking the straw figure down, and declaring victory. A Straw Man happens whenever someone argues against a caricature or extreme version of what you said instead of what you actually meant.",
            detailedExplanation = "The Straw Man fallacy operates in two steps: first, an interlocutor's nuanced premise is replaced with a weaker, more extreme, or absurd misrepresentation; second, that distorted version is refuted, creating the illusion that the original position has been debunked. Variants include the 'Weak Man' (selecting the weakest actual argument made by a fringe advocate and treating it as representative of the entire position) and the 'Hollow Man' (inventing an entirely fictional opponent with no specific quotes or arguments at all).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Municipal Budget Meeting",
                    scenario = "Councilmember A says, 'We should allocate 10% more funding to bike lanes this year.' Councilmember B replies, 'My opponent wants to ban cars entirely and force elderly citizens to cycle in winter storms.'",
                    analysis = "A modest budgetary adjustment is exaggerated into an extreme, unworkable mandate that was never proposed."
                ),
                EverydayExample(
                    context = "Household Conversation",
                    scenario = "Partner A says, 'I'd love to cook at home a bit more often this month.' Partner B says, 'So you think every restaurant meal we've had together was a waste of money?'",
                    analysis = "A forward-looking preference is reframed as a sweeping condemnation of shared memories."
                )
            ),
            howToRecognise = listOf(
                "A nuanced or conditional statement ('sometimes', 'in certain cases') is restated using absolute qualifiers ('always', 'never', 'everyone').",
                "The rebuttal begins with 'So what you're really saying is...' followed by an absurd or uncharitable conclusion.",
                "Criticism targets the most extreme fringe voice of a movement rather than the specific argument presented."
            ),
            whyItOccurs = "Partisan competition, confirmation bias, and out-group homogeneity bias make people genuinely perceive opposing viewpoints as more extreme than they are. Rhetorically, refuting an extreme caricature rallies an audience much faster than engaging with trade-offs.",
            howToRespond = listOf(
                "Calmly point out the discrepancy: 'That's not quite my position—let me clarify what I am actually proposing.'",
                "Practice Steelmanning: articulate the strongest, most charitable version of the other person's view before offering critique.",
                "Ask the other person to quote or specify which exact premise they disagree with."
            ),
            relatedConceptIds = listOf("ct_steelmanning", "ct_principle_of_charity", "fallacy_false_dilemma", "fallacy_motte_and_bailey"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Extensively analysed in informal logic and pragma-dialectics (Talisse & Aikin, 2006). Experimental studies on argumentation show that audiences often fail to detect straw man distortions when they already share the speaker's conclusion.",
            sources = listOf(
                SourceReference(
                    title = "Two Forms of the Straw Man",
                    sourceName = "Argumentation (Springer)",
                    authorsOrYear = "Talisse, R. & Aikin, S. F. (2006)",
                    url = "https://scholar.google.com/scholar?q=Talisse+Aikin+2006+Two+Forms+of+the+Straw+Man"
                ),
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("misrepresentation", "exaggeration", "caricature", "weak man", "steelman")
        ),

        ConceptArticle(
            id = "fallacy_false_dilemma",
            name = "False Dilemma",
            alternativeNames = listOf("False Dichotomy", "Either-Or Fallacy", "Fallacy of the Excluded Middle"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_DISTORTIONS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Informal Relevance Fallacies", "Rhetorical & Ambiguity Fallacies"),
            shortDefinition = "Presenting only two extreme options as if they are the sole possibilities when a spectrum of middle-ground or alternative choices actually exists.",
            beginnerExplanation = "A False Dilemma forces you to pick between Option A and Option B while hiding Options C, D, and E. It turns a complex situation with many shades of grey into an artificial 'either/or' choice.",
            detailedExplanation = "Logically, a disjunctive syllogism ('Either P or Q; not P; therefore Q') is valid in form, but it is unsound when the premise 'Either P or Q' falsely exhausts the state space. False dilemmas conflate contrary statements (which can both be false) with contradictory statements (where one must be true and the other false). In everyday persuasion, framing a problem as binary pressures audiences toward a preferred option by making the only presented alternative appear catastrophic.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Career & Product Strategy",
                    scenario = "'Either we ship this unfinished feature by Friday, or our competitors will put us out of business.'",
                    analysis = "Ignores intermediate options such as shipping a scoped beta, delaying by one week, or disabling the buggy module."
                ),
                EverydayExample(
                    context = "Personal Productivity",
                    scenario = "'If I can't complete a full 90-minute workout today, there's no point exercising at all.'",
                    analysis = "Reflects all-or-nothing thinking by overlooking a 20-minute walk or stretching session."
                )
            ),
            howToRecognise = listOf(
                "Statements framed strictly as 'Either we do X, or Y happens' or 'You're either with us or against us.'",
                "Complex multidimensional trade-offs are compressed into two polar opposites.",
                "Compromise, hybrid solutions, or maintaining the status quo are omitted without justification."
            ),
            whyItOccurs = "Binary categorisation reduces cognitive load (heuristics) and aligns with All-or-Nothing cognitive distortions under stress. In rhetoric, binary choices create urgency and suppress deliberation.",
            howToRespond = listOf(
                "Ask explicitly: 'Are those really the only two options, or could we combine elements of both?'",
                "Generate at least three distinct alternatives before making any important decision.",
                "Distinguish between logical contradictories (A vs. not-A) and spectrum contraries (hot vs. cold)."
            ),
            relatedConceptIds = listOf("cd_all_or_nothing", "fallacy_straw_man", "dme_framing_effect", "ct_intellectual_humility"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "A foundational informal fallacy in logic textbooks; closely parallels dichotomous thinking studied in clinical cognitive psychology (Beck, 1976) and narrow framing in behavioural decision research (Kahneman & Lovallo, 1993).",
            sources = listOf(
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/"
                ),
                SourceReference(
                    title = "Introduction to Philosophy: Logic",
                    sourceName = "OpenStax / Rebus Community",
                    authorsOrYear = "Van Cleave, M. (2016)",
                    url = "https://openstax.org/subjects/humanities"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("binary thinking", "either or", "false dichotomy", "black and white")
        ),

        ConceptArticle(
            id = "fallacy_affirming_consequent",
            name = "Affirming the Consequent",
            alternativeNames = listOf("Converse Error", "Fallacy of the Converse"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Formal Deductive Fallacies"),
            shortDefinition = "A formal deductive fallacy that takes a true conditional statement ('If P, then Q'), observes that Q is true, and invalidly concludes that P must also be true.",
            beginnerExplanation = "If it rains, the street gets wet. If you look outside and see the street is wet, can you be 100% certain it rained? No—a street sweeper or a sprinkler could have wet the pavement. Assuming 'the street is wet, so it must have rained' is Affirming the Consequent.",
            detailedExplanation = "In propositional logic, a valid Modus Ponens inference has the form: 'If P then Q; P; therefore Q.' Affirming the Consequent reverses the second premise and conclusion: 'If P then Q; Q; therefore P.' This is deductively invalid because P is stated as a sufficient condition for Q, not a necessary condition. Many other antecedent causes (R, S, T) might also produce Q. Notably, while deductively invalid, observing Q can sometimes serve as weak abductive (inference to the best explanation) evidence for P in scientific hypothesis testing—provided alternative explanations are systematically ruled out.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Debugging",
                    scenario = "'If the database server is down, the login page times out. The login page just timed out, so the database server must be down.'",
                    analysis = "A DNS failure, expired SSL certificate, or client Wi-Fi outage could also cause the login page to time out."
                ),
                EverydayExample(
                    context = "Medical Self-Diagnosis",
                    scenario = "'People with condition X experience chronic fatigue. I have chronic fatigue, so I definitely have condition X.'",
                    analysis = "Fatigue is a non-specific symptom shared by dozens of benign and clinical conditions."
                )
            ),
            howToRecognise = listOf(
                "A conditional rule ('If A happens, B results') is treated as reversible ('If B resulted, A must have happened').",
                "Alternative sufficient causes for an observed outcome are ignored.",
                "Symptoms or effects are treated as unique diagnostic proof of a single cause."
            ),
            whyItOccurs = "Human associative memory links cause and effect symmetrically. In everyday conversation, 'if' is frequently interpreted as 'if and only if' (biconditional equivalence), leading reasoners to treat conditionals as two-way streets.",
            howToRespond = listOf(
                "Ask: 'What else could produce this exact same result even if the proposed cause never happened?'",
                "Check whether the rule is a one-way conditional ('If P then Q') or a true biconditional ('If and only if P then Q').",
                "Use differential diagnosis: list multiple competing hypotheses and test what uniquely distinguishes them."
            ),
            relatedConceptIds = listOf("ct_falsifiability", "rp_occams_razor", "bias_base_rate_fallacy", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formally proven invalid in classical propositional calculus since Aristotle and the Stoic logicians. Psychological studies using the Wason Selection Task (Wason, 1968) consistently show that a majority of adults endorse the converse error when reasoning about abstract rules.",
            sources = listOf(
                SourceReference(
                    title = "Classical Logic",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Shapiro, S. & Kouri Kissel, T. (2022)",
                    url = "https://plato.stanford.edu/entries/logic-classical/"
                ),
                SourceReference(
                    title = "Reasoning about a rule",
                    sourceName = "Quarterly Journal of Experimental Psychology (PubMed)",
                    authorsOrYear = "Wason, P. C. (1968)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/5683766/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("formal fallacy", "modus ponens", "conditional logic", "converse error", "deduction")
        ),

        ConceptArticle(
            id = "fallacy_texas_sharpshooter",
            name = "Texas Sharpshooter Fallacy",
            alternativeNames = listOf("Clustering Illusion Fallacy", "Data Dredging Fallacy", "Post-Hoc Target Drawing"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Causal & Statistical Fallacies"),
            shortDefinition = "Cherry-picking a random cluster of data points after the fact and drawing a 'bullseye' around them to claim a meaningful causal pattern.",
            beginnerExplanation = "The name comes from a joke about a marksman who fires his rifle randomly at the side of a barn, walks up to where the most bullet holes happened to cluster together, paints a target bullseye around that spot, and brags that he is a sharpshooter.",
            detailedExplanation = "In statistics and epidemiology, the Texas Sharpshooter fallacy occurs when researchers or observers examine a large dataset across many variables, notice a dense cluster by chance, and then formulate a hypothesis using that very same dataset to 'prove' the hypothesis. When enough variables or geographic regions are inspected, random noise inevitably produces striking clusters (the multiple comparisons problem). Treating an unpredicted post-hoc cluster as confirmatory proof without testing it on an independent out-of-sample dataset invalidates the statistical inference.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Business Analytics",
                    scenario = "A marketing team runs 40 identical ads across 40 cities. In one city, sales jump 25% that week. The team concludes that the specific demographic of that city uniquely loves their slogan.",
                    analysis = "Across 40 cities, random fluctuation alone will produce outliers; without replication in a new week, the bullseye was painted after the shots landed."
                ),
                EverydayExample(
                    context = "Superstition & Coincidence",
                    scenario = "Recalling the three times you thought of an old friend right before they texted you, while forgetting the 500 times you thought of someone and heard nothing.",
                    analysis = "Highlighting the coincidental hits while discarding the massive denominator of misses."
                )
            ),
            howToRecognise = listOf(
                "A specific subgroup, timeframe, or metric is highlighted without explaining why that slice was chosen beforehand.",
                "No pre-registered hypothesis existed prior to inspecting the data.",
                "The total number of comparisons, trials, or regions examined (the denominator) is omitted."
            ),
            whyItOccurs = "The human visual and cognitive system evolved to detect patterns rapidly (apophenia and the clustering illusion). True randomness looks clumpier than people intuitively expect, so random clusters feel intentional.",
            howToRespond = listOf(
                "Separate exploratory data analysis (generating hypotheses) from confirmatory testing (testing on fresh data).",
                "Ask: 'How many total metrics or groups were checked before finding this correlation?'",
                "Apply statistical corrections for multiple comparisons (such as the Bonferroni correction)."
            ),
            relatedConceptIds = listOf("bias_confirmation", "bias_survivorship", "ct_bayes_theorem", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Grounded in mathematical probability theory (the multiple comparisons problem) and cognitive research on the clustering illusion (Gilovich, Vallone, & Tversky, 1985).",
            sources = listOf(
                SourceReference(
                    title = "The hot hand in basketball: On the misperception of random sequences",
                    sourceName = "Cognitive Psychology",
                    authorsOrYear = "Gilovich, T., Vallone, R., & Tversky, A. (1985)",
                    url = "https://scholar.google.com/scholar?q=Gilovich+Vallone+Tversky+1985+misperception+random+sequences"
                ),
                SourceReference(
                    title = "Texas Sharpshooter Fallacy",
                    sourceName = "The Decision Lab",
                    authorsOrYear = "The Decision Lab Reference Catalogue",
                    url = "https://thedecisionlab.com/biases/texas-sharpshooter-fallacy"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("p-hacking", "cherry picking", "clustering illusion", "data dredging", "post hoc")
        ),

        ConceptArticle(
            id = "fallacy_motte_and_bailey",
            name = "Motte-and-Bailey Fallacy",
            alternativeNames = listOf("Strategic Equivocation", "Doctrine of the Motte and Bailey"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Rhetorical & Ambiguity Fallacies"),
            shortDefinition = "Conflating a bold, controversial, hard-to-defend claim (the 'bailey') with a modest, universally accepted truism (the 'motte') whenever the bold claim is challenged.",
            beginnerExplanation = "Named after medieval castles that had a large, desirable courtyard (the bailey) and a tiny, heavily fortified stone tower (the motte). A speaker makes a sweeping, controversial claim in public, but as soon as someone challenges it, they retreat to a harmless, obvious statement and pretend that was all they meant.",
            detailedExplanation = "Philosopher Nicholas Shackel (2005) coined the term Motte-and-Bailey doctrine to describe a specific form of strategic equivocation. A speaker advances a provocative position with sweeping practical implications (the Bailey). When critics present counterarguments, the speaker retreats to a trivial, uncontroversial definition of the same words (the Motte) and accuses critics of attacking a common-sense truth. Once the critic concedes the trivial Motte, the speaker quietly returns to asserting the controversial Bailey as if it had been vindicated.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Wellness Marketing",
                    scenario = "An influencer claims a herbal tea 'detoxifies your organs and cures seasonal illness' (Bailey). When a biochemist challenges the claim, the influencer replies, 'Are you seriously denying that staying hydrated with warm herbal tea is soothing when you're tired?' (Motte).",
                    analysis = "The speaker swaps a medical cure claim for a trivial hydration statement when pressed."
                ),
                EverydayExample(
                    context = "Management Debate",
                    scenario = "A manager argues that 'all remote work destroys team accountability' (Bailey). When shown high output metrics, they reply, 'I'm just saying human connection matters' (Motte).",
                    analysis = "Retreats from an absolute policy claim to an uncontroversial platitude without retracting the policy."
                )
            ),
            howToRecognise = listOf(
                "Key terms shift between a radical technical meaning and an everyday common-sense meaning mid-argument.",
                "When challenged, the speaker says, 'All I'm saying is [obvious truism],' despite having just advocated far stronger conclusions.",
                "After winning agreement on the modest statement, the speaker resumes acting as though the controversial statement was proven."
            ),
            whyItOccurs = "Ambiguity in natural language allows speakers to enjoy the rhetorical prestige and excitement of bold claims while avoiding the epistemic burden of proof required to defend them.",
            howToRespond = listOf(
                "Explicitly agree with the Motte while separating it from the Bailey: 'I completely agree that hydration is good (the Motte); my question is specifically about the organ-detoxification claim (the Bailey).'",
                "Define ambiguous terms clearly before debating their consequences.",
                "Ask whether the speaker is willing to drop the stronger claim permanently if they only stand by the modest one."
            ),
            relatedConceptIds = listOf("fallacy_straw_man", "rp_burden_of_proof", "ct_steelmanning", "pr_framing"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Formulated by philosopher Nicholas Shackel in 2005 in the journal Metaphilosophy as an analysis of rhetorical equivocation in postmodern philosophy; widely adopted in contemporary argumentation analysis.",
            sources = listOf(
                SourceReference(
                    title = "The Vacuity of Postmodernist Methodology",
                    sourceName = "Metaphilosophy",
                    authorsOrYear = "Shackel, N. (2005)",
                    url = "https://scholar.google.com/scholar?q=Nicholas+Shackel+2005+Motte+and+Bailey"
                ),
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("equivocation", "moving goalposts", "retreat", "shackel", "rhetoric")
        ),

        // ==========================================
        // 2. COGNITIVE BIASES
        // ==========================================
        ConceptArticle(
            id = "bias_confirmation",
            name = "Confirmation Bias",
            alternativeNames = listOf("Confirmatory Bias", "My-Side Bias", "Congeniality Bias"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Belief & Confirmation Biases"),
            shortDefinition = "The tendency to search for, interpret, favour, and recall information in a way that confirms one's preexisting beliefs or hypotheses while giving disproportionately less consideration to alternative possibilities.",
            beginnerExplanation = "Once we form an opinion, our brain starts acting like a defence lawyer rather than an impartial judge. We eagerly notice evidence that agrees with us, accept it without much scrutiny, and overlook or harshly criticise facts that point the other way.",
            detailedExplanation = "Confirmation bias is one of the most pervasive phenomena in cognitive psychology, operating across three distinct stages of information processing: (1) Biased Search — framing questions and queries that can only yield confirming answers (positive test strategy); (2) Biased Interpretation — holding disconfirming evidence to a much stricter methodological standard than confirming evidence (asymmetric scrutiny); and (3) Biased Memory — selectively recalling supportive facts over time. Importantly, confirmation bias is not always driven by emotion; even dispassionate scientists testing a working hypothesis can fall into it if they only look for predicted outcomes rather than testing what would falsify their model.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Online Search Behaviour",
                    scenario = "Typing 'Why is coffee bad for your heart?' into a search engine instead of 'What are the health effects of coffee on cardiovascular health?'",
                    analysis = "The query itself presupposes the conclusion, ensuring search algorithms return pages that confirm the premise."
                ),
                EverydayExample(
                    context = "Hiring & Interviews",
                    scenario = "An interviewer forms a warm impression of a candidate in the first two minutes and spends the rest of the interview asking softball questions that highlight the candidate's strengths.",
                    analysis = "Initial positive impression guides subsequent inquiry to confirm rather than test suitability."
                )
            ),
            howToRecognise = listOf(
                "Feeling an immediate surge of relief and acceptance when reading a headline that supports your view, versus an urge to check sample sizes when a headline contradicts your view.",
                "Searching exclusively for examples where a rule held true rather than cases where it failed.",
                "Consulting only sources or colleagues known to agree with your initial hunch."
            ),
            whyItOccurs = "Evolutionarily and cognitively, testing positive instances ('Does this berry match the safe berries I know?') is computationally cheaper than testing negative complements. Additionally, reducing cognitive dissonance protects self-esteem and social identity.",
            howToRespond = listOf(
                "Actively seek disconfirmation: ask, 'What specific evidence would prove my current belief wrong?'",
                "Use neutral, non-leading search queries when researching any topic.",
                "Conduct a 'Pre-Mortem' or assign a Devil's Advocate in team decisions."
            ),
            relatedConceptIds = listOf("ct_falsifiability", "bias_belief_perseverance", "fallacy_texas_sharpshooter", "dme_escalation_commitment"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated across hundreds of empirical studies since Peter Wason's 2-4-6 rule discovery task (1960) and Lord, Ross, & Lepper's (1979) study on biased assimilation of capital punishment evidence. Nickerson (1998) provides the definitive comprehensive review.",
            sources = listOf(
                SourceReference(
                    title = "Confirmation bias: A ubiquitous phenomenon in many guises",
                    sourceName = "Review of General Psychology",
                    authorsOrYear = "Nickerson, R. S. (1998)",
                    url = "https://scholar.google.com/scholar?q=Nickerson+1998+Confirmation+bias+ubiquitous+phenomenon"
                ),
                SourceReference(
                    title = "Biased assimilation and attitude polarization",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Lord, C. G., Ross, L., & Lepper, M. R. (1979)",
                    url = "https://scholar.google.com/scholar?q=Lord+Ross+Lepper+1979+Biased+assimilation"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("myside bias", "echo chamber", "cherry picking", "wason", "motivated reasoning")
        ),

        ConceptArticle(
            id = "bias_survivorship",
            name = "Survivorship Bias",
            alternativeNames = listOf("Survival Bias", "Silent Evidence Fallacy"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS, CollectionCategory.LOGICAL_FALLACIES),
            subcategories = listOf("Probability & Estimation Biases", "Causal & Statistical Fallacies"),
            shortDefinition = "Concentrating on the people, companies, or things that survived a selection process while overlooking those that failed and became invisible, leading to overly optimistic or false conclusions.",
            beginnerExplanation = "When we only study winners, we miss the fact that many losers did the exact same things. Because failures quietly disappear from view, we mistake luck or common habits for a guaranteed formula for success.",
            detailedExplanation = "Survivorship bias is a severe form of selection bias. The classic historical illustration comes from World War II statistician Abraham Wald and the Statistical Research Group. Examining returning bombers, the military noticed bullet holes concentrated on the fuselage and wings and wanted to add heavy armour there. Wald pointed out that they were only looking at planes that survived; the missing planes were in the ocean because they had been hit in the engines and cockpit—the exact areas showing no bullet holes on returning aircraft. In finance, medicine, and entrepreneurship, ignoring the 'graveyard' of failed funds, discontinued trials, or bankrupt startups systematically distorts base rates.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Business & Career Advice",
                    scenario = "Reading biographies of three billionaire college dropouts and concluding that dropping out of college causes entrepreneurial success.",
                    analysis = "Overlooks the hundreds of thousands of dropouts who struggled financially and never had biographies written about them."
                ),
                EverydayExample(
                    context = "Architecture & Product Durability",
                    scenario = "Looking at a 200-year-old stone cottage and saying, 'They built every house to last back then, unlike today.'",
                    analysis = "The poorly built houses from 200 years ago collapsed long ago; only the sturdiest examples survived to the present."
                )
            ),
            howToRecognise = listOf(
                "Analysis examines only successful companies, top-performing athletes, or still-active investment funds.",
                "Questions like 'How many people tried this exact strategy and failed?' cannot be answered from the dataset presented.",
                "Historical nostalgia claims that old music, films, or buildings were universally superior."
            ),
            whyItOccurs = "Visible evidence is vivid and easily retrieved from memory (Availability Heuristic), whereas 'silent evidence'—absent data points that were filtered out—requires deliberate statistical reconstruction.",
            howToRespond = listOf(
                "Always ask to see the graveyard: 'What does the denominator of failed attempts look like?'",
                "Compare successful cases against unsuccessful cases to identify traits that actually differentiate them.",
                "When evaluating investment or medical outcomes, insist on intention-to-treat or full-cohort data."
            ),
            relatedConceptIds = listOf("heur_availability", "bias_base_rate_fallacy", "fallacy_texas_sharpshooter", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formalised statistically by Abraham Wald (1943) in aircraft vulnerability memoranda and documented empirically in financial mutual fund return studies (Elton, Gruber, & Blake, 1996), which proved that ignoring defunct funds inflates apparent industry returns.",
            sources = listOf(
                SourceReference(
                    title = "A Reprint of 'A Method of Estimating Plane Vulnerability Based on Damage of Survivors'",
                    sourceName = "Statistical Research Group / Center for Naval Analyses",
                    authorsOrYear = "Wald, A. (1943 / 1980)",
                    url = "https://scholar.google.com/scholar?q=Abraham+Wald+Estimating+Plane+Vulnerability+Survivors"
                ),
                SourceReference(
                    title = "Survivorship Bias in Mutual Fund Performance",
                    sourceName = "The Review of Financial Studies",
                    authorsOrYear = "Elton, E. J., Gruber, M. J., & Blake, C. R. (1996)",
                    url = "https://scholar.google.com/scholar?q=Elton+Gruber+Blake+1996+Survivorship+Bias"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("abraham wald", "bomber planes", "selection bias", "silent evidence", "winners")
        ),

        ConceptArticle(
            id = "bias_base_rate_fallacy",
            name = "Base Rate Fallacy",
            alternativeNames = listOf("Base Rate Neglect", "Prior Probability Neglect"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Probability & Estimation Biases"),
            shortDefinition = "Judging the probability of an event based on specific, vivid descriptive details while ignoring the underlying statistical prevalence (the base rate) in the population.",
            beginnerExplanation = "When given a general statistical fact (like how rare a condition is) alongside a specific description or test result, human intuition almost completely ignores the general statistic and focuses 100% on the specific story or test.",
            detailedExplanation = "According to Bayes' Theorem, estimating the posterior probability of a hypothesis requires combining the prior probability (base rate) with the likelihood of the new evidence. Daniel Kahneman and Amos Tversky demonstrated that people routinely neglect prior probabilities when individuating information is present. For example, if a medical screening test is 99% accurate (1% false-positive rate) for a disease that affects 1 in 10,000 people, testing 10,000 people will yield 1 true positive and roughly 100 false positives. A person who tests positive therefore has less than a 1% chance of actually having the condition—yet most people (including many clinicians) intuitively guess 99%.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Medical Screening",
                    scenario = "Panicking after a positive result on a screening test for a very rare condition, assuming a 95% accurate test means a 95% chance of illness.",
                    analysis = "When the condition is rare (low base rate), false positives outnumber true positives even with high test specificity."
                ),
                EverydayExample(
                    context = "Personality Stereotypes",
                    scenario = "Hearing that Steve is shy, tidy, and loves quiet libraries, and guessing Steve is more likely to be a professional librarian than a salesperson.",
                    analysis = "There are vastly more salespeople than librarians in the general workforce; neglecting that base rate leads to a likely error."
                )
            ),
            howToRecognise = listOf(
                "A probability judgment is made without asking 'How common is this in the first place?'",
                "Test accuracy percentages (sensitivity/specificity) are confused with the probability of actually having the condition (positive predictive value).",
                "Vivid personal anecdotes override large-scale demographic or historical frequencies."
            ),
            whyItOccurs = "The mind relies on the Representativeness Heuristic—matching a case to a mental prototype—rather than performing multiplicative Bayesian calculations. Natural frequencies are intuitive, whereas abstract conditional percentages are cognitively opaque.",
            howToRespond = listOf(
                "Anchor every prediction on the 'Outside View' (the historical base rate) before adjusting for case-specific details.",
                "Convert confusing percentages into natural frequencies (e.g., 'Out of 1,000 people...').",
                "Apply Bayes' Theorem explicitly when interpreting diagnostic or security alerts."
            ),
            relatedConceptIds = listOf("heur_representativeness", "ct_bayes_theorem", "dme_planning_fallacy", "bias_survivorship"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Extensively validated by Kahneman & Tversky (1973). Notably, Gerd Gigerenzer and Hoffrage (1995) demonstrated that base rate neglect drops dramatically when problems are presented in 'natural frequency' formats ('10 out of 1,000') rather than single-event probabilities ('1%').",
            sources = listOf(
                SourceReference(
                    title = "On the psychology of prediction",
                    sourceName = "Psychological Review",
                    authorsOrYear = "Kahneman, D. & Tversky, A. (1973)",
                    url = "https://scholar.google.com/scholar?q=Kahneman+Tversky+1973+On+the+psychology+of+prediction"
                ),
                SourceReference(
                    title = "How to improve Bayesian reasoning without instruction: Frequency formats",
                    sourceName = "Psychological Review",
                    authorsOrYear = "Gigerenzer, G. & Hoffrage, U. (1995)",
                    url = "https://scholar.google.com/scholar?q=Gigerenzer+Hoffrage+1995+Bayesian+reasoning+frequency+formats"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("bayes theorem", "false positive", "prior probability", "outside view", "kahneman")
        ),

        ConceptArticle(
            id = "bias_halo_effect",
            name = "Halo Effect",
            alternativeNames = listOf("Halo Error", "Physical Attractiveness Stereotype", "Horns Effect (Inverse)"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Evaluation & Attribution Biases"),
            shortDefinition = "A cognitive bias in which an overall positive impression of a person, company, or brand in one specific area spills over to positively bias evaluations of their unrelated traits.",
            beginnerExplanation = "When someone excels at one visible thing—like speaking confidently, dressing well, or having a sleek website—we automatically assume they are also honest, technically competent, and fair-minded, even without any evidence for those other traits.",
            detailedExplanation = "Coined by psychologist Edward Thorndike in 1920, the Halo Effect describes the inability of evaluators to treat distinct attributes independently. In Thorndike's original study of military officers rating soldiers, ratings of physical posture and voice quality strongly correlated with ratings of intelligence, leadership, and dependability. The inverse phenomenon—where a single negative trait taints all subsequent judgments—is known as the Horns Effect or Devil Effect. In business, a company experiencing booming stock prices is often praised for its visionary culture and management, only for those exact same practices to be condemned as reckless if the stock later falls.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software & Consumer Design",
                    scenario = "Trusting a financial app with sensitive banking data simply because its onboarding animations and typography look polished.",
                    analysis = "Visual aesthetic quality creates a 'halo' of perceived cybersecurity competence."
                ),
                EverydayExample(
                    context = "Performance Appraisals",
                    scenario = "A manager rates an charismatic, articulate employee as 'highly organised and analytical' despite missed project deadlines.",
                    analysis = "Strong verbal communication spills over into unrelated operational ratings."
                )
            ),
            howToRecognise = listOf(
                "An evaluator assigns uniform high (or uniform low) scores across completely unrelated categories on a rubric.",
                "First impressions formed in the opening seconds of an interaction dominate the final assessment.",
                "Celebrity endorsements persuade buyers on technical or medical topics outside the celebrity's domain."
            ),
            whyItOccurs = "The brain strives for cognitive coherence (what Kahneman calls WYSIATI—'What You See Is All There Is'). Resolving ambiguous traits in favour of an established first impression reduces mental conflict.",
            howToRespond = listOf(
                "Grade one trait at a time across all candidates before moving to the next trait (horizontal grading).",
                "Use structured, blinded evaluation criteria where possible.",
                "Explicitly ask: 'Do I have direct evidence for this specific skill, or am I inferring it from their charisma?'"
            ),
            relatedConceptIds = listOf("heur_affect", "sp_fundamental_attribution", "bias_confirmation", "bias_anchoring"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "First quantified by Thorndike (1920) and experimentally confirmed by Nisbett & Wilson (1977), who showed that students' ratings of a lecturer's accent and appearance reversed depending on whether the lecturer acted warm or distant—while students remained completely unaware of the spillover.",
            sources = listOf(
                SourceReference(
                    title = "A constant error in psychological ratings",
                    sourceName = "Journal of Applied Psychology",
                    authorsOrYear = "Thorndike, E. L. (1920)",
                    url = "https://scholar.google.com/scholar?q=Thorndike+1920+constant+error+in+psychological+ratings"
                ),
                SourceReference(
                    title = "The halo effect: Evidence for unconscious alteration of judgments",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Nisbett, R. E. & Wilson, T. D. (1977)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/892751/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("first impression", "thorndike", "horns effect", "spillover", "attractiveness")
        ),

        ConceptArticle(
            id = "bias_anchoring",
            name = "Anchoring Bias",
            alternativeNames = listOf("Anchoring and Adjustment", "Focalism"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.HEURISTICS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Probability & Estimation Biases"),
            shortDefinition = "Relying too heavily on the first piece of numerical or contextual information encountered (the 'anchor') so that subsequent estimates remain insufficiently adjusted away from it.",
            beginnerExplanation = "When estimating an unknown value, the first number you hear acts like a heavy anchor dropped in the water. Even if you know the number is too high or even completely random, your final guess stays pulled toward that starting number.",
            detailedExplanation = "Discovered by Amos Tversky and Daniel Kahneman (1974), anchoring operates through two distinct mechanisms: (1) Insufficient Adjustment — where people start at an initial value and mentally adjust outward, stopping as soon as they reach the edge of a plausible range; and (2) Selective Accessibility (priming) — where considering whether an anchor could be true automatically activates memory traces consistent with that anchor. Remarkable experiments show that even patently arbitrary numbers—such as the last two digits of a person's social security number or a spin of a wheel of fortune—significantly pull subsequent willingness-to-pay and judicial sentencing estimates.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Retail Pricing & Negotiations",
                    scenario = "A jacket is listed with a crossed-out tag of $450 and a 'sale price' of $180. The buyer feels $180 is a bargain without checking whether the jacket's true market value is $120.",
                    analysis = "The $450 tag serves purely as a high anchor to make $180 appear modest."
                ),
                EverydayExample(
                    context = "Project Time Estimates",
                    scenario = "An executive asks, 'Can we build this module in two weeks?' Even when the engineer pushes back, they counter with 'Four weeks' rather than the realistic ten weeks.",
                    analysis = "The initial two-week mention anchors the negotiation range artificially low."
                )
            ),
            howToRecognise = listOf(
                "An arbitrary or extreme figure is introduced early in a negotiation or retail display.",
                "Adjustments from an initial estimate feel incremental rather than independently calculated from the ground up.",
                "A discussion revolves entirely around a single baseline metric."
            ),
            whyItOccurs = "Evaluating an anchor requires mentally simulating how it might be true, which primes anchor-consistent facts in working memory. Furthermore, mental adjustment requires effortful cognitive control, which terminates prematurely once an estimate feels 'close enough.'",
            howToRespond = listOf(
                "Calculate your own independent baseline valuation before looking at the other party's asking price.",
                "Explicitly generate arguments for why the initial anchor is completely wrong ('Consider the Opposite').",
                "In group forecasting, collect independent written estimates silently before anyone speaks a number aloud."
            ),
            relatedConceptIds = listOf("dme_framing_effect", "dme_planning_fallacy", "pr_door_in_the_face", "mm_first_principles"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "One of the most robust and replicable effects in behavioural economics and experimental psychology (Tversky & Kahneman, 1974; Furnham & Boo, 2011). Holds even among experienced real-estate appraisers and trial judges.",
            sources = listOf(
                SourceReference(
                    title = "Judgment under Uncertainty: Heuristics and Biases",
                    sourceName = "Science (PubMed)",
                    authorsOrYear = "Tversky, A. & Kahneman, D. (1974)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/17835457/"
                ),
                SourceReference(
                    title = "A literature review of the anchoring effect",
                    sourceName = "The Journal of Socio-Economics",
                    authorsOrYear = "Furnham, A. & Boo, H. C. (2011)",
                    url = "https://scholar.google.com/scholar?q=Furnham+Boo+2011+literature+review+anchoring+effect"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("negotiation", "pricing", "first number", "focalism", "kahneman")
        ),

        ConceptArticle(
            id = "bias_belief_perseverance",
            name = "Belief Perseverance",
            alternativeNames = listOf("Conceptual Conservatism", "Continued Influence Effect"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY, CollectionCategory.MEMORY_BIASES),
            subcategories = listOf("Belief & Confirmation Biases"),
            shortDefinition = "Maintaining a belief cleanly and confidently even after the original evidence that formed the belief has been completely discredited or shown to be fabricated.",
            beginnerExplanation = "When we learn a new 'fact,' we immediately start inventing explanations for why it makes sense. If we later find out the original fact was fake or a mistake, our self-generated explanations stay behind in our memory and keep the belief alive anyway.",
            detailedExplanation = "Pioneered by Lee Ross, Mark Lepper, and colleagues at Stanford University (1975), belief perseverance demonstrates that beliefs acquire a life of their own once integrated into a causal mental model. In classic experiments, participants were given false feedback that they were exceptionally skilled (or poor) at distinguishing real from fake suicide notes. Even after the experimenter explicitly revealed that the feedback had been predetermined at random before they arrived, participants continued to rate their actual skill in line with the debunked feedback. Once a person constructs causal narratives to explain why a claim is true, pulling out the foundational brick does not topple the building.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Media Corrections & Retractions",
                    scenario = "Reading a dramatic breaking news story blaming a fire on faulty wiring. Three days later, the newspaper prints a retraction stating the wiring was fine, yet months later readers still distrust that brand of wiring.",
                    analysis = "The initial causal story ('cheap wiring causes fires') persists after the factual basis is retracted."
                ),
                EverydayExample(
                    context = "Interpersonal Misunderstandings",
                    scenario = "Hearing a rumour that a coworker criticised your project. Even after learning the rumour was a mix-up involving someone else entirely, you still feel guarded around that coworker.",
                    analysis = "Emotional and causal inferences built during the rumour outlive the rumour's refutation."
                )
            ),
            howToRecognise = listOf(
                "Saying 'Well, even if that specific study/story turned out to be fake, it still rings true.'",
                "Continuing to cite a conclusion after its primary source data has been retracted.",
                "Feeling reluctant to update an opinion despite acknowledging that the original reason for adopting it was mistaken."
            ),
            whyItOccurs = "When encountering new information, people engage in spontaneous causal explanation—linking the claim to existing memories and values. Retracting the external source leaves those internal causal stories intact in long-term memory.",
            howToRespond = listOf(
                "Practice 'Consider the Opposite': actively write down causal explanations for why the exact opposite outcome could be true.",
                "When issuing a correction, provide an alternative causal explanation that fills the narrative gap rather than merely stating 'X is false.'",
                "Audit your long-held beliefs by asking: 'How did I first come to believe this, and is that original source still valid?'"
            ),
            relatedConceptIds = listOf("bias_confirmation", "prop_illusory_truth", "ct_falsifiability", "mem_misinformation_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Ross, Lepper, & Hubbard (1975) and extensively studied in cognitive psychology under the 'Continued Influence Effect' of misinformation (Lewandowsky et al., 2012).",
            sources = listOf(
                SourceReference(
                    title = "Perseverance in self-perception and social perception",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Ross, L., Lepper, M. R., & Hubbard, M. (1975)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/1195704/"
                ),
                SourceReference(
                    title = "Misinformation and Its Correction: Continued Influence and Successful Debiasing",
                    sourceName = "Psychological Science in the Public Interest",
                    authorsOrYear = "Lewandowsky, S., Ecker, U. K., Seifert, C. M., Schwarz, N., & Cook, J. (2012)",
                    url = "https://scholar.google.com/scholar?q=Lewandowsky+2012+Misinformation+and+Its+Correction"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("debunking", "retraction", "continued influence", "lee ross", "stubbornness")
        )
    )
}
