package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference
import com.example.model.SourceType

object ContentPack7PathwayExpansion {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 1. LOGICAL FALLACIES ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "fallacy_denying_antecedent",
            name = "Denying the Antecedent",
            alternativeNames = listOf("Inverse Error", "Fallacy of the Inverse"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Formal Fallacies", "Deductive Reasoning Errors"),
            shortDefinition = "A formal deductive fallacy that takes a true conditional premise ('If P, then Q'), observes that P is false ('Not P'), and invalidly concludes that Q must also be false ('Therefore, not Q').",
            beginnerExplanation = "If you are in Paris, you are in France. If you are NOT in Paris, does that mean you are not in France? Of course not—you could be in Lyon or Nice. Assuming 'Not P, therefore Not Q' is Denying the Antecedent.",
            detailedExplanation = "In classical propositional logic, a conditional statement 'If P, then Q' establishes P as a sufficient condition for Q, not a necessary condition. Denying the Antecedent has the formal structure: (1) P -> Q; (2) ~P; (3) Therefore, ~Q. Because Q can be brought about by alternative sufficient conditions (R, S, or T), the falsity of P leaves the truth value of Q undetermined. People frequently commit this error when they mentally convert a one-way conditional into a biconditional ('If and only if P, then Q').",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Engineering & Testing",
                    scenario = "'If the code has a syntax error, the build will fail. There are no syntax errors in this file, so the build will definitely succeed.'",
                    analysis = "Linker errors, missing dependencies, or failed unit tests can still cause the build to fail even without syntax errors."
                ),
                EverydayExample(
                    context = "Public Discourse & Policy",
                    scenario = "'If a city has zero public parks, residents' wellbeing suffers. Our city has three parks, so residents' wellbeing cannot be suffering.'",
                    analysis = "Ignores housing costs, air quality, and transit factors that independently affect wellbeing."
                )
            ),
            howToRecognise = listOf(
                "Arguing that because one specific cause was ruled out, the effect cannot occur.",
                "Treating a sufficient condition ('If A happens, B follows') as the *only* possible route to B.",
                "Confusing valid Modus Tollens ('Not Q, therefore Not P') with invalid Denying the Antecedent ('Not P, therefore Not Q')."
            ),
            whyItOccurs = "Pragmatic implicature in everyday conversation: when a parent says 'If you mow the lawn, I'll give you $20,' the listener pragmatically infers 'and if you don't, I won't'—a conversational shortcut that fails in formal and scientific deduction.",
            howToRespond = listOf(
                "Ask: 'Even if P did not happen, what other factors could still bring about Q?'",
                "Compare with Modus Tollens: only the falsity of the *consequent* (~Q) deductively disproves the antecedent (~P).",
                "Explicitly distinguish sufficient conditions from necessary conditions."
            ),
            relatedConceptIds = listOf("fallacy_affirming_consequent", "ct_falsifiability", "rp_occams_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formally invalid in propositional logic (Aristotle; Stoic logic) and empirically documented in human conditional reasoning studies (Evans, Newstead, & Byrne, 1993).",
            sources = listOf(
                SourceReference(
                    title = "Classical Logic",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Shapiro, S. & Kouri Kissel, T. (2022)",
                    url = "https://plato.stanford.edu/entries/logic-classical/",
                    publicationYear = "2022",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "Human Reasoning: The Psychology of Deduction",
                    sourceName = "Psychology Press",
                    authorsOrYear = "Evans, J. St. B. T., Newstead, S. E., & Byrne, R. M. J. (1993)",
                    url = "https://scholar.google.com/scholar?q=Evans+Newstead+Byrne+1993+Human+Reasoning+Psychology+of+Deduction",
                    publicationYear = "1993",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("inverse error", "formal fallacy", "modus tollens", "conditional logic", "deduction"),
            difficultyOverride = DifficultyLevel.INTERMEDIATE
        ),

        ConceptArticle(
            id = "fallacy_no_true_scotsman",
            name = "No True Scotsman",
            alternativeNames = listOf("Ad-Hoc Rescue Fallacy", "Appeal to Purity"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Informal Fallacies", "Presumption Fallacies", "Fallacies in Online Discussions"),
            shortDefinition = "Protecting a universal generalisation from falsifying counterexamples by arbitrarily redefining the group's membership criteria on the spot to exclude the counterexample ('No *true* member of X would do that').",
            beginnerExplanation = "Named by philosopher Antony Flew: Hamish reads in the paper that a man from Aberdeen committed a crime and says, 'No Scotsman would do such a thing!' When his friend points out that the culprit was born and raised in Scotland, Hamish replies, 'Well, no *true* Scotsman would do such a thing!' Instead of admitting the generalisation was too broad, he rewrites the definition of 'Scotsman' to make his claim untouchable.",
            detailedExplanation = "Introduced by philosopher Antony Flew in his 1975 book 'Thinking About Thinking,' the No True Scotsman fallacy is an informal ad-hoc immunisation strategy. The speaker begins with an empirical universal claim ('All members of group X have virtue Y'). When confronted with a concrete, verifiable counterexample (Member A of group X lacks virtue Y), the speaker refuses to retract the universal claim and instead shifts the meaning of 'X' from an objective, agreed-upon definition to a shifting honorific definition that automatically excludes anyone who lacks Y. This converts a testable empirical claim into an unfalsifiable tautology.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Methodology Debates",
                    scenario = "Advocate: 'Teams using Framework X never miss deadlines.' Colleague: 'Company Y used Framework X and ran six months late.' Advocate: 'Well, then they weren't doing *true* Framework X!'",
                    analysis = "Redefines the methodology so that only successful projects count as 'true' implementations."
                ),
                EverydayExample(
                    context = "Online Community Disputes",
                    scenario = "'No real audiophile listens to compressed streaming audio.'",
                    analysis = "Uses a purity test to gatekeep identity rather than debating acoustic perception data."
                )
            ),
            howToRecognise = listOf(
                "Modifier words like 'real', 'true', 'authentic', or 'genuine' appear suddenly only *after* a counterexample is presented.",
                "Objective membership criteria (citizenship, certification, following a documented manual) are replaced mid-argument with circular outcome criteria.",
                "Any failure of a method is automatically blamed on the practitioner not being 'pure' enough."
            ),
            whyItOccurs = "Protects in-group identity (Social Identity Theory) and shields cherished beliefs from Popperian falsification.",
            howToRespond = listOf(
                "Agree on clear, objective definitions of terms *before* evaluating examples.",
                "Point out the circularity: 'If we define a true X as someone who never fails, then saying true Xs never fail is just a circular definition, not a factual discovery.'",
                "Invite the speaker to replace 'All X...' with a calibrated probabilistic statement ('Most X...' or 'When applied with conditions A and B...')."
            ),
            relatedConceptIds = listOf("ct_falsifiability", "manip_moving_goalposts", "fallacy_motte_and_bailey", "bias_confirmation"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Antony Flew (1975) in analytic philosophy and informal logic; closely mirrors Popper's (1934) critique of conventionalist stratagems that immunise hypotheses against refutation.",
            sources = listOf(
                SourceReference(
                    title = "Thinking About Thinking: Or, Do I Sincerely Want to Be Right?",
                    sourceName = "Fontana / Collins",
                    authorsOrYear = "Flew, A. (1975)",
                    url = "https://scholar.google.com/scholar?q=Antony+Flew+1975+Thinking+About+Thinking+No+True+Scotsman",
                    publicationYear = "1975",
                    sourceType = SourceType.MONOGRAPH_BOOK
                ),
                SourceReference(
                    title = "Fallacies",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansen, H. (2020)",
                    url = "https://plato.stanford.edu/entries/fallacies/",
                    publicationYear = "2020",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("antony flew", "purity test", "gatekeeping", "ad hoc", "tautology")
        ),

        // ==========================================
        // 2. COGNITIVE BIASES ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "bias_optimism",
            name = "Optimism Bias",
            alternativeNames = listOf("Unrealistic Optimism", "Comparative Optimism", "Valence Effect in Prediction"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS, CollectionCategory.PSYCHOLOGICAL_PHENOMENA),
            subcategories = listOf("Probability and Risk", "Overconfidence", "Belief Formation"),
            shortDefinition = "The cognitive tendency to overestimate the likelihood of experiencing positive events while underestimating the personal probability of encountering negative events compared to objective baselines or peers.",
            beginnerExplanation = "Even when people know the exact statistical rate of car accidents, cyberattacks, or project delays in the general population, most individuals genuinely believe their *own* personal risk is much lower than average.",
            detailedExplanation = "Investigated extensively by Neil Weinstein (1980) and neuroscientist Tali Sharot (2011), Optimism Bias manifests as asymmetric belief updating: humans update their beliefs significantly more when presented with favourable news ('your risk is lower than you thought') than when presented with unfavourable news ('your risk is higher than you thought'). While moderate optimism promotes resilience and goal persistence, unchecked optimism bias in engineering, medicine, and finance fuels the Planning Fallacy and insufficient safety margins.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Cybersecurity & Backups",
                    scenario = "Knowing that hardware failures happen to thousands of laptops daily, yet postponing cloud backups for months because 'my drive is fine.'",
                    analysis = "Acknowledges the population base rate while exempting oneself from it."
                ),
                EverydayExample(
                    context = "Startup & Financial Budgeting",
                    scenario = "Budgeting a new venture assuming 0% customer churn and immediate viral adoption.",
                    analysis = "Overweights desirable outcomes relative to historical industry survival rates."
                )
            ),
            howToRecognise = listOf(
                "Believing 'That statistic applies to average teams, not our team' without specific structural safeguards.",
                "Updating forecasts immediately on good news while discounting early warning indicators.",
                "Omitting contingency buffers in financial or engineering plans."
            ),
            whyItOccurs = "fMRI studies (Sharot et al., 2011) show reduced coding of undesirable estimation errors in the right inferior prefrontal gyrus compared to strong frontal coding of desirable surprises.",
            howToRespond = listOf(
                "Anchor on the Outside View (Reference Class Forecasting) rather than internal hopes.",
                "Pair optimistic execution goals with a pessimistic 'Pre-Mortem' risk checklist.",
                "Build structural Margins of Safety into budgets and timelines."
            ),
            relatedConceptIds = listOf("dme_planning_fallacy", "mm_margin_of_safety", "mm_inversion", "bias_base_rate_fallacy"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Weinstein (1980) in the Journal of Personality and Social Psychology and neurobiologically characterised by Sharot, Korn, & Dolan (2011) in Nature Neuroscience.",
            sources = listOf(
                SourceReference(
                    title = "Unrealistic optimism about future life events",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Weinstein, N. D. (1980)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/7431206/",
                    publicationYear = "1980",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "How unrealistic optimism is maintained in the face of reality",
                    sourceName = "Nature Neuroscience (PubMed)",
                    authorsOrYear = "Sharot, T., Korn, C. W., & Dolan, R. J. (2011)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21983684/",
                    publicationYear = "2011",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("tali sharot", "weinstein", "overconfidence", "wishful thinking", "risk underestimation")
        ),

        ConceptArticle(
            id = "bias_blind_spot",
            name = "Bias Blind Spot",
            alternativeNames = listOf("Metacognitive Asymmetry of Bias", "Naive Realism"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Self-Perception", "Social Judgment", "Overconfidence"),
            shortDefinition = "The tendency to easily recognise the impact of cognitive and motivational biases on the judgments of others while failing to perceive the influence of those exact same biases on one's own judgments.",
            beginnerExplanation = "When someone disagrees with us, we quickly spot their Confirmation Bias, Halo Effect, or self-interest. When we examine our own opinion, we look inward, feel calm and rational, and conclude: 'I just looked at the objective facts.' That blind spot to our own biases is the Bias Blind Spot.",
            detailedExplanation = "Coined by Emily Pronin, Daniel Lin, and Lee Ross (2002), the Bias Blind Spot is rooted in two mechanisms: (1) Naive Realism — the conviction that we perceive reality directly and objectively as it truly is, so anyone who sees it differently must be biased; and (2) The Introspection Illusion — when judging whether *we* were biased, we look inward at our conscious thoughts, and because cognitive biases operate unconsciously outside awareness, we find 'no trace of bias' in our introspection and declare ourselves impartial! Strikingly, West, Meserve, and Stanovich (2012) found that higher cognitive sophistication and IQ do *not* reduce the Bias Blind Spot.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Peer Review & Academic Debate",
                    scenario = "A researcher spots methodological flaws in a rival lab's paper within five minutes, while overlooking identical sample-size limitations in their own draft.",
                    analysis = "Applies rigorous external scrutiny to others while relying on introspective good intentions for oneself."
                ),
                EverydayExample(
                    context = "Conflict Resolution",
                    scenario = "Two departments in a dispute each rate themselves as '100% data-driven' and the other department as 'driven by politics.'",
                    analysis = "Naive realism causes both sides to equate their own perspective with objective reality."
                )
            ),
            howToRecognise = listOf(
                "Using the names of cognitive biases as weapons to win arguments against others while never auditing your own priors.",
                "Saying 'I know I wasn't biased because I carefully thought about it and felt neutral.'",
                "Assuming that anyone who reads the same facts and reaches a different conclusion must be acting in bad faith."
            ),
            whyItOccurs = "The Introspection Illusion (Pronin & Kugler, 2007): because unconscious biases leave no conscious footprints in working memory, searching our feelings for bias always returns a false negative.",
            howToRespond = listOf(
                "Stop relying on introspection ('Do I feel biased?') and instead use structural safeguards (blinded reviews, pre-committed rubrics, and base-rate checklists).",
                "Treat learning about biases in MINDTRAP primarily as a mirror for self-calibration rather than a hammer for criticising others.",
                "Invite independent peers to audit your blind spots."
            ),
            relatedConceptIds = listOf("ct_intellectual_humility", "bias_confirmation", "phen_dunning_kruger", "sp_fundamental_attribution"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Pronin, Lin, & Ross (2002) in Personality and Social Psychology Bulletin and extended by West, Meserve, & Stanovich (2012) in the Journal of Personality and Social Psychology.",
            sources = listOf(
                SourceReference(
                    title = "The Bias Blind Spot: Perceptions of Bias in Self Versus Others",
                    sourceName = "Personality and Social Psychology Bulletin",
                    authorsOrYear = "Pronin, E., Lin, D. Y., & Ross, L. (2002)",
                    url = "https://scholar.google.com/scholar?q=Pronin+Lin+Ross+2002+The+Bias+Blind+Spot",
                    publicationYear = "2002",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Cognitive sophistication does not attenuate the bias blind spot",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "West, R. F., Meserve, R. J., & Stanovich, K. E. (2012)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/22663351/",
                    publicationYear = "2012",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("emily pronin", "naive realism", "introspection illusion", "stanovich", "self awareness")
        ),

        // ==========================================
        // 3. PSYCHOLOGICAL MANIPULATION ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "manip_love_bombing",
            name = "Love Bombing & Idealisation Cycles",
            alternativeNames = listOf("Affective Flooding", "Overwhelming Early Idealisation"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Emotional Pressure", "Boundary Violations", "Recognition, Prevention and Healthy Responses"),
            shortDefinition = "An overwhelming display of excessive affection, grand promises, and constant attention early in a relationship or group recruitment process, used to accelerate dependency and bypass normal boundary development.",
            beginnerExplanation = "Healthy trust grows gradually as two people get to know each other's real character over time. Love bombing floods a new acquaintance with extravagant flattery, 24/7 messaging, and 'you're the only one who understands me' declarations in the first few days—creating a fast, artificial bond before switching to control or withdrawal.",
            detailedExplanation = "Originally documented by psychologist Margaret Thaler Singer (1995) in studies of high-control recruitment groups and later investigated in interpersonal relationship research (Claire Strutzenberg et al., 2017), Love Bombing operates as the first phase of an 'Idealisation–Devaluation' cycle. By saturating the target's attention and accelerating intimacy far faster than organic acquaintance warrants, it establishes a high affective baseline. When the excessive praise is later withdrawn or replaced with criticism, Intermittent Reinforcement triggers anxious efforts by the target to win back the initial idealised approval.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Predatory Recruitment & High-Pressure Groups",
                    scenario = "A seminar group showers a newcomer with standing applause, constant praise of their 'rare genius,' and instant insider status during a weekend workshop, followed on Monday by demands for financial commitment and cutting ties with skeptical friends.",
                    analysis = "Uses affective flooding to lower critical scrutiny and isolate the recruit from external support."
                ),
                EverydayExample(
                    context = "Professional & Interpersonal Boundaries",
                    scenario = "A new business partner declares on Day 2 that you are 'the most brilliant collaborator I've ever met,' texts 40 times a day, and reacts with anger if you take two hours to reply during dinner.",
                    analysis = "Excessive early flattery is paired with intolerance for normal autonomy."
                )
            ),
            howToRecognise = listOf(
                "Extravagant praise and declarations of deep soulmate or lifelong loyalty before the person actually knows your real history or values.",
                "Pressure to skip normal pacing, independent review, or time alone with existing friends.",
                "A sudden shift from pedestal idealisation to cold disapproval the moment you set a modest boundary."
            ),
            whyItOccurs = "Exploits human reciprocity norms and the desire for belonging; intense early validation establishes the high-reward anchor required for subsequent Intermittent Reinforcement.",
            howToRespond = listOf(
                "Maintain steady, healthy pacing: genuine goodwill respects your schedule, independent friendships, and time to deliberate.",
                "Evaluate people and organisations by how they respond to a polite 'no' or boundary, not by how flattering they are when you say 'yes.'",
                "Keep trusted outside friends and mentors in the loop when evaluating high-stakes personal or business commitments."
            ),
            relatedConceptIds = listOf("manip_intermittent_reinforcement", "manip_emotional_blackmail", "manip_gaslighting", "bias_halo_effect"),
            evidenceLevel = EvidenceLevel.EVIDENCE_DEVELOPING,
            scientificEvidenceAndLimitations = "Investigated in cult/high-control group sociology by Singer (1995) and empirically measured in interpersonal communication studies by Strutzenberg, Wiersma-Mosley, Jozkowski, & Becnel (2017). Educational note: describes a behavioural influence pattern, not a clinical diagnosis.",
            sources = listOf(
                SourceReference(
                    title = "Love-bombing: A narcissistic approach to relationship formation",
                    sourceName = "Discovery, The Student Journal of Dale Bumpers College (University of Arkansas)",
                    authorsOrYear = "Strutzenberg, C. et al. (2017)",
                    url = "https://scholar.google.com/scholar?q=Strutzenberg+2017+Love+bombing+relationship+formation",
                    publicationYear = "2017",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Cults in Our Midst",
                    sourceName = "Jossey-Bass",
                    authorsOrYear = "Singer, M. T. (1995)",
                    url = "https://scholar.google.com/scholar?q=Margaret+Singer+1995+Cults+in+Our+Midst",
                    publicationYear = "1995",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("idealisation", "flattery", "pacing", "boundaries", "high control")
        ),

        ConceptArticle(
            id = "manip_moving_goalposts",
            name = "Moving the Goalposts",
            alternativeNames = listOf("Shifting Standards Manipulation", "Asymmetric Criterion Escalation"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Deception and Misleading Communication", "Coercive Control", "Recognition, Prevention and Healthy Responses"),
            shortDefinition = "Unilaterally changing the agreed-upon criteria for success, proof, or satisfaction *after* the other person has already met the original requirements, ensuring the target remains perpetually seeking approval or unable to settle a claim.",
            beginnerExplanation = "Imagine kicking a football right between the goalposts, only for the referee to pick up the posts, carry them 20 yards to the left, and shout 'You missed!' Moving the Goalposts happens in debates and relationships whenever meeting the exact requirement someone asked for is met with 'Well, that doesn't count—now you also have to do Y.'",
            detailedExplanation = "Moving the Goalposts operates both as an informal fallacy in argumentation (a variant of Special Pleading that renders a position unfalsifiable) and as a coercive control tactic in workplaces and relationships. In healthy collaboration, criteria for a promotion, deliverables, or evidentiary proof are defined upfront and honoured when met. In manipulative dynamics, the goalposts are continually relocated each time the target achieves them, keeping the target in a state of chronic effort and self-doubt without ever granting the promised recognition or resolution.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Promotion Criteria",
                    scenario = "An employee is told in January: 'If you bring in $200k in new client renewals, you'll earn the Senior Lead promotion.' In June, after delivering $220k, they are told: 'Renewals don't really count—you need three international enterprise logos first.'",
                    analysis = "Retroactively invalidates the fulfilled milestone to withhold the agreed outcome."
                ),
                EverydayExample(
                    context = "Scientific & Online Debate",
                    scenario = "'Show me one peer-reviewed study proving X.' After a peer-reviewed study is provided: 'Okay, one study doesn't count—show me a 20-year longitudinal meta-analysis across 50 countries.'",
                    analysis = "Escalates evidentiary demands post-hoc to avoid updating a belief."
                )
            ),
            howToRecognise = listOf(
                "Fulfilling a clearly stated request results in a new precondition rather than acknowledgement.",
                "Phrases like 'Well, that was the bare minimum—what I *really* meant was...'",
                "Exhaustion from chasing an approval standard that never stays stationary."
            ),
            whyItOccurs = "In debate, it shields a belief from cognitive dissonance; in interpersonal and organisational settings, it extracts uncompensated effort while preserving power asymmetry.",
            howToRespond = listOf(
                "Document success criteria and deliverables in writing before beginning work ('If we achieve X and Y by Q3, does that satisfy the requirement completely?').",
                "In debate, ask upfront: 'Before I look up the data, what specific evidence would you accept as sufficient?'",
                "Call out the shift calmly: 'We agreed on Criterion A last month, and Criterion A is now complete. Let's close out Phase 1 before scoping any new requirements.'"
            ),
            relatedConceptIds = listOf("fallacy_no_true_scotsman", "ct_falsifiability", "manip_gaslighting", "manip_intermittent_reinforcement"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Analysed in informal logic under Special Pleading and ad-hoc hypothesis modification (Popper, 1934; Walton, 2008) and in social psychology research on 'Shifting Standards' in stereotyping and evaluation (Biernat & Manis, 1994).",
            sources = listOf(
                SourceReference(
                    title = "Shifting standards and the evaluation of competence: complexity in gender-based judgment",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Biernat, M. & Manis, M. (1994)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/8195981/",
                    publicationYear = "1994",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Informal Logic: A Pragmatic Approach",
                    sourceName = "Cambridge University Press",
                    authorsOrYear = "Walton, D. (2008)",
                    url = "https://scholar.google.com/scholar?q=Douglas+Walton+2008+Informal+Logic+Pragmatic+Approach",
                    publicationYear = "2008",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("special pleading", "shifting standards", "goalposts", "accountability", "falsifiability")
        ),

        // ==========================================
        // 4. PSYCHOLOGICAL PHENOMENA ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "phen_hawthorne_effect",
            name = "Hawthorne Effect (Observer Reactivity)",
            alternativeNames = listOf("Observer Effect in Human Behaviour", "Participant Reactivity"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Social Presence and Observation Effects", "Expectancy and Self-Fulfilling Effects"),
            shortDefinition = "The alteration of human behaviour that occurs when individuals become aware that they are being observed, measured, or studied.",
            beginnerExplanation = "People drive more carefully when a police cruiser is visible and wash their hands more thoroughly when a clipboard observer is standing in the hospital hallway. Whenever humans know they are in an experiment or audit, their behaviour temporarily changes—which can trick researchers into thinking a new policy caused the improvement when it was really just the spotlight of being watched.",
            detailedExplanation = "Named by Henry A. Landsberger (1958) after analysing experiments conducted between 1924 and 1932 at the Hawthorne Works electric factory in Cicero, Illinois, the Hawthorne Effect describes behavioural reactivity to observation. While modern economic historians (Levitt & List, 2011) proved that the original 1920s factory lighting data were noisy and overstated in old textbooks, modern systematic reviews in clinical medicine and epidemiology (McCambridge, Witton, & Elbourne, 2014) confirm that research participation and overt observation genuinely alter short-term human compliance and performance.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "UX & Product Usability Testing",
                    scenario = "Users invited into a formal usability lab read every terms-of-service paragraph carefully while researchers watch through a camera—whereas at home they click 'Accept' in 0.4 seconds.",
                    analysis = "Awareness of observation induces conscientious self-presentation."
                ),
                EverydayExample(
                    context = "Hospital Hygiene Audits",
                    scenario = "Hand-sanitiser usage jumps to 94% on days when an infection-control auditor stands on the ward with a clipboard, then drops back to 55% via automated dispenser sensors the next day.",
                    analysis = "Overt observation inflates short-term compliance metrics."
                )
            ),
            howToRecognise = listOf(
                "Pilot programs that show dramatic gains during a heavily monitored 2-week trial, followed by a return to baseline once researchers leave.",
                "Unblinded studies that lack an active control group receiving equal researcher attention.",
                "Relying solely on overt, announced inspections to gauge everyday operational culture."
            ),
            whyItOccurs = "Social desirability, evaluation apprehension, and heightened attentional focus when an external observer is salient.",
            howToRespond = listOf(
                "In experimental design, always give the control group equal observation and attention (an 'attention-placebo control') so observation effects cancel out.",
                "Measure long-term habits over months after the novelty of observation fades.",
                "Combine laboratory observation with unobtrusive aggregate telemetry where appropriate and ethical."
            ),
            relatedConceptIds = listOf("phen_pygmalion_effect", "phen_spotlight_effect", "para_goodharts_law", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.MIXED_OR_DISPUTED,
            scientificEvidenceAndLimitations = "Levitt & List (2011) debunked the mythological claims about the original 1924 Hawthorne factory light-bulb data, while McCambridge et al.'s (2014) systematic review in the Journal of Clinical Epidemiology confirmed that participant reactivity to observation is real across 19 randomized controlled trials, though heterogeneous in size.",
            sources = listOf(
                SourceReference(
                    title = "Systematic review of the Hawthorne effect: New concepts are needed to study research participation effects",
                    sourceName = "Journal of Clinical Epidemiology (PubMed)",
                    authorsOrYear = "McCambridge, J., Witton, J., & Elbourne, D. R. (2014)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/24275499/",
                    publicationYear = "2014",
                    sourceType = SourceType.META_ANALYSIS
                ),
                SourceReference(
                    title = "Was There Really a Hawthorne Effect at the Hawthorne Plant? An Analysis of the Original Illumination Experiments",
                    sourceName = "American Economic Journal: Applied Economics",
                    authorsOrYear = "Levitt, S. D. & List, J. A. (2011)",
                    url = "https://scholar.google.com/scholar?q=Levitt+List+2011+Was+There+Really+a+Hawthorne+Effect",
                    publicationYear = "2011",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("observer effect", "reactivity", "landsberger", "clinical trials", "social desirability")
        ),

        ConceptArticle(
            id = "phen_baader_meinhof",
            name = "Frequency Illusion (Baader–Meinhof Phenomenon)",
            alternativeNames = listOf("Baader–Meinhof Phenomenon", "Selective Attention Frequency Bias"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.HEURISTICS),
            subcategories = listOf("Attention and Salience Effects"),
            shortDefinition = "A perceptual phenomenon in which, right after learning or noticing an unfamiliar word, concept, or object for the first time, you suddenly seem to encounter it everywhere—even though its actual frequency in the environment has not changed.",
            beginnerExplanation = "Have you ever learned an unusual vocabulary word on Monday, or test-driven a specific model of yellow hatchback, and then seen that exact word or car five times by Friday? The world didn't suddenly print more copies of that word overnight; your brain's attention filter simply tagged it as 'relevant' and stopped filtering it out.",
            detailedExplanation = "Named the 'Frequency Illusion' by Stanford linguist Arnold Zwicky (2005) (and informally dubbed the 'Baader-Meinhof phenomenon' on a 1994 newspaper forum), this effect is the product of two working partners in human cognition: (1) Selective Attention — the human brain is bombarded by millions of sensory bits per second and filters out 99% of background stimuli until a concept is primed in working memory; and (2) Confirmation Bias — each subsequent time the newly primed word or object appears, the brain registers a 'hit' ('Look, there it is again!'), reinforcing the illusion of a sudden surge in external frequency.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Learning Mental Models",
                    scenario = "After reading the MINDTRAP entry on the 'Motte-and-Bailey Fallacy' for the first time, noticing three separate commentators use that exact rhetorical structure during the same week.",
                    analysis = "The rhetorical pattern was always present in public discourse; learning its name gave your perception a schema to spot it."
                ),
                EverydayExample(
                    context = "Consumer Purchases",
                    scenario = "Buying a specific brand of running shoes and suddenly noticing dozens of strangers wearing the exact same model on the train.",
                    analysis = "Selective visual attention highlights stimuli that match recently encoded personal relevance."
                )
            ),
            howToRecognise = listOf(
                "Feeling an uncanny sense of coincidence ('Why is everyone suddenly talking about X this week?') right after you personally discovered X.",
                "Mistaking heightened personal awareness of a problem or trend for an objective spike in its real-world rate.",
                "Media panics where intense reporting on a rare event makes routine occurrences look like an sudden epidemic."
            ),
            whyItOccurs = "Top-down attentional priming in visual and semantic processing combined with the Availability Heuristic.",
            howToRespond = listOf(
                "Check objective time-series data (such as search volume logs or historical incidence rates) before concluding that a phenomenon is actually increasing.",
                "Use the Frequency Illusion constructively: studying mental models and fallacies intentionally primes your attention to spot reasoning traps in daily life.",
                "Distinguish changes in your *attention* from changes in the *territory*."
            ),
            relatedConceptIds = listOf("bias_confirmation", "heur_availability", "mm_map_not_territory", "fallacy_texas_sharpshooter"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Defined in cognitive linguistics by Arnold Zwicky (2005, Stanford University) and grounded in well-established experimental research on top-down selective attention and priming (Treisman, 1969; Kristjánsson & Campana, 2010).",
            sources = listOf(
                SourceReference(
                    title = "Just Between Dr. Language and I (The Frequency Illusion)",
                    sourceName = "Language Log / Stanford University",
                    authorsOrYear = "Zwicky, A. M. (2005)",
                    url = "https://scholar.google.com/scholar?q=Arnold+Zwicky+2005+Frequency+Illusion",
                    publicationYear = "2005",
                    sourceType = SourceType.ACADEMIC_ENCYCLOPEDIA
                ),
                SourceReference(
                    title = "Strategies and limitations of selective attention",
                    sourceName = "Psychological Review (PubMed)",
                    authorsOrYear = "Treisman, A. M. (1969)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/4896312/",
                    publicationYear = "1969",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("baader meinhof", "frequency illusion", "selective attention", "zwicky", "priming")
        ),

        // ==========================================
        // 5. COGNITIVE DISTORTIONS ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "cd_overgeneralisation",
            name = "Overgeneralisation & Global Labeling",
            alternativeNames = listOf("Sweeping Generalisation Distortion", "Global Self-Labeling"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES),
            subcategories = listOf("Overgeneralisation and Global Labeling", "Inductive Reasoning Errors"),
            shortDefinition = "Drawing a sweeping, permanent rule about oneself, others, or life based on a single isolated negative event ('This always happens to me'; 'I failed this test, so I am a failure').",
            beginnerExplanation = "When a single flat tire or rejected job application turns into 'Nothing ever goes right for me,' that is Overgeneralisation. Its extreme form is Global Labeling: instead of saying 'I made a mistake on that spreadsheet,' saying 'I am a loser.'",
            detailedExplanation = "Identified by Aaron T. Beck (1976) and Albert Ellis (1962), Overgeneralisation is the psychological counterpart to the Hasty Generalisation fallacy in inductive logic (inferring a universal population parameter from a sample size of n = 1). In cognitive therapy, Global Labeling takes a specific, time-bound behaviour ('I stumbled on question 3 during Tuesday's interview') and overgeneralises it into a static, essentialist noun defining an entire human being ('I'm an incompetent interviewee'). Research by Carol Dweck on Fixed vs. Growth Mindsets shows that global trait labels impair resilience and problem-solving after setbacks.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Job Search & Career",
                    scenario = "Receiving a rejection email from one company and thinking, 'No company in this industry will ever hire me.'",
                    analysis = "Extrapolates a sample size of 1 into a permanent universal law."
                ),
                EverydayExample(
                    context = "Interpersonal Frustration",
                    scenario = "A partner forgets to pick up milk once and is met with: 'You *never* listen to anything I ask!'",
                    analysis = "Overgeneralises a single lapse using 'always/never' absolutes."
                )
            ),
            howToRecognise = listOf(
                "Using universal quantifiers ('always', 'never', 'everyone', 'nobody', 'every time') after a single incident.",
                "Equating a specific action or mistake with a global identity noun ('I made an error' -> 'I am a failure').",
                "Treating a temporary setback as a permanent condition."
            ),
            whyItOccurs = "Negative events command high attentional salience, temporarily crowding out counterexamples in working memory.",
            howToRespond = listOf(
                "Use specific, time-bounded language ('E-Prime' or behavioral specificity): replace 'I am terrible at math' with 'I missed three calculus problems on Tuesday's quiz.'",
                "List three concrete counterexamples from your past that disprove the 'always/never' statement.",
                "Ask: 'Would a scientist accept a sample size of 1 as proof of a universal law?'"
            ),
            relatedConceptIds = listOf("cd_all_or_nothing", "cd_catastrophizing", "cd_personalisation", "heur_representativeness"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Core construct in Cognitive Behavioural Therapy (Beck, 1976) and supported by empirical research on explanatory style (Abramson, Seligman, & Teasdale, 1978, 'Learned Helplessness' global vs. specific attributions).",
            sources = listOf(
                SourceReference(
                    title = "Learned helplessness in humans: critique and reformulation",
                    sourceName = "Journal of Abnormal Psychology (PubMed)",
                    authorsOrYear = "Abramson, L. Y., Seligman, M. E., & Teasdale, J. D. (1978)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/649856/",
                    publicationYear = "1978",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Cognitive Therapy and the Emotional Disorders",
                    sourceName = "International Universities Press",
                    authorsOrYear = "Beck, A. T. (1976)",
                    url = "https://scholar.google.com/scholar?q=Aaron+Beck+1976+Cognitive+Therapy+and+the+Emotional+Disorders",
                    publicationYear = "1976",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("hasty generalisation", "labeling", "always never", "seligman", "cbt")
        ),

        ConceptArticle(
            id = "cd_personalisation",
            name = "Personalisation (Cognitive Distortion)",
            alternativeNames = listOf("Self-Referential Blame Distortion", "Egocentric Causality Leap"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Personalisation and Blame Attribution"),
            shortDefinition = "Assuming excessive personal responsibility or blame for external events—or other people's moods—that are largely or entirely outside one's control.",
            beginnerExplanation = "If a picnic gets rained out or a client cancels a contract because their parent company froze budgets, Personalisation whispers: 'It's all my fault.' It confuses having *some* connection to a situation with being the sole omnipotent cause of everything that happens.",
            detailedExplanation = "Described by Aaron Beck (1976), Personalisation takes two related forms: (1) Causal Personalisation — blaming oneself for multi-factor outcomes that depended on dozens of external variables; and (2) Referential Personalisation — assuming that neutral external events (such as two people laughing across a room or a manager looking tired) are directed specifically at oneself. While taking ownership of one's actual actions is healthy, Personalisation ignores external causal factors and creates unwarranted guilt.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Team Project Outcomes",
                    scenario = "A product launch misses its target during an industry-wide recession, and the junior designer blames their icon colour choice for the entire company's revenue dip.",
                    analysis = "Ignores macroeconomic and product-strategy factors to assign 100% of causality to oneself."
                ),
                EverydayExample(
                    context = "Everyday Social Cues",
                    scenario = "A friend seems quiet at lunch, and you immediately conclude, 'I must have offended them,' when they actually have a migraine.",
                    analysis = "Assumes you are the cause of another person's internal state."
                )
            ),
            howToRecognise = listOf(
                "Apologising reflexively for things you did not cause and cannot control.",
                "Assuming someone else's bad mood is a reaction to you.",
                "Failing to separate your specific contribution from broader systemic factors."
            ),
            whyItOccurs = "Egocentric availability (our own actions and presence are always at the centre of our awareness) combined with an illusion of control.",
            howToRespond = listOf(
                "Draw a Responsibility Pie Chart: before assigning 100% of the blame to yourself, list every other external factor, market condition, and participant first, assign each a realistic slice, and only assign yourself the remaining slice.",
                "Pair with the Spotlight Effect and Mind Reading checks.",
                "Distinguish what is inside your circle of control from what is outside it."
            ),
            relatedConceptIds = listOf("cd_mind_reading", "phen_spotlight_effect", "sp_fundamental_attribution", "cd_emotional_reasoning"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Validated in clinical cognitive therapy (Beck, 1976) and experimental research on the 'Responsibility Pie' cognitive restructuring technique (Greenberger & Padesky, 1995).",
            sources = listOf(
                SourceReference(
                    title = "Mind Over Mood: Change How You Feel by Changing the Way You Think",
                    sourceName = "Guilford Press",
                    authorsOrYear = "Greenberger, D. & Padesky, C. A. (1995)",
                    url = "https://scholar.google.com/scholar?q=Greenberger+Padesky+1995+Mind+Over+Mood",
                    publicationYear = "1995",
                    sourceType = SourceType.MONOGRAPH_BOOK
                ),
                SourceReference(
                    title = "Cognitive Therapy and the Emotional Disorders",
                    sourceName = "International Universities Press",
                    authorsOrYear = "Beck, A. T. (1976)",
                    url = "https://scholar.google.com/scholar?q=Aaron+Beck+1976+Cognitive+Therapy+and+the+Emotional+Disorders",
                    publicationYear = "1976",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("self blame", "responsibility pie", "guilt", "egocentric", "cbt")
        )
    )
}
