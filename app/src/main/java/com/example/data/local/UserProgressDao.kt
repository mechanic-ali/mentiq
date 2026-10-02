package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgressDao {
    @Query("SELECT * FROM user_progress")
    fun getAllProgress(): Flow<List<UserProgressEntity>>

    @Query("SELECT * FROM user_progress WHERE questionId = :id")
    suspend fun getProgressForQuestion(id: Int): UserProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: UserProgressEntity)

    @Query("UPDATE user_progress SET isBookmarked = :isBookmarked WHERE questionId = :questionId")
    suspend fun updateBookmark(questionId: Int, isBookmarked: Boolean)

    @Query("DELETE FROM user_progress")
    suspend fun resetAllProgress()
}
