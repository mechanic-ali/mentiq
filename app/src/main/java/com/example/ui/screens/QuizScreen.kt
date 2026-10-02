package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.UserProgressEntity
import com.example.data.model.Question
import com.example.ui.components.*
import com.example.ui.viewmodel.QuizUiState
import com.example.ui.viewmodel.QuizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val progressMap by viewModel.progressMap.collectAsState()

    val currentQuestion = viewModel.currentQuestion
    val currentProgress = progressMap[currentQuestion.id]

    val totalAnswered = remember(progressMap) {
        progressMap.values.count { it.selectedOption != null }
    }
    val correctCount = remember(progressMap) {
        progressMap.values.count { it.isCorrect }
    }
    val wrongCount = remember(progressMap) {
        progressMap.values.count { it.selectedOption != null && !it.isCorrect }
    }

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val isTablet = maxWidth >= 600.dp

        if (isTablet) {
            // Adaptive Two-Pane Layout for Tablet (e.g. Redmi Pad 2 SE 9.7")
            TabletTwoPaneLayout(
                viewModel = viewModel,
                uiState = uiState,
                progressMap = progressMap,
                currentQuestion = currentQuestion,
                currentProgress = currentProgress,
                totalAnswered = totalAnswered,
                correctCount = correctCount,
                wrongCount = wrongCount
            )
        } else {
            // Mobile Single-Pane Layout (e.g. Redmi Note 12)
            PhoneSinglePaneLayout(
                viewModel = viewModel,
                uiState = uiState,
                progressMap = progressMap,
                currentQuestion = currentQuestion,
                currentProgress = currentProgress,
                totalAnswered = totalAnswered,
                correctCount = correctCount,
                wrongCount = wrongCount
            )
        }

        // Bottom Sheet Navigator for Mobile
        if (!isTablet && uiState.isNavigatorOpen) {
            ModalBottomSheet(
                onDismissRequest = { viewModel.toggleNavigator() },
                sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .navigationBarsPadding()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Suallar Kataloqu (1-91)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(onClick = { viewModel.toggleNavigator() }) {
                            Icon(Icons.Default.Close, contentDescription = "Bağla")
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    QuestionNavigator(
                        allQuestions = viewModel.allQuestions,
                        currentQuestionId = currentQuestion.id,
                        progressMap = progressMap,
                        onSelectQuestion = { id ->
                            viewModel.goToQuestion(id)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhoneSinglePaneLayout(
    viewModel: QuizViewModel,
    uiState: QuizUiState,
    progressMap: Map<Int, UserProgressEntity>,
    currentQuestion: Question,
    currentProgress: UserProgressEntity?,
    totalAnswered: Int,
    correctCount: Int,
    wrongCount: Int
) {
    val scrollState = rememberLazyListState()

    // Reset scroll position when question changes
    LaunchedEffect(currentQuestion.id) {
        scrollState.scrollToItem(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Məntiq Quiz • ${currentQuestion.id}/91",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (uiState.isQuizMode) "Sınaq Rejimi" else "Tədris & İzah Rejimi",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    // Bookmark button
                    IconButton(
                        onClick = { viewModel.toggleBookmark() },
                        modifier = Modifier.testTag("bookmark_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (currentProgress?.isBookmarked == true) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Əlfəcin",
                            tint = if (currentProgress?.isBookmarked == true) Color(0xFFF59E0B) else MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Mode switch button
                    IconButton(
                        onClick = { viewModel.toggleMode() },
                        modifier = Modifier.testTag("mode_switch_button")
                    ) {
                        Icon(
                            imageVector = if (uiState.isQuizMode) Icons.Default.School else Icons.Default.Quiz,
                            contentDescription = "Rejimi dəyiş",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    // Navigator menu button
                    IconButton(
                        onClick = { viewModel.toggleNavigator() },
                        modifier = Modifier.testTag("open_navigator_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.GridView,
                            contentDescription = "Bütün suallar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars),
                tonalElevation = 6.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalButton(
                        onClick = { viewModel.previousQuestion() },
                        enabled = uiState.currentQuestionIndex > 0,
                        modifier = Modifier.testTag("prev_question_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Əvvəlki")
                    }

                    OutlinedButton(
                        onClick = { viewModel.toggleNavigator() },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.testTag("jump_question_button")
                    ) {
                        Text("${currentQuestion.id} / 91", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { viewModel.nextQuestion() },
                        enabled = uiState.currentQuestionIndex < viewModel.allQuestions.size - 1,
                        modifier = Modifier.testTag("next_question_button")
                    ) {
                        Text("Növbəti")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Stats bar
            item {
                ProgressBarCard(
                    answered = totalAnswered,
                    total = viewModel.allQuestions.size,
                    correct = correctCount,
                    wrong = wrongCount
                )
            }

            // Question Diagram Visual
            item {
                QuestionDiagramView(question = currentQuestion)
            }

            // Question Title & Text
            item {
                Text(
                    text = currentQuestion.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // Hint proposal card
            item {
                HintProposalCard(
                    hintText = currentQuestion.hintProposal,
                    isExpanded = uiState.isHintExpanded,
                    onToggle = { viewModel.toggleHint() }
                )
            }

            // Option choices (A, B, C, D, E)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    currentQuestion.options.forEach { optionText ->
                        val letter = optionText.trim().take(1).uppercase()
                        val isSelected = currentProgress?.selectedOption.equals(letter, ignoreCase = true)
                        val isCorrectOption = currentQuestion.correctOption.equals(letter, ignoreCase = true)
                        val showResult = currentProgress?.selectedOption != null || !uiState.isQuizMode

                        OptionCard(
                            optionText = optionText,
                            optionLetter = letter,
                            isSelected = isSelected,
                            isCorrectOption = isCorrectOption,
                            showResult = showResult,
                            onClick = {
                                viewModel.selectOption(letter)
                            }
                        )
                    }
                }
            }

            // Show solution / explanation toggle button
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalButton(
                        onClick = { viewModel.toggleExplanation() },
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("toggle_explanation_button")
                    ) {
                        Icon(
                            imageVector = if (uiState.isExplanationExpanded) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (uiState.isExplanationExpanded) "İzahı Gizlət" else "Geniş Həll Yoluna Bax",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Detailed Step-by-Step Explanation
            if (uiState.isExplanationExpanded || !uiState.isQuizMode) {
                item {
                    ExplanationCard(
                        correctOption = currentQuestion.correctOption,
                        explanationText = currentQuestion.fullExplanation
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun TabletTwoPaneLayout(
    viewModel: QuizViewModel,
    uiState: QuizUiState,
    progressMap: Map<Int, UserProgressEntity>,
    currentQuestion: Question,
    currentProgress: UserProgressEntity?,
    totalAnswered: Int,
    correctCount: Int,
    wrongCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        // Left Pane (Navigator, Stats, Filters) ~ 340dp
        Surface(
            modifier = Modifier
                .width(360.dp)
                .fillMaxHeight(),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
            tonalElevation = 2.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Məntiq Quiz",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "91 Qanunauyğunluq Testi",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(onClick = { viewModel.toggleMode() }) {
                        Icon(
                            imageVector = if (uiState.isQuizMode) Icons.Default.School else Icons.Default.Quiz,
                            contentDescription = "Rejimi dəyiş",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Stats Card
                ProgressBarCard(
                    answered = totalAnswered,
                    total = viewModel.allQuestions.size,
                    correct = correctCount,
                    wrong = wrongCount
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Question fast navigator
                Text(
                    text = "Bütün Suallar (1-91)",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                QuestionNavigator(
                    allQuestions = viewModel.allQuestions,
                    currentQuestionId = currentQuestion.id,
                    progressMap = progressMap,
                    onSelectQuestion = { id -> viewModel.goToQuestion(id) },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = { viewModel.resetProgress() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Nəticələri Sıfırla")
                }
            }
        }

        VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant)

        // Right Pane (Active Question, Diagram, Options, Solution)
        Scaffold(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            topBar = {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Sual #${currentQuestion.id} / 91",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = currentQuestion.category,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { viewModel.toggleBookmark() }) {
                                Icon(
                                    imageVector = if (currentProgress?.isBookmarked == true) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                                    contentDescription = "Əlfəcin",
                                    tint = if (currentProgress?.isBookmarked == true) Color(0xFFF59E0B) else MaterialTheme.colorScheme.onSurface
                                )
                            }

                            FilledTonalButton(
                                onClick = { viewModel.toggleExplanation() }
                            ) {
                                Icon(
                                    imageVector = if (uiState.isExplanationExpanded) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(if (uiState.isExplanationExpanded) "İzahı Gizlət" else "Həll İzahı")
                            }
                        }
                    }
                }
            },
            bottomBar = {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        FilledTonalButton(
                            onClick = { viewModel.previousQuestion() },
                            enabled = uiState.currentQuestionIndex > 0
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Əvvəlki Sual")
                        }

                        Button(
                            onClick = { viewModel.nextQuestion() },
                            enabled = uiState.currentQuestionIndex < viewModel.allQuestions.size - 1
                        ) {
                            Text("Növbəti Sual")
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                        }
                    }
                }
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Diagram Card
                item {
                    QuestionDiagramView(question = currentQuestion)
                }

                // Question Title
                item {
                    Text(
                        text = currentQuestion.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Hint Proposal Card
                item {
                    HintProposalCard(
                        hintText = currentQuestion.hintProposal,
                        isExpanded = uiState.isHintExpanded,
                        onToggle = { viewModel.toggleHint() }
                    )
                }

                // Options List
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        currentQuestion.options.forEach { optionText ->
                            val letter = optionText.trim().take(1).uppercase()
                            val isSelected = currentProgress?.selectedOption.equals(letter, ignoreCase = true)
                            val isCorrectOption = currentQuestion.correctOption.equals(letter, ignoreCase = true)
                            val showResult = currentProgress?.selectedOption != null || !uiState.isQuizMode

                            OptionCard(
                                optionText = optionText,
                                optionLetter = letter,
                                isSelected = isSelected,
                                isCorrectOption = isCorrectOption,
                                showResult = showResult,
                                onClick = { viewModel.selectOption(letter) }
                            )
                        }
                    }
                }

                // Solution
                if (uiState.isExplanationExpanded || !uiState.isQuizMode) {
                    item {
                        ExplanationCard(
                            correctOption = currentQuestion.correctOption,
                            explanationText = currentQuestion.fullExplanation
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProgressBarCard(
    answered: Int,
    total: Int,
    correct: Int,
    wrong: Int
) {
    val progressFraction = if (total > 0) answered.toFloat() / total else 0f
    val accuracy = if (answered > 0) (correct.toFloat() / answered * 100).toInt() else 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("progress_summary_card"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(14.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tərəqqi: $answered / $total",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Dəqiqlik: $accuracy%",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { progressFraction },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color(0xFF10B981)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Doğru: $correct", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color(0xFFEF4444)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Səhv: $wrong", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(MaterialTheme.colorScheme.surfaceVariant))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Qalıb: ${total - answered}", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
