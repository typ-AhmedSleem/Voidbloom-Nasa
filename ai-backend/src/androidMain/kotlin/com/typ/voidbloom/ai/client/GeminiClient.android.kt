package com.typ.voidbloom.ai.client

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.typ.voidbloom.shared.Secrets.DEMO_API_KEY
import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.VbSettingsKeys
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

actual open class GeminiClient actual constructor() : AIClient, KoinComponent {

    actual val apiKey: String
        get() = get<VbSettings>().secureGetString(VbSettingsKeys.AI_ENGINE_API_KEY, DEMO_API_KEY)

    private val gemini = GenerativeModel(
        modelName = GeminiModels.GEMINI_FLASH_2_5,
        apiKey = apiKey
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
}