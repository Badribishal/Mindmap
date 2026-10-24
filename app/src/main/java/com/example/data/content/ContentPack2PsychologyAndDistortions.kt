package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack2PsychologyAndDistortions {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 3. PSYCHOLOGICAL MANIPULATION
        // ==========================================
        ConceptArticle(
            id = "manip_gaslighting",
            name = "Gaslighting",
            alternativeNames = listOf("Epistemic Manipulation", "Reality Distortion Tactics"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Reality Distortion & Deception"),
            shortDefinition = "A persistent pattern of psychological manipulation in which a person sows self-doubt and confusion in another individual, causing them to question their own memory, perception, or judgment.",
            beginnerExplanation = "Note: Ordinary disagreement or having different memories of an event is not gaslighting. True gaslighting is a repeated, deliberate pattern where someone denies facts you witnessed, insists you 'imagined it' or are 'too sensitive,' and gradually makes you distrust your own mind.",
            detailedExplanation = "Originating from Patrick Hamilton's 1938 play 'Gas Light' (where a husband dims the gas lamps and insists his wife is imagining the dimming), gaslighting has been studied in clinical psychology, sociology, and epistemology (Abramson, 2014; Sweet, 2019). Unlike a single isolated lie—which seeks only to conceal a specific fact—gaslighting aims to undermine the target's epistemic agency (their confidence as an independent knower). Because the term has undergone concept creep in popular culture, researchers emphasise distinguishing genuine manipulative gaslighting from honest memory discrepancies, normal interpersonal disagreements, or cultural misunderstandings.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Accountability",
                    scenario = "A supervisor verbally instructs an employee to drop Project A and focus on Project B. Two weeks later, in front of leadership, the supervisor says, 'I never told you to pause Project A—you've been forgetting basic instructions lately, haven't you?'",
                    analysis = "Combines flat denial of a prior instruction with an attack on the employee's general cognitive reliability."
                ),
                EverydayExample(
                    context = "Interpersonal Boundaries",
                    scenario = "After repeatedly making disparaging remarks and being asked to stop, a partner responds, 'You're completely making that up. Everyone in your family says you invent drama out of thin air.'",
                    analysis = "Denies the observable pattern and recruits fabricated social consensus to isolate and destabilise the target's perception."
                )
            ),
            howToRecognise = listOf(
                "Frequently apologising or second-guessing your own clear memories of conversations that just occurred.",
                "The other party not only disagrees about what happened, but repeatedly insists your memory or emotional stability is defective.",
                "Feeling the need to keep written logs or screenshots simply to reassure yourself of what was agreed upon."
            ),
            whyItOccurs = "Human self-trust is partially social; when someone we trust or depend upon expresses total certainty that our perception is faulty, epistemic humility can be exploited against us. Power asymmetries in workplaces or relationships amplify this vulnerability.",
            howToRespond = listOf(
                "Maintain external documentation: follow up important verbal agreements with a polite summary email ('Per our conversation today, we agreed to...').",
                "Anchor on present boundaries rather than debating historical memory: 'Regardless of how we each remember last Tuesday, going forward I need requests in writing.'",
                "Seek perspective from trusted, independent peers or licensed professionals outside the dynamic."
            ),
            relatedConceptIds = listOf("manip_darvo", "manip_intermittent_reinforcement", "mem_misinformation_effect", "ct_intellectual_humility"),
            evidenceLevel = EvidenceLevel.EVIDENCE_DEVELOPING,
            scientificEvidenceAndLimitations = "Extensively analysed in qualitative sociology (Sweet, 2019, American Sociological Review) and philosophical epistemology (Abramson, 2014). While not a formal DSM diagnostic category—and never to be used to diagnose individuals—its relational mechanisms are well documented in interpersonal abuse literature.",
            sources = listOf(
                SourceReference(
                    title = "The Sociology of Gaslighting",
                    sourceName = "American Sociological Review",
                    authorsOrYear = "Sweet, P. L. (2019)",
                    url = "https://scholar.google.com/scholar?q=Paige+Sweet+2019+The+Sociology+of+Gaslighting"
                ),
                SourceReference(
                    title = "Turning up the Lights on Gaslighting",
                    sourceName = "Philosophical Perspectives",
                    authorsOrYear = "Abramson, K. (2014)",
                    url = "https://scholar.google.com/scholar?q=Kate+Abramson+2014+Turning+up+the+Lights+on+Gaslighting"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("reality distortion", "self doubt", "manipulation", "boundaries", "memory denial")
        ),

        ConceptArticle(
            id = "manip_darvo",
            name = "DARVO",
            alternativeNames = listOf("Deny, Attack, and Reverse Victim and Offender", "Blame Reversal Tactic"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Reality Distortion & Deception", "Relational & Emotional Pressure"),
            shortDefinition = "A defensive and manipulative reaction pattern—Deny, Attack, and Reverse Victim and Offender—used when someone is held accountable for harmful behaviour.",
            beginnerExplanation = "DARVO is a three-step deflection when someone is confronted about a harmful action: first they Deny it happened, then they Attack the person who brought it up, and finally they flip the script (Reverse Victim and Offender) so that the person asking for accountability feels guilty and ends up apologising.",
            detailedExplanation = "Identified by psychologist Jennifer Freyd (1997) at the University of Oregon, DARVO describes a structured rhetorical sequence used to evade accountability. Step 1 (Deny) minimizes or flatly rejects the documented behaviour. Step 2 (Attack) questions the credibility, morality, or motives of the person raising the concern. Step 3 (Reverse Victim and Offender) frames the mere act of raising the concern as an unjust persecution, casting the original actor as the aggrieved victim. Empirical studies by Harsey, Zurbriggen, and Freyd (2017) show that exposure to DARVO significantly confuses third-party observers and induces self-blame in targets, though prior awareness of the DARVO pattern существенно reduces its effectiveness.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Team Project Conflict",
                    scenario = "When asked why they took sole credit for a shared report, a colleague says: 'I didn't exclude your name (Deny)—you're just jealous and petty (Attack), and honestly it's toxic that I have to endure these hostile accusations after working so hard (Reverse Victim and Offender).'",
                    analysis = "Shifts the entire conversation from missing attribution on a report to comforting the colleague's hurt feelings."
                ),
                EverydayExample(
                    context = "Customer or Institutional Accountability",
                    scenario = "A contractor confronted with uncompleted work accuses the homeowner of 'harassment and distrust' for inspecting the site.",
                    analysis = "Reframes standard quality verification as personal persecution."
                )
            ),
            howToRecognise = listOf(
                "A calm, specific request for accountability ends with you defending your own character or apologising for bringing the issue up.",
                "The sequence moves rapidly from 'That didn't happen' to 'You're attacking me.'",
                "The original factual issue is completely buried beneath a new debate about the tone or timing of your complaint."
            ),
            whyItOccurs = "DARVO exploits social norms of empathy and fairness; conscientious people naturally pause when accused of hurting someone, allowing the accountability conversation to be hijacked.",
            howToRespond = listOf(
                "Name the pattern silently to yourself so you do not get pulled into defending your character.",
                "Keep the conversation anchored strictly to the original, verifiable topic: 'We can discuss how you feel about my tone at 2:00 PM; right now we need to resolve the missing attribution on the report.'",
                "Recognise that learning the structure of DARVO significantly inoculates both targets and observers against its confusion."
            ),
            relatedConceptIds = listOf("manip_gaslighting", "fallacy_ad_hominem", "prop_whataboutism", "manip_intermittent_reinforcement"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Freyd (1997) and empirically tested in experimental and survey studies by Harsey, Zurbriggen, & Freyd (2017), who confirmed that teaching people about DARVO measurably reduces its manipulative impact.",
            sources = listOf(
                SourceReference(
                    title = "Perpetrator Responses to Victim Confrontation: DARVO and Victim Self-Blame",
                    sourceName = "Journal of Aggression, Maltreatment & Trauma",
                    authorsOrYear = "Harsey, S. J., Zurbriggen, E. L., & Freyd, J. J. (2017)",
                    url = "https://scholar.google.com/scholar?q=Harsey+Zurbriggen+Freyd+2017+DARVO"
                ),
                SourceReference(
                    title = "Violations of Power, Adaptive Blindness and Betrayal Trauma Theory",
                    sourceName = "Feminism & Psychology",
                    authorsOrYear = "Freyd, J. J. (1997)",
                    url = "https://scholar.google.com/scholar?q=Jennifer+Freyd+1997+DARVO"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("blame shifting", "reverse victim", "freyd", "accountability", "deflection")
        ),

        ConceptArticle(
            id = "manip_intermittent_reinforcement",
            name = "Intermittent Reinforcement",
            alternativeNames = listOf("Variable-Ratio Reinforcement Schedule", "Hot-and-Cold Conditioning"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.PSYCHOLOGICAL_PHENOMENA),
            subcategories = listOf("Relational & Emotional Pressure", "Boundary Erosion & Coercive Tactics"),
            shortDefinition = "Delivering rewards, warmth, or approval on an unpredictable, irregular schedule—a conditioning pattern that creates much stronger behavioural persistence than consistent rewards.",
            beginnerExplanation = "If a vending machine fails to give you a snack twice, you walk away because you expect consistency. If a slot machine fails 20 times and then suddenly pays out once at random, people keep pulling the lever for hours. Unpredictable rewards hook the brain's anticipation system.",
            detailedExplanation = "Discovered in behavioural psychology by B.F. Skinner (1938, 1957), schedules of reinforcement govern how quickly a behaviour is learned and how resistant it is to extinction. While continuous reinforcement (rewarding every single effort) builds habits quickly, behaviour stops soon after rewards cease. By contrast, a variable-ratio or variable-interval schedule—where positive reinforcement arrives unpredictably—produces the highest rate of effort and the strongest resistance to extinction (the Partial Reinforcement Extinction Effect). In unhealthy interpersonal dynamics or persuasive product design, alternating between cold withdrawal and sudden, intense warmth or validation keeps individuals anxiously striving to recapture the positive state.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Digital Product Design",
                    scenario = "Pull-to-refresh feeds and notification badges that mostly show mundane updates alongside occasional high-reward social validation.",
                    analysis = "Variable-ratio reward schedules drive compulsive checking habits."
                ),
                EverydayExample(
                    context = "Unhealthy Relational Dynamics",
                    scenario = "A mentor or partner who is dismissive and unreachable for weeks, then suddenly lavishes praise and deep attentiveness right when the other person prepares to leave.",
                    analysis = "Unpredictable warmth creates a potent conditioning loop that makes stepping away difficult."
                )
            ),
            howToRecognise = listOf(
                "Feeling preoccupied with trying to figure out 'what I did right that one day' to earn someone's basic kindness or reliability.",
                "Moments of relief after tension feel disproportionately euphoric compared to calm, steady relationships.",
                "Persisting in an unrewarding situation far longer than you would if the unpleasantness were constant."
            ),
            whyItOccurs = "Neurobiologically, midbrain dopamine neurons fire most intensely not when a reward is guaranteed, but when reward prediction error is uncertain (Schultz, Dayan, & Montague, 1997). Uncertainty amplifies craving and focus.",
            howToRespond = listOf(
                "Evaluate relationships and environments by their average baseline consistency over months, not their rare peak moments.",
                "Recognise the physiological pull of uncertainty as a conditioning reflex rather than proof of deep compatibility.",
                "Establish clear personal standards for consistent mutual respect."
            ),
            relatedConceptIds = listOf("manip_gaslighting", "dme_sunk_cost", "dme_escalation_commitment", "phen_hedonic_treadmill"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "The behavioural mechanics of variable-ratio reinforcement are among the most rigorously replicated findings in operant conditioning (Ferster & Skinner, 1957) and computational neuroscience (Schultz et al., 1997).",
            sources = listOf(
                SourceReference(
                    title = "Schedules of Reinforcement",
                    sourceName = "Appleton-Century-Crofts",
                    authorsOrYear = "Ferster, C. B. & Skinner, B. F. (1957)",
                    url = "https://scholar.google.com/scholar?q=Ferster+Skinner+1957+Schedules+of+Reinforcement"
                ),
                SourceReference(
                    title = "A neural substrate of prediction and reward",
                    sourceName = "Science (PubMed)",
                    authorsOrYear = "Schultz, W., Dayan, P., & Montague, P. R. (1997)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/9054347/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("skinner", "variable ratio", "slot machine", "hot and cold", "dopamine")
        ),

        // ==========================================
        // 4. PSYCHOLOGICAL PHENOMENA
        // ==========================================
        ConceptArticle(
            id = "phen_dunning_kruger",
            name = "Dunning–Kruger Effect",
            alternativeNames = listOf("Metacognitive Dual Burden", "Unskilled and Unaware"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Self-Perception & Metacognition"),
            shortDefinition = "A metacognitive phenomenon in which people with limited knowledge or competence in a specific domain overestimate their relative performance because they lack the very expertise needed to recognise their own mistakes.",
            beginnerExplanation = "Popular internet culture often misstates the Dunning–Kruger effect as 'unintelligent people think they are smarter than experts.' In reality, Dunning and Kruger found something much subtler: we all have blind spots when we are beginners in a skill, because the knowledge required to do a good job is the exact same knowledge required to judge whether a job was done well.",
            detailedExplanation = "Published by Justin Kruger and David Dunning (1999), the effect describes a 'dual burden' of low domain competence: lacking skill in logic, grammar, or technical analysis not only causes poor performance, it also deprives the individual of the metacognitive criteria needed to recognise that their answers are flawed. Contrary to viral internet graphs showing a dramatic 'Mount Stupid' spike where novices think they outrank experts, the actual data show that novices typically estimate themselves around the 60th percentile (slightly above average) while scoring in the 12th percentile—they rarely claim to beat top experts. Meanwhile, top performers slightly underestimate how uncommon their skill is (due to the False Consensus Effect). Methodological debates also note that statistical regression to the mean and autocorrelation account for a portion of the observed gap.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Learning a New Craft",
                    scenario = "After watching two introductory videos on espresso brewing, a hobbyist feels confident they understand everything about coffee extraction—until they try dialing in a light roast and realise how many variables exist.",
                    analysis = "Initial familiarity creates a sense of mastery before the true complexity of the domain becomes visible."
                ),
                EverydayExample(
                    context = "Grammar & Editing",
                    scenario = "A writer struggles to proofread their own essay for comma splices because they do not yet know the grammatical rule that defines a comma splice.",
                    analysis = "The skill needed to produce correct punctuation is identical to the skill needed to spot punctuation errors."
                )
            ),
            howToRecognise = listOf(
                "Feeling that a complex professional discipline is 'just common sense' before studying its technical literature.",
                "Struggling to evaluate why your own solution failed without external feedback.",
                "Assuming that if a task is easy for you (when you are actually an expert), it must be effortless for everyone else too."
            ),
            whyItOccurs = "Metacognitive monitoring depends on domain-specific schemas. Additionally, regression to the mean ensures that anyone scoring at the extreme bottom of a test can almost only err upward when estimating their percentile rank.",
            howToRespond = listOf(
                "Seek objective external feedback and rubric-based testing early when learning any new skill.",
                "Use the Circle of Competence mental model to map the boundary between what you know and what you have only read about.",
                "Notice when someone uses 'Dunning-Kruger' as an insult—remember it describes a universal human metacognitive blind spot, not a personality defect."
            ),
            relatedConceptIds = listOf("mm_circle_of_competence", "ct_intellectual_humility", "bias_confirmation", "sp_false_consensus"),
            evidenceLevel = EvidenceLevel.MIXED_OR_DISPUTED,
            scientificEvidenceAndLimitations = "Kruger & Dunning's (1999) original findings are widely cited, but mathematical psychologists (Krueger & Mueller, 2002; Gignac & Zajenkowski, 2020) have demonstrated that a substantial share of the classic quartile chart stems from statistical regression to the mean and measurement noise, though genuine metacognitive deficits in novices remain supported.",
            sources = listOf(
                SourceReference(
                    title = "Unskilled and unaware of it: How difficulties in recognizing one's own incompetence lead to inflated self-assessments",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Kruger, J. & Dunning, D. (1999)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/10626367/"
                ),
                SourceReference(
                    title = "The Dunning-Kruger effect is (mostly) a statistical artefact: Valid approaches to testing the hypothesis with individual differences data",
                    sourceName = "Intelligence",
                    authorsOrYear = "Gignac, G. E. & Zajenkowski, M. (2020)",
                    url = "https://scholar.google.com/scholar?q=Gignac+Zajenkowski+2020+Dunning+Kruger+statistical+artefact"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("metacognition", "overconfidence", "novice", "mount stupid", "competence")
        ),

        ConceptArticle(
            id = "phen_pygmalion_effect",
            name = "Pygmalion Effect",
            alternativeNames = listOf("Rosenthal Effect", "Interpersonal Expectancy Effect", "Golem Effect (Negative Counterpart)"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Expectancy & Performance Effects"),
            shortDefinition = "A phenomenon in which higher expectations placed upon individuals—by teachers, coaches, or leaders—lead to an actual measurable increase in their performance.",
            beginnerExplanation = "When a teacher or manager genuinely believes a student or team member has high potential, they subtly give that person warmer encouragement, more patience, richer feedback, and better opportunities—which helps the person actually succeed.",
            detailedExplanation = "Named after the classical myth of Pygmalion and investigated by Robert Rosenthal and Lenore Jacobson (1968), the Pygmalion Effect is a specific form of self-fulfilling prophecy operating in educational and organisational settings. Rosenthal identified a four-factor mediation model explaining how internal expectations translate into real performance gains: (1) Climate — creating a warmer socio-emotional environment; (2) Input — teaching more challenging material to those expected to succeed; (3) Output — giving more opportunities and longer wait-times to respond; and (4) Feedback — offering more detailed, constructive guidance when errors occur. The negative counterpart—where low expectations depress performance—is termed the Golem Effect.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Mentorship & Onboarding",
                    scenario = "A team lead is told a new junior developer is a 'fast riser.' When the junior developer hits a bug, the lead treats it as a fascinating learning puzzle rather than a sign of incompetence, accelerating the developer's growth.",
                    analysis = "Positive expectation alters the mentor's coaching behaviour, producing the expected competence."
                ),
                EverydayExample(
                    context = "Classroom Participation",
                    scenario = "An instructor unconsciously waits three extra seconds for a 'high-potential' student to formulate an answer, while cutting off a 'struggling' student after one second.",
                    analysis = "Micro-behaviours in wait-time and encouragement shape actual student achievement."
                )
            ),
            howToRecognise = listOf(
                "Notice who receives patient follow-up questions versus who gets quickly passed over in meetings.",
                "Early labels ('gifted', 'slow starter') continue to predict treatment years later.",
                "Team performance rises or falls to match a new leader's stated belief in the group's capability."
            ),
            whyItOccurs = "Expectations act as perceptual filters (Confirmation Bias) and guide non-verbal micro-behaviours (tone, eye contact, patience) that directly alter the learner's motivation, self-efficacy, and practice quality.",
            howToRespond = listOf(
                "Adopt a growth-mindset expectation for all learners and colleagues rather than sorting people into fixed tiers.",
                "Standardise wait-times and feedback quality across all students or team members.",
                "Audit whether low performance in a group is being reinforced by a Golem Effect of low trust."
            ),
            relatedConceptIds = listOf("bias_confirmation", "bias_halo_effect", "phen_spotlight_effect", "sp_fundamental_attribution"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Rosenthal & Jacobson (1968) and meta-analysed across hundreds of classroom and workplace studies (Rosenthal & Rubin, 1978; Jussim & Harber, 2005). Note: Jussim & Harber's review shows that while real and reliable, teacher expectancy effects are typically modest in magnitude (r ≈ 0.10–0.20) rather than omnipotent.",
            sources = listOf(
                SourceReference(
                    title = "Interpersonal expectancy effects: the first 345 studies",
                    sourceName = "Behavioral and Brain Sciences",
                    authorsOrYear = "Rosenthal, R. & Rubin, D. B. (1978)",
                    url = "https://scholar.google.com/scholar?q=Rosenthal+Rubin+1978+Interpersonal+expectancy+effects+345+studies"
                ),
                SourceReference(
                    title = "Teacher Expectations and Self-Fulfilling Prophecies: Knowns and Unknowns",
                    sourceName = "Personality and Social Psychology Review (PubMed)",
                    authorsOrYear = "Jussim, L. & Harber, K. D. (2005)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/15869379/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("self-fulfilling prophecy", "rosenthal", "expectations", "golem effect", "teaching")
        ),

        ConceptArticle(
            id = "phen_spotlight_effect",
            name = "Spotlight Effect",
            alternativeNames = listOf("Egocentric Salience Bias", "Social Spotlight Illusion"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY, CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Self-Perception & Metacognition"),
            shortDefinition = "The tendency to significantly overestimate how much other people notice our appearance, minor blunders, or momentary embarrassment.",
            beginnerExplanation = "When you spill a drop of coffee on your shirt or stumble over a word in a meeting, it feels as if a giant theatre spotlight is shining directly on you. In reality, almost everyone else in the room is too busy worrying about their own spotlight to barely notice yours.",
            detailedExplanation = "Investigated by Thomas Gilovich, Victoria Medvec, and Kenneth Savitsky (2000), the Spotlight Effect arises because each of us is the centre of our own perceptual universe. In their famous Cornell University experiment, students were asked to wear an embarrassing T-shirt into a room of peers and estimate how many people noticed. Students predicted that roughly 50% of the room would notice the shirt; in reality, fewer than 25% did. Even when observers did look, they rapidly forgot. A closely related phenomenon is the Illusion of Transparency—overestimating how clearly others can detect our internal nervousness or anxiety.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Public Speaking",
                    scenario = "A presenter's voice cracks once during a 20-minute talk. They spend the evening convinced the entire audience remembers the voice crack, whereas attendees only remember the main slides.",
                    analysis = "Internal salience of the stumble is mistaken for external salience in the audience's memory."
                ),
                EverydayExample(
                    context = "Social Gatherings",
                    scenario = "Arriving at a dinner party with a bad haircut and feeling self-conscious all night, while friends barely register any change.",
                    analysis = "We compare our current appearance closely against our mirror image, whereas others view us holistically."
                )
            ),
            howToRecognise = listOf(
                "Assuming that silence or a passing glance from a stranger is a reaction to something about your clothes or behaviour.",
                "Avoiding asking a question in a seminar or gym because 'everyone will stare at me.'",
                "Replaying a minor verbal slip for days after an event."
            ),
            whyItOccurs = "This is an anchoring and adjustment phenomenon: we anchor heavily on our own vivid phenomenology (our awareness of our flaw or nervousness) and adjust insufficiently for the fact that others are preoccupied with their own thoughts.",
            howToRespond = listOf(
                "Ask yourself: 'How closely do I remember a coworker's minor slip of the tongue from two weeks ago?'",
                "Remind yourself that others are focused on their own internal tasks and concerns.",
                "Pause briefly before reacting to a minor social blunder; giving yourself a moment of psychological distance reduces perceived salience."
            ),
            relatedConceptIds = listOf("bias_anchoring", "cd_catastrophizing", "sp_false_consensus", "phen_pygmalion_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Replicated across multiple laboratory and field paradigms by Gilovich, Medvec, & Savitsky (2000) and Savitsky, Epley, & Gilovich (2001).",
            sources = listOf(
                SourceReference(
                    title = "The spotlight effect in social judgment: An egocentric bias in estimates of the salience of one's own actions and appearance",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Gilovich, T., Medvec, V. H., & Savitsky, K. (2000)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/10707330/"
                ),
                SourceReference(
                    title = "The Self and Social Judgment",
                    sourceName = "Noba Project Psychology Textbook",
                    authorsOrYear = "Noba Project Module",
                    url = "https://nobaproject.com/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("embarrassment", "social anxiety", "self-consciousness", "gilovich", "illusion of transparency")
        ),

        ConceptArticle(
            id = "phen_hedonic_treadmill",
            name = "Hedonic Treadmill",
            alternativeNames = listOf("Hedonic Adaptation", "Baseline Happiness Adaptation"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_PHENOMENA,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Attention & Motivational Effects"),
            shortDefinition = "The observed tendency of humans to return to a relatively stable baseline level of happiness despite major positive or negative life changes or material acquisitions.",
            beginnerExplanation = "When you get a promotion, a new phone, or a nicer apartment, you feel a genuine burst of excitement. Within a few weeks or months, however, the new luxury becomes your normal background expectation, and your day-to-day mood returns close to where it was before.",
            detailedExplanation = "Coined by Philip Brickman and Donald Campbell (1971) and later refined by Sonja Lyubomirsky, Ed Diener, and Daniel Kahneman, hedonic adaptation functions much like sensory adaptation: just as our eyes adjust to bright sunlight and our nose stops smelling a room's scent after a few minutes, our affective system recalibrates to ongoing circumstances so it remains sensitive to new changes. Modern longitudinal research shows that while adaptation to material purchases and income increases above comfort thresholds is rapid and nearly complete, adaptation is not 100% uniform—factors like chronic noise, long commutes, unemployment, and supportive social relationships show much slower or incomplete adaptation.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Consumer Purchases",
                    scenario = "Believing that upgrading to a luxury car will make every morning commute joyful, only to find yourself feeling the exact same impatience in traffic three months later.",
                    analysis = "Attention shifts away from the car's interior once its novelty fades, returning focus to daily traffic."
                ),
                EverydayExample(
                    context = "Career Milestones",
                    scenario = "Thinking 'Once I reach Senior Director, I'll finally feel content,' and within a month of the promotion immediately fixating on the Vice President tier.",
                    analysis = "Aspiration levels shift upward in lockstep with achievements, keeping satisfaction stationary."
                )
            ),
            howToRecognise = listOf(
                "Frequently thinking 'I will finally be happy as soon as I acquire/achieve X.'",
                "Past milestones that once felt like major dreams now feel ordinary and unremarkable.",
                "Rising income is matched immediately by lifestyle creep that leaves subjective satisfaction unchanged."
            ),
            whyItOccurs = "From an evolutionary perspective, a nervous system that stayed permanently euphoric after one success would stop vigilance and goal pursuit. Attention naturally migrates from constant background states to novel changes.",
            howToRespond = listOf(
                "Prioritise experiences, skill mastery, and social connections over static material possessions, as dynamic experiences resist adaptation longer.",
                "Practice deliberate gratitude or 'negative visualisation' (imagining briefly not having what you currently enjoy) to reset appreciation.",
                "Reduce chronic daily friction (such as a stressful commute or sleep deprivation), which resists adaptation more than luxury goods."
            ),
            relatedConceptIds = listOf("dme_sunk_cost", "manip_intermittent_reinforcement", "heur_affect", "bias_anchoring"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Brickman, Coates, & Janoff-Bulman (1978) famously studied lottery winners; later longitudinal panel studies by Diener, Lucas, & Scollon (2006) in 'Beyond the Hedonic Treadmill' updated the theory, confirming strong adaptation to material wealth while noting that major life events can shift individual set points.",
            sources = listOf(
                SourceReference(
                    title = "Beyond the hedonic treadmill: Revising the adaptation theory of well-being",
                    sourceName = "American Psychologist (PubMed)",
                    authorsOrYear = "Diener, E., Lucas, R. E., & Scollon, C. N. (2006)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/16719675/"
                ),
                SourceReference(
                    title = "Lottery winners and accident victims: Is happiness relative?",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Brickman, P., Coates, D., & Janoff-Bulman, R. (1978)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/690806/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("happiness", "adaptation", "affective forecasting", "lifestyle creep", "diener")
        ),

        // ==========================================
        // 5. COGNITIVE DISTORTIONS
        // ==========================================
        ConceptArticle(
            id = "cd_catastrophizing",
            name = "Catastrophizing",
            alternativeNames = listOf("Magnification", "Worst-Case Scenario Jumping", "Awfulizing"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Predictive & Interpretive Leaps"),
            shortDefinition = "A cognitive distortion in which an individual automatically leaps to the worst possible outcome of an uncertain situation and treats that catastrophe as both highly probable and unmanageable.",
            beginnerExplanation = "Catastrophizing turns a small problem into a domino chain of disasters: 'My manager asked for a quick 5-minute chat -> I must have made a huge mistake -> I'm going to be fired -> I'll lose my apartment.' It combines overestimating the chance of disaster with underestimating your ability to cope.",
            detailedExplanation = "Identified by Albert Ellis (1962) and Aaron T. Beck (1976) in the foundations of Cognitive Behavioural Therapy (CBT), catastrophizing involves two synchronized cognitive appraisals: (1) Probability Overestimation — treating a low-probability worst-case outcome as a near certainty; and (2) Coping Minimization — assuming that if the negative event occurs, one will be completely unable to endure or recover from it.Note: Experiencing catastrophic thoughts is a normal human response to uncertainty and stress, not a clinical diagnosis.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Communication",
                    scenario = "Receiving a short message reading 'Can we talk at 3 PM?' and spending the next four hours mentally rehearsing getting laid off, when the manager only wanted input on a holiday schedule.",
                    analysis = "Ambiguous neutral stimulus triggers an immediate leap to an extreme threat narrative."
                ),
                EverydayExample(
                    context = "Minor Physical Setbacks",
                    scenario = "Experiencing a mild headache after staring at a screen all day and immediately concluding it must be a life-threatening neurological condition.",
                    analysis = "Bypasses common, benign base-rate explanations in favour of the most severe possibility."
                )
            ),
            howToRecognise = listOf(
                "Chains of 'What if...' thoughts that escalate rapidly from a minor hiccup to total ruin.",
                "Using words like 'disaster', 'ruined', 'unbearable', or 'end of the world' for everyday setbacks.",
                "Physical tension and anxiety reacting to a mental movie of the future as if it has already happened."
            ),
            whyItOccurs = "From an evolutionary standpoint, a threat-detection system that produces 99 false alarms and catches 1 real predator survived better than a complacent system ('Smoke Detector Principle'). Under fatigue or stress, prefrontal probability calibration weakens.",
            howToRespond = listOf(
                "Use the Three-Column Technique: write down (1) the Worst Case, (2) the Best Case, and (3) the Most Realistic/Probable Case.",
                "Separate probability from coping: even if the inconvenient outcome happened, list three concrete steps you would take to handle it.",
                "Check historical base rates: 'Out of the last 20 times I worried a meeting would be a disaster, how many actually were?'"
            ),
            relatedConceptIds = listOf("cd_all_or_nothing", "cd_emotional_reasoning", "bias_base_rate_fallacy", "phen_spotlight_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Core construct in Aaron Beck's Cognitive Therapy (1976) and extensively validated in clinical and non-clinical cognitive restructuring research (Quartana, Campbell, & Edwards, 2009).",
            sources = listOf(
                SourceReference(
                    title = "Cognitive Therapy and the Emotional Disorders",
                    sourceName = "International Universities Press",
                    authorsOrYear = "Beck, A. T. (1976)",
                    url = "https://scholar.google.com/scholar?q=Aaron+Beck+1976+Cognitive+Therapy+and+the+Emotional+Disorders"
                ),
                SourceReference(
                    title = "Psychology 2e: Therapy and Treatment (Cognitive Behavioral Therapy)",
                    sourceName = "OpenStax Psychology",
                    authorsOrYear = "Spielman, R. M. et al. (2020)",
                    url = "https://openstax.org/subjects/psychology"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("worst case", "cbt", "aaron beck", "magnification", "anxiety", "overthinking")
        ),

        ConceptArticle(
            id = "cd_all_or_nothing",
            name = "All-or-Nothing Thinking",
            alternativeNames = listOf("Black-and-White Thinking", "Dichotomous Thinking", "Polarised Thinking"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES),
            subcategories = listOf("Extreme & Polarised Filtering"),
            shortDefinition = "Viewing performance, people, or situations in absolute, extreme categories ('perfect' vs. 'total failure') with no recognition of middle ground or partial progress.",
            beginnerExplanation = "All-or-Nothing thinking erases the numbers 1 through 99 on a scale, leaving only 0 and 100. If a project, habit, or day isn't 100% flawless, your inner critic labels it a 0% failure.",
            detailedExplanation = "Described by Aaron Beck (1976) and popularised by David Burns (1980), dichotomous thinking is the cognitive equivalent of the False Dilemma fallacy applied to self-evaluation and interpersonal judgment. Because real-world human performance almost always falls along a continuous distribution, demanding perfection guarantees that normal minor imperfections are interpreted as total defeat. This distortion frequently undermines habit formation (the 'what-the-hell effect' in behavioral research, where missing one day of a routine leads someone to abandon the entire month).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Habit Formation & Nutrition",
                    scenario = "Eating one cookie while trying to eat healthier and thinking, 'Well, I've completely blown my nutrition plan today, so I might as well eat the whole box and give up.'",
                    analysis = "Treats a tiny 100-calorie deviation as equivalent to abandoning the entire goal."
                ),
                EverydayExample(
                    context = "Skill Learning",
                    scenario = "Receiving 95% positive feedback on a presentation along with one constructive suggestion, and concluding, 'I'm terrible at presenting.'",
                    analysis = "Anything short of flawless perfection is categorised as incompetence."
                )
            ),
            howToRecognise = listOf(
                "Frequent use of absolute words: 'always', 'never', 'completely', 'ruined', 'flawless', 'useless'.",
                "Abandoning worthwhile projects as soon as the first minor obstacle or imperfection appears.",
                "Swinging between idealising a colleague or method and completely devaluing them."
            ),
            whyItOccurs = "Binary categorisation is cognitively fast and requires minimal working memory. High perfectionism also uses binary rules in an attempt to avoid criticism, though it paradoxically increases procrastination.",
            howToRespond = listOf(
                "Replace binary labels with a 0-to-100% continuum scale: 'If this wasn't 100%, was it 75% or 80% effective?'",
                "Adopt the rule 'Never miss twice' instead of demanding an unbroken streak.",
                "Look for three specific elements that worked well alongside the one element that needs improvement."
            ),
            relatedConceptIds = listOf("fallacy_false_dilemma", "cd_catastrophizing", "cd_emotional_reasoning", "heur_satisficing"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Validated in cognitive therapy research (Beck, 1976; Burns, 1980) and behavioural self-regulation studies on goal abandonment (Cochran & Tesser, 1996).",
            sources = listOf(
                SourceReference(
                    title = "Cognitive Therapy and the Emotional Disorders",
                    sourceName = "International Universities Press",
                    authorsOrYear = "Beck, A. T. (1976)",
                    url = "https://scholar.google.com/scholar?q=Aaron+Beck+1976+Cognitive+Therapy+and+the+Emotional+Disorders"
                ),
                SourceReference(
                    title = "The 'what the hell' effect: Some effects of goal proximity and goal framing on performance",
                    sourceName = "Striving and Feeling (Lawrence Erlbaum)",
                    authorsOrYear = "Cochran, W. & Tesser, A. (1996)",
                    url = "https://scholar.google.com/scholar?q=Cochran+Tesser+1996+what+the+hell+effect+goal+framing"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("perfectionism", "black and white", "dichotomous", "burns", "cbt")
        ),

        ConceptArticle(
            id = "cd_emotional_reasoning",
            name = "Emotional Reasoning",
            alternativeNames = listOf("Affect-as-Proof Distortion", "Feelings as Facts"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.HEURISTICS),
            subcategories = listOf("Emotional & Self-Labeling Rules"),
            shortDefinition = "Concluding that because you feel a strong negative emotion, that emotion is objective proof of external reality ('I feel anxious, therefore I must be in danger'; 'I feel guilty, therefore I must have done something wrong').",
            beginnerExplanation = "Emotions are real and important signals, but they are not infallible smoke detectors. Emotional reasoning happens when we treat a feeling as courtroom evidence of a fact—assuming that feeling inadequate proves we are incompetent.",
            detailedExplanation = "In cognitive therapy (Beck, 1976; Burns, 1980), emotional reasoning occurs when an individual bypasses empirical evidence and uses their current affective state to validate a thought. Because emotions are often triggered by prior cognitive distortions (such as catastrophizing or all-or-nothing thinking), using the resulting emotion to 'prove' the thought creates a closed circular loop: a distorted thought triggers anxiety, and the anxiety is then cited as proof that the distorted thought was accurate. In experimental psychology, this closely relates to the Affect Heuristic and 'affect-as-information' models (Schwarz & Clore, 1983).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Impostor Feelings at Work",
                    scenario = "Feeling nervous before leading a project for the first time and thinking, 'The fact that I feel like a fraud proves I'm not qualified for this role.'",
                    analysis = "Mistakes normal novelty-induced nervousness for objective evidence of incompetence."
                ),
                EverydayExample(
                    context = "Setting Healthy Boundaries",
                    scenario = "Politely declining an unreasonable weekend work request, feeling a wave of guilt afterward, and concluding, 'I feel guilty, so saying no must have been selfish.'",
                    analysis = "Treats conditioned guilt as moral proof that a healthy boundary was wrong."
                )
            ),
            howToRecognise = listOf(
                "Sentences structured as 'I feel [emotion], therefore it must be true that [external claim].'",
                "Dismissing objective track records or positive data because you 'just don't feel confident about it.'",
                "Treating physical tiredness or low mood on a rainy Tuesday as evidence that your life plans are failing."
            ),
            whyItOccurs = "Under the Affect-as-Information framework (Schwarz & Clore, 1983), humans routinely ask 'How do I feel about this?' as a fast mental shortcut for complex evaluative judgments.",
            howToRespond = listOf(
                "Validate the emotion as a feeling while separating it from external facts: 'I notice I am feeling anxious right now, and feelings are not automatically facts.'",
                "Check whether fatigue, hunger, or stress (HALT: Hungry, Angry, Lonely, Tired) is colouring your current mood.",
                "Write down the objective evidence for and against the thought as if presenting it to a neutral jury."
            ),
            relatedConceptIds = listOf("heur_affect", "cd_catastrophizing", "cd_all_or_nothing", "bias_confirmation"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Investigated both in clinical CBT research (Beck, 1976; Arntz, Rauner, & van den Hout, 1995) and social cognition research on mood as information (Schwarz & Clore, 1983).",
            sources = listOf(
                SourceReference(
                    title = "Mood, misattribution, and judgments of well-being: Informative and directive functions of affective states",
                    sourceName = "Journal of Personality and Social Psychology",
                    authorsOrYear = "Schwarz, N. & Clore, G. L. (1983)",
                    url = "https://scholar.google.com/scholar?q=Schwarz+Clore+1983+Mood+misattribution+judgments+of+well-being"
                ),
                SourceReference(
                    title = "'If I feel anxious, there must be danger': Ex-consequentia reasoning in inferring danger in anxiety disorders",
                    sourceName = "Behaviour Research and Therapy (PubMed)",
                    authorsOrYear = "Arntz, A., Rauner, M., & van den Hout, M. (1995)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/7487851/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("feelings as facts", "impostor syndrome", "affect as information", "cbt", "anxiety")
        )
    )
}
