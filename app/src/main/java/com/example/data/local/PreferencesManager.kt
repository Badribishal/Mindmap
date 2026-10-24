package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.ui.theme.ReadingFontSize
import com.example.ui.theme.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mindtrap_preferences")

data class UserPreferencesState(
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val readingFontSize: ReadingFontSize = ReadingFontSize.MEDIUM,
    val showEvidenceBadgesInLists: Boolean = true,
    val expandExamplesByDefault: Boolean = true,
    val dailyReadingGoal: Int = 2 // 0 = Off, 1..5 = calm daily target (non-punitive)
)

class PreferencesManager(private val context: Context) {

    companion object {
        private val KEY_THEME_MODE = stringPreferencesKey("theme_mode")
        private val KEY_FONT_SIZE = stringPreferencesKey("reading_font_size")
        private val KEY_SHOW_EVIDENCE = booleanPreferencesKey("show_evidence_badges")
        private val KEY_EXPAND_EXAMPLES = booleanPreferencesKey("expand_examples_default")
        private val KEY_DAILY_GOAL = intPreferencesKey("daily_reading_goal")
    }

    val preferencesFlow: Flow<UserPreferencesState> = context.dataStore.data.map { prefs ->
        val themeStr = prefs[KEY_THEME_MODE] ?: ThemeMode.SYSTEM.name
        val fontStr = prefs[KEY_FONT_SIZE] ?: ReadingFontSize.MEDIUM.name
        val showEvidence = prefs[KEY_SHOW_EVIDENCE] ?: true
        val expandExamples = prefs[KEY_EXPAND_EXAMPLES] ?: true
        val dailyGoal = (prefs[KEY_DAILY_GOAL] ?: 2).coerceIn(0, 10)

        UserPreferencesState(
            themeMode = runCatching { ThemeMode.valueOf(themeStr) }.getOrDefault(ThemeMode.SYSTEM),
            readingFontSize = runCatching { ReadingFontSize.valueOf(fontStr) }.getOrDefault(ReadingFontSize.MEDIUM),
            showEvidenceBadgesInLists = showEvidence,
            expandExamplesByDefault = expandExamples,
            dailyReadingGoal = dailyGoal
        )
    }

    suspend fun setThemeMode(mode: ThemeMode) {
        context.dataStore.edit { it[KEY_THEME_MODE] = mode.name }
    }

    suspend fun setReadingFontSize(size: ReadingFontSize) {
        context.dataStore.edit { it[KEY_FONT_SIZE] = size.name }
    }

    suspend fun setShowEvidenceBadges(show: Boolean) {
        context.dataStore.edit { it[KEY_SHOW_EVIDENCE] = show }
    }

    suspend fun setExpandExamplesByDefault(expand: Boolean) {
        context.dataStore.edit { it[KEY_EXPAND_EXAMPLES] = expand }
    }

    suspend fun setDailyReadingGoal(goal: Int) {
        context.dataStore.edit { it[KEY_DAILY_GOAL] = goal.coerceIn(0, 10) }
    }
}
