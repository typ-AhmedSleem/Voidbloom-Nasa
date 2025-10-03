package com.typ.voidbloom.ai.engines

import com.typ.voidbloom.ai.client.AIClient
import com.typ.voidbloom.ai.client.GeminiPrompt

abstract class AIEngine(internal val client: AIClient) {

    /**
     * Generates a response based on the given prompt.
     * The prompt should be well-defined, concise and specific
     * to our output.
     * Also, if it needs output, the output format or schema
     * should be provided also.
     */
    suspend fun generateFromPrompt(vararg prompts: GeminiPrompt): String {
        return client.ask(prompts.asList())
    }

}