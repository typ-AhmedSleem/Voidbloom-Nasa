package com.typ.voidbloom.ai.client

data class GeminiPrompt(
    val content: String,
    val role: String = "user",
)