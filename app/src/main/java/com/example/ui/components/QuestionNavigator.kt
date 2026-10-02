package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.UserProgressEntity
import com.example.data.model.Question

enum class QuestionFilter(val label: String) {
    ALL("Hamısı"),
    CORRECT("Doğru"),
    WRONG("Səhv"),
    UNANSWERED("Cavabsız"),
    BOOKMARKED("Əlfəcinlər")
}

@Composable
fun QuestionNavigator(
    allQuestions: List<Question>,
    currentQuestionId: Int,
    progressMap: Map<Int, UserProgressEntity>,
    onSelectQuestion: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedFilter by remember { mutableStateOf(QuestionFilter.ALL) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredQuestions = remember(allQuestions, progressMap, selectedFilter, searchQuery) {
        allQuestions.filter { q ->
            val progress = progressMap[q.id]
            val matchesFilter = when (selectedFilter) {
                QuestionFilter.ALL -> true
                QuestionFilter.CORRECT -> progress?.isCorrect == true
                QuestionFilter.WRONG -> progress != null && progress.selectedOption != null && !progress.isCorrect
                QuestionFilter.UNANSWERED -> progress?.selectedOption == null
                QuestionFilter.BOOKMARKED -> progress?.isBookmarked == true
            }

            val matchesSearch = if (searchQuery.isBlank()) {
                true
            } else {
                q.id.toString().contains(searchQuery.trim()) ||
                        q.category.contains(searchQuery.trim(), ignoreCase = true) ||
                        q.title.contains(searchQuery.trim(), ignoreCase = true)
            }

            matchesFilter && matchesSearch
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("question_navigator_container")
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .testTag("question_search_input"),
            placeholder = { Text("Sual nömrəsi və ya açar söz (1-91)...", fontSize = 13.sp) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Axtarış", modifier = Modifier.size(18.dp))
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        // Filter chips
        ScrollableTabRow(
            selectedTabIndex = selectedFilter.ordinal,
            edgePadding = 0.dp,
            divider = {},
            indicator = {},
            containerColor = Color.Transparent,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            QuestionFilter.entries.forEach { filter ->
                val isSelected = selectedFilter == filter
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedFilter = filter },
                    label = {
                        val count = when (filter) {
                            QuestionFilter.ALL -> allQuestions.size
                            QuestionFilter.CORRECT -> progressMap.values.count { it.isCorrect }
                            QuestionFilter.WRONG -> progressMap.values.count { it.selectedOption != null && !it.isCorrect }
                            QuestionFilter.UNANSWERED -> allQuestions.size - progressMap.values.count { it.selectedOption != null }
                            QuestionFilter.BOOKMARKED -> progressMap.values.count { it.isBookmarked }
                        }
                        Text("${filter.label} ($count)", fontSize = 12.sp)
                    },
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .testTag("filter_chip_${filter.name}"),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }

        // Grid of numbers 1-91
        if (filteredQuestions.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Bu filtrə uyğun sual tapılmadı.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 46.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 280.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredQuestions, key = { it.id }) { question ->
                    val progress = progressMap[question.id]
                    val isCurrent = question.id == currentQuestionId

                    val itemColor = when {
                        progress?.isCorrect == true -> Color(0xFF10B981)
                        progress?.selectedOption != null -> Color(0xFFEF4444)
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }

                    val textColor = when {
                        progress?.selectedOption != null -> Color.White
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }

                    Surface(
                        modifier = Modifier
                            .size(44.dp)
                            .testTag("nav_question_item_${question.id}")
                            .clickable { onSelectQuestion(question.id) },
                        shape = RoundedCornerShape(10.dp),
                        color = itemColor,
                        border = if (isCurrent) BorderStroke(2.5.dp, MaterialTheme.colorScheme.primary) else null
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "${question.id}",
                                fontWeight = if (isCurrent) FontWeight.ExtraBold else FontWeight.Bold,
                                color = textColor,
                                fontSize = 13.sp
                            )

                            if (progress?.isBookmarked == true) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(2.dp),
                                    contentAlignment = Alignment.TopEnd
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Bookmark,
                                        contentDescription = "Əlfəcin",
                                        tint = Color(0xFFF59E0B),
                                        modifier = Modifier.size(11.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
