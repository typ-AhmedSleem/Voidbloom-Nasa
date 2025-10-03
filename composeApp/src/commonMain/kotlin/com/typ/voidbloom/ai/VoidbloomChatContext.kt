package com.typ.voidbloom.ai

import androidx.compose.runtime.Immutable

@Immutable
data class VoidbloomChatContext(
    val title: String,
    val abstract: String,
)