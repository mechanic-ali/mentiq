package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey val questionId: Int,
    val selectedOption: String? = null,
    val isCorrect: Boolean = false,
    val isBookmarked: Boolean = false,
    val hintViewed: Boolean = false,
    val explanationViewed: Boolean = false,
    val updatedAt: Long = System.currentTimeMillis()
)
