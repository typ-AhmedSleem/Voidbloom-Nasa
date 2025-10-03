package com.typ.voidbloom.ai.client

import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.typ.voidbloom.shared.Secrets.DEMO_API_KEY
import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.VbSettingsKeys
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

internal actual class GeminiChatBotClient actual constructor(val systemInstruction: GeminiPrompt) : AIClient, KoinComponent {

    actual val apiKey: String
        get() = get<VbSettings>().secureGetString(VbSettingsKeys.AI_ENGINE_API_KEY, DEMO_API_KEY)

    private val gemini = GenerativeModel(
        modelName = GeminiModels.GEMINI_FLASH_2_5,
        apiKey = apiKey
    )
    private val chat = Chat(
        model = gemini,
        history = mutableListOf(
            content(role = systemInstruction.role) {
                text(systemInstruction.content)
            }
        )
    )

    actual override suspend fun ask(prompts: List<GeminiPrompt>): String {
        return gemini.generateContent(
            *prompts.map { prompt ->
                content(role = prompt.role) {
                    text(prompt.content)
                }
            }.toTypedArray()
        ).text ?: ""
    }

    actual suspend fun sendMessage(question: String): String? {
        return chat.sendMessage(content { text(question) }).text
    }

}