package com.typ.voidbloom.ai.client

import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.VbSettingsKeys
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

internal actual class GeminiChatBotClient actual constructor(systemInstruction: GeminiPrompt) : AIClient, KoinComponent {

    actual val apiKey: String
        get() = get<VbSettings>().secureGetString(VbSettingsKeys.AI_ENGINE_API_KEY, "")

    actual override suspend fun ask(prompts: List<GeminiPrompt>): String {
        return "Not yet implemented"
    }

    actual suspend fun sendMessage(question: String): String? {
        return "Not yet implemented"
    }
}