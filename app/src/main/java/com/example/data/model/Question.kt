package com.example.data.model

data class Question(
    val id: Int,
    val title: String,
    val category: String,
    val options: List<String>,
    val correctOption: String, // "A", "B", "C", "D", "E"
    val hintProposal: String,
    val fullExplanation: String,
    val diagramType: String,
    val diagramData: Map<String, String> = emptyMap()
)
