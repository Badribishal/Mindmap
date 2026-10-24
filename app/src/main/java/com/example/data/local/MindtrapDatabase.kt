package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        ArticleReadStatusEntity::class,
        BookmarkEntity::class,
        ArticleNoteEntity::class,
        ReadingHistoryEntity::class,
        SearchHistoryEntity::class,
        UserCollectionEntity::class,
        CollectionArticleCrossRef::class
    ],
    version = 2,
    exportSchema = false
)
abstract class MindtrapDatabase : RoomDatabase() {
    abstract fun mindtrapDao(): MindtrapDao

    companion object {
        @Volatile
        private var INSTANCE: MindtrapDatabase? = null

        fun getInstance(context: Context): MindtrapDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MindtrapDatabase::class.java,
                    "mindtrap_atlas.db"
                )
                    .fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
