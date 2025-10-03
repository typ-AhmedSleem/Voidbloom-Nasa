package com.typ.voidbloom.ai.engines

import com.typ.voidbloom.ai.client.GeminiChatBotClient
import com.typ.voidbloom.ai.client.GeminiPromptsFactory

class VoidbloomChatEngine(
    publicationTitle: String,
    publicationAbstract: String,
) : AIEngine(
    client = GeminiChatBotClient(
        GeminiPromptsFactory.createVoidbloomChatSystemInstructionPrompt(
            publicationTitle = publicationTitle,
            publicationAbstract = publicationAbstract,
        )
    )
) {

    private val gemini = client as GeminiChatBotClient

    suspend fun askChat(question: String): ChatBotResponse {
        return ChatBotResponse(gemini.sendMessage(question) ?: "")
    }

}