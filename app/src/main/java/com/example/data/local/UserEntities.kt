package com.example.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "article_read_status")
data class ArticleReadStatusEntity(
    @PrimaryKey val articleId: String,
    val isRead: Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val articleId: String,
    val savedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "article_notes")
data class ArticleNoteEntity(
    @PrimaryKey val articleId: String,
    val noteText: String,
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "reading_history")
data class ReadingHistoryEntity(
    @PrimaryKey val articleId: String,
    val lastOpenedAt: Long = System.currentTimeMillis(),
    val openCount: Int = 1
)

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey val query: String,
    val searchedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_collections")
data class UserCollectionEntity(
    @PrimaryKey(autoGenerate = true) val collectionId: Long = 0,
    val name: String,
    val description: String,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(
    tableName = "collection_articles",
    primaryKeys = ["collectionId", "articleId"],
    indices = [Index(value = ["articleId"]), Index(value = ["collectionId"])]
)
data class CollectionArticleCrossRef(
    val collectionId: Long,
    val articleId: String,
    val addedAt: Long = System.currentTimeMillis()
)
