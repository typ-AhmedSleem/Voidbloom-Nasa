package com.typ.voidbloom.shared.ui.models

// Node types: publication, keyword, category, organism
data class GraphNode(
    val id: String,
    val label: String,
    val type: String,
)

