package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.UserProgressEntity
import com.example.data.model.Question
import com.example.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class QuizUiState(
    val currentQuestionIndex: Int = 0,
    val isQuizMode: Boolean = true, // true = Quiz sınaq rejimi, false = Tədris/Həll izahı rejimi
    val isHintExpanded: Boolean = false,
    val isExplanationExpanded: Boolean = false,
    val isNavigatorOpen: Boolean = false,
    val isDarkMode: Boolean = false
)

class QuizViewModel(private val repository: QuestionRepository) : ViewModel() {

    val allQuestions: List<Question> = repository.allQuestions

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    val progressMap: StateFlow<Map<Int, UserProgressEntity>> = repository.getAllProgress()
        .combine(MutableStateFlow(Unit)) { list, _ ->
            list.associateBy { it.questionId }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyMap()
        )

    val currentQuestion: Question
        get() = allQuestions.getOrElse(_uiState.value.currentQuestionIndex) { allQuestions.first() }

    fun selectOption(optionLetter: String) {
        val q = currentQuestion
        val isCorrect = (optionLetter.equals(q.correctOption, ignoreCase = true))

        viewModelScope.launch {
            repository.saveAnswer(q.id, optionLetter, isCorrect)
        }

        // In quiz mode, automatically expand explanation after answering so student can immediately inspect the logic
        _uiState.value = _uiState.value.copy(
            isExplanationExpanded = true
        )
    }

    fun toggleBookmark() {
        val q = currentQuestion
        val currentProgress = progressMap.value[q.id]
        val newBookmark = !(currentProgress?.isBookmarked ?: false)

        viewModelScope.launch {
            repository.toggleBookmark(q.id, newBookmark)
        }
    }

    fun toggleHint() {
        val current = _uiState.value.isHintExpanded
        _uiState.value = _uiState.value.copy(isHintExpanded = !current)
        if (!current) {
            viewModelScope.launch {
                repository.markHintViewed(currentQuestion.id)
            }
        }
    }

    fun toggleExplanation() {
        val current = _uiState.value.isExplanationExpanded
        _uiState.value = _uiState.value.copy(isExplanationExpanded = !current)
        if (!current) {
            viewModelScope.launch {
                repository.markExplanationViewed(currentQuestion.id)
            }
        }
    }

    fun toggleMode() {
        val newMode = !_uiState.value.isQuizMode
        _uiState.value = _uiState.value.copy(
            isQuizMode = newMode,
            isExplanationExpanded = !newMode // auto show explanation in Study mode
        )
    }

    fun toggleNavigator() {
        _uiState.value = _uiState.value.copy(isNavigatorOpen = !_uiState.value.isNavigatorOpen)
    }

    fun toggleTheme() {
        _uiState.value = _uiState.value.copy(isDarkMode = !_uiState.value.isDarkMode)
    }

    fun goToQuestion(id: Int) {
        val index = allQuestions.indexOfFirst { it.id == id }
        if (index != -1) {
            _uiState.value = _uiState.value.copy(
                currentQuestionIndex = index,
                isHintExpanded = false,
                isExplanationExpanded = !_uiState.value.isQuizMode, // auto open in study mode
                isNavigatorOpen = false
            )
        }
    }

    fun nextQuestion() {
        if (_uiState.value.currentQuestionIndex < allQuestions.size - 1) {
            _uiState.value = _uiState.value.copy(
                currentQuestionIndex = _uiState.value.currentQuestionIndex + 1,
                isHintExpanded = false,
                isExplanationExpanded = !_uiState.value.isQuizMode
            )
        }
    }

    fun previousQuestion() {
        if (_uiState.value.currentQuestionIndex > 0) {
            _uiState.value = _uiState.value.copy(
                currentQuestionIndex = _uiState.value.currentQuestionIndex - 1,
                isHintExpanded = false,
                isExplanationExpanded = !_uiState.value.isQuizMode
            )
        }
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetProgress()
            _uiState.value = _uiState.value.copy(
                isHintExpanded = false,
                isExplanationExpanded = false
            )
        }
    }
}
