package com.typ.voidbloom.ai.client

import org.koin.core.component.KoinComponent

internal expect class GeminiChatBotClient(systemInstruction: GeminiPrompt) : AIClient, KoinComponent {

    val apiKey: String

    override suspend fun ask(prompts: List<GeminiPrompt>): String

    suspend fun sendMessage(question: String): String?

}