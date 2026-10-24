package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference

object ContentPack6ExtendedEncyclopedia {

    val articles: List<ConceptArticle> = listOf(
        // Collection 1 addition: Slippery Slope / Equivocation
        ConceptArticle(
            id = "fallacy_slippery_slope",
            name = "Slippery Slope Fallacy",
            alternativeNames = listOf("Domino Fallacy", "Camel's Nose Fallacy", "Thin Edge of the Wedge"),
            primaryCategory = CollectionCategory.LOGICAL_FALLACIES,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC, CollectionCategory.COGNITIVE_DISTORTIONS),
            subcategories = listOf("Causal & Statistical Fallacies", "Informal Relevance Fallacies"),
            shortDefinition = "Arguing that accepting a relatively modest initial step will inevitably trigger an unstoppable chain reaction of events leading to a catastrophic extreme, without providing evidence for the intermediate causal links.",
            beginnerExplanation = "A Slippery Slope argument warns that if you allow Step A today, Steps B, C, D, and Z will automatically follow until disaster strikes—ignoring all the brakes, checkpoints, and common-sense rules that can stop the slide along the way.",
            detailedExplanation = "In informal logic (Walton, 2015), a Slippery Slope argument is not *always* fallacious: if an actual mechanical, legal, or psychological feedback loop connects Step A to Step Z (such as Sorites drift or addictive habit formation), pointing out that trajectory is valid Second-Order Thinking. It becomes the Slippery Slope *Fallacy* when a speaker asserts that a multi-step cascade is inevitable while providing zero empirical or logical justification for why each intermediate step must follow, or while ignoring clear stopping points ('bright lines').",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Flexibility Debate",
                    scenario = "'If we allow engineers to shift their start time by 30 minutes for commuter trains, soon people will show up at 2 PM, then stop attending meetings altogether, and the company will collapse.'",
                    analysis = "Assumes that a bounded 30-minute policy removes all management accountability for core hours."
                ),
                EverydayExample(
                    context = "Personal Decision Making",
                    scenario = "'If I let myself take one Saturday afternoon off to rest, I'll lose all my discipline and never finish my degree.'",
                    analysis = "Confuses scheduled recovery with total abandonment of goals."
                )
            ),
            howToRecognise = listOf(
                "A chain of four or more hypothetical 'if... then...' steps presented as a 100% certainty.",
                "No mechanism is provided to explain why people cannot simply stop at Step B.",
                "Emotional catastrophe is placed at the end of the chain to trigger fear rather than evaluate Step A on its own merits."
            ),
            whyItOccurs = "Combines Catastrophizing with the Representativeness Heuristic: a vivid narrative chain feels plausible even though multiplying the probability of 6 uncertain steps ($0.5^6 = 1.5\\%$) makes the final outcome highly unlikely.",
            howToRespond = listOf(
                "Inspect each link in the chain individually: 'What specific mechanism forces Step B to lead to Step C?'",
                "Design an explicit Bright-Line Rule or stopping guardrail at Step A so the slope cannot slide.",
                "Distinguish genuine systemic feedback loops from unsupported fear appeals."
            ),
            relatedConceptIds = listOf("para_sorites", "cd_catastrophizing", "mm_second_order", "fallacy_false_dilemma"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Extensively classified in argumentation theory (Walton, 2015) and tested in cognitive psychology studies on consequentialist reasoning (Corner, Hahn, & Oaksford, 2011).",
            sources = listOf(
                SourceReference(
                    title = "Slippery Slope Arguments",
                    sourceName = "Oxford University Press / Informal Logic",
                    authorsOrYear = "Walton, D. (1992 / 2015)",
                    url = "https://scholar.google.com/scholar?q=Douglas+Walton+Slippery+Slope+Arguments"
                ),
                SourceReference(
                    title = "The slippery slope argument – probability, utility & categoryncertainty",
                    sourceName = "Cognition (PubMed)",
                    authorsOrYear = "Corner, A., Hahn, U., & Oaksford, M. (2011)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21288516/"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("domino effect", "chain reaction", "bright line", "walton", "catastrophe")
        ),

        // Collection 2 addition: Cognitive Dissonance
        ConceptArticle(
            id = "bias_cognitive_dissonance",
            name = "Cognitive Dissonance & Rationalisation",
            alternativeNames = listOf("Post-Decision Dissonance", "Effort Justification", "Sour Grapes Rationalisation"),
            primaryCategory = CollectionCategory.COGNITIVE_BIASES,
            secondaryCategories = listOf(CollectionCategory.PSYCHOLOGICAL_PHENOMENA, CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Belief & Confirmation Biases", "Evaluation & Attribution Biases"),
            shortDefinition = "The state of mental discomfort experienced when holding two contradictory beliefs—or when one's actions conflict with one's values—which drives people to unconsciously alter their attitudes or invent rationalisations to restore inner harmony.",
            beginnerExplanation = "Aesop told the fable of a fox who tried to reach high grapes, failed, and walked away muttering, 'I bet those grapes are sour anyway.' When our actions and beliefs clash, we feel an uncomfortable mental itch (dissonance)—and instead of admitting a mistake, we often rewrite our beliefs to make ourselves feel right.",
            detailedExplanation = "Formulated by Leon Festinger in 1957 and tested in his famous experiment with J. Merrill Carlsmith (1959), Cognitive Dissonance Theory is one of the most influential frameworks in social psychology. In Festinger & Carlsmith's experiment, participants performed a boring peg-turning task for an hour and were then paid either $1 or $20 to tell the next waiting participant that the task was fun. Paradoxically, those paid only $1 later rated the boring task as genuinely *more enjoyable* than those paid $20! Why? Because $20 provided a clear external justification for telling a white lie ('I did it for the $20'), whereas $1 was insufficient external justification—forcing the $1 group to resolve their internal dissonance ('I am an honest person, yet I just said the task was fun') by convincing themselves the task really wasn't bad.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Post-Purchase Rationalisation (Buyer's Stockholm Syndrome)",
                    scenario = "After spending $2,000 on a non-refundable laptop with a cramped keyboard, a buyer spends weeks reading glowing reviews of that exact model and insisting to friends that the cramped keyboard actually 'improves typing posture.'",
                    analysis = "Upgrades the evaluation of the chosen option after the fact to eliminate post-purchase regret."
                ),
                EverydayExample(
                    context = "Effort Justification in Clubs & Bootcamps",
                    scenario = "Participants who endure an exhausting, grueling application process for a mediocre committee rate the committee as far more prestigious and valuable than members who joined effortlessly.",
                    analysis = "Believing 'I suffered for nothing' is painful, so the mind inflates the value of the group to justify the suffering."
                )
            ),
            howToRecognise = listOf(
                "Suddenly disparaging an opportunity, job, or person only *after* learning you didn't get it ('Sour Grapes').",
                "Defending a tedious, outdated process because you spent years mastering it (Effort Justification).",
                "Feeling a flash of defensiveness or anger before even finishing reading a fact that conflicts with a lifestyle habit."
            ),
            whyItOccurs = "Neuroimaging studies show that cognitive conflict activates the dorsal anterior cingulate cortex (dACC), triggering aversive arousal that the brain resolves by adjusting the path of least resistance—usually changing a subjective attitude rather than undoing an irreversible past action.",
            howToRespond = listOf(
                "Notice defensive discomfort as a helpful diagnostic signal: 'Wait—am I defending this choice because the evidence is strong, or because I already committed to it?'",
                "Practice Self-Affirmation: reminding yourself of your core values and overall competence makes it much easier to admit a specific mistake without feeling threatened.",
                "Separate evaluating the quality of an outcome from the effort it took to get there."
            ),
            relatedConceptIds = listOf("dme_escalation_commitment", "bias_confirmation", "bias_belief_perseverance", "pr_foot_in_the_door"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Leon Festinger (1957, 'A Theory of Cognitive Dissonance') and Festinger & Carlsmith (1959), and replicated across more than six decades of behavioural and neuroimaging research (Harmon-Jones & Mills, 2019).",
            sources = listOf(
                SourceReference(
                    title = "Cognitive consequences of forced compliance",
                    sourceName = "The Journal of Abnormal and Social Psychology (PubMed)",
                    authorsOrYear = "Festinger, L. & Carlsmith, J. M. (1959)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/13640824/"
                ),
                SourceReference(
                    title = "An Introduction to Cognitive Dissonance Theory and an Overview of Current Perspectives on the Theory",
                    sourceName = "American Psychological Association",
                    authorsOrYear = "Harmon-Jones, E. & Mills, J. (2019)",
                    url = "https://scholar.google.com/scholar?q=Harmon+Jones+Mills+2019+Introduction+Cognitive+Dissonance+Theory"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("festinger", "rationalisation", "sour grapes", "effort justification", "self justification")
        ),

        // Collection 3 addition: Guilt Tripping & Emotional Blackmail
        ConceptArticle(
            id = "manip_emotional_blackmail",
            name = "Emotional Blackmail (FOG)",
            alternativeNames = listOf("Fear, Obligation, and Guilt Pressure", "Coercive Guilt Tripping"),
            primaryCategory = CollectionCategory.PSYCHOLOGICAL_MANIPULATION,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC),
            subcategories = listOf("Relational & Emotional Pressure", "Boundary Erosion & Coercive Tactics"),
            shortDefinition = "A form of relational manipulation in which someone uses Fear, Obligation, and Guilt ('FOG') to punish or prevent another person from setting normal, healthy personal boundaries.",
            beginnerExplanation = "Healthy communication states requests directly ('I'd love your help on Saturday if you're free') and accepts 'no' respectfully. Emotional blackmail turns a 'no' into a test of love or loyalty: 'If you really cared about this family/team, you wouldn't even ask for the weekend off.'",
            detailedExplanation = "Conceptualised in clinical interpersonal psychology by Susan Forward (1997), emotional blackmail operates by creating a dense 'FOG'—Fear (of anger, withdrawal, or retaliation), Obligation (appeals to duty distorted beyond reasonable reciprocity), and Guilt (blaming the target for the manipulator's own emotional regulation). Regardless of whether the tactic uses overt anger or quiet martyr-like suffering ('Fine, I'll just stay here alone in the dark and do all the work myself'), the core structure is identical: holding the relationship's peace hostage until the target surrenders their boundary.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Workplace Overwork Pressure",
                    scenario = "When an engineer declines unpaid Sunday overtime due to family plans, a manager sighs: 'I guess some of us actually care whether this team survives, and some of us clock out at 5.'",
                    analysis = "Equates a healthy contractual boundary with disloyalty and betrayal of peers."
                ),
                EverydayExample(
                    context = "Interpersonal Martyrdom",
                    scenario = "'After everything I sacrificed for you ten years ago, you won't even cancel your business trip for my dinner party?'",
                    analysis = "Uses historical gifts as permanent leverage to override current obligations."
                )
            ),
            howToRecognise = listOf(
                "Conditionals framed as 'If you really loved/respected me, you would [comply immediately].'",
                "Ordinary personal boundaries are treated as cruel personal attacks.",
                "Feeling surrounded by Fear, Obligation, and Guilt (FOG) whenever you express an independent preference."
            ),
            whyItOccurs = "Exploits conscientiousness, empathy, and attachment security; compliance immediately relieves the short-term tension, which inadvertently reinforces the manipulator's use of guilt next time.",
            howToRespond = listOf(
                "Use non-defensive boundary statements: 'I care about our relationship/team, AND I am not available this Sunday.'",
                "Pause before answering high-pressure demands: 'Let me think about that and get back to you tomorrow' breaks the immediate emotional urgency.",
                "Allow the other person to own their own disappointment without rushing to rescue them by sacrificing your boundary."
            ),
            relatedConceptIds = listOf("manip_gaslighting", "manip_darvo", "cd_emotional_reasoning", "pr_door_in_the_face"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A clinical descriptive framework (Forward, 1997) grounded in established empirical research on guilt induction in interpersonal compliance (Baumeister, Stillwell, & Heatherton, 1994).",
            sources = listOf(
                SourceReference(
                    title = "Guilt: an interpersonal approach",
                    sourceName = "Psychological Bulletin (PubMed)",
                    authorsOrYear = "Baumeister, R. F., Stillwell, A. M., & Heatherton, T. F. (1994)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/8165271/"
                ),
                SourceReference(
                    title = "Emotional Blackmail: When the People in Your Life Use Fear, Obligation, and Guilt to Manipulate You",
                    sourceName = "HarperCollins",
                    authorsOrYear = "Forward, S. & Frazier, D. (1997)",
                    url = "https://scholar.google.com/scholar?q=Susan+Forward+1997+Emotional+Blackmail"
                )
            ),
            reviewStatus = ReviewStatus.CROSS_REFERENCED,
            keywords = listOf("guilt trip", "fear obligation guilt", "fog", "boundaries", "coercion")
        ),

        // Collection 5 addition: Mind Reading
        ConceptArticle(
            id = "cd_mind_reading",
            name = "Mind Reading (Cognitive Distortion)",
            alternativeNames = listOf("Arbitrary Inference", "Jumping to Conclusions — Mind Reading"),
            primaryCategory = CollectionCategory.COGNITIVE_DISTORTIONS,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY),
            subcategories = listOf("Predictive & Interpretive Leaps"),
            shortDefinition = "Assuming with certainty that you know what another person is thinking or why they acted—usually projecting negative judgment toward yourself—without asking or checking the evidence.",
            beginnerExplanation = "Someone walks past you in the hallway without smiling or replies to your message with a single 'Ok.' Mind Reading immediately fills in the blank: 'They're mad at me and think my idea was stupid'—when in reality they were squinting because they forgot their glasses or rushing into a dentist appointment.",
            detailedExplanation = "Classified by Aaron Beck (1976) as a primary subtype of 'Jumping to Conclusions' (alongside Fortune Telling), Mind Reading occurs when we project our own internal insecurities onto ambiguous social cues and treat that projection as telepathic fact. Because we rarely stop to test our mind-reading assumptions—often withdrawing or acting defensive toward the other person based on what we *assume* they think—Mind Reading can easily trigger a self-fulfilling interpersonal loop.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Digital Messaging",
                    scenario = "A colleague replies 'Sure.' with a period at the end of the text, and you spend the afternoon convinced they resent working with you.",
                    analysis = "Treats ambiguous punctuation habits as direct telepathic evidence of hostility."
                ),
                EverydayExample(
                    context = "Giving a Presentation",
                    scenario = "Seeing an audience member furrow their brow and immediately concluding 'They think I'm incompetent,' when they are actually concentrating hard on a chart.",
                    analysis = "Misinterprets focused cognitive effort as disapproval."
                )
            ),
            howToRecognise = listOf(
                "Stating as a fact 'She thinks I'm...', 'He only said that because...', or 'They all noticed...' without any direct statement from them.",
                "Reacting coldly to someone based on an imagined slight you never verified.",
                "Assuming silence equals rejection."
            ),
            whyItOccurs = "Human Theory of Mind evolved to infer others' intentions rapidly, but under stress or social anxiety, ambiguous cues default to threat-protective negative interpretations (Hostile or Self-Referential Attribution).",
            howToRespond = listOf(
                "Generate three benign alternative explanations for the person's behaviour (e.g., tired, distracted by another project, in a rush).",
                "Replace mind-reading assumptions with direct, calm communication: 'Hey, I noticed you were quiet during the review—did you have any concerns about the timeline?'",
                "Pair with Hanlon's Razor and the Spotlight Effect."
            ),
            relatedConceptIds = listOf("phen_spotlight_effect", "rp_hanlons_razor", "sp_fundamental_attribution", "cd_catastrophizing"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Validated in Aaron Beck's cognitive therapy research (1976) and experimental social cognition studies on 'illusion of transparency' and accuracy of interpersonal perception (Kenny, 1994; Epley, 2014).",
            sources = listOf(
                SourceReference(
                    title = "Mindwise: Why We Misunderstand What Others Think, Believe, Feel, and Want",
                    sourceName = "Knopf / University of Chicago",
                    authorsOrYear = "Epley, N. (2014)",
                    url = "https://scholar.google.com/scholar?q=Nicholas+Epley+2014+Mindwise+Misunderstand+What+Others+Think"
                ),
                SourceReference(
                    title = "Cognitive Therapy and the Emotional Disorders",
                    sourceName = "International Universities Press",
                    authorsOrYear = "Beck, A. T. (1976)",
                    url = "https://scholar.google.com/scholar?q=Aaron+Beck+1976+Cognitive+Therapy+and+the+Emotional+Disorders"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("jumping to conclusions", "projection", "social anxiety", "telepathy", "epley")
        ),

        // Collection 9 addition: Lateral Reading & Source Verification
        ConceptArticle(
            id = "prop_lateral_reading",
            name = "Lateral Reading",
            alternativeNames = listOf("Civic Online Reasoning", "Cross-Source Triangulation"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Source Verification & Digital Literacy"),
            shortDefinition = "A media literacy verification method in which a reader evaluates the credibility of an unfamiliar website or claim not by reading 'vertically' down the page itself, but by immediately leaving the page to open new tabs and see what independent, authoritative sources say about the organisation and claim.",
            beginnerExplanation = "When university professors and students want to check if a website is trustworthy, they often make the mistake of staying on the website—looking at its 'About Us' page, its polished logo, and its long list of links ('vertical reading'). Professional fact-checkers do the opposite: within seconds, they open a new tab and search who funds the site and what independent experts say about it ('lateral reading').",
            detailedExplanation = "Discovered in empirical think-aloud studies by Sam Wineburg and Sarah McGrew (2017, 2019) at the Stanford History Education Group, Lateral Reading explains why professional fact-checkers reliably outperform both undergraduate students and PhD historians when evaluating unfamiliar online sources. Staying inside a website ('vertical reading') leaves the reader vulnerable to the Halo Effect of sleek web design, fabricated 'About' pages, and self-referential citations. By reading *laterally* across the open web—checking who owns the domain, examining peer-reviewed consensus on PubMed or Google Scholar, and tracing a quoted statistic back to its original primary dataset—readers verify context in a fraction of the time.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Evaluating an Unfamiliar Research Institute",
                    scenario = "Encountering a slickly formatted PDF report from the 'Institute for Nutritional Integrity.' Instead of reading its 30 pages of charts, opening a new tab to search the institute's name and discovering in 20 seconds that it is a PR front funded by a single beverage lobby.",
                    analysis = "Lateral verification reveals institutional conflict of interest before biased framing can take hold."
                ),
                EverydayExample(
                    context = "Tracing a Viral Statistic",
                    scenario = "Seeing a dramatic chart shared on social media, searching the exact study title on Google Scholar, and finding that the viral post cropped out half the chart.",
                    analysis = "Recovers the primary source context."
                )
            ),
            howToRecognise = listOf(
                "Leaving an unfamiliar article within 15 seconds to verify the author, publisher, and primary source in separate tabs.",
                "Practising 'Click Restraint'—scanning a full page of search results to see which authoritative domains appear before clicking the top flashy headline.",
                "Distinguishing sponsored native content from independent peer-reviewed reporting."
            ),
            whyItOccurs = "Counteracts the Halo Effect of visual polish and the Illusory Truth Effect of self-contained narratives.",
            howToRespond = listOf(
                "When encountering a surprising claim from an unfamiliar outlet, open a new tab and ask three questions: (1) Who is behind this information? (2) What is the primary evidence? (3) What do other independent sources say?",
                "Practice Click Restraint on search results: read the domain URLs and snippets across the first ten results before clicking.",
                "Trace hyperlinks all the way back to the original scientific paper or public dataset."
            ),
            relatedConceptIds = listOf("prop_illusory_truth", "prop_firehose_falsehood", "bias_halo_effect", "rp_burden_of_proof"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated in controlled empirical studies by Wineburg & McGrew (2019) in Teachers College Record and replicated in large-scale digital literacy interventions (Breakstone et al., 2021).",
            sources = listOf(
                SourceReference(
                    title = "Lateral Reading and the Nature of Expertise: Reading Less and Learning More When Evaluating Digital Information",
                    sourceName = "Teachers College Record (Stanford History Education Group)",
                    authorsOrYear = "Wineburg, S. & McGrew, S. (2019)",
                    url = "https://scholar.google.com/scholar?q=Wineburg+McGrew+2019+Lateral+Reading+Nature+of+Expertise"
                ),
                SourceReference(
                    title = "Lateral reading: College students learn to critically evaluate internet sources in an online course",
                    sourceName = "Harvard Kennedy School Misinformation Review",
                    authorsOrYear = "Breakstone, J. et al. (2021)",
                    url = "https://scholar.google.com/scholar?q=Breakstone+Wineburg+2021+Lateral+reading+college+students"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("fact checking", "media literacy", "wineburg", "click restraint", "verification")
        ),

        // Collection 10 addition: Goodhart's Law / Paradox of Control
        ConceptArticle(
            id = "para_goodharts_law",
            name = "Goodhart's Law & Campbell's Law",
            alternativeNames = listOf("Metric Gaming Paradox", "Target Corruption Principle"),
            primaryCategory = CollectionCategory.PHILOSOPHICAL_AND_LOGICAL_PARADOXES,
            secondaryCategories = listOf(CollectionCategory.MENTAL_MODELS, CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Decision & Social Paradoxes", "Systems & Strategic Thinking"),
            shortDefinition = "The systemic paradox that 'when a measure becomes a target, it ceases to be a good measure'—because high-stakes pressure to maximise a proxy metric causes people to game the metric at the expense of the underlying goal.",
            beginnerExplanation = "A thermometer is a wonderful tool for measuring the temperature of a room. But if you tell a building manager, 'We will pay you a $10,000 bonus if that thermometer reads 72°F all winter,' they can simply hold a lighter under the glass bulb while the rest of the building freezes. Once a measurement becomes a high-stakes target, people optimise the number instead of the reality.",
            detailedExplanation = "Formulated by British economist Charles Goodhart in 1975 regarding monetary policy (and succinctly restated by anthropologist Marilyn Strathern in 1997 as 'When a measure becomes a target, it ceases to be a good measure'), Goodhart's Law is closely paired with psychologist Donald T. Campbell's Law (1976): 'The more any quantitative social indicator is used for social decision-making, the more subject it will be to corruption pressures and the more apt it will be to distort and corrupt the social processes it is intended to monitor.' Because every metric is a simplified 'map' of a complex 'territory,' applying intense financial or reputational pressure to a single metric incentivises agents to exploit the gap between the proxy and the real goal.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Academic & Hospital Rankings",
                    scenario = "Ranking surgeons solely by post-operative survival percentages leads some hospitals to turn away high-risk, critically ill patients who urgently need surgery in order to protect their scorecard.",
                    analysis = "Optimising the survival metric harms overall patient welfare."
                ),
                EverydayExample(
                    context = "Software Engineering",
                    scenario = "Measuring developer productivity by 'lines of code written' leads to bloated, repetitive code instead of concise refactoring.",
                    analysis = "The proxy metric diverges immediately from software quality."
                )
            ),
            howToRecognise = listOf(
                "A single KPI or dashboard number is tied directly to bonuses, promotions, or penalties.",
                "Metrics are improving rapidly on paper while actual user or citizen experience feels worse.",
                "Employees spending significant creative energy figuring out how to classify work to fit the scorecard."
            ),
            whyItOccurs = "Any single scalar metric captures only a projection of a multi-dimensional goal; under high stakes, rational agents follow the path of least resistance to move the number.",
            howToRespond = listOf(
                "Use balanced paired metrics ('Tension Metrics'): pair a speed metric (e.g., call resolution time) with a quality counter-metric (e.g., customer issue fully solved on first contact).",
                "Keep diagnostic metrics informational rather than turning every thermometer into a high-stakes quota.",
                "Combine quantitative dashboards with qualitative audits (The Map Is Not the Territory)."
            ),
            relatedConceptIds = listOf("mm_map_not_territory", "mm_second_order", "dme_escalation_commitment", "heur_satisficing"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formulated by Goodhart (1975), Campbell (1976), and Strathern (1997), and extensively studied in economics, healthcare policy, and AI alignment research (Manheim & Garrabrant, 2018).",
            sources = listOf(
                SourceReference(
                    title = "Assessing the impact of planned social change (Campbell's Law)",
                    sourceName = "Evaluation and Program Planning",
                    authorsOrYear = "Campbell, D. T. (1979)",
                    url = "https://scholar.google.com/scholar?q=Donald+Campbell+1979+Assessing+impact+planned+social+change"
                ),
                SourceReference(
                    title = "'Improving ratings': audit in the British University system",
                    sourceName = "European Review",
                    authorsOrYear = "Strathern, M. (1997)",
                    url = "https://scholar.google.com/scholar?q=Marilyn+Strathern+1997+Improving+ratings+audit+when+a+measure+becomes+a+target"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("goodhart", "campbells law", "kpi", "metrics", "cobra effect", "incentives")
        ),

        // Collection 12 addition: Rosy Retrospection & Zeigarnik / Source Amnesia
        ConceptArticle(
            id = "mem_source_amnesia",
            name = "Source Monitoring Error & Cryptomnesia",
            alternativeNames = listOf("Source Amnesia", "Sleeper Effect Driver", "Unconscious Plagiarism"),
            primaryCategory = CollectionCategory.MEMORY_BIASES,
            secondaryCategories = listOf(CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY, CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Source & Attribution Memory"),
            shortDefinition = "Recalling a piece of information, idea, or melody while forgetting—or misattributing—where, when, or from whom it was originally learned.",
            beginnerExplanation = "Have you ever shared an interesting 'fact' at dinner, only to pause and realise you have no idea whether you read it in a peer-reviewed journal or saw it in a fictional movie trailer? That separation between *what* you remember and *where* you learned it is a Source Monitoring Error.",
            detailedExplanation = "Researched extensively by Marcia K. Johnson, Shahin Hashtroudi, and D. Stephen Lindsay (1993), the Source Monitoring Framework explains that memories do not come stamped with an indelible bibliographic label. Instead, when we retrieve a memory, we reconstruct its origin using heuristics based on its sensory detail and familiarity. This leads to two striking phenomena: (1) The Sleeper Effect in persuasion — where a message from an untrustworthy tabloid is initially discounted, but weeks later the tabloid tag fades while the message remains, causing belief in the message to rise over time; and (2) Cryptomnesia (unconscious plagiarism) — where a creator genuinely believes they just invented a brand-new melody, joke, or idea that they actually heard years earlier.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Creative Brainstorming (Cryptomnesia)",
                    scenario = "During a Tuesday meeting, a colleague suggests an idea you pitched last month, genuinely believing it just popped into their head as an original insight.",
                    analysis = "Semantic content ('the idea is good') was retained in memory while the episodic source tag ('who said it last month') faded."
                ),
                EverydayExample(
                    context = "Media Literacy (The Sleeper Effect)",
                    scenario = "Remembering a health claim as credible six months after seeing it in a satirical post, because the memory of the satirical banner has vanished.",
                    analysis = "Dissociation between the content trace and the discounting cue."
                )
            ),
            howToRecognise = listOf(
                "Recalling a statistic or quote vividly while being completely unable to recall the publication or context.",
                "Blending details from a historical drama film with actual historical textbook facts.",
                "Assuming a familiar-sounding idea is your own original creation."
            ),
            whyItOccurs = "In human brain architecture, semantic content (the 'what', mediated by temporal-cortical networks) and episodic source context (the 'where/when', requiring hippocampal and prefrontal binding) decay at different rates.",
            howToRespond = listOf(
                "When taking study or research notes, always record the citation URL and author right next to the quote immediately.",
                "Apply Hanlon's Razor when someone repeats your idea in a meeting—often it is genuine cryptomnesia rather than calculated theft.",
                "Never pass along a dramatic claim that 'I read somewhere' without re-verifying the primary source first."
            ),
            relatedConceptIds = listOf("prop_illusory_truth", "mem_misinformation_effect", "rp_hanlons_razor", "bias_belief_perseverance"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Formalised by Johnson, Hashtroudi, & Lindsay (1993) in Psychological Bulletin and studied in unconscious plagiarism experiments by Brown & Murphy (1989).",
            sources = listOf(
                SourceReference(
                    title = "Source monitoring",
                    sourceName = "Psychological Bulletin (PubMed)",
                    authorsOrYear = "Johnson, M. K., Hashtroudi, S., & Lindsay, D. S. (1993)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/8346328/"
                ),
                SourceReference(
                    title = "Cryptomnesia: Delineating inadvertent plagiarism",
                    sourceName = "Journal of Experimental Psychology: Learning, Memory, and Cognition",
                    authorsOrYear = "Brown, A. S. & Murphy, D. R. (1989)",
                    url = "https://scholar.google.com/scholar?q=Brown+Murphy+1989+Cryptomnesia+Delineating+inadvertent+plagiarism"
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("source amnesia", "cryptomnesia", "sleeper effect", "marcia johnson", "plagiarism")
        )
    )
}
