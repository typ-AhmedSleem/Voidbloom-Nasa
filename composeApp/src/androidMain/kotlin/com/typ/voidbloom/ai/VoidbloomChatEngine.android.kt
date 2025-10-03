package com.typ.voidbloom.ai

import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.content
import org.koin.core.component.KoinComponent

actual class VoidbloomChatEngine actual constructor(val chatContext: VoidbloomChatContext) : KoinComponent {

    private val geminiModel = Firebase
        .ai(backend = GenerativeBackend.googleAI())
        .generativeModel(
            modelName = "gemini-2.5-flash",
            systemInstruction = content {
                text(
                    AiPromptFactory.createVoidbloomChatSystemInstruction(
                        publicationTitle = chatContext.title,
                        publicationAbstract = chatContext.abstract
                    ).also {
                        println("[AI:SYSTEM-INSTRUCTION] '$it'.")
                    }
                )
            }
        )

    private val chat = geminiModel.startChat()

    actual suspend fun askQuestion(question: String): String {
        return runCatching { chat.sendMessage(question).text!! }
            .getOrDefault("Unknown error occurred")

    }


}