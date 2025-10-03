package com.typ.voidbloom.ai.client

interface AIClient {
    suspend fun ask(prompts: List<GeminiPrompt>): String
}