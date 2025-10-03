package com.typ.voidbloom.ai

import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.content
import com.typ.voidbloom.shared.models.Publication
import com.typ.voidbloom.utils.abstract

actual class VoidbloomSummarizesEngine actual constructor(val context: VoidbloomChatContext) {

    private val geminiModel = Firebase
        .ai(backend = GenerativeBackend.googleAI())
        .generativeModel(
            modelName = "gemini-2.5-flash",
            systemInstruction = content {
                text(
                    AiPromptFactory.summarizePublicationSystemInstruction(
                        publicationTitle = context.title,
                    )
                ).also {
                    println("[VoidbloomSummarizesEngine:SYSTEM-INSTRUCTION] '$it'.")
                }
            }
        )

    actual suspend fun summarizePublication(publication: Publication): String {
        return runCatching {
            geminiModel.generateContent("[Publication Abstract]\n${publication.abstract()}").text!!
        }.getOrDefault("Can't summarize publication.")
    }

}