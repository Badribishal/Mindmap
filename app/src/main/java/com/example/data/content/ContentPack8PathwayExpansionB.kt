package com.example.data.content

import com.example.model.CollectionCategory
import com.example.model.ConceptArticle
import com.example.model.DifficultyLevel
import com.example.model.EverydayExample
import com.example.model.EvidenceLevel
import com.example.model.ReviewStatus
import com.example.model.SourceReference
import com.example.model.SourceType

object ContentPack8PathwayExpansionB {

    val articles: List<ConceptArticle> = listOf(
        // ==========================================
        // 6. MENTAL MODELS ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "mm_pareto_principle",
            name = "Pareto Principle & Power Law Distributions",
            alternativeNames = listOf("80/20 Rule", "Law of the Vital Few", "Zipfian / Power-Law Asymmetry"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Probabilistic and Expected-Value Models", "Systems Thinking and Feedback Loops"),
            shortDefinition = "The observation that in many complex systems governed by multiplicative feedback, roughly 80% of outcomes or effects flow from 20% of the inputs or causes.",
            beginnerExplanation = "Not all tasks, bugs, or customers contribute equally. While a bell curve (normal distribution) describes things like human height where everyone clusters near the average, a Power Law (Pareto distribution) describes systems where a tiny handful of 'vital few' inputs produce the vast majority of results.",
            detailedExplanation = "First observed by Italian economist Vilfredo Pareto (1896) regarding land ownership and generalised to quality engineering by Joseph M. Juran (1941, who coined 'the vital few and the trivial many'), the Pareto Principle reflects underlying Power Law (P(X > x) ~ x^(-alpha)) dynamics. Note that 80% and 20% don't have to sum to 100%—they are two separate axes (e.g., 15% of software bugs may cause 85% of crashes). Recognising when you are operating in a Pareto environment prevents the error of treating all to-do list items as equally important.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Software Reliability Engineering",
                    scenario = "Microsoft's engineering telemetry famously revealed that fixing the top 20% most-reported bugs eliminated 80% of total system crashes experienced by users.",
                    analysis = "Prioritising by crash frequency yields exponentially higher stability than fixing bugs in random order."
                ),
                EverydayExample(
                    context = "Language & Study",
                    scenario = "In most natural languages, the top 1,000 most frequent words account for roughly 80% of everyday conversational text (Zipf's Law).",
                    analysis = "Mastering high-frequency core vocabulary unlocks comprehension fastest."
                )
            ),
            howToRecognise = listOf(
                "A small number of root causes account for the majority of support tickets, revenue, or delays.",
                "Treating 20 minor tasks as equivalent to 1 foundational bottleneck.",
                "Multiplicative or preferential-attachment systems (cities, citations, network traffic)."
            ),
            whyItOccurs = "Preferential attachment, compounding feedback loops, and multiplicative variance produce heavy-tailed Pareto distributions rather than Gaussian bell curves.",
            howToRespond = listOf(
                "Before starting a busy week, ask: 'Which 20% of my planned tasks will generate 80% of the real value?'",
                "In root-cause analysis, use a Pareto Chart to rank defect categories by frequency before allocating engineering hours.",
                "Avoid misapplying 80/20 to safety-critical checklists where 100% of steps are mandatory."
            ),
            relatedConceptIds = listOf("mm_first_principles", "mm_margin_of_safety", "heur_satisficing", "para_goodharts_law"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Mathematically formalised in Pareto distributions (Pareto, 1896) and power-law analyses in complex networks (Clauset, Shalizi, & Newman, 2009, SIAM Review).",
            sources = listOf(
                SourceReference(
                    title = "Power-Law Distributions in Empirical Data",
                    sourceName = "SIAM Review",
                    authorsOrYear = "Clauset, A., Shalizi, C. R., & Newman, M. E. J. (2009)",
                    url = "https://scholar.google.com/scholar?q=Clauset+Shalizi+Newman+2009+Power+Law+Distributions+Empirical+Data",
                    publicationYear = "2009",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Juran's Quality Handbook (The Vital Few and the Useful Many)",
                    sourceName = "McGraw-Hill",
                    authorsOrYear = "Juran, J. M. (1951 / 1999)",
                    url = "https://scholar.google.com/scholar?q=Joseph+Juran+Vital+Few+Pareto+Principle",
                    publicationYear = "1999",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("80 20 rule", "power law", "juran", "pareto", "prioritisation")
        ),

        ConceptArticle(
            id = "mm_margin_of_safety",
            name = "Margin of Safety & Redundancy",
            alternativeNames = listOf("Engineering Buffer Principle", "Fault Tolerance Margin"),
            primaryCategory = CollectionCategory.MENTAL_MODELS,
            secondaryCategories = listOf(CollectionCategory.DECISION_MAKING_ERRORS),
            subcategories = listOf("Engineering Redundancy and Margin of Safety", "Epistemic Boundaries and Competence Mapping"),
            shortDefinition = "Designing systems, budgets, schedules, and valuations to withstand loads and disruptions significantly worse than expected average conditions.",
            beginnerExplanation = "If an engineer calculates that the heaviest truck crossing a bridge will weigh 10 tons, they never build the bridge to snap at 10.1 tons—they build it to hold 30 or 40 tons. That extra capacity between expected load and failure is the Margin of Safety.",
            detailedExplanation = "Originating in structural engineering (Factor of Safety) and adapted to financial risk management by Benjamin Graham (1949), the Margin of Safety acknowledges that our forecasts of the future are always subject to model error, unforeseen shocks, and the Planning Fallacy. A system optimised for 100% efficiency under ideal sunny conditions has zero resilience when an unexpected storm hits. Building deliberate buffers in time, capital, server capacity, and sleep absorbs tail-risk variance without catastrophic failure.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Travel & High-Stakes Deadlines",
                    scenario = "Arriving at the airport two hours before an international flight rather than timing your arrival for 60 seconds before the boarding gate closes.",
                    analysis = "Trades a small, predictable wait time to eliminate the catastrophic tail risk of missing the flight due to a 15-minute traffic jam."
                ),
                EverydayExample(
                    context = "Cloud Infrastructure",
                    scenario = "Provisioning server clusters with auto-scaling headroom and multi-zone failover rather than running every node at 99% CPU utilisation.",
                    analysis = "Prevents cascading outages during traffic spikes."
                )
            ),
            howToRecognise = listOf(
                "Plans or budgets that fail completely if even a single assumption slips by 10%.",
                "Confusing unused buffer capacity with 'waste.'",
                "Sizing Margin of Safety proportionally to how uncertain and irreversible the stakes are."
            ),
            whyItOccurs = "Optimism Bias and short-term efficiency pressures tempt planners to strip away buffers during calm periods.",
            howToRespond = listOf(
                "Scale your buffer to your uncertainty: the less reliable your forecast, the larger your Margin of Safety must be.",
                "Protect personal cognitive margin by avoiding back-to-back 100% calendar booking.",
                "Pair with Reference Class Forecasting to size realistic timeline reserves."
            ),
            relatedConceptIds = listOf("dme_planning_fallacy", "bias_optimism", "mm_inversion", "mm_circle_of_competence"),
            evidenceLevel = EvidenceLevel.INFORMAL_CONCEPT,
            scientificEvidenceAndLimitations = "A foundational canon in reliability engineering (High Reliability Theory; Weick & Sutcliffe, 2001) and financial risk analysis (Graham, 1949).",
            sources = listOf(
                SourceReference(
                    title = "Managing the Unexpected: Resilient Performance in an Age of Uncertainty",
                    sourceName = "Jossey-Bass / University of Michigan",
                    authorsOrYear = "Weick, K. E. & Sutcliffe, K. M. (2001)",
                    url = "https://scholar.google.com/scholar?q=Weick+Sutcliffe+2001+Managing+the+Unexpected",
                    publicationYear = "2001",
                    sourceType = SourceType.MONOGRAPH_BOOK
                ),
                SourceReference(
                    title = "The Intelligent Investor (Chapter 20: 'Margin of Safety' as the Central Concept)",
                    sourceName = "Harper & Brothers",
                    authorsOrYear = "Graham, B. (1949)",
                    url = "https://scholar.google.com/scholar?q=Benjamin+Graham+1949+Margin+of+Safety",
                    publicationYear = "1949",
                    sourceType = SourceType.MONOGRAPH_BOOK
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("redundancy", "buffer", "resilience", "factor of safety", "benjamin graham")
        ),

        // ==========================================
        // 7. HEURISTICS ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "heur_recognition",
            name = "Recognition Heuristic",
            alternativeNames = listOf("Fast-and-Frugal Recognition Rule", "Ignorance-Driven Inference"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Recognition and Fluency Heuristics", "Fast-and-Frugal Decision Trees"),
            shortDefinition = "A fast-and-frugal heuristic stating that if one of two alternatives is recognised and the other is not, we infer that the recognised alternative has the higher value with respect to the criterion.",
            beginnerExplanation = "When German students were asked 'Which city has a larger population: San Diego or San Antonio?', they guessed right more often than American students! Why? Because the German students had heard of San Diego and had never heard of San Antonio, allowing them to use the simple Recognition Heuristic ('pick the name you recognise'), whereas American students recognised both cities and got bogged down in conflicting details.",
            detailedExplanation = "Formulated by Daniel Goldstein and Gerd Gigerenzer (2002) at the Max Planck Institute for Human Development, the Recognition Heuristic is a prime example of 'Ecological Rationality'—where a simple mental shortcut exploits the structure of the environment to make accurate inferences with minimal computation. Whenever media and cultural mentions correlate positively with a criterion (such as city population, university size, or tournament seedings), merely recognising one name and not the other yields rapid, surprisingly accurate judgments (' the less-is-more effect'). However, it fails when recognition is driven by notoriety, scandal, or paid advertising rather than quality.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Consumer Brand Choice",
                    scenario = "Standing in a pharmacy aisle in a foreign country and picking the one cold medicine brand name you recognise over five unfamiliar brands.",
                    analysis = "Substitutes brand recognition for chemical comparison."
                ),
                EverydayExample(
                    context = "Sports & Geography Predictions",
                    scenario = "Predicting the winner of a Wimbledon tennis match by picking the player whose name you have heard before.",
                    analysis = "In Goldstein & Gigerenzer's studies, recognition predicted tennis outcomes nearly as well as official ATP rankings."
                )
            ),
            howToRecognise = listOf(
                "Choosing an option immediately because its name is familiar while alternatives are unknown.",
                "Advertising campaigns that simply display a brand logo on stadium boards without making any specific product claim.",
                "Assuming name recognition equals competence in technical or political selections."
            ),
            whyItOccurs = "Adaptive exploitation of environmental statistical correlations between criterion size and environmental mention frequency.",
            howToRespond = listOf(
                "Ask: 'Is recognition correlated with genuine quality in this specific environment, or just with marketing budget and controversy?'",
                "In consumer and hiring decisions, evaluate unrecognized candidates on objective rubrics so familiar names don't win by default.",
                "Distinguish ecological environments where fast-and-frugal heuristics work from adversarial marketing environments."
            ),
            relatedConceptIds = listOf("heur_fluency", "heur_availability", "prop_illusory_truth", "heur_satisficing"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Goldstein & Gigerenzer (2002) in Psychological Review and extensively debated and tested in judgment and decision-making literature (Pachur et al., 2011).",
            sources = listOf(
                SourceReference(
                    title = "Models of ecological rationality: the recognition heuristic",
                    sourceName = "Psychological Review (PubMed)",
                    authorsOrYear = "Goldstein, D. G. & Gigerenzer, G. (2002)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/11863042/",
                    publicationYear = "2002",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "The recognition heuristic: A review of theory and tests",
                    sourceName = "Frontiers in Psychology (PubMed)",
                    authorsOrYear = "Pachur, T., Todd, P. M., Gigerenzer, G., Schooler, L. J., & Goldstein, D. G. (2011)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/21779264/",
                    publicationYear = "2011",
                    sourceType = SourceType.META_ANALYSIS
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("gigerenzer", "fast and frugal", "ecological rationality", "less is more", "familiarity")
        ),

        ConceptArticle(
            id = "heur_fluency",
            name = "Fluency Heuristic (Processing Ease)",
            alternativeNames = listOf("Cognitive Ease Shortcut", "Perceptual & Retrieval Fluency"),
            primaryCategory = CollectionCategory.HEURISTICS,
            secondaryCategories = listOf(CollectionCategory.COGNITIVE_BIASES, CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY),
            subcategories = listOf("Recognition and Fluency Heuristics", "Effort-Reduction and Attribute Substitution"),
            shortDefinition = "Judging statements, names, or visual designs that are easier and faster to mentally read, pronounce, or process as more truthful, safer, and more valuable than hard-to-process alternatives.",
            beginnerExplanation = "When text is printed in crisp, high-contrast ink or a company name is easy to pronounce, our brain processes it smoothly ('high cognitive ease'). Without our noticing, we misattribute that pleasant feeling of smooth reading to the *content* itself—judging easy-to-read claims as truer and easy-to-pronounce stocks as safer.",
            detailedExplanation = "Investigated by Danny Oppenheimer, Adam Alter, Norbert Schwarz, and Rolf Reber, the Fluency Heuristic encompasses visual perceptual fluency, linguistic pronounceability, and conceptual fluency. Alter and Oppenheimer (2006) famously demonstrated that newly listed stocks with easily pronounceable ticker symbols (like 'KAR') outperformed unpronounceable tickers (like 'RDO') in their first days of trading because investors felt greater cognitive ease. Conversely, mild 'disfluency' (such as a slightly unfamiliar font or problem format) can sometimes trigger slower, more analytical System 2 scrutiny.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Visual Typography & Trust",
                    scenario = "The exact same historical trivia fact is rated as significantly more likely to be true when printed in high-contrast dark charcoal on warm white paper than when printed in low-contrast light yellow on white.",
                    analysis = "Visual legibility (perceptual fluency) is misattributed to factual accuracy."
                ),
                EverydayExample(
                    context = "Rhyme-as-Reason Effect",
                    scenario = "A proverb phrased with a neat rhyme ('Woes unite foes') is judged as more insightful and accurate than an identical non-rhyming statement ('Troubles cause enemies to unite').",
                    analysis = "Acoustic fluency enhances perceived truth (McGlone & Tofighbakhsh, 2000)."
                )
            ),
            howToRecognise = listOf(
                "Trusting a claim because it is phrased in a catchy rhyme, aphorism, or slick infographic.",
                "Judging a complex technical explanation as 'untrustworthy' solely because the terminology is unfamiliar.",
                "Preferring options with simpler names without comparing underlying specifications."
            ),
            whyItOccurs = "Metacognitive misattribution: the brain monitors its own processing speed and uses 'cognitive ease' as an all-purpose signal of safety, familiarity, and truth.",
            howToRespond = listOf(
                "Separate presentation polish from evidentiary substance: ask 'If this catchy aphorism were written in plain prose, would the data still hold up?'",
                "When communicating your own valid research or software designs, maximise readability and clarity so unnecessary disfluency doesn't obscure your work.",
                "Slow down to engage analytical System 2 verification when evaluating sleek, high-fluency pitches."
            ),
            relatedConceptIds = listOf("prop_illusory_truth", "heur_recognition", "heur_availability", "bias_halo_effect"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated by Reber & Schwarz (1999) on perceptual contrast and truth, McGlone & Tofighbakhsh (2000) on rhyme-as-reason, and Alter & Oppenheimer (2009) in Psychological Review.",
            sources = listOf(
                SourceReference(
                    title = "Uniting the tribes of fluency to form a metacognitive nation",
                    sourceName = "Personality and Social Psychology Review (PubMed)",
                    authorsOrYear = "Alter, A. L. & Oppenheimer, D. M. (2009)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/19638628/",
                    publicationYear = "2009",
                    sourceType = SourceType.META_ANALYSIS
                ),
                SourceReference(
                    title = "Effects of perceptual fluency on judgments of truth",
                    sourceName = "Consciousness and Cognition (PubMed)",
                    authorsOrYear = "Reber, R. & Schwarz, N. (1999)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/10487787/",
                    publicationYear = "1999",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("cognitive ease", "pronounceability", "rhyme as reason", "oppenheimer", "schwarz")
        ),

        // ==========================================
        // 8. PERSUASION & 9. MEDIA LITERACY ADDITIONS
        // ==========================================
        ConceptArticle(
            id = "pr_social_proof",
            name = "Social Proof & Informational Influence",
            alternativeNames = listOf("Herd Behaviour Cue", "Consensus Persuasion Principle"),
            primaryCategory = CollectionCategory.PERSUASION_AND_RHETORIC,
            secondaryCategories = listOf(CollectionCategory.SOCIAL_PSYCHOLOGY, CollectionCategory.HEURISTICS),
            subcategories = listOf("Social Proof and Authority Cues", "Social Imitation and Default Heuristics"),
            shortDefinition = "The psychological and persuasive principle that when people are uncertain how to act or choose in a situation, they look to the visible actions and endorsements of others—especially peers similar to themselves—to determine the correct behaviour.",
            beginnerExplanation = "When you walk past two restaurants in an unfamiliar city—one completely empty and the other bustling with locals—you naturally assume the busy restaurant has better food. Looking to what others are doing when we lack direct information is Social Proof.",
            detailedExplanation = "Identified by Robert Cialdini (1984) as one of the core principles of influence and grounded in Muzafer Sherif's (1935) and Solomon Asch's (1951) social psychology experiments, Social Proof operates most powerfully under two conditions: (1) Uncertainty — when a situation is ambiguous or unfamiliar; and (2) Similarity — when the observed reference group shares our identity or context. In Goldstein, Cialdini, and Griskevicius's (2008) famous hotel towel experiment, a sign reading '75% of guests who stayed in this exact room reused their towels' outperformed standard environmental appeals by leveraging descriptive peer norms. However, social proof can also backfire ('boomerang effect') if a message inadvertently normalises undesirable behaviour ('Last year 80% of people failed to file on time').",
            everydayExamples = listOf(
                EverydayExample(
                    context = "E-Commerce & Software Adoption",
                    scenario = "Displaying verified download counts, star ratings, or 'Most Popular Plan' badges on a pricing table.",
                    analysis = "Reduces buyer uncertainty by signalling collective validation."
                ),
                EverydayExample(
                    context = "Negative Descriptive Norm Boomerang",
                    scenario = "In Arizona's Petrified Forest, a sign reading 'Many past visitors have removed petrified wood from the park, changing the natural state' actually *increased* theft—because it inadvertently provided social proof that stealing wood was common!",
                    analysis = "Highlighting how common a problem is can accidentally normalise the behaviour (Cialdini et al., 2006)."
                )
            ),
            howToRecognise = listOf(
                "Persuasive appeals emphasising 'Millions of users,' 'Best-selling,' or '9 out of 10 peers choose X.'",
                "Manufactured or fake reviews (Astroturfing) designed to simulate organic consensus.",
                "Public health campaigns that accidentally normalize a bad habit by stressing how widespread it is."
            ),
            whyItOccurs = "Informational social influence: in ancestral and everyday environments, collective behaviour often aggregates useful distributed knowledge at low personal cost.",
            howToRespond = listOf(
                "Verify whether apparent popularity is organic or manufactured (check independent review distributions and Astroturfing signals).",
                "Remember that crowds can form 'Information Cascades' where everyone copies the first two people without independent verification.",
                "When designing positive civic campaigns, highlight the positive norm of what most people do right rather than publicising how many people break the rule."
            ),
            relatedConceptIds = listOf("prop_astroturfing", "sp_bystander_effect", "sp_groupthink", "pr_foot_in_the_door"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Demonstrated in field experiments by Goldstein, Cialdini, & Griskevicius (2008) in the Journal of Consumer Research and Cialdini et al. (2006) in Social Influence.",
            sources = listOf(
                SourceReference(
                    title = "A Room with a Viewpoint: Using Social Norms to Motivate Environmental Conservation in Hotels",
                    sourceName = "Journal of Consumer Research",
                    authorsOrYear = "Goldstein, N. J., Cialdini, R. B., & Griskevicius, V. (2008)",
                    url = "https://scholar.google.com/scholar?q=Goldstein+Cialdini+Griskevicius+2008+Room+with+a+Viewpoint",
                    publicationYear = "2008",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Managing social norms for persuasive impact",
                    sourceName = "Social Influence",
                    authorsOrYear = "Cialdini, R. B. et al. (2006)",
                    url = "https://scholar.google.com/scholar?q=Cialdini+2006+Managing+social+norms+persuasive+impact",
                    publicationYear = "2006",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("cialdini", "herd behaviour", "social norms", "conformity", "reviews")
        ),

        ConceptArticle(
            id = "pr_inoculation_theory",
            name = "Inoculation Theory (Pre-Bunking)",
            alternativeNames = listOf("Attitudinal Inoculation", "Psychological Pre-Bunking"),
            primaryCategory = CollectionCategory.PERSUASION_AND_RHETORIC,
            secondaryCategories = listOf(CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY, CollectionCategory.CRITICAL_THINKING),
            subcategories = listOf("Inoculation Theory and Pre-Bunking", "Misinformation and Disinformation Dynamics"),
            shortDefinition = "Building cognitive resistance against future manipulative persuasion or misinformation by exposing people beforehand to a weakened dose of the deceptive argument along with clear refutations.",
            beginnerExplanation = "Just as a medical vaccine exposes your immune system to a weakened version of a virus so your body builds antibodies before meeting the real virus, Psychological Inoculation ('pre-bunking') forewarns you of a manipulation trick and shows a weak example of it—so you instantly spot and resist it in the wild.",
            detailedExplanation = "Formulated by social psychologist William J. McGuire in 1961 (originally inspired by researching how to help people resist coercive ideological persuasion) and extended to modern digital misinformation by Sander van der Linden and John Cook, Inoculation Theory consists of two core components: (1) Threat / Forewarning — alerting the reader that their independent judgment is about to be targeted by a persuasive manipulation attempt, which wakes up critical vigilance; and (2) Refutational Preemption — presenting a micro-dose of the manipulative technique (such as fake experts, false dilemmas, or emotional scapegoating) paired with the tools to dismantle it.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Cybersecurity Phishing Training",
                    scenario = "Showing employees a simulated phishing email that uses artificial 15-minute urgency and spoofed sender headers, so they immediately recognize the real attack three weeks later.",
                    analysis = "Technique-based pre-bunking builds transferable recognition."
                ),
                EverydayExample(
                    context = "Public Science Communication",
                    scenario = "Explaining the 'Fake Expert' and 'Cherry-Picked Short Timeframe' techniques before audiences encounter misleading viral graphs.",
                    analysis = "Inoculates against the underlying rhetorical structure rather than chasing individual myths after they go viral."
                )
            ),
            howToRecognise = listOf(
                "Educational briefings that forewarn audiences of specific rhetorical tricks before exposure.",
                "Technique-based inoculation (teaching how Straw Man or Astroturfing works) that transfers across many different topics.",
                "Contrast with post-hoc Debunking, which struggles against Belief Perseverance after a myth has already taken root."
            ),
            whyItOccurs = "Forewarning motivates counter-arguing (activating System 2 defenses), and refutational practice provides accessible schemas in working memory.",
            howToRespond = listOf(
                "Prefer Pre-Bunking over reactive Debunking whenever preparing teams, students, or citizens for high-noise topics.",
                "Focus inoculation on universal *manipulation techniques* (like emotional language, false dichotomies, and cherry-picking) rather than memorising thousands of isolated rumours.",
                "Review MINDTRAP entries periodically as a cognitive inoculation exercise."
            ),
            relatedConceptIds = listOf("prop_firehose_falsehood", "prop_illusory_truth", "bias_belief_perseverance", "prop_lateral_reading"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Initiated by McGuire (1961) in the Journal of Abnormal and Social Psychology, meta-analysed across 54 studies by Banas & Rains (2010), and validated at scale on millions of viewers by Roozenbeek, van der Linden, et al. (2022) in Science Advances.",
            sources = listOf(
                SourceReference(
                    title = "The relative efficacy ofvarious types of prior belief-defense in producing immunity against persuasion",
                    sourceName = "Journal of Abnormal and Social Psychology (PubMed)",
                    authorsOrYear = "McGuire, W. J. & Papageorgis, D. (1961)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/13773992/",
                    publicationYear = "1961",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                ),
                SourceReference(
                    title = "Psychological inoculation improves resilience against misinformation on social media",
                    sourceName = "Science Advances (PubMed)",
                    authorsOrYear = "Roozenbeek, J., van der Linden, S., Goldberg, B., Rathje, S., & Lewandowsky, S. (2022)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/36001675/",
                    publicationYear = "2022",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("prebunking", "mcguire", "van der linden", "vaccine", "misinformation resilience")
        ),

        ConceptArticle(
            id = "prop_cherry_picking",
            name = "Cherry Picking (Fallacy of Incomplete Evidence)",
            alternativeNames = listOf("Suppressing Evidence", "Selective Citation", "Slanting"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.LOGICAL_FALLACIES, CollectionCategory.COGNITIVE_BIASES),
            subcategories = listOf("Statistical and Visual Data Distortion", "Evidence and Claims Verification"),
            shortDefinition = "Selectively presenting only individual data points, time windows, or studies that support a predetermined conclusion while withholding or ignoring the larger body of available evidence that contradicts it.",
            beginnerExplanation = "When picking cherries from a basket for a photo, you pick only the brightest, ripest ones and leave the bruised ones hidden at the bottom. In argument and media, Cherry Picking means zooming in on a tiny, flattering 2-week slice of a chart while hiding the 10-year trend line.",
            detailedExplanation = "In logic and scientific methodology, the Principle of Total Evidence (formulated by philosopher Rudolf Carnap, 1947) states that when estimating probability or evaluating an inductive argument, we must consider *all* relevant available evidence—not merely a curated subset. Cherry Picking violates this principle even when every individual cherry-picked fact is technically true in isolation! Common forms include: (1) Endpoint Cherry-Picking — starting a financial or temperature graph on an unusually high or low outlier day to manufacture a fake trend; (2) Publication / Citation Bias — citing 2 small preliminary studies while omitting 30 larger replications that found null results; and (3) Anecdotal Selection — highlighting three happy customers out of 5,000.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "Financial & Stock Charts",
                    scenario = "A fund manager advertises 'Up 40% since March 23!' while hiding the 5-year chart showing the fund dropped 50% the month before March 23 and is still down overall.",
                    analysis = "Selects a convenient trough date as the starting anchor to manufacture an upward slope."
                ),
                EverydayExample(
                    context = "Resume & Marketing Quotes",
                    scenario = "A movie poster quotes a critic saying '...breathtakingly ambitious...' when the full sentence was 'While breathtakingly ambitious in budget, the script is incoherent.'",
                    analysis = "Crops out surrounding context to invert the reviewer's actual conclusion."
                )
            ),
            howToRecognise = listOf(
                "Charts that start at an odd, non-standard date (e.g., 'Since April 14, 2021') rather than standard 1-year, 5-year, or 10-year intervals.",
                "Arguments that cite a single isolated study on a heavily researched topic instead of a systematic review or meta-analysis.",
                "Omission of denominators, control groups, or full-cohort results."
            ),
            whyItOccurs = "Intentional persuasion spin or unintentional Confirmation Bias when researchers only search for supportive citations.",
            howToRespond = listOf(
                "Apply Carnap's Principle of Total Evidence: ask 'What does the full time-series chart or systematic meta-analysis show?'",
                "Zoom out on any graph: check what happened immediately before the chosen start date.",
                "Prefer pre-registered systematic reviews (such as Cochrane reviews) over single hand-picked papers."
            ),
            relatedConceptIds = listOf("bias_confirmation", "fallacy_texas_sharpshooter", "bias_survivorship", "prop_lateral_reading"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Grounded in Rudolf Carnap's (1947, 1950) Principle of Total Evidence in inductive logic and extensively studied in medical meta-research on selective outcome reporting (Ioannidis, 2005; Goldacre, 2012).",
            sources = listOf(
                SourceReference(
                    title = "Logical Foundations of Probability (The Requirement of Total Evidence)",
                    sourceName = "University of Chicago Press",
                    authorsOrYear = "Carnap, R. (1950)",
                    url = "https://scholar.google.com/scholar?q=Rudolf+Carnap+1950+Logical+Foundations+of+Probability+Total+Evidence",
                    publicationYear = "1950",
                    sourceType = SourceType.MONOGRAPH_BOOK
                ),
                SourceReference(
                    title = "Empirical evaluation of selective reporting of outcomes in randomized trials",
                    sourceName = "JAMA (PubMed)",
                    authorsOrYear = "Chan, A. W., Hróbjartsson, A., Haahr, M. T., Gøtzsche, P. C., & Altman, D. G. (2004)",
                    url = "https://pubmed.ncbi.nlm.nih.gov/15161896/",
                    publicationYear = "2004",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("selective reporting", "incomplete evidence", "carnap", "meta analysis", "misleading charts")
        ),

        ConceptArticle(
            id = "prop_astroturfing",
            name = "Astroturfing & Manufactured Consensus",
            alternativeNames = listOf("Synthetic Grassroots Campaign", "Coordinated Inauthentic Behaviour"),
            primaryCategory = CollectionCategory.PROPAGANDA_AND_MEDIA_LITERACY,
            secondaryCategories = listOf(CollectionCategory.PERSUASION_AND_RHETORIC, CollectionCategory.PSYCHOLOGICAL_MANIPULATION),
            subcategories = listOf("Classical and Modern Propaganda Techniques", "Online Scams and Deceptive Interfaces"),
            shortDefinition = "The deceptive practice of disguising an orchestrated commercial, political, or PR campaign as a spontaneous, organic 'grassroots' movement of ordinary citizens or independent customers.",
            beginnerExplanation = "Named after AstroTurf (artificial plastic grass designed to look like real grass), Astroturfing happens when a company or lobby group pays for hundreds of fake customer reviews, automated bot accounts, or front groups with citizen-sounding names so the public thinks 'everyone in my community supports this.'",
            detailedExplanation = "Studied in communication sociology and computational propaganda research (Howard, Woolley, & Calo, 2018; Keller et al., 2020), Astroturfing exploits two cognitive vulnerabilities simultaneously: Social Proof (people trust peer consensus) and the Illusory Truth Effect (hearing the same talking point from twenty 'independent' voices builds familiarity). Unlike transparent advertising—where the sponsor's name is disclosed so audiences can weigh commercial interest—astroturfing conceals the principal sponsor to bypass source skepticism.",
            everydayExamples = listOf(
                EverydayExample(
                    context = "E-Commerce & App Store Reviews",
                    scenario = "A newly launched product suddenly receives 400 five-star reviews within two hours, all using nearly identical phrasing and posted by accounts created on the same day.",
                    analysis = "Simulates organic customer satisfaction to trigger Social Proof."
                ),
                EverydayExample(
                    context = "Public Policy Comment Periods",
                    scenario = "A corporate lobbyist funds the 'Citizens' Alliance for Neighbourhood Energy' and submits 50,000 automated form letters to regulators.",
                    analysis = "Masks concentrated institutional lobbying as widespread civic grassroots sentiment."
                )
            ),
            howToRecognise = listOf(
                "Sudden bursts of identically worded comments or reviews arriving within a narrow timestamp window.",
                "Organisations with warm 'Citizens for X' names that disclose zero board members, funding sources, or physical history.",
                "Accounts that only interact with a single commercial or political talking point."
            ),
            whyItOccurs = "Hijacks the Social Proof heuristic while concealing institutional conflicts of interest.",
            howToRespond = listOf(
                "Apply Lateral Reading: search who registered the domain and who funds the coalition.",
                "Inspect the distribution and specificity of product reviews (verified long-term reviews with specific pros and cons are harder to fake than generic 5-star praise).",
                "Evaluate arguments on their primary evidence rather than apparent comment-section volume."
            ),
            relatedConceptIds = listOf("pr_social_proof", "prop_lateral_reading", "prop_illusory_truth", "prop_firehose_falsehood"),
            evidenceLevel = EvidenceLevel.WELL_SUPPORTED,
            scientificEvidenceAndLimitations = "Documented in political communication and computational social science research (Keller, Schoch, Stier, & Yang, 2020; Walker, 2014, 'Grassroots for Hire', Cambridge University Press).",
            sources = listOf(
                SourceReference(
                    title = "Grassroots for Hire: Public Affairs Consultants in American Democracy",
                    sourceName = "Cambridge University Press",
                    authorsOrYear = "Walker, E. T. (2014)",
                    url = "https://scholar.google.com/scholar?q=Edward+Walker+2014+Grassroots+for+Hire+Cambridge",
                    publicationYear = "2014",
                    sourceType = SourceType.MONOGRAPH_BOOK
                ),
                SourceReference(
                    title = "Political Astroturfing on Twitter: How to Coordinate a Disinformation Campaign",
                    sourceName = "Political Communication",
                    authorsOrYear = "Keller, F. B., Schoch, D., Stier, S., & Yang, J. (2020)",
                    url = "https://scholar.google.com/scholar?q=Keller+Schoch+Stier+Yang+2020+Political+Astroturfing",
                    publicationYear = "2020",
                    sourceType = SourceType.PEER_REVIEWED_JOURNAL
                )
            ),
            reviewStatus = ReviewStatus.VERIFIED_ACADEMIC,
            keywords = listOf("fake reviews", "bots", "grassroots", "sockpuppets", "social proof")
        )
    )
}
