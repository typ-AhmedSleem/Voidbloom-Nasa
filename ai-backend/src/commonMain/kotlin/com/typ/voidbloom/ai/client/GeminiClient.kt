package com.typ.voidbloom.ai.client

import org.koin.core.component.KoinComponent

expect open class GeminiClient() : AIClient, KoinComponent {
    val apiKey: String
    override suspend fun ask(prompts: List<GeminiPrompt>): String
}