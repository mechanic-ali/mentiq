package com.example.data.repository

import com.example.data.local.UserProgressDao
import com.example.data.local.UserProgressEntity
import com.example.data.model.Question
import kotlinx.coroutines.flow.Flow

class QuestionRepository(private val dao: UserProgressDao) {
    val allQuestions: List<Question> = (questionsPart1 + questionsPart2 + questionsPart3)
        .sortedBy { it.id }

    fun getQuestionById(id: Int): Question? {
        return allQuestions.find { it.id == id }
    }

    fun getAllProgress(): Flow<List<UserProgressEntity>> {
        return dao.getAllProgress()
    }

    suspend fun saveAnswer(questionId: Int, selectedOption: String, isCorrect: Boolean) {
        val existing = dao.getProgressForQuestion(questionId)
        val updated = existing?.copy(
            selectedOption = selectedOption,
            isCorrect = isCorrect,
            updatedAt = System.currentTimeMillis()
        ) ?: UserProgressEntity(
            questionId = questionId,
            selectedOption = selectedOption,
            isCorrect = isCorrect,
            updatedAt = System.currentTimeMillis()
        )
        dao.upsertProgress(updated)
    }

    suspend fun toggleBookmark(questionId: Int, isBookmarked: Boolean) {
        val existing = dao.getProgressForQuestion(questionId)
        val updated = existing?.copy(
            isBookmarked = isBookmarked,
            updatedAt = System.currentTimeMillis()
        ) ?: UserProgressEntity(
            questionId = questionId,
            isBookmarked = isBookmarked,
            updatedAt = System.currentTimeMillis()
        )
        dao.upsertProgress(updated)
    }

    suspend fun markHintViewed(questionId: Int) {
        val existing = dao.getProgressForQuestion(questionId)
        val updated = existing?.copy(
            hintViewed = true,
            updatedAt = System.currentTimeMillis()
        ) ?: UserProgressEntity(
            questionId = questionId,
            hintViewed = true,
            updatedAt = System.currentTimeMillis()
        )
        dao.upsertProgress(updated)
    }

    suspend fun markExplanationViewed(questionId: Int) {
        val existing = dao.getProgressForQuestion(questionId)
        val updated = existing?.copy(
            explanationViewed = true,
            updatedAt = System.currentTimeMillis()
        ) ?: UserProgressEntity(
            questionId = questionId,
            explanationViewed = true,
            updatedAt = System.currentTimeMillis()
        )
        dao.upsertProgress(updated)
    }

    suspend fun resetProgress() {
        dao.resetAllProgress()
    }
}
