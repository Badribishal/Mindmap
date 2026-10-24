package com.example

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.content.EncyclopediaContentPipeline
import com.example.data.local.MindtrapDatabase
import com.example.data.local.PreferencesManager
import com.example.data.repository.MindtrapRepository
import com.example.model.CollectionCategory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var db: MindtrapDatabase
    private lateinit var repository: MindtrapRepository

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MindtrapDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        repository = MindtrapRepository(db.mindtrapDao(), PreferencesManager(context))
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun `pipeline validates all 15 collections, 82 canonical entries, learning pathways, and 7500 target audit`() {
        val report = EncyclopediaContentPipeline.validatePipeline()
        assertTrue(
            "Pipeline should be valid; duplicates=${report.duplicateIdsDetected}, broken=${report.brokenRelatedLinks}",
            report.isValid
        )
        assertEquals(15, report.totalPrimaryCategoriesCovered)
        assertTrue("Should have at least 80 verified canonical articles", report.totalArticles >= 80)
        assertTrue("Should have at least 150 category memberships", report.totalCategoryMemberships >= 150)
        assertEquals(7500, report.overallTargetMemberships)
        assertEquals(7500 - report.totalCategoryMemberships, report.remainingToOverallTarget)
        assertEquals(15, report.perCategoryAudit.size)
        assertTrue(report.duplicateIdsDetected.isEmpty())
        assertTrue(report.brokenRelatedLinks.isEmpty())

        // Verify all 15 Structured Learning Pathways resolve every article ID
        val pathways = EncyclopediaContentPipeline.learningPathways
        assertEquals(15, pathways.size)
        for (pathway in pathways) {
            assertTrue(pathway.orderedArticleIds.isNotEmpty())
            for (artId in pathway.orderedArticleIds) {
                assertNotNull("Missing pathway article ID: $artId", EncyclopediaContentPipeline.getArticle(artId))
            }
        }

        // Verify Authoritative Source Registry and 20-part article depth
        assertEquals(12, EncyclopediaContentPipeline.sourceRegistry.size)
        for (article in EncyclopediaContentPipeline.allArticles) {
            assertTrue(article.resolvedHistoricalBackground.isNotBlank())
            assertTrue(article.resolvedOriginAndAttribution.isNotBlank())
            assertTrue(article.resolvedTypesAndVariants.isNotEmpty())
            assertTrue(article.resolvedMediaAndPublicExamples.isNotEmpty())
            assertTrue(article.resolvedCommonMisconceptions.isNotEmpty())
            assertTrue(article.resolvedWhyItMatters.isNotBlank())
            assertTrue(article.estimatedReadingMinutes >= 3)
            assertNotNull(EncyclopediaContentPipeline.getSuggestedNextArticle(article))
        }
    }

    @Test
    fun `universal search finds articles by name, synonym, everyday situation, and category`() {
        val byName = EncyclopediaContentPipeline.searchArticles("Confirmation Bias")
        assertTrue(byName.any { it.id == "bias_confirmation" })

        val bySynonym = EncyclopediaContentPipeline.searchArticles("Tu Quoque")
        assertTrue(bySynonym.any { it.id == "fallacy_ad_hominem" || it.id == "prop_whataboutism" })

        val bySituation = EncyclopediaContentPipeline.searchArticles("bomber")
        assertTrue(bySituation.any { it.id == "bias_survivorship" })
    }

    @Test
    fun `random topic discovery avoids consecutive duplicates and prefers unread articles`() {
        val allIds = EncyclopediaContentPipeline.allArticles.map { it.id }.toSet()
        val unreadArticleId = "bias_confirmation"
        val readSetExceptOne = allIds - unreadArticleId

        val picked = EncyclopediaContentPipeline.selectRandomTopic(
            readArticleIds = readSetExceptOne,
            lastSelectedArticleId = "fallacy_ad_hominem"
        )
        assertEquals(unreadArticleId, picked.id)

        var previousId: String? = null
        repeat(15) {
            val next = EncyclopediaContentPipeline.selectRandomTopic(
                readArticleIds = emptySet(),
                lastSelectedArticleId = previousId
            )
            assertNotNull(next)
            if (previousId != null) {
                assertNotEquals(previousId, next.id)
            }
            previousId = next.id
        }
    }

    @Test
    fun `manual read status, bookmarks, notes, search history, and export-import roundtrip work reliably`() = runBlocking {
        val testArticleId = "bias_confirmation"

        // Opening an article records history but MUST NOT mark it as read
        repository.recordArticleOpened(testArticleId)
        assertFalse(testArticleId in repository.readArticleIdsFlow.first())
        assertTrue(repository.readingHistoryArticlesFlow.first().any { it.id == testArticleId })

        // Search history persistence
        repository.recordSearchQuery("Simpson")
        assertTrue("Simpson" in repository.searchHistoryFlow.first())

        // Manually mark as read
        repository.setArticleReadStatus(testArticleId, true)
        assertTrue(testArticleId in repository.readArticleIdsFlow.first())
        assertEquals(1, repository.overallProgressFlow.first().readArticles)

        // Bookmark and Note
        repository.toggleBookmark(testArticleId, currentlyBookmarked = false)
        repository.saveArticleNote(testArticleId, "My critical thinking study note")
        val colId = repository.createUserCollection("Debate Prep", "Fallacies to watch")
        repository.addArticleToUserCollection(colId, testArticleId)

        val exportedJson = repository.exportPersonalDataJson()
        assertTrue(exportedJson.contains("My critical thinking study note"))

        // Clear all and re-import
        repository.clearAllPersonalData()
        assertEquals(0, repository.overallProgressFlow.first().readArticles)

        val importResult = repository.importPersonalDataJson(exportedJson)
        assertTrue(importResult.success)
        assertEquals(1, importResult.readImported)
        assertEquals(1, importResult.bookmarksImported)
        assertEquals(1, importResult.notesImported)
        assertTrue(testArticleId in repository.readArticleIdsFlow.first())
        assertEquals(
            "My critical thinking study note",
            repository.notesByArticleIdFlow.first()[testArticleId]?.noteText
        )
    }

    @Test
    fun `all five navigation destinations and article reader open properly in UI`() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("MINDTRAP").assertIsDisplayed()

        // Navigate to Library
        composeTestRule.onNodeWithTag("nav_tab_library").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("15 Primary Collections").assertIsDisplayed()

        // Navigate to Index
        composeTestRule.onNodeWithTag("nav_tab_index").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("A–Z Master Index").assertIsDisplayed()

        // Navigate to Saved
        composeTestRule.onNodeWithTag("nav_tab_saved").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Saved & Annotations").assertIsDisplayed()

        // Navigate to Settings
        composeTestRule.onNodeWithTag("nav_tab_settings").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("theme_chip_dark").performClick()
        composeTestRule.waitForIdle()

        // Return Home and tap Random Discovery FAB
        composeTestRule.onNodeWithTag("nav_tab_home").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("random_discovery_fab").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("article_reader_screen").assertIsDisplayed()
    }
}
