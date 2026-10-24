package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack4PropagandaParadoxesDecisions {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 9. PROPAGANDA AND MEDIA LITERACY
        // ==========================================
        ConceptArticle(
            id = "prop_illusory_truth",
            name = "Illusory Truth Effect",
            alternativeNames = listOf("Truth-by-Repetition Effect", "Processing Fluency Bias", "Reiteration Effect"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.MEMORY_BIASES),
            subcategories = listOf("Repeated Falsehoods & Framing"),
            shortDefinition = "The tendency to believe false or unverified information to be true simply because it has been encountered repeatedly, as the brain mistakes familiarity and ease of processing for accuracy.",
            beginnerExplanation = "When you read or hear the exact same claim five or six times from different places, your brain processes the sentence faster and more smoothly. Without realising it, we mistake that smooth feeling of familiarity ('I've heard that before') for the feeling of truth ('That's a verified fact').",
            detailedExplanation = "First demonstrated experimentally by Lynn Hasher, David Goldstein, and Thomas Toppino (1977), the Illusory Truth Effect occurs because humans routinely use 'processing fluency'—how effortlessly a statement is decoded and retrieved—as a metacognitive cue for validity. In propaganda and digital misinformation ecosystems, repeating a talking point across multiple channels ensures that even skeptical audiences encode the claim into memory. Weeks later, when the specific unreliable source is forgotten, the residual familiarity of the claim elevates its perceived truthfulness. Research by Fazio et al. (2015) further demonstrated that repetition increases perceived truth even when people possess prior knowledge contradicting the statement.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Viral Social Media Myths",
                    scenario = "Scrolling past a false health claim ('Humans only use 10% of their brains') dozens of times over the years until it feels like an established scientific textbook fact.",
                    analysis = "Sheer repetition builds processing fluency that masquerades as factual consensus."
                ),
                EverydayExample(
                    context = "Advertising & Political Slogans",
                    scenario = "Repeating a three-word slogan across billboards, podcasts, and search ads until consumers rate the brand as 'the most trusted' without ever seeing independent quality comparisons.",
                    analysis = "Familiarity is misattributed to trustworthiness."
                )
            ),
            howToRecognise = listOf(
                "Thinking 'Everybody knows that...' about a claim, yet realising you cannot name a single primary study or original source for it.",
                "Identical phrasing or slogans appearing simultaneously across dozens of seemingly independent accounts.",
                "Repeating a false myth inside a headline while trying to debunk it (which inadvertently reinforces the myth's familiarity)."
            ),
            whyItOccurs = "Processing fluency heuristic: in everyday perception, true and familiar statements are processed faster than novel contradictions, so the brain relies on fluency when it does not slow down to retrieve stored semantic knowledge.",
            howToRespond = listOf(
                "When a claim feels 'obviously true because I've heard it everywhere,' pause and trace its primary source ('Where did this originally come from?').",
                "When correcting misinformation, lead with the true fact ('The Truth Sandwich') rather than repeating the false myth in bold letters at the top.",
                "Use lateral reading—verify the source's track record rather than relying on how familiar the claim sounds."
            ),
            relatedConceptIds = listOf("bias_belief_perseverance", "heur_availability", "mem_misinformation_effect", "prop_firehose_falsehood"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Replicated across decades of cognitive science since Hasher, Goldstein, & Toppino (1977), with modern extensions by Fazio, Brashier, Payne, & Marsh (2015) in the Journal of Experimental Psychology: General.",
            sources = listOf(
                SourceReference(
                    title = "Frequency and the conference of referential validity",
                    sourceName = "Journal of Verbal Learning and Verbal Behavior",
                    authorsOrYear = "Hasher, L., Goldstein, D., & Toppino, T. (1977)",
                    url = "https://scholar.google.com/scholar?q=Hasher+Goldstein+Toppino+1977+Frequency+conference+referential+validity"
                ),
                SourceReference(
                    title = "Knowledge does not protect against illusory truth",
                    sourceName = "Journal of Experimental Psychology: General (PubMed)",
                    authorsOrYear = "Fazio, L. K., Brashier, N. M., Payne, B. K., & Marsh, E. J. (2015)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/26301795/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("repetition", "familiarity", "processing fluency", "misinformation", "propaganda")
        ),

        ConceptArticle(
            id = "prop_firehose_falsehood",
            name = "Firehose of Falsehood",
            alternativeNames = listOf("Information Flooding", "Epistemic Exhaustion Strategy", "Gish Gallop (Debate Variant)"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Information Flooding & Exhaustion"),
            shortDefinition = "A propaganda model that broadcasts a high-volume, rapid, multi-channel stream of partial truths, contradictions, and fabrications without regard for internal consistency, aiming to overwhelm and exhaust critical verification.",
            beginnerExplanation = "Classical propaganda tried to tell one convincing, consistent story. The 'Firehose of Falsehood' does the exact opposite: it sprays 20 contradictory stories at once so fast that fact-checkers cannot keep up, leaving the public exhausted and thinking, 'Nobody can ever know what's true anyway.'",
            detailedExplanation = "Analysed by researchers Christopher Paul and Miriam Matthews (2016) at the RAND Corporation, the Firehose of Falsehood has four defining characteristics: it is (1) high-volume and multichannel, (2) rapid, continuous, and repetitive, (3) lacking commitment to objective reality, and (4) lacking commitment to consistency. In interpersonal debate, its smaller cousin is the 'Gish Gallop'—flooding an opponent with a dozen dubious claims in two minutes, knowing it takes ten times longer to refute a falsehood than to state it (Brandolini's Law). The ultimate goal of information flooding is often not to convince the audience of a single narrative, but to induce cynicism and epistemic paralysis.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Live Debate (Gish Gallop)",
                    scenario = "A speaker rattles off 12 misquoted statistics in 90 seconds. When the respondent spends their entire 2-minute rebuttal carefully correcting the first two statistics, the speaker claims the other 10 went unchallenged.",
                    analysis = "Exploits the asymmetry between the speed of assertion and the time required for rigorous verification."
                ),
                EverydayExample(
                    context = "Crisis Disinformation",
                    scenario = "During a major breaking event, automated networks push five mutually contradictory theories simultaneously across social feeds.",
                    analysis = "Aims to overwhelm attention and induce 'nothing is knowable' fatigue."
                )
            ),
            howToRecognise = listOf(
                "A source puts forward multiple mutually incompatible explanations for the same event on the same day.",
                "Rapid-fire lists of dozens of weak claims presented with no pause for verification.",
                "A prevailing takeaway message of 'Everything is fake, everyone lies, so don't trust any data.'"
            ),
            whyItOccurs = "Cognitive load and Brandolini's Asymmetry Principle: generating an unverified claim takes seconds, whereas retrieving primary data and explaining context requires high cognitive effort.",
            howToRespond = listOf(
                "Refuse to chase every spray of the firehose: pick the single most foundational claim, dismantle it thoroughly, and point out the flooding tactic explicitly.",
                "Pre-bunk (inoculate) audiences by explaining the information-flooding technique before they encounter the stream.",
                "Provide clear, verified primary documentation rather than doing point-by-point amplification of fabrications."
            ),
            relatedConceptIds = listOf("prop_illusory_truth", "prop_whataboutism", "rp_burden_of_proof", "rp_hitchens_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Documented in strategic communication research by Paul & Matthews (2016) and psychological inoculation studies by van der Linden et al. (2017).",
            sources = listOf(
                SourceReference(
                    title = "The Russian 'Firehose of Falsehood' Propaganda Model",
                    sourceName = "RAND Corporation Perspective",
                    authorsOrYear = "Paul, C. & Matthews, M. (2016)",
                    url = "https://scholar.google.com/scholar?q=Paul+Matthews+2016+Firehose+of+Falsehood+RAND"
                ),
                SourceReference(
                    title = "Inoculating the Public against Misinformation about Climate Change",
                    sourceName = "Global Challenges (PubMed)",
                    authorsOrYear = "van der Linden, S. et al. (2017)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/31565263/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("gish gallop", "brandolinis law", "disinformation", "flooding", "inoculation")
        ),

        ConceptArticle(
            id = "prop_whataboutism",
            name = "Whataboutism",
            alternativeNames = listOf("Whataboutery", "Tu Quoque Deflection", "Counter-Accusation Pivoting"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Information Flooding & Exhaustion", "Informal Relevance Fallacies"),
            shortDefinition = "Responding to a specific criticism or difficult question by deflecting attention to a separate real or alleged wrongdoing committed by the critic or a third party ('What about X?').",
            beginnerExplanation = "If two people both run a red light, neither one becomes innocent just by pointing at the other driver. Whataboutism is the habit of answering 'Why did you do A?' with 'Well, what about when they did B?' so that Problem A never gets answered.",
            detailedExplanation = "Structurally a strategic application of the Tu Quoque ('you too') variant of Ad Hominem and the Red Herring fallacy, Whataboutism derails accountability by changing the subject while appearing to appeal to fairness and consistency. Comparing similar historical cases to ensure consistent standards can be legitimate *after* the current issue is addressed; it becomes fallacious Whataboutism when used as a shield to evade answering the original question.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Corporate Environmental Audit",
                    scenario = "When asked about a factory's chemical spill into a local river, a spokesperson replies, 'What about the airline industry's carbon emissions? Why aren't you investigating them instead?'",
                    analysis = "Airline emissions are an entirely separate issue that does not clean up or excuse the local river spill."
                ),
                EverydayExample(
                    context = "Team Code Review",
                    scenario = "A developer asked to add unit tests to a new module replies, 'What about the legacy billing module from 2019 that has zero tests?'",
                    analysis = "Uses past technical debt elsewhere as an excuse to avoid quality standards today."
                )
            ),
            howToRecognise = listOf(
                "Responses to a specific factual question that begin with 'What about when...' or 'Why isn't anyone talking about...'",
                "The original issue is dropped completely as participants get baited into defending the second topic.",
                "Implicitly arguing that unless every problem in the world is solved simultaneously, no single problem can be criticised."
            ),
            whyItOccurs = "Exploits human fairness norms (aversion to perceived double standards) while functioning as a low-effort Red Herring to escape an uncomfortable topic.",
            howToRespond = listOf(
                "Acknowledge and park the second topic immediately, then return to the first: 'I agree that legacy billing also needs tests, and we can schedule that next; right now, let's finish reviewing this module.'",
                "Ask: 'If we agree that both X and Y are wrong, how do we fix X today?'",
                "Refuse to defend the third party introduced by the deflection."
            ),
            relatedConceptIds = listOf("fallacy_ad_hominem", "manip_darvo", "prop_firehose_falsehood", "ct_principle_of_charity"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Rooted in classical Tu Quoque fallacy analysis (Walton, 1998) and studied in political communication research on deflection strategies.",
            sources = listOf(
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/"
                ),
                SourceReference(
                    title = "Ad Hominem Arguments (Tu Quoque chapter)",
                    sourceName = "University of Alabama Press",
                    authorsOrYear = "Walton, D. (1998)",
                    url = "https://scholar.google.com/scholar?q=Walton+1998+Ad+Hominem+Arguments+Tu+Quoque"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("tu quoque", "red herring", "deflection", "double standard", "hypocrisy")
        ),

        // ==========================================
        // 10. PHILOSOPHICAL AND LOGICAL PARADOXES
        // ==========================================
        ConceptArticle(
            id = "para_ship_of_theseus",
            name = "Ship of Theseus",
            alternativeNames = listOf("Theseus's Paradox", "Identity Over Time Puzzle", "Grandfather's Axe"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS),
            subcategories = listOf("Identity & Vagueness Paradoxes"),
            shortDefinition = "A classical metaphysical thought experiment asking whether an object that has had every single one of its original components gradually replaced over time remains the fundamentally same object.",
            beginnerExplanation = "If a wooden ship sails for 30 years and, plank by plank, every rotting board, mast, and nail is replaced with new wood until zero original pieces remain, is it still the same ship? And what if someone saved all the old rotting planks and reassembled them into a second ship—which one is the real Ship of Theseus?",
            detailedExplanation = "Recorded by Plutarch (c. 1st century CE) and extended by Thomas Hobbes (who added the second ship reassembled from discarded planks), the Ship of Theseus probes our intuitions about identity across time. It exposes a tension between two ways humans define 'sameness': (1) Material Composition — an object is the sum of its exact physical parts; and (2) Functional & Historical Continuity — an object is a continuous pattern or organisation that persists even as its matter turns over.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Architecture & Refactoring",
                    scenario = "Over five years, an engineering team rewrites every microservice, database table, and UI screen of an app while keeping the same brand name and user accounts.",
                    analysis = "Continuity of function and user state defines identity even after 100% of the code has changed."
                ),
                EverydayExample(
                    context = "Organisational & Team Culture",
                    scenario = "A sports team or university club where every founding member has graduated, yet the team's traditions, play style, and identity persist.",
                    analysis = "Systems are defined by relationships and rules as much as by specific parts."
                )
            ),
            howToRecognise = listOf(
                "Debates over whether a heavily modified institution, band, or product is 'still the real thing.'",
                "Confusion caused by treating 'same' as a single rigid concept rather than specifying 'same physical parts' vs. 'same continuous history.'",
                "Gradual incremental shifts where each step feels tiny, yet the end state is completely transformed."
            ),
            whyItOccurs = "Human cognition uses 'psychological essentialism'—assigning an invisible essence to named objects so we can track them across time.",
            howToRespond = listOf(
                "Dissolve verbal disputes about 'is it the same X?' by specifying which dimension of identity actually matters for your decision (legal continuity, material authenticity, or functional behaviour).",
                "Pair with the Sorites Paradox to understand how gradual continuous changes cross categorical boundaries.",
                "In systems design, focus on preserving core invariants and interfaces while allowing internal components to be replaced cleanly."
            ),
            relatedConceptIds = listOf("para_sorites", "mm_map_not_territory", "mm_first_principles", "para_paradox_of_choice"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A foundational thought experiment in analytic metaphysics (Plutarch; Hobbes, 1655 De Corpore) and studied empirically in cognitive development research on object persistence.",
            sources = listOf(
                SourceReference(
                    title = "Identity Over Time",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Gallois, A. (2016)",
                    url = "https://plato.stanford.edu/entries/identity-time/"
                ),
                SourceReference(
                    title = "Relative Identity",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Deutsch, H. & Garbacz, P. (2022)",
                    url = "https://plato.stanford.edu/entries/identity-relative/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("plutarch", "hobbes", "identity", "metaphysics", "continuity")
        ),

        ConceptArticle(
            id = "para_sorites",
            name = "Sorites Paradox",
            alternativeNames = listOf("Paradox of the Heap", "Little-by-Little Fallacy", "Continuum Fallacy"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Identity & Vagueness Paradoxes"),
            shortDefinition = "A paradox arising from vague predicates: if removing a single grain of sand from a heap of 10,000 grains still leaves a heap, repeated application of that rule implies that even a single grain—or zero grains—is still a heap.",
            beginnerExplanation = "'Sorites' comes from the Greek word *soros*, meaning 'heap.' One grain of sand is not a heap. Adding one grain of sand to something that is not a heap cannot suddenly turn it into a heap. Yet somehow, 10,000 grains is undeniably a heap! This puzzle shows how tiny, imperceptible steps add up to massive changes.",
            detailedExplanation = "Attributed to Eubulides of Miletus (4th century BCE), the Sorites Paradox exposes how classical binary logic struggles with vague, continuous concepts ('heap', 'bald', 'tall', 'safe'). It gives rise to two opposite errors in practical reasoning: (1) The Continuum Fallacy — arguing that because there is no single sharp line separating A from B, there is no real difference between A and B at all; and (2) Creeping Normalcy — failing to react to a gradual degradation in standards, health, or budgets because no single day's 0.1% change feels large enough to cross a threshold.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Scope Creep & Technical Debt",
                    scenario = "'Adding just one more 5-line configuration flag won't make the codebase messy.' Repeated 300 times over two years, the system becomes unmaintainable.",
                    analysis = "Each individual step falls below the threshold of alarm, yet the cumulative sum crosses a qualitative boundary."
                ),
                EverydayExample(
                    context = "Legal & Regulatory Line-Drawing",
                    scenario = "Arguing that speed limits or voting ages are meaningless because a person is no more mature on their 18th birthday than 24 hours earlier.",
                    analysis = "Commits the Continuum Fallacy: the absence of a natural razor-sharp boundary does not negate the real difference between childhood and adulthood."
                )
            ),
            howToRecognise = listOf(
                "Justifying a bad habit with 'Just this one extra time won't make a difference.'",
                "Dismissing a distinction entirely because borderline cases exist ('Where do you draw the line?').",
                "Slow, incremental drift in budgets, sleep debt, or ethical boundaries."
            ),
            whyItOccurs = "Human language uses discrete categorical buckets to describe continuous physical and biological spectrums.",
            howToRespond = listOf(
                "Establish explicit 'Bright-Line Rules' (clear numerical thresholds) to prevent Sorites drift in budgets, schedules, and personal habits.",
                "Measure cumulative change against a fixed baseline from six months ago rather than comparing today only against yesterday.",
                "Recognise that the existence of twilight does not mean there is no difference between day and night."
            ),
            relatedConceptIds = listOf("para_ship_of_theseus", "fallacy_false_dilemma", "cd_all_or_nothing", "dme_escalation_commitment"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "A central topic in philosophical logic, vagueness theory, and fuzzy logic (Hyde & Raffman, 2018).",
            sources = listOf(
                SourceReference(
                    title = "Sorites Paradox",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hyde, D. & Raffman, D. (2018)",
                    url = "https://plato.stanford.edu/entries/sorites-paradox/"
                ),
                SourceReference(
                    title = "Vagueness",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Sorensen, R. (2022)",
                    url = "https://plato.stanford.edu/entries/vagueness/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("heap", "vagueness", "continuum fallacy", "scope creep", "bright line")
        ),

        ConceptArticle(
            id = "para_paradox_of_choice",
            name = "Paradox of Choice",
            alternativeNames = listOf("Choice Overload", "Overchoice Effect"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS, CollectionCategory.HEURISTICS),
            subcategories = listOf("Decision & Social Paradoxes"),
            shortDefinition = "The observation that while having some choice is essential for autonomy and well-being, expanding the number of options beyond a moderate threshold can increase anxiety, decision paralysis, and post-decision regret.",
            beginnerExplanation = "Having zero choices feels awful, and having 5 or 6 good choices feels empowering. We naturally assume that having 60 choices must be ten times better—yet often, facing a wall of 60 nearly identical options makes us freeze up, walk away empty-handed, or feel less satisfied with whatever we pick.",
            detailedExplanation = "Popularised by Barry Schwartz (2004) and investigated by Sheena Iyengar and Mark Lepper (2000), Choice Overload describes an inverted-U relationship between option count and decision satisfaction. When options multiply into the dozens, four psychological costs rise: information overload, escalation of expectations, anticipated regret over opportunity costs, and self-blame.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Retail & Product Design",
                    scenario = "In Iyengar and Lepper's grocery study, a tasting booth displaying 24 flavours of gourmet jam attracted more passersby than a booth with 6 flavours, yet customers at the 6-flavour booth were ten times more likely to actually buy a jar.",
                    analysis = "Large assortments attract curiosity but can trigger decision deferral at commitment."
                ),
                EverydayExample(
                    context = "Streaming & Entertainment",
                    scenario = "Spending 35 minutes scrolling through 2,000 movie thumbnails on a streaming service and eventually turning the TV off without watching anything.",
                    analysis = "The opportunity cost of committing two hours to one film out of thousands induces choice paralysis."
                )
            ),
            howToRecognise = listOf(
                "Postponing a helpful decision because there are too many sub-options to compare.",
                "Feeling nagging regret right after making a good choice because you keep wondering about the runner-up option.",
                "Users abandoning a software onboarding screen that presents 15 configuration toggles at once."
            ),
            whyItOccurs = "Bounded working memory capacity combined with loss aversion: every rejected option's unique advantage is mentally coded as a forgone loss.",
            howToRespond = listOf(
                "Practice Satisficing: set your criteria first and pick the first option that clears the bar.",
                "When designing products or presenting proposals, curate choices down to 3–5 distinct options.",
                "Make significant choices non-reversible in your mind once settled, rather than endlessly re-shopping."
            ),
            relatedConceptIds = listOf("heur_satisficing", "dme_sunk_cost", "cd_all_or_nothing", "mm_inversion"),
            evidenceLevel = EvidenceLevel.MIXED_OR_DISPUTED,
            scientificEvidenceAndLimitations = "Iyengar & Lepper's (2000) jam study is a classic, while meta-analyses by Scheibehenne et al. (2010) and Chernev, Böckenholt, & Goodman (2015) clarified that Choice Overload occurs specifically when options are complex, hard to compare, and decision-makers lack prior preferences.",
            sources = listOf(
                SourceReference(
                    title = "When choice is demotivating: Can one desire too much of a good thing?",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Iyengar, S. S. & Lepper, M. R. (2000)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/11138768/"
                ),
                SourceReference(
                    title = "Choice overload: A conceptual review and meta-analysis",
                    sourceName = "Journal of Consumer Psychology",
                    authorsOrYear = "Chernev, A., Böckenholt, U., & Goodman, J. (2015)",
                    url = "https://scholar.google.com/scholar?q=Chernev+Bockenholt+Goodman+2015+Choice+overload+meta+analysis"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("barry schwartz", "iyengar", "jam study", "choice overload", "opportunity cost")
        ),

        // ==========================================
        // 11. DECISION-MAKING ERRORS
        // ==========================================
        ConceptArticle(
            id = "dme_sunk_cost",
            name = "Sunk Cost Fallacy",
            alternativeNames = listOf("Concorde Effect", "Retrospective Cost Bias"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Commitment & Escalation Traps"),
            shortDefinition = "Continuing an endeavour, investment, or activity solely because of previously invested time, money, or effort that cannot be recovered, even when current future costs outweigh future benefits.",
            beginnerExplanation = "A 'sunk cost' is money or time that is already spent and gone forever regardless of what you do next. The Sunk Cost Fallacy is sitting through a miserable two-hour movie in the freezing rain just because you already paid $15 for the ticket—turning one loss into two.",
            detailedExplanation = "In rational decision theory, only incremental future costs and future benefits should govern a choice; historical, irrecoverable ('sunk') costs are irrelevant. However, Richard Thaler (1980) and Hal Arkes & Catherine Blumer (1985) demonstrated that humans systematically violate this principle due to Loss Aversion and mental accounting.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Personal Leisure & Entertainment",
                    scenario = "Forcing yourself to finish a dull 800-page novel you dislike because you already spent $25 and six hours reading the first half.",
                    analysis = "The $25 and six hours cannot be refunded; spending six more hours only compounds the cost."
                ),
                EverydayExample(
                    context = "Product & Software Architecture",
                    scenario = "Refusing to switch from a broken in-house framework to a mature open-source library because 'we already spent eight months building our custom version.'",
                    analysis = "The eight months are gone either way; the only rational question is which path costs less from today forward."
                )
            ),
            howToRecognise = listOf(
                "Arguments that begin with 'We can't stop now after everything we've already put into this.'",
                "Keeping unwearable clothes, unused subscriptions, or failing projects alive to avoid 'wasting' the purchase price.",
                "Emotional dread at the thought of 'writing off' a past investment."
            ),
            whyItOccurs = "Driven by Kahneman and Tversky's Loss Aversion, Thaler's Mental Accounting, and the social desire not to appear wasteful.",
            howToRespond = listOf(
                "Ask the Zero-Base Question: 'If I were starting from scratch today with zero prior investment, would I enter this project right now?'",
                "Reframe past effort as tuition paid for learning what works, rather than a debt that must be redeemed.",
                "Separate the people who approved the original investment from the people who evaluate whether to continue it."
            ),
            relatedConceptIds = listOf("dme_escalation_commitment", "dme_planning_fallacy", "pr_foot_in_the_door", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated experimentally by Arkes & Blumer (1985) in Organizational Behavior and Human Decision Processes and formulated in behavioral economics by Thaler (1980).",
            sources = listOf(
                SourceReference(
                    title = "The psychology of sunk cost",
                    sourceName = "Organizational Behavior and Human Decision Processes",
                    authorsOrYear = "Arkes, H. R. & Blumer, C. (1985)",
                    url = "https://scholar.google.com/scholar?q=Arkes+Blumer+1985+The+psychology+of+sunk+cost"
                ),
                SourceReference(
                    title = "Toward a positive theory of consumer choice",
                    sourceName = "Journal of Economic Behavior & Organization",
                    authorsOrYear = "Thaler, R. (1980)",
                    url = "https://scholar.google.com/scholar?q=Richard+Thaler+1980+Toward+a+positive+theory+of+consumer+choice"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("loss aversion", "concorde fallacy", "throwing good money after bad", "thaler", "arkes")
        ),

        ConceptArticle(
            id = "dme_planning_fallacy",
            name = "Planning Fallacy",
            alternativeNames = listOf("Inside-View Optimism Bias", "Best-Case Scenario Forecasting"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Forecasting & Planning Fallacies"),
            shortDefinition = "The systematic tendency to underestimate the time, costs, and risks required to complete a future task, even when the planner has direct personal experience of similar past tasks taking much longer.",
            beginnerExplanation = "When we estimate how long a project will take, we picture a world where nobody gets sick, no software bugs pop up, and every email gets answered in five minutes. Even though our last ten projects hit unexpected delays, we still plan the eleventh project as if everything will go smoothly.",
            detailedExplanation = "Proposed by Daniel Kahneman and Amos Tversky in 1979 and tested empirically by Roger Buehler, Dale Griffin, and Michael Ross (1994), the Planning Fallacy arises from taking the 'Inside View' rather than the 'Outside View.' Planners focus on the specific components of their unique project and mentally simulate a success scenario while ignoring historical base rates of disruption.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Sprint Estimation",
                    scenario = "Estimating that an API integration will take 'two afternoons' by picturing only writing the happy-path code, forgetting authentication edge cases, rate limits, code review, and QA testing.",
                    analysis = "Simulates best-case execution while omitting routine friction."
                ),
                EverydayExample(
                    context = "Home Renovations & Infrastructure",
                    scenario = "Planning a kitchen remodel for three weeks and $15,000, despite neighbours' identical kitchens taking nine weeks and $28,000.",
                    analysis = "Neglects historical base rates (the Outside View) in favour of an optimistic internal plan."
                )
            ),
            howToRecognise = listOf(
                "Project timelines that contain zero buffer for unexpected blockers or external dependencies.",
                "Saying 'Yes, past projects ran late, but *this* time we know what we're doing.'",
                "A 'worst-case' estimate that is still faster than the historical average of past projects."
            ),
            whyItOccurs = "Inside-view mental simulation focuses on intentional actions rather than statistical distributions of random disruptions.",
            howToRespond = listOf(
                "Use Reference Class Forecasting (the Outside View): find 5 to 10 similar past projects, calculate their actual average duration, and use that as your baseline.",
                "Break monolithic tasks into small, concrete sub-deliverables.",
                "Run a Pre-Mortem to surface likely bottlenecks before committing to a delivery date."
            ),
            relatedConceptIds = listOf("bias_base_rate_fallacy", "mm_inversion", "dme_sunk_cost", "dme_escalation_commitment"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Buehler, Griffin, & Ross (1994) and in Bent Flyvbjerg's large-scale empirical audits of global infrastructure projects (2006).",
            sources = listOf(
                SourceReference(
                    title = "Exploring the 'planning fallacy': Why people underestimate their task completion times",
                    sourceName = "Journal of Personality and Social Psychology",
                    authorsOrYear = "Buehler, R., Griffin, D., & Ross, M. (1994)",
                    url = "https://scholar.google.com/scholar?q=Buehler+Griffin+Ross+1994+Exploring+the+planning+fallacy"
                ),
                SourceReference(
                    title = "From GOOD Intentions to Real Projects: Reference Class Forecasting",
                    sourceName = "Project Management Journal",
                    authorsOrYear = "Flyvbjerg, B. (2006)",
                    url = "https://scholar.google.com/scholar?q=Bent+Flyvbjerg+2006+Reference+Class+Forecasting+planning+fallacy"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("time estimation", "deadlines", "outside view", "reference class forecasting", "optimism")
        ),

        ConceptArticle(
            id = "dme_escalation_commitment",
            name = "Escalation of Commitment",
            alternativeNames = listOf("Commitment Escalation Trap", "Doubling Down on Failure"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Commitment & Escalation Traps"),
            shortDefinition = "A human and organisational behaviour pattern in which an individual or group facing increasingly negative outcomes from a prior decision nevertheless continues to pour additional resources into the same failing course of action.",
            beginnerExplanation = "While the Sunk Cost Fallacy is about feeling attached to past money or time already spent, Escalation of Commitment adds ego and reputation: because you publicly championed a plan, admitting it isn't working feels embarrassing, so you double down in hopes of a turnaround.",
            detailedExplanation = "First investigated experimentally by Barry M. Staw (1976) in 'Knee-Deep in the Big Muddy,' Escalation of Commitment integrates cognitive dissonance, self-justification, and Prospect Theory risk-seeking in the domain of losses.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Executive Strategy",
                    scenario = "A founder who publicly promised investors that a new hardware line would succeed responds to dismal early sales by pouring half the company's remaining cash into doubling manufacturing.",
                    analysis = "Self-justification and reputation protection drive risk-seeking behaviour in the domain of losses."
                ),
                EverydayExample(
                    context = "Public Arguments",
                    scenario = "Realising halfway through a debate that your initial claim was mistaken, but arguing even louder and making bolder claims to avoid admitting error in front of peers.",
                    analysis = "Ego defence overrides epistemic accuracy."
                )
            ),
            howToRecognise = listOf(
                "Treating negative feedback or missed milestones as 'a temporary test of our resolve' rather than diagnostic data.",
                "Punishing or sidelining team members who bring objective bad news.",
                "Refusing to set explicit 'kill criteria' (conditions under which the project will be stopped)."
            ),
            whyItOccurs = "Festinger's Cognitive Dissonance combined with Kahneman & Tversky's risk-seeking in the domain of losses.",
            howToRespond = listOf(
                "Establish written, quantitative 'Pre-Committed Kill Criteria' (tripwires) before launching a project.",
                "Rotate decision authority: have periodic continuation reviews conducted by an independent committee.",
                "Reward psychological safety and early course-correction."
            ),
            relatedConceptIds = listOf("dme_sunk_cost", "bias_confirmation", "sp_groupthink", "ct_intellectual_humility"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Initiated by Barry Staw (1976) and confirmed across over 150 empirical studies (Sleesman et al., 2012 meta-analysis).",
            sources = listOf(
                SourceReference(
                    title = "Knee-deep in the big muddy: a study of escalating commitment to a chosen course of action",
                    sourceName = "Organizational Behavior and Human Performance",
                    authorsOrYear = "Staw, B. M. (1976)",
                    url = "https://scholar.google.com/scholar?q=Barry+Staw+1976+Knee+deep+in+the+big+muddy"
                ),
                SourceReference(
                    title = "Cleaning up the big muddy: A meta-analytic review of the determinants of escalation of commitment",
                    sourceName = "Academy of Management Journal",
                    authorsOrYear = "Sleesman, D. J. et al. (2012)",
                    url = "https://scholar.google.com/scholar?q=Sleesman+2012+Cleaning+up+the+big+muddy+meta+analytic+escalation"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("barry staw", "self justification", "doubling down", "kill criteria", "sunk cost")
        ),

        ConceptArticle(
            id = "dme_framing_effect",
            name = "Framing Effect (Decision & Risk)",
            alternativeNames = listOf("Valence Framing Bias", "Gain-Loss Asymmetry"),
            primaryCategory = CollectionCategory.DECISION_MAKING_ERRORS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Action, Inaction & Outcome Traps"),
            shortDefinition = "Making systematically different—and sometimes completely reversed—choices depending on whether the exact same objective outcome is described in terms of potential gains or potential losses.",
            beginnerExplanation = "A medical procedure with a '90% survival rate' is mathematically identical to one with a '10% mortality rate.' Yet patients and doctors alike are far more likely to approve the surgery when they hear '90% survival.' How a choice is worded changes our appetite for risk.",
            detailedExplanation = "Demonstrated by Amos Tversky and Daniel Kahneman (1981) in their 'Asian Disease Problem' and explained by Prospect Theory, the Framing Effect violates description invariance. When outcomes are framed as gains, people become risk-averse; when the exact same mathematical outcomes are framed as losses, people flip to becoming risk-seeking.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Healthcare Informed Consent",
                    scenario = "Patients presented with 'Out of 100 patients who have this procedure, 95 are symptom-free after one year' opt in at much higher rates than patients told '5 out of 100 patients experience complications.'",
                    analysis = "Survival framing highlights the reassuring majority; mortality framing triggers loss aversion."
                ),
                EverydayExample(
                    context = "Payment Surcharges vs. Discounts",
                    scenario = "Customers bristle at a '3% Credit Card Surcharge' (framed as a penalty/loss) but happily accept a '3% Cash Discount' (framed as a bonus/gain), even though the final prices are identical.",
                    analysis = "Shifting the reference point changes a perceived loss into a forgone gain."
                )
            ),
            howToRecognise = listOf(
                "Options presented using only positive survival/success rates or only negative failure/loss rates.",
                "Feeling a sudden shift in your risk tolerance when a problem is restated from a different reference point.",
                "Default opt-in versus opt-out checkboxes guiding choices."
            ),
            whyItOccurs = "Prospect Theory's S-shaped value function is concave for gains (producing risk aversion) and steeper and convex for losses (producing loss aversion).",
            howToRespond = listOf(
                "Always dual-frame critical decisions: write down both the gain frame ('90% succeed') and the loss frame ('10% fail') side by side before choosing.",
                "Convert relative risk percentages into absolute numbers per 1,000 people.",
                "Check what reference point is being assumed as the baseline."
            ),
            relatedConceptIds = listOf("pr_framing", "dme_sunk_cost", "heur_affect", "bias_anchoring"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated in Tversky & Kahneman's (1981) Science paper and replicated globally across clinical, financial, and policy populations (Kühberger, 1998 meta-analysis).",
            sources = listOf(
                SourceReference(
                    title = "The framing of decisions and the psychology of choice",
                    sourceName = "Science (PubMed)",
                    authorsOrYear = "Tversky, A. & Kahneman, D. (1981)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/7455683/"
                ),
                SourceReference(
                    title = "The Influence of Framing on Risky Decisions: A Meta-analysis",
                    sourceName = "Organizational Behavior and Human Decision Processes",
                    authorsOrYear = "Kühberger, A. (1998)",
                    url = "https://scholar.google.com/scholar?q=Kuhberger+1998+Influence+of+Framing+on+Risky+Decisions+Meta+analysis"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("prospect theory", "loss aversion", "tversky", "gain vs loss", "invariance")
        )
    )
}
