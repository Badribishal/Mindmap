package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack5MemorySocialCriticalReasoning {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 12. MEMORY BIASES
        // ==========================================
        ConceptArticle(
            id = "mem_hindsight_bias",
            name = "Hindsight Bias",
            alternativeNames = listOf("Knew-It-All-Along Effect", "Creeping Determinism"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Evaluative & Temporal Recall"),
            shortDefinition = "The tendency, after an event has occurred, to perceive the outcome as having been much more predictable and inevitable than it actually was beforehand.",
            beginnerExplanation = "Before a game, election, or product launch, the future is full of genuine uncertainty. The moment the result is announced, our memory quietly edits our past uncertainty so we feel, 'I knew that was going to happen all along!'",
            detailedExplanation = "First investigated systematically by Baruch Fischhoff (1975), Hindsight Bias operates by automatically updating our mental model of the world to incorporate the known outcome. Once we know how a story ended, the causal steps leading to that specific ending become salient in memory, while all the plausible alternative branches that *almost* happened fade away ('creeping determinism'). When asked to recall what probability they assigned to the event before it happened, people systematically misremember their own prior predictions as closer to the actual outcome. This creates a severe problem in judging decision quality (Outcome Bias): observers punish cautious decision-makers when a rare freak accident occurs, assuming the decision-maker 'should have seen the obvious signs.'",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Financial Markets & Tech Trends",
                    scenario = "After a speculative bubble bursts, commentators declare that the exact date and trigger of the crash were 'obvious to anyone paying attention'—despite having made no such warning beforehand.",
                    analysis = "Post-outcome knowledge makes pre-crash warning signs stand out from the noise."
                ),
                EverydayExample(
                    context = "Post-Incident Reviews",
                    scenario = "During a software outage post-mortem, blaming an engineer for not anticipating a rare three-way race condition that had never occurred in five years.",
                    analysis = "Knowing the bug's cause makes the code path look glaringly obvious in retrospect."
                )
            ),
            howToRecognise = listOf(
                "Saying 'I knew it all along' or 'It was inevitable' after an unpredictable outcome.",
                "Judging the quality of a past decision purely by its lucky or unlucky outcome rather than the information available at the time the choice was made.",
                "Forgetting how confident you were in a prediction that turned out to be wrong."
            ),
            whyItOccurs = "Human memory is reconstructive rather than a video recorder; assimilating new outcome knowledge automatically overwrites or re-indexes the pre-outcome cognitive state.",
            howToRespond = listOf(
                "Keep a written Decision Journal: record your exact predictions, probability percentages, and reasoning *before* important decisions resolve.",
                "Practice 'Consider the Opposite': list three ways the event could easily have turned out differently.",
                "Evaluate decisions by process quality at the time of choice, not by retrospective outcome."
            ),
            relatedConceptIds = listOf("mem_misinformation_effect", "mem_peak_end_rule", "bias_confirmation", "mm_inversion"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Fischhoff (1975) in the Journal of Experimental Psychology: Human Perception and Performance and confirmed across over 800 studies (Roese & Vohs, 2012).",
            sources = listOf(
                SourceReference(
                    title = "Hindsight is not equal to foresight: The effect of outcome knowledge on judgment under uncertainty",
                    sourceName = "Journal of Experimental Psychology: Human Perception and Performance",
                    authorsOrYear = "Fischhoff, B. (1975)",
                    url = "https://scholar.google.com/scholar?q=Baruch+Fischhoff+1975+Hindsight+is+not+equal+to+foresight"
                ),
                SourceReference(
                    title = "Hindsight Bias",
                    sourceName = "Perspectives on Psychological Science (PubMed)",
                    authorsOrYear = "Roese, N. J. & Vohs, K. D. (2012)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/26168501/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("fischhoff", "knew it all along", "outcome bias", "decision journal", "retrospect")
        ),

        ConceptArticle(
            id = "mem_misinformation_effect",
            name = "Misinformation Effect",
            alternativeNames = listOf("Post-Event Memory Contamination", "Retroactive Memory Distortion"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.PSYCHOLOGICAL_PHENOMENA, CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY),
            subcategories = listOf("Reconstructive & Suggestibility Distortion"),
            shortDefinition = "The impairment and alteration of episodic memories for a past event after an individual is exposed to misleading information, leading questions, or post-event suggestions.",
            beginnerExplanation = "Human memory does not work like a locked MP4 video file on a hard drive; every time we remember an event, we reconstruct it. If someone asks a leading question afterward ('How fast were the cars going when they smashed into each other?'), that single word 'smashed' can cause our brain to insert broken glass into our memory that was never actually there.",
            detailedExplanation = "Pioneered by cognitive psychologist Elizabeth Loftus and John Palmer (1974), the Misinformation Effect revolutionised legal psychology and cognitive neuroscience. In their classic experiment, participants watched film clips of traffic accidents and were later asked to estimate vehicle speed. Those asked how fast the cars were going when they 'smashed' into each other estimated significantly higher speeds—and one week later were more than twice as likely to falsely remember seeing broken glass—compared to those asked when the cars 'hit' or 'contacted' each other. Because episodic recall involves reconsolidation, post-event suggestions, co-witness discussions, and leading interview questions can seamlessly blend with original sensory traces.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Eyewitness & Incident Interviews",
                    scenario = "Two coworkers discuss a tense client call over lunch before writing their incident notes; one coworker's mistaken recollection gets adopted by the second coworker as their own first-hand memory.",
                    analysis = "Co-witness discussion introduces post-event details that overwrite independent recall."
                ),
                EverydayExample(
                    context = "Customer Research Surveys",
                    scenario = "Asking users 'How confusing did you find the new checkout button?' rather than 'How would you describe your experience with the checkout screen?'",
                    analysis = "Presuppositional phrasing alters how participants reconstruct their recent experience."
                )
            ),
            howToRecognise = listOf(
                "Leading questions containing presuppositions ('Did you see *the* stop sign?' vs. 'Was there *a* stop sign?').",
                "Witnesses discussing an incident together before recording their independent statements.",
                "Mistaking vividness and emotional confidence in a memory for objective accuracy."
            ),
            whyItOccurs = "Source monitoring errors and memory reconsolidation: the brain stores the gist of an event and integrates plausible post-event details without preserving a tag of whether the detail came from original perception or a later conversation.",
            howToRespond = listOf(
                "Record contemporaneous notes immediately after an important observation before discussing it with others.",
                "When interviewing witnesses, users, or colleagues, use open-ended, non-leading questions ('Tell me everything you observed in your own words').",
                "Remember that subjective confidence in a memory is weakly correlated with accuracy once post-event contamination has occurred."
            ),
            relatedConceptIds = listOf("mem_hindsight_bias", "prop_illusory_truth", "manip_gaslighting", "bias_belief_perseverance"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Loftus & Palmer (1974) and replicated across 30+ years of eyewitness memory research (Loftus, 2005).",
            sources = listOf(
                SourceReference(
                    title = "Reconstruction of automobile destruction: An example of the interaction between language and memory",
                    sourceName = "Journal of Verbal Learning and Verbal Behavior",
                    authorsOrYear = "Loftus, E. F. & Palmer, J. C. (1974)",
                    url = "https://scholar.google.com/scholar?q=Loftus+Palmer+1974+Reconstruction+of+automobile+destruction"
                ),
                SourceReference(
                    title = "Planting misinformation in the human mind: A 30-year investigation of the malleability of memory",
                    sourceName = "Learning & Memory (PubMed)",
                    authorsOrYear = "Loftus, E. F. (2005)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/16027179/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("elizabeth loftus", "eyewitness", "leading questions", "false memory", "reconsolidation")
        ),

        ConceptArticle(
            id = "mem_peak_end_rule",
            name = "Peak–End Rule",
            alternativeNames = listOf("Duration Neglect in Memory", "Peak-End Evaluation Heuristic"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.HEURISTICS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Evaluative & Temporal Recall"),
            shortDefinition = "A memory heuristic in which people judge an past experience largely by how they felt at its most intense point (the 'peak') and at its conclusion (the 'end'), rather than by the total sum or average of every moment.",
            beginnerExplanation = "Our 'remembering self' does not add up every minute of a vacation or medical visit. Instead, it takes two snapshots: the single most intense moment (best or worst) and the final few minutes. How an experience ends disproportionately colours our memory of the whole thing.",
            detailedExplanation = "Discovered by Daniel Kahneman, Barbara Fredrickson, Charles Schreiber, and Donald Redelmeier (1993), the Peak–End Rule reveals a striking divergence between the 'experiencing self' (moment-to-moment sensation) and the 'remembering self' (retrospective evaluation). Accompanied by 'Duration Neglect,' people consistently rate a painful medical procedure or cold-water immersion as *less* aversive in memory if a brief period of milder discomfort is added onto the end—even though the extended trial inflicted strictly more total physical pain! Because future choices are made by the remembering self, peaks and endings govern whether people repeat an experience.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Travel & Hospitality",
                    scenario = "Enjoying six lovely days at a resort, followed by a chaotic 45-minute checkout billing dispute on the final morning—leaving the traveller remembering the entire trip negatively.",
                    analysis = "A negative ending overwrites six days of positive duration in retrospective evaluation."
                ),
                EverydayExample(
                    context = "User Experience & Onboarding",
                    scenario = "A tax filing app ends a tedious 30-minute form with a clear, reassuring confirmation summary and celebratory completion state.",
                    analysis = "Crafting a smooth, rewarding ending elevates the remembered satisfaction of a necessary chore."
                )
            ),
            howToRecognise = listOf(
                "Judging a multi-year job, relationship, or trip almost entirely by its final week.",
                "Overlooking total duration when comparing two pleasant or unpleasant experiences.",
                "Customer satisfaction scores plunging due to friction in the final offboarding or checkout step."
            ),
            whyItOccurs = "Evolutionary memory compression: storing a moment-by-moment integral of every life episode would overwhelm biological memory, so the brain stores representative snapshots (peak intensity and terminal state).",
            howToRespond = listOf(
                "When evaluating past options, consult objective logs of day-to-day satisfaction rather than relying solely on how the episode ended.",
                "When designing presentations, meetings, or customer journeys, invest disproportionate care in creating one memorable peak insight and a clean, uplifting conclusion.",
                "End difficult study or workout sessions with a calmer, pleasant cooldown so your remembering self stays motivated to return tomorrow."
            ),
            relatedConceptIds = listOf("heur_availability", "mem_hindsight_bias", "phen_hedonic_treadmill", "heur_affect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated experimentally by Kahneman, Fredrickson, Schreiber, & Redelmeier (1993) in Psychological Science and in clinical colonoscopy studies by Redelmeier & Kahneman (1996).",
            sources = listOf(
                SourceReference(
                    title = "When More Pain Is Preferred to Less: Adding a Better End",
                    sourceName = "Psychological Science",
                    authorsOrYear = "Kahneman, D., Fredrickson, B. L., Schreiber, C. A., & Redelmeier, D. A. (1993)",
                    url = "https://scholar.google.com/scholar?q=Kahneman+Fredrickson+1993+When+More+Pain+Is+Preferred+to+Less"
                ),
                SourceReference(
                    title = "Patients' memories of painful medical treatments: real-time and retrospective evaluations",
                    sourceName = "Pain (PubMed)",
                    authorsOrYear = "Redelmeier, D. A. & Kahneman, D. (1996)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/8862606/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("kahneman", "duration neglect", "remembering self", "user experience", "endings")
        ),

        // ==========================================
        // 13. SOCIAL PSYCHOLOGY
        // ==========================================
        ConceptArticle(
            id = "sp_fundamental_attribution",
            name = "Fundamental Attribution Error",
            alternativeNames = listOf("Correspondence Bias", "Actor–Observer Asymmetry"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Attribution & Interpersonal Judgment"),
            shortDefinition = "The tendency, when explaining other people's behaviour, to overemphasise internal personal traits (character, intelligence, intent) while underestimating external situational pressures.",
            beginnerExplanation = "If *you* arrive 10 minutes late to a meeting, you explain it by the situation: 'There was an unexpected train delay and my phone died.' If *someone else* arrives 10 minutes late, you explain it by their personality: 'They are disorganized and don't respect our time.'",
            detailedExplanation = "Coined by Stanford social psychologist Lee Ross in 1977 and closely linked to Edward Jones and Victor Harris's (1967) research on Correspondence Bias, the Fundamental Attribution Error (FAE) describes a systematic asymmetry in causal attribution. In Jones & Harris's classic experiment, participants read essays either supporting or opposing Fidel Castro; even when told explicitly that the essay writer had been assigned their position by a coin toss, readers still inferred that the writer personally held the views expressed in the essay! Cross-cultural psychology (Markus & Kitayama, 1991; Nisbett, 2003) has added an important nuance: while ubiquitous, dispositional attribution is significantly stronger in individualistic Western cultures than in holistic East Asian cultures, where situational context receives greater spontaneous weight.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Traffic & Commuting",
                    scenario = "Assuming a driver who cuts you off is a reckless, selfish person, while assuming that when you accidentally merge tightly, it was simply because the highway signage was confusing.",
                    analysis = "Applies internal character judgment to the stranger and situational context to oneself."
                ),
                EverydayExample(
                    context = "Customer Support & Bug Reports",
                    scenario = "Blaming users for 'not reading the screen' when 30% of customers click the wrong button, instead of recognising that the interface layout is ambiguous.",
                    analysis = "Attributes a systemic design flaw to user disposition."
                )
            ),
            howToRecognise = listOf(
                "Explaining another person's mistake using permanent character labels ('lazy', 'careless', 'hostile') before asking what constraints they faced.",
                "Notice the Actor–Observer Double Standard: excusing your own missteps via context while judging others' identical missteps as character flaws.",
                "Assuming an actor or spokesperson's assigned role reflects their private personality."
            ),
            whyItOccurs = "Perceptual salience: when you watch another person act, the person is the vivid moving figure in the centre of your visual field while their invisible situational constraints (sleep deprivation, conflicting boss instructions, family emergency) are hidden. When you act, your eyes look outward at your environment, making your situation salient to you.",
            howToRespond = listOf(
                "Ask the Situational First Question: 'What invisible constraints, incentives, or pressures would make a reasonable, well-intentioned person act this way?'",
                "Apply Hanlon's Razor and the Principle of Charity before inferring malice.",
                "In systems engineering and safety reviews, look for environmental and workflow causes ('Blameless Post-Mortems') rather than stopping at 'human error.'"
            ),
            relatedConceptIds = listOf("rp_hanlons_razor", "ct_principle_of_charity", "bias_halo_effect", "sp_bystander_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Jones & Harris (1967) and Ross (1977). Cross-cultural research by Miller (1984) and Morris & Peng (1994) demonstrated that cultural schemas moderate the strength of dispositional versus situational attribution.",
            sources = listOf(
                SourceReference(
                    title = "The attribution of attitudes",
                    sourceName = "Journal of Experimental Social Psychology",
                    authorsOrYear = "Jones, E. E. & Harris, V. A. (1967)",
                    url = "https://scholar.google.com/scholar?q=Jones+Harris+1967+The+attribution+of+attitudes"
                ),
                SourceReference(
                    title = "The intuitive psychologist and his shortcomings: Distortions in the attribution process",
                    sourceName = "Advances in Experimental Social Psychology",
                    authorsOrYear = "Ross, L. (1977)",
                    url = "https://scholar.google.com/scholar?q=Lee+Ross+1977+The+intuitive+psychologist+and+his+shortcomings"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("lee ross", "correspondence bias", "actor observer", "empathy", "blameless postmortem")
        ),

        ConceptArticle(
            id = "sp_bystander_effect",
            name = "Bystander Effect",
            alternativeNames = listOf("Diffusion of Responsibility", "Pluralistic Ignorance in Emergencies"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.PSYCHOLOGICAL_PHENOMENA),
            subcategories = listOf("Conformity & Collective Action"),
            shortDefinition = "A social psychological phenomenon in which individuals are less likely—or slower—to offer help or take action in an ambiguous situation when passive bystanders are present than when they are alone.",
            beginnerExplanation = "When you are the only person who sees a problem, 100% of the responsibility to help rests clearly on your shoulders. When 20 people are copied on an urgent email or standing around an ambiguous situation, everyone waits for someone else to step up first—and often nobody does.",
            detailedExplanation = "Pioneered by Bibb Latané and John Darley (1968, 1970) in a series of landmark laboratory experiments, the Bystander Effect is driven by three distinct psychological processes: (1) Diffusion of Responsibility — as group size increases, each individual's felt share of personal obligation drops; (2) Pluralistic Ignorance — when an emergency or problem is ambiguous (like smoke seeping under a door), people glance at others' calm faces to gauge whether to worry, and because everyone is trying to look calm, the group collectively misinterprets the situation as safe; and (3) Evaluation Apprehension — fear of looking foolish in front of strangers if the situation turns out to be a false alarm.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Email & Incident Alerts",
                    scenario = "Sending an urgent email to a 15-person distribution list asking 'Can someone check why the staging server is down?'—resulting in silence for three hours because everyone assumed a teammate was handling it.",
                    analysis = "Addressing a group without assigning a single named owner triggers classic diffusion of responsibility."
                ),
                EverydayExample(
                    context = "First Aid & Public Safety",
                    scenario = "During a medical incident in a busy plaza, shouting 'Somebody call an ambulance!' is far less effective than pointing directly at one specific person and saying, 'You in the blue jacket, please call 911 right now.'",
                    analysis = "Singling out one individual eliminates both diffusion of responsibility and ambiguity."
                )
            ),
            howToRecognise = listOf(
                "Action items assigned to 'the team' or 'everyone' rather than a single Directly Responsible Individual (DRI).",
                "Group silence in a meeting when an obvious flaw appears on screen, as everyone waits to see if anyone else speaks up.",
                "Slower response times on crowded support channels than on direct 1-on-1 messages."
            ),
            whyItOccurs = "Social referencing (looking to peers to interpret ambiguous events) combined with cognitive division of moral and operational responsibility across group members.",
            howToRespond = listOf(
                "In any emergency or project task, assign one specific person by name: 'Alex, will you call emergency services?' or 'Priya, you own ticket #402.'",
                "When you notice an ambiguous problem in a crowd or meeting, break Pluralistic Ignorance by speaking up first—even a simple 'Hey, does that look right to everyone?' frees others to act.",
                "Remember that modern camera-footage research shows people *do* frequently help in clear, non-ambiguous emergencies once one person initiates action."
            ),
            relatedConceptIds = listOf("sp_groupthink", "sp_fundamental_attribution", "sp_false_consensus", "phen_spotlight_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Validated in laboratory and field studies by Darley & Latané (1968) and meta-analysed by Fischer et al. (2011), who showed the effect is strongest in ambiguous situations and weakens or reverses when danger is unmistakable or bystanders know one another (Philpot et al., 2020 CCTV study).",
            sources = listOf(
                SourceReference(
                    title = "Bystander intervention in emergencies: diffusion of responsibility",
                    sourceName = "Journal of Personality and Social Psychology (PubMed)",
                    authorsOrYear = "Darley, J. M. & Latané, B. (1968)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/5645600/"
                ),
                SourceReference(
                    title = "The bystander-effect: a meta-analytic review on bystander intervention in dangerous and non-dangerous emergencies",
                    sourceName = "Psychological Bulletin (PubMed)",
                    authorsOrYear = "Fischer, P. et al. (2011)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21534650/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("diffusion of responsibility", "pluralistic ignorance", "darley latane", "accountability", "emergency")
        ),

        ConceptArticle(
            id = "sp_groupthink",
            name = "Groupthink",
            alternativeNames = listOf("Consensus-Seeking Pathology", "Conformity Cascade"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Group Decision & Identity Dynamics"),
            shortDefinition = "A dysfunction of highly cohesive groups in which the desire for harmony, unanimity, and loyalty overrides realistic appraisal of alternative courses of action and suppresses dissent.",
            beginnerExplanation = "Smart, well-meaning people can make disastrous decisions together when no one wants to 'rock the boat.' In Groupthink, keeping the room harmonious and agreeing with the leader becomes more important than pointing out the iceberg dead ahead.",
            detailedExplanation = "Formulated by Yale psychologist Irving Janis (1972, 1982) through historical analyses of major policy fiascos and successes, Groupthink occurs when group cohesiveness interacts with structural faults (such as aninsulated group, a directive leader who states their preference upfront, and lack of methodological review procedures). Janis identified eight classic symptoms, including: an illusion of invulnerability, collective rationalisation of warnings, self-censorship of doubts, direct pressure on dissenters, and an 'illusion of unanimity' (where silence is assumed to mean enthusiastic agreement).",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Executive Product Launch",
                    scenario = "A CEO opens a strategy meeting by saying, 'I'm thrilled about our new pricing plan—does anyone see any issues before we announce it?' Four directors privately see major flaws, but because everyone else nods, each stays silent and the meeting ends in 'unanimous' approval.",
                    analysis = "Directive leadership upfront combines with self-censorship to manufacture an illusion of unanimity."
                ),
                EverydayExample(
                    context = "Committee Hiring",
                    scenario = "Dismissing red flags in a reference check because the committee feels tired, likes the candidate's warmth, and wants to wrap up before Friday.",
                    analysis = "Desire for closure and consensus suppresses critical scrutiny."
                )
            ),
            howToRecognise = listOf(
                "Leaders stating their preferred conclusion at the very start of a deliberation rather than listening first.",
                "High-stakes decisions passing with zero debate or questions.",
                "Team members who raise risk scenarios being treated as 'not team players' or 'negative.'"
            ),
            whyItOccurs = "Humans have a strong evolutionary need for in-group belonging; challenging a shared consensus risks social friction, whereas concurring brings immediate social validation.",
            howToRespond = listOf(
                "Leaders should withhold their own opinion until everyone else has spoken.",
                "Institutionalise a rotating 'Devil's Advocate' or 'Red Team' whose explicit job is to argue the strongest case against the proposal.",
                "Collect anonymous written risk assessments before opening floor discussion."
            ),
            relatedConceptIds = listOf("dme_escalation_commitment", "sp_bystander_effect", "bias_confirmation", "ct_steelmanning"),
            evidenceLevel = EvidenceLevel.EVIDENCE_DEVELOPING,
            scientificEvidenceAndLimitations = "Formulated by Irving Janis (1972). While Janis's case-study framework is foundational in organisational psychology, experimental reviews (Baron, 2005) note that not all of Janis's antecedent conditions are required—ubiquitous social conformity (Asch, 1951) and group polarization (Sunstein, 2002) often suffice to produce groupthink symptoms.",
            sources = listOf(
                SourceReference(
                    title = "Victims of Groupthink: A psychological study of foreign-policy decisions and fiascoes",
                    sourceName = "Houghton Mifflin",
                    authorsOrYear = "Janis, I. L. (1972)",
                    url = "https://scholar.google.com/scholar?q=Irving+Janis+1972+Victims+of+Groupthink"
                ),
                SourceReference(
                    title = "So right it's wrong: Groupthink and the ubiquitous nature of polarized group decision making",
                    sourceName = "Advances in Experimental Social Psychology",
                    authorsOrYear = "Baron, R. S. (2005)",
                    url = "https://scholar.google.com/scholar?q=Robert+Baron+2005+Groupthink+ubiquitous+nature+polarized+group"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("irving janis", "conformity", "echo chamber", "devils advocate", "consensus")
        ),

        ConceptArticle(
            id = "sp_false_consensus",
            name = "False Consensus Effect",
            alternativeNames = listOf("Egocentric Social Projection", "Looking-Glass Perception"),
            primaryCategory = CollectionCategory.SOCIAL_PSYCHOLOGY,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Attribution & Interpersonal Judgment"),
            shortDefinition = "The cognitive bias whereby people overestimate the degree to which their own beliefs, preferences, values, and habits are shared by the wider population.",
            beginnerExplanation = "We tend to assume that 'normal people think like me.' Whether it's how we load the dishwasher, how we interpret an emoji, or which software shortcut we use, we overestimate how many other people share our exact preference.",
            detailedExplanation = "Demonstrated in a classic Stanford study by Lee Ross, David Greene, and Pamela House (1977), the False Consensus Effect shows that regardless of which choice a person makes, they estimate that a majority of their peers would make the exact same choice. In Ross et al.'s experiment, students were asked to walk around campus for 30 minutes wearing a large sandwich board reading 'EAT AT JOE'S.' Students who agreed estimated that 62% of peers would also agree; students who refused estimated that 67% of peers would also refuse. Moreover, both groups tended to judge people who made the opposite choice as having more unusual personality traits.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Product Design & UX Research",
                    scenario = "A developer builds an app with complex keyboard gestures and no labels, assuming 'every user will naturally swipe here because that's what I do.'",
                    analysis = "Projects the builder's own mental model onto a diverse general user base."
                ),
                EverydayExample(
                    context = "Team Communication",
                    scenario = "Assuming that because you enjoy receiving late-night Slack messages as soon as an idea strikes, your entire team also prefers late-night messages.",
                    analysis = "Mistakes personal work style for universal consensus."
                )
            ),
            howToRecognise = listOf(
                "Saying 'Nobody uses that feature anymore' or 'Everyone prefers X' based solely on your own habits and three friends.",
                "Feeling shocked when an objective poll or usability test contradicts your personal preference.",
                "Treating people who hold a different preference as statistical outliers."
            ),
            whyItOccurs = "Selective Exposure (we socialize with people similar to ourselves, making our views more available in memory) combined with Anchoring on our own immediate internal experience.",
            howToRespond = listOf(
                "Remember the UX maxim: 'You are not the user'—always test assumptions with representative empirical sampling.",
                "Actively seek out perspectives from outside your immediate professional and demographic circle.",
                "Check objective survey data before claiming 'most people think X.'"
            ),
            relatedConceptIds = listOf("heur_availability", "bias_confirmation", "phen_spotlight_effect", "phen_dunning_kruger"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Ross, Greene, & House (1977) and confirmed across more than 115 independent studies in Mullen et al.'s (1985) meta-analysis.",
            sources = listOf(
                SourceReference(
                    title = "The 'false consensus effect': An egocentric bias in social perception and attribution processes",
                    sourceName = "Journal of Experimental Social Psychology",
                    authorsOrYear = "Ross, L., Greene, D., & House, P. (1977)",
                    url = "https://scholar.google.com/scholar?q=Ross+Greene+House+1977+The+false+consensus+effect"
                ),
                SourceReference(
                    title = "The false consensus effect: A meta-analysis of 115 hypothesis tests",
                    sourceName = "Journal of Experimental Social Psychology",
                    authorsOrYear = "Mullen, B. et al. (1985)",
                    url = "https://scholar.google.com/scholar?q=Mullen+1985+false+consensus+effect+meta+analysis+115"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("projection", "echo chamber", "you are not the user", "lee ross", "consensus")
        ),

        // ==========================================
        // 14. CRITICAL THINKING
        // ==========================================
        ConceptArticle(
            id = "ct_steelmanning",
            name = "Steelmanning",
            alternativeNames = listOf("Steel Man Principle", "Constructive Counter-Formulation"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES, CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Charitable & Constructive Argumentation"),
            shortDefinition = "The epistemic practice of articulating the strongest, most coherent, and most persuasive version of an interlocutor's argument—often improving upon their initial phrasing—before attempting to evaluate or critique it.",
            beginnerExplanation = "The exact opposite of a Straw Man fallacy. Instead of looking for a slip of the tongue so you can score an easy debate point, Steelmanning asks: 'What is the smartest, strongest version of what this person is trying to say?' Only when you can defeat their best argument have you truly tested your own view.",
            detailedExplanation = "Building on philosopher Daniel Dennett's synthesis of Anatol Rapoport's rules for constructive criticism (2013) and John Stuart Mill's argument in 'On Liberty' (1859) ('He who knows only his own side of the case, knows little of that'), Steelmanning follows a four-step protocol: (1) Attempt to re-express your target's position so clearly, vividly, and fairly that your target says, 'Thanks, I wish I'd thought of putting it that way'; (2) List any points of agreement (especially if they are not matters of general or widespread agreement); (3) Mention anything you have learned from your target; and (4) Only then are you permitted to say so much as a word of rebuttal or criticism.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Architecture Design Review",
                    scenario = "Before arguing for a monolithic database, an architect begins by presenting the three strongest resilience benefits of the opposing team's microservices proposal so accurately that the opposing team nods in agreement.",
                    analysis = "Demonstrates genuine comprehension and focuses the debate on real trade-offs rather than caricatures."
                ),
                EverydayExample(
                    context = "Interpersonal Disagreement",
                    scenario = "Saying 'Let me make sure I understand the strongest case for waiting until Q3: it gives QA two full weeks and protects our support team during the holiday rush—is that right?'",
                    analysis = "De-escalates defensiveness and models collaborative truth-seeking."
                )
            ),
            howToRecognise = listOf(
                "Restating an opposing viewpoint in a way that the other person enthusiastically endorses.",
                "Supplying stronger evidence or clearer logic for an opponent's premise than they initially offered.",
                "Using the Ideological Turing Test: being able to write an essay for the opposing view that a genuine advocate cannot tell apart from their own."
            ),
            whyItOccurs = "Deliberate epistemic discipline designed to counteract Confirmation Bias, the Straw Man fallacy, and adversarial debate reflexes.",
            howToRespond = listOf(
                "Before critiquing any proposal, ask: 'Can I summarize your strongest point first, and you tell me if I got it right?'",
                "Be cautious not to 'over-steelman' into inventing a completely different position the speaker doesn't actually hold—always check with the speaker first.",
                "Pair with Rapoport's Rules in written and verbal debates."
            ),
            relatedConceptIds = listOf("fallacy_straw_man", "ct_principle_of_charity", "ct_intellectual_humility", "bias_confirmation"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Grounded in philosophical argumentation theory (Mill, 1859; Rapoport, 1960; Dennett, 2013) and empirical research on active listening and attitude de-polarisation (Itzchakov, Kluger, & Castro, 2017).",
            sources = listOf(
                SourceReference(
                    title = "Intuition Pumps and Other Tools for Thinking (Rapoport's Rules)",
                    sourceName = "W. W. Norton & Company",
                    authorsOrYear = "Dennett, D. C. (2013)",
                    url = "https://scholar.google.com/scholar?q=Daniel+Dennett+2013+Intuition+Pumps+Rapoport+Rules"
                ),
                SourceReference(
                    title = "Argument and Argumentation",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Dutilh Novaes, C. (2021)",
                    url = "https://plato.stanford.edu/entries/argument/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("straw man", "rapoports rules", "dennett", "charity", "turing test")
        ),

        ConceptArticle(
            id = "ct_principle_of_charity",
            name = "Principle of Charity",
            alternativeNames = listOf("Charitable Interpretation", "Rational Accommodation Principle"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Charitable & Constructive Argumentation"),
            shortDefinition = "A methodological principle in philosophy and rhetoric requiring an interpreter to understand a speaker's ambiguous statements in the most rational, coherent, and truth-preserving way possible.",
            beginnerExplanation = "Human speech is full of shorthand, typos, and imperfect phrasing. When a statement could be read in two ways—one way that makes the speaker sound absurd or contradictory, and another way that makes reasonable sense—the Principle of Charity instructs us to choose the sensible reading.",
            detailedExplanation = "Formulated in 20th-century philosophy of language by Neil Wilson (1959), Willard Van Orman Quine (1960), and Donald Davidson (1973), the Principle of Charity started as a foundational condition for radical translation: we cannot even begin to understand another speaker's words unless we assume most of their background beliefs about the shared world are coherent and rational. Applied to everyday argumentation and critical thinking, it prohibits 'gotcha' pedantry—seizing on a clumsy word choice or unstated obvious premise to dismiss an entire argument when the speaker's intended rational meaning is clear.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Online & Written Discussions",
                    scenario = "A colleague writes in a hurry, 'Nobody reads PDF manuals anymore.' Instead of replying 'False! I read one yesterday, so your point is invalid,' a charitable reader interprets 'nobody' as colloquial shorthand for 'most mainstream users prefer interactive onboarding.'",
                    analysis = "Looks past conversational hyperbole to engage the substantive point."
                ),
                EverydayExample(
                    context = "Reading Historical or Cross-Cultural Texts",
                    scenario = "Asking what problem an author was genuinely trying to solve within their context before dismissing an unfamiliar term as nonsense.",
                    analysis = "Maximises intelligibility before evaluating truth."
                )
            ),
            howToRecognise = listOf(
                "Asking 'What would have to be true for this person's statement to make sense?'",
                "Supplying obvious unstated premises (enthymemes) rather than treating their omission as a logical blunder.",
                "Distinguishing a slip of the tongue from a substantive disagreement."
            ),
            whyItOccurs = "Natural human language relies heavily on pragmatic context and Gricean cooperative maxims; literalist pedantry breaks communication without advancing truth.",
            howToRespond = listOf(
                "When someone says something that sounds patently absurd, pause and ask: 'Could I be misreading one of their words?'",
                "Ask clarifying questions ('When you say X, do you mean A or B?') before launching a rebuttal.",
                "Remember that charity is not gullibility: once you have interpreted the claim in its strongest rational form, you should still test it rigorously against evidence."
            ),
            relatedConceptIds = listOf("ct_steelmanning", "fallacy_straw_man", "rp_hanlons_razor", "sp_fundamental_attribution"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A foundational principle in analytic philosophy of language and epistemology (Quine, 1960; Davidson, 1973, 'Radical Interpretation').",
            sources = listOf(
                SourceReference(
                    title = "Donald Davidson (Radical Interpretation and the Principle of Charity)",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Malpas, J. (2019)",
                    url = "https://plato.stanford.edu/entries/davidson/"
                ),
                SourceReference(
                    title = "Word and Object",
                    sourceName = "MIT Press",
                    authorsOrYear = "Quine, W. V. O. (1960)",
                    url = "https://scholar.google.com/scholar?q=Quine+1960+Word+and+Object+Principle+of+Charity"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("donald davidson", "quine", "interpretation", "pedantry", "good faith")
        ),

        ConceptArticle(
            id = "ct_falsifiability",
            name = "Falsifiability",
            alternativeNames = listOf("Refutability Criterion", "Popperian Demarcation"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.REASONING_PRINCIPLES, CollectionCategory.MENTAL_MODELS),
            subcategories = listOf("Probabilistic & Empirical Calibration"),
            shortDefinition = "The principle that for any empirical claim, hypothesis, or theory to be scientifically meaningful and testable, there must exist a conceivable observation or experiment that could prove it false.",
            beginnerExplanation = "If a theory can effortlessly explain away every possible outcome—both rain and sunshine, both success and failure—then it actually explains nothing at all. A genuinely informative claim sticks its neck out by stating clearly what *cannot* happen if the claim is true.",
            detailedExplanation = "Formulated by philosopher of science Karl Popper in 'The Logic of Scientific Discovery' (1934/1959), Falsifiability addresses both the Problem of Induction and the Problem of Demarcation (distinguishing empirical science from unfalsifiable pseudoscience). Because no number of white swans can deductively prove the universal statement 'All swans are white,' yet a single observed black swan deductively refutes it (via Modus Tollens), empirical knowledge advances through bold conjectures and rigorous attempts at refutation. When an advocate rescues a failing theory by endlessly inventing untestable ad-hoc excuses ('The prediction only failed because the skeptics in the room disrupted the energy'), they immunise the claim against falsification at the cost of emptying it of empirical content.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Product & Business Hypotheses",
                    scenario = "Instead of a vague goal like 'Users will love our redesign,' stating a falsifiable hypothesis: 'If the new checkout flow is clearer, cart abandonment will drop by at least 5% within 14 days; if it does not, our hypothesis is wrong.'",
                    analysis = "Defines an objective empirical failure condition upfront."
                ),
                EverydayExample(
                    context = "Ad-Hoc Immunisation (Moving Goalposts)",
                    scenario = "A market forecaster predicts a crash in May. When the market rises in May, they say, 'That just proves the crash is building up even bigger for October!'",
                    analysis = "Both a market drop and a market rise are cited as 'confirmations' of the thesis, making it unfalsifiable."
                )
            ),
            howToRecognise = listOf(
                "Every possible outcome—including the exact opposite of what was predicted—is reinterpreted as supporting the theory.",
                "Heavy reliance on 'No True Scotsman' or ad-hoc escape clauses whenever counter-examples appear.",
                "Inability to answer the question: 'What specific observation would convince you that this belief is mistaken?'"
            ),
            whyItOccurs = "Confirmation Bias and Belief Perseverance make humans naturally seek protective rationalisations for cherished beliefs rather than exposing them to risky tests.",
            howToRespond = listOf(
                "Ask yourself and others the Popperian Question: 'What concrete evidence, if we saw it tomorrow, would change your mind?'",
                "Design experiments and A/B tests specifically to try to *break* your favourite hypothesis rather than merely confirm it.",
                "Watch out for 'No True Scotsman' redefinitions that quietly turn an empirical claim into a tautology."
            ),
            relatedConceptIds = listOf("bias_confirmation", "bias_belief_perseverance", "rp_occams_razor", "rp_hitchens_razor"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Karl Popper (1934). In contemporary philosophy of science, scholars note the Duhem–Quine thesis: in practice, scientists rarely abandon an entire foundational theory from a single anomalous measurement without first checking auxiliary assumptions (instrument calibration, initial conditions)—yet long-term refusal to allow any test to count against a claim remains a hallmark of pseudoscience.",
            sources = listOf(
                SourceReference(
                    title = "Karl Popper",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Thornton, S. (2022)",
                    url = "https://plato.stanford.edu/entries/popper/"
                ),
                SourceReference(
                    title = "Science and Pseudoscience",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Hansson, S. O. (2021)",
                    url = "https://plato.stanford.edu/entries/pseudo-science/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("karl popper", "black swan", "modus tollens", "scientific method", "demarcation")
        ),

        ConceptArticle(
            id = "ct_bayes_theorem",
            name = "Bayesian Updating",
            alternativeNames = listOf("Bayes' Rule Reasoning", "Probabilistic Belief Revision"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.REASONING_PRINCIPLES),
            subcategories = listOf("Probabilistic & Empirical Calibration"),
            shortDefinition = "A mathematical and epistemological framework for updating the probability of a hypothesis incrementally as new evidence arrives, weighing the strength of the new evidence against the prior baseline probability.",
            beginnerExplanation = "Instead of treating beliefs as an on/off light switch ('100% true' or '100% false'), Bayesian thinking treats beliefs like a dimmer switch from 0% to 99.9%. You start with a reasonable baseline estimate (your 'prior'), and each time new evidence comes in, you nudge the dial up or down in proportion to how strong and surprising that evidence is.",
            detailedExplanation = "Derived by Thomas Bayes (1763) and Pierre-Simon Laplace (1774), Bayes' Theorem states that the posterior probability of a hypothesis equals its prior probability multiplied by the likelihood ratio of the observed evidence: P(H | E) = [P(E | H) * P(H)] / P(E). As a critical thinking discipline (studied empirically by Philip Tetlock in the Good Judgment Project), Bayesian updating prevents two opposite errors: (1) Base Rate Neglect / Over-reaction — abandoning a well-established baseline because of one noisy anecdote; and (2) Belief Perseverance / Under-reaction — refusing to move your probability dial at all when genuine diagnostic evidence accumulates.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Everyday Troubleshooting",
                    scenario = "When your home internet stops working, you don't immediately assume an undersea fiber-optic cable was cut by a submarine (extremely low prior probability). You check whether the router power cord came loose first (high prior probability), then update step by step.",
                    analysis = "Combines prior base rates with sequential diagnostic checks."
                ),
                EverydayExample(
                    context = "Forecasting & Project Risk",
                    scenario = "Starting with a 70% confidence estimate that a vendor will deliver on time, then adjusting down to 50% after they miss their first interim milestone, and down to 20% after their lead engineer leaves.",
                    analysis = "Incremental calibration enables early contingency action without waiting for total certainty."
                )
            ),
            howToRecognise = listOf(
                "Expressing predictions in calibrated percentages ('I'm ~75% confident') rather than vague words ('probably', 'maybe') or absolutes ('definitely').",
                "Asking two separate questions about any new clue: 'How likely is this clue if my hypothesis is true?' AND 'How likely is this clue even if my hypothesis is false?'",
                "Updating smoothly without ego attachment when new data arrive."
            ),
            whyItOccurs = "Formalises optimal information integration under uncertainty, correcting intuitive heuristics like Representativeness and Confirmation Bias.",
            howToRespond = listOf(
                "Always establish the Prior (base rate) before weighing new evidence.",
                "Evaluate the Likelihood Ratio: a piece of evidence only moves the needle if it is much more likely to occur under Hypothesis A than under Hypothesis B.",
                "Practice calibration by tracking your 60%, 80%, and 90% confidence predictions over time."
            ),
            relatedConceptIds = listOf("bias_base_rate_fallacy", "heur_representativeness", "ct_falsifiability", "ct_intellectual_humility"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Mathematically foundational in probability theory (Bayes, 1763) and empirically validated in forecasting tournaments by Tetlock & Gardner (2015), where 'superforecasters' trained in probabilistic Bayesian updating significantly outperformed intelligence analysts.",
            sources = listOf(
                SourceReference(
                    title = "Bayes' Theorem",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Joyce, J. (2021)",
                    url = "https://plato.stanford.edu/entries/bayes-theorem/"
                ),
                SourceReference(
                    title = "Superforecasting: The Art and Science of Prediction",
                    sourceName = "Crown Publishing / Good Judgment Project",
                    authorsOrYear = "Tetlock, P. E. & Gardner, D. (2015)",
                    url = "https://scholar.google.com/scholar?q=Philip+Tetlock+2015+Superforecasting+Art+Science+Prediction"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("bayes theorem", "priors", "superforecasting", "tetlock", "probability")
        ),

        ConceptArticle(
            id = "ct_intellectual_humility",
            name = "Intellectual Humility",
            alternativeNames = listOf("Epistemic Humility", "Socratic Fallibilism"),
            primaryCategory = CollectionCategory.CRITICAL_THINKING,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Self-Questioning & Intellectual Humility"),
            shortDefinition = "The metacognitive awareness that one's beliefs, knowledge, and perspectives are fallible and incomplete, accompanied by a willingness to revise views in light of stronger evidence.",
            beginnerExplanation = "Intellectual humility is not lacking confidence or pretending nobody knows anything. It is holding your current views with appropriate confidence while staying genuinely curious about how you might be mistaken—treating a correction not as a personal defeat, but as a free upgrade to your mental map.",
            detailedExplanation = "Researched extensively in contemporary personality and cognitive psychology (Leary et al., 2017; Porter & Schumann, 2018; Krumrei-Mancuso & Rouse, 2016), Intellectual Humility sits as the virtuous mean between Intellectual Arrogance (dogmatism and closed-mindedness) and Intellectual Diffidence (timidity or gullibility). Empirical studies show that individuals high in intellectual humility scrutinise the quality of arguments more accurately, are less susceptible to the Myside/Confirmation Bias, show lower affective polarisation toward people who disagree with them, and demonstrate superior mastery learning after setbacks.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Leadership & Engineering",
                    scenario = "A senior principal engineer says in a design review: 'Here is my current recommendation, and here are the two assumptions I am least sure about—please poke holes in them.'",
                    analysis = "Combines clear expertise with explicit transparency about uncertainty."
                ),
                EverydayExample(
                    context = "Everyday Learning",
                    scenario = "Being comfortable saying 'I don't know enough about that topic yet to have a strong opinion' rather than improvising a confident take on the spot.",
                    analysis = "Separates self-worth from pretending to be omniscient."
                )
            ),
            howToRecognise = listOf(
                "Separating your personal identity from your current hypotheses ('I am not my ideas').",
                "Expressing genuine curiosity when someone presents verifiable counter-evidence.",
                "Explicitly stating the confidence level and boundary conditions of your claims."
            ),
            whyItOccurs = "Requires overriding ego-defensive threat responses and cultivating a 'Scout Mindset' (seeking to map the terrain accurately) over a 'Soldier Mindset' (defending a tribe's flag).",
            howToRespond = listOf(
                "Adopt the phrase: 'Strong opinions, loosely held—updated immediately when better data arrive.'",
                "Ask yourself: 'What is the strongest piece of evidence that currently makes me uncomfortable about my own view?'",
                "Thank colleagues when they catch an error in your reasoning."
            ),
            relatedConceptIds = listOf("mm_circle_of_competence", "phen_dunning_kruger", "ct_steelmanning", "ct_bayes_theorem"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Psychometrically and experimentally validated by Leary et al. (2017) in Personality and Social Psychology Bulletin and Porter & Schumann (2018).",
            sources = listOf(
                SourceReference(
                    title = "Cognitive and Interpersonal Features of Intellectual Humility",
                    sourceName = "Personality and Social Psychology Bulletin (PubMed)",
                    authorsOrYear = "Leary, M. R. et al. (2017)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/28903672/"
                ),
                SourceReference(
                    title = "Intellectual humility and openness to the opposing view",
                    sourceName = "Self and Identity",
                    authorsOrYear = "Porter, T. & Schumann, K. (2018)",
                    url = "https://scholar.google.com/scholar?q=Porter+Schumann+2018+Intellectual+humility+openness+opposing+view"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("socrates", "scout mindset", "fallibilism", "open mindedness", "leary")
        ),

        // ==========================================
        // 15. REASONING PRINCIPLES
        // ==========================================
        ConceptArticle(
            id = "rp_occams_razor",
            name = "Occam's Razor",
            alternativeNames = listOf("Law of Parsimony", "Lex Parsimoniae", "Principle of Ontological Economy"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Epistemic Razors & Parsimony"),
            shortDefinition = "The methodological principle that when two competing hypotheses explain the observed data equally well, the one that requires fewer untested assumptions or postulated entities should be preferred for testing first.",
            beginnerExplanation = "Often paraphrased as 'the simplest explanation is usually the best,' Occam's Razor is actually more precise: don't multiply extra, unproven assumptions when a straightforward mechanism already accounts for all the facts. In medicine, doctors phrase this as: 'When you hear hoofbeats behind you, think horses first, not zebras.'",
            detailedExplanation = "Associated with the 14th-century Franciscan logician William of Ockham ('Pluralitas non est ponenda sine necessitate' — 'Plurality should not be posited without necessity'), Occam's Razor is an abductive heuristic and formal principle in statistical model selection (such as the Akaike Information Criterion and Bayesian Occam's Razor). Mathematically, every independent, unverified assumption added to a hypothesis acts as a conjunction P(A and B and C) that lowers its prior probability and risks overfitting to noise. Crucially, Occam's Razor only arbitrates *when explanatory power is equal*—if a simpler model fails to account for the actual evidence, empirical adequacy always overrides simplicity.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software & Network Debugging",
                    scenario = "When a web page fails to load, checking whether the Wi-Fi router unplugged or a DNS configuration expired before hypothesising a zero-day kernel compiler bug.",
                    analysis = "Tests single-assumption, high-base-rate causes before multi-assumption chains."
                ),
                EverydayExample(
                    context = "Data Science & Machine Learning",
                    scenario = "Preferring a clean 3-variable linear model that generalises well to new data over a 50-parameter polynomial curve that memorises random noise in the training set.",
                    analysis = "Penalises unnecessary complexity to prevent overfitting."
                )
            ),
            howToRecognise = listOf(
                "Competing explanations where Hypothesis A requires 1 routine mechanism and Hypothesis B requires 6 independent coincidences to all happen in secret.",
                "Conspiracy narratives that add a new invisible layer every time a prediction fails.",
                "Over-engineered root-cause theories."
            ),
            whyItOccurs = "Conjunction probability: multiplying independent uncertain assumptions ($0.5 \\times 0.5 \\times 0.5 \\dots$) exponentially reduces joint probability.",
            howToRespond = listOf(
                "Count the number of independent, unverified assumptions each competing explanation requires.",
                "Remember Einstein's caveat: 'Everything should be made as simple as possible, but not simpler'—never discard verified facts just to keep a story simple.",
                "Test the most parsimonious hypothesis first to save diagnostic time."
            ),
            relatedConceptIds = listOf("rp_hanlons_razor", "heur_representativeness", "ct_bayes_theorem", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Analysed extensively in philosophy of science and formalised mathematically in Bayesian model selection and algorithmic information theory (Minimum Description Length; Baker, 2022).",
            sources = listOf(
                SourceReference(
                    title = "Simplicity",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Baker, A. (2022)",
                    url = "https://plato.stanford.edu/entries/simplicity/"
                ),
                SourceReference(
                    title = "William of Ockham",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Spade, P. V. & Panaccio, C. (2019)",
                    url = "https://plato.stanford.edu/entries/ockham/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("parsimony", "simplicity", "william of ockham", "overfitting", "abduction")
        ),

        ConceptArticle(
            id = "rp_hanlons_razor",
            name = "Hanlon's Razor",
            alternativeNames = listOf("Incompetence-Before-Malice Heuristic", "Charitable Attribution Razor"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Epistemic Razors & Parsimony"),
            shortDefinition = "A practical reasoning adage stating: 'Never attribute to malice that which is adequately explained by neglect, ignorance, fatigue, or ordinary human error.'",
            beginnerExplanation = "When someone forgets to reply to your email, bumps into your cart, or ships a broken update, our threatened brain often jumps to 'They did that on purpose to slight me!' Hanlon's Razor reminds us that busyness, tiredness, confusion, and simple mistakes are vastly more common in daily life than calculated evil plots.",
            detailedExplanation = "While named after Robert J. Hanlon (1980), equivalent formulations appear in Johann Wolfgang von Goethe (1774, 'The Sorrows of Young Werther': 'Misunderstandings and lethargy perhaps produce more wrong in the world than deceit and malice do'), Jane Austen, and Napoleon Bonaparte. Epistemically, Hanlon's Razor combines Occam's Razor with a correction for the Fundamental Attribution Error and Hostile Attribution Bias. Calculated malice requires awareness, motive, planning, and coordination, whereas oversight or miscommunication requires only ordinary cognitive load or system friction.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Communication",
                    scenario = "Discovering you were left off a calendar invite and asking 'Hey, could you add me to the invite?' rather than assuming a colleague is orchestrating a political coup against you.",
                    analysis = "Checks for a simple calendar autocomplete oversight before assuming hostility."
                ),
                EverydayExample(
                    context = "Customer Service Disputes",
                    scenario = "Approaching a billing error by saying 'It looks like the system double-charged my card by mistake' rather than accusing the support representative of fraud.",
                    analysis = "Preserves goodwill and resolves the problem faster."
                )
            ),
            howToRecognise = listOf(
                "Jumping immediately to 'They are out to get me' after an ambiguous inconvenience.",
                "Constructing elaborate stories of intentional sabotage when a mundane clerical error explains all the facts.",
                "Escalating interpersonal conflict before asking a simple clarifying question."
            ),
            whyItOccurs = "Evolutionary threat detection and the Fundamental Attribution Error make humans hyper-vigilant to intentional social slights.",
            howToRespond = listOf(
                "Default to curiosity on the first occurrence: treat single incidents as oversights or misunderstandings.",
                "Maintain healthy boundaries: if harmful behaviour repeats consistently *after* clear feedback has been given, update your assessment (Hanlon's Razor is a starting prior, not an excuse to ignore repeated manipulation).",
                "Look for broken processes rather than bad intentions in team operations."
            ),
            relatedConceptIds = listOf("sp_fundamental_attribution", "rp_occams_razor", "ct_principle_of_charity", "manip_gaslighting"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A philosophical and practical heuristic supported empirically by social psychology research on Hostile Attribution Bias (Dodge, 1980) and the Fundamental Attribution Error (Ross, 1977).",
            sources = listOf(
                SourceReference(
                    title = "Social cognition and children's aggressive behavior (Hostile Attribution Bias)",
                    sourceName = "Child Development (PubMed)",
                    authorsOrYear = "Dodge, K. A. (1980)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/7363732/"
                ),
                SourceReference(
                    title = "The intuitive psychologist and his shortcomings",
                    sourceName = "Advances in Experimental Social Psychology",
                    authorsOrYear = "Ross, L. (1977)",
                    url = "https://scholar.google.com/scholar?q=Lee+Ross+1977+The+intuitive+psychologist+and+his+shortcomings"
                )
            ),
            reviewStatus = ReviewStatus.CROSS_REFERENCED,
            keywords = listOf("malice", "mistake", "hostile attribution", "forgiveness", "paranoia")
        ),

        ConceptArticle(
            id = "rp_chestertons_fence",
            name = "Chesterton's Fence",
            alternativeNames = listOf("Principle of Second-Order Conservation", "Understand-Before-Removing Rule"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS),
            subcategories = listOf("Diagnostic & Structural Canons"),
            shortDefinition = "The principle that you should never tear down a fence, rule, code block, or institution until you first understand why it was put up in the first place.",
            beginnerExplanation = "Imagine walking down a country road, seeing a fence built across a field for no obvious reason, and saying, 'I don't see the use of this; let's knock it down!' Chesterton's rule says: fences don't grow out of the ground by magic—someone spent time and money building it to solve a problem. Only when you know what that problem was can you judge whether it's safe to remove.",
            detailedExplanation = "Formulated by essayist G. K. Chesterton in his 1929 book 'The Thing,' Chesterton's Fence is a vital safeguard against naive First-Order reform. Complex software systems, safety protocols, legal traditions, and ecological food webs often contain components that look redundant during calm weather because they are quietly preventing a rare catastrophe (or because the problem they solved disappeared *precisely because the fence is still standing*). Once you investigate and confirm that the original reason is genuinely obsolete—for instance, the fence kept out livestock from a farm that closed 40 years ago—you are fully justified in removing it.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Refactoring",
                    scenario = "A new developer deletes a strange 4-line timeout check in legacy code because 'it looks unnecessary,' inadvertently reintroducing a production crash that only triggers on leap-year billing cycles.",
                    analysis = "Removed a defensive guardrail without checking git blame or commit history to learn why it was added."
                ),
                EverydayExample(
                    context = "Organisational Restructuring",
                    scenario = "An incoming executive eliminates a seemingly quiet quality-assurance checklist to speed up shipping, only to face a costly product recall two months later.",
                    analysis = "Mistook the absence of recent recalls for proof that the checklist was useless, rather than proof that the checklist was working."
                )
            ),
            howToRecognise = listOf(
                "Saying 'I don't see why we have this step, so let's delete it right now.'",
                "Confusing 'the problem hasn't happened in years' with 'the safeguard is no longer needed.'",
                "Rewriting an entire system from scratch without interviewing the people who maintain the current one."
            ),
            whyItOccurs = "The costs of maintaining a rule or fence are visible today, whereas the counterfactual disasters the fence silently prevents are invisible (Survivorship / Prevention Paradox).",
            howToRespond = listOf(
                "Before removing any legacy rule, code block, or habit, answer: 'Who created this, what problem were they solving, and does that problem still exist?'",
                "Document the 'why' behind your own code and policies so future maintainers don't have to guess why the fence is there.",
                "Once you verify that the original constraint truly no longer applies, remove the obsolete fence cleanly."
            ),
            relatedConceptIds = listOf("mm_second_order", "mm_first_principles", "bias_survivorship", "dme_planning_fallacy"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "Formulated by G. K. Chesterton (1929, 'The Thing', Chapter: 'The Drift from Domesticity') and widely applied in systems engineering, institutional economics, and software architecture.",
            sources = listOf(
                SourceReference(
                    title = "The Thing (Chapter: The Drift from Domesticity)",
                    sourceName = "Dodd, Mead and Company",
                    authorsOrYear = "Chesterton, G. K. (1929)",
                    url = "https://scholar.google.com/scholar?q=Chesterton+1929+The+Thing+fence+across+a+road"
                ),
                SourceReference(
                    title = "Thinking in Systems: A Primer",
                    sourceName = "Chelsea Green Publishing",
                    authorsOrYear = "Meadows, D. H. (2008)",
                    url = "https://scholar.google.com/scholar?q=Donella+Meadows+2008+Thinking+in+Systems"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("chesterton", "legacy code", "refactoring", "unintended consequences", "tradition")
        ),

        ConceptArticle(
            id = "rp_burden_of_proof",
            name = "Burden of Proof (Onus Probandi)",
            alternativeNames = listOf("Onus Probandi", "Epistemic Responsibility Principle", "Sagan Standard"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Burden of Proof & Justification"),
            shortDefinition = "The foundational principle of logic, law, and science that the obligation to provide sufficient warrant and evidence rests with the person making a positive claim, rather than requiring others to disprove it.",
            beginnerExplanation = "From the classical Latin maxim *Ei incumbit probatio qui dicit, non qui negat* ('Proof lies on him who asserts, not on him who denies'). If someone claims a newly invented pill doubles human lifespan, it is their job to provide clinical trial evidence—not everyone else's job to run a lab to prove the pill doesn't work.",
            detailedExplanation = "Rooted in Roman law, classical dialectics, and scientific methodology, the Burden of Proof prevents the 'Argument from Ignorance' (Argumentum ad Ignorantiam)—the fallacy of claiming a proposition is true simply because it has not yet been proven false. Because it is logically impossible in an open universe to prove a universal negative across all space and time (Russell's Teapot), shifting the burden onto skeptics would force us to accept an infinite number of mutually contradictory claims. Furthermore, as Pierre-Simon Laplace ('The weight of evidence for an extraordinary claim must be proportioned to its strangeness') and Carl Sagan ('Extraordinary claims require extraordinary evidence') demonstrated, the required strength of evidence scales with how improbable the claim is relative to established prior knowledge.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Product & Vendor Claims",
                    scenario = "A software vendor claims their proprietary algorithm reduces server costs by 80%. When asked for benchmarks, they reply, 'Well, you can't prove it won't save you 80%!'",
                    analysis = "Illegitimately attempts to shift the burden of verification onto the buyer."
                ),
                EverydayExample(
                    context = "Legal & Workplace Investigations",
                    scenario = "Requiring verifiable documentation before penalising an employee, rather than demanding the employee prove a negative about an unrecorded event.",
                    analysis = "Upholds due process and epistemic fairness."
                )
            ),
            howToRecognise = listOf(
                "Challenges framed as 'Prove me wrong!' or 'Nobody has disproven that X causes Y.'",
                "Treating the current absence of disproof as positive evidence in favour of a claim.",
                "Demanding peer-reviewed refutations for an offhand speculation that was presented with zero evidence."
            ),
            whyItOccurs = "Asymmetry of effort: asserting a bold claim is effortless, while designing empirical studies to test it is costly.",
            howToRespond = listOf(
                "Politely return the burden to where it belongs: 'You may be right—what is the strongest primary evidence that led you to that conclusion?'",
                "Apply Laplace and Sagan's proportional standard: routine claims need routine evidence; extraordinary claims require extraordinary evidence.",
                "Pair with Hitchens's Razor when encountering completely unsupported assertions."
            ),
            relatedConceptIds = listOf("rp_hitchens_razor", "ct_falsifiability", "ct_bayes_theorem", "prop_firehose_falsehood"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Foundational across classical jurisprudence (Corpus Juris Civilis), informal logic (Walton, 2014, 'Burden of Proof, Presumption and Argumentation'), and statistical hypothesis testing (null hypothesis significance testing).",
            sources = listOf(
                SourceReference(
                    title = "Burden of Proof, Presumption and Argumentation",
                    sourceName = "Cambridge University Press",
                    authorsOrYear = "Walton, D. (2014)",
                    url = "https://scholar.google.com/scholar?q=Douglas+Walton+2014+Burden+of+Proof+Presumption+Argumentation"
                ),
                SourceReference(
                    title = "Informal Logic",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Groarke, L. (2022)",
                    url = "https://plato.stanford.edu/entries/logic-informal/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("onus probandi", "sagan standard", "russells teapot", "argument from ignorance", "evidence")
        ),

        ConceptArticle(
            id = "rp_hitchens_razor",
            name = "Hitchens's Razor",
            alternativeNames = listOf("Epistemic Nullification Razor", "Quod Gratis Asseritur"),
            primaryCategory = CollectionCategory.REASONING_PRINCIPLES,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING, CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY),
            subcategories = listOf("Epistemic Razors & Parsimony", "Burden of Proof & Justification"),
            shortDefinition = "An epistemological razor stating: 'What can be asserted without evidence can also be dismissed without evidence.'",
            beginnerExplanation = "If someone makes a sweeping accusation or grand claim and offers zero evidence to back it up, you do not owe them a 20-page research paper to refute it. Pointing out that no evidence has been provided is a complete and sufficient response.",
            detailedExplanation = "A modern English formulation (Christopher Hitchens, 2003, 2007) of the classical Latin scholastic proverb *Quod gratis asseritur, gratis negatur* ('What is freely asserted is freely denied', documented at least since the 19th century), Hitchens's Razor serves as a defensive boundary against Brandolini's Law and the Firehose of Falsehood. Without this principle, any bad-faith interlocutor could paralyse productive inquiry indefinitely simply by inventing bare assertions faster than conscientious researchers can investigate them. Note that Hitchens's Razor dismisses the *unwarranted claim from requiring rebuttal until evidence is supplied*; it does not prove that the opposite of the claim is true.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Internet Rumours & Speculation",
                    scenario = "An anonymous comment claims a trusted open-source library secretly mines cryptocurrency, offering no code line, commit hash, or network log. Maintainers note that the claim contains zero evidence and decline to halt their release cycle.",
                    analysis = "Prevents unsubstantiated noise from hijacking engineering resources."
                ),
                EverydayExample(
                    context = "Meeting Discussions",
                    scenario = "When someone asserts 'Our competitors are all abandoning mobile apps this year' with no source, responding: 'Until we have market data showing that, let's stick to our verified user metrics.'",
                    analysis = "Politely declines to pivot strategy on a bare assertion."
                )
            ),
            howToRecognise = listOf(
                "Sweeping factual or causal claims presented with zero citations, data, or testable mechanisms.",
                "Attempts to trap you into spending hours disproving an off-the-cuff speculation.",
                "Confusing the right to state an opinion with the obligation of others to treat an unsupported factual assertion as established."
            ),
            whyItOccurs = "Protects finite cognitive attention and enforces the Burden of Proof against asymmetric assertion flooding.",
            howToRespond = listOf(
                "Respond calmly and concisely: 'That's a major claim—once you share the data or documentation behind it, I'll be glad to take a look.'",
                "Distinguish personal value preferences (which don't require scientific citations) from empirical claims about the world (which do).",
                "Remember that dismissing an unsupported claim is not the same as proving its negation—stay open if real evidence is later produced."
            ),
            relatedConceptIds = listOf("rp_burden_of_proof", "prop_firehose_falsehood", "rp_occams_razor", "ct_falsifiability"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A classical philosophical and rhetorical canon (*Quod gratis asseritur, gratis negatur*) operationalising the symmetry of epistemic warrant in argumentation theory.",
            sources = listOf(
                SourceReference(
                    title = "Informal Logic",
                    sourceName = "Stanford Encyclopedia of Philosophy",
                    authorsOrYear = "Groarke, L. (2022)",
                    url = "https://plato.stanford.edu/entries/logic-informal/"
                ),
                SourceReference(
                    title = "Burden of Proof, Presumption and Argumentation",
                    sourceName = "Cambridge University Press",
                    authorsOrYear = "Walton, D. (2014)",
                    url = "https://scholar.google.com/scholar?q=Douglas+Walton+2014+Burden+of+Proof+Presumption+Argumentation"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("hitchens", "quod gratis asseritur", "burden of proof", "brandolinis law", "skepticism")
        )
    )
}
