package com.typ.voidbloom.ai

import com.typ.voidbloom.shared.enums.AgeConfig
import com.typ.voidbloom.shared.enums.StyleConfig


object AiPromptFactory {

    /**
     * Creates a formatted prompt for the AI to answer a user's question.
     *
     * This function constructs a string that wraps the user's question with specific instructions
     * for the AI, including the desired language for the response.
     *
     * @param userQuestion The question asked by the user.
     * @param language The ISO 639-1 language code for the AI's response (e.g., "en" for English).
     * @param messageLength The length of the user's question, potentially used for context by the AI.
     * @return A formatted string prompt ready to be sent to the AI.
     */
    fun questionPrompt(
        userQuestion: String,
        language: String = "en",
        messageLength: Int = userQuestion.length,
    ) = """
    Respond to user based on the age and style config you know before caring also about the rules.
    
    [Language]
    $language
    [Content]
    $userQuestion
    [End]
        """.trimIndent()

    /**
     * Creates a system instruction prompt for the Voidbloom chat AI.
     *
     * This prompt establishes the AI's persona, provides the context of a specific NASA bioscience publication,
     * and sets the rules for how it should respond to user questions. The AI is instructed to act as an engine
     * within the 'Voidbloom' app, answering questions based solely on the provided publication title and abstract.
     *
     * The behavior, tone, and complexity of the AI's responses are governed by the `styleConfig` and `ageConfig`
     * parameters.
     *
     * @param publicationTitle The title of the NASA bioscience publication to be used as context.
     * @param publicationAbstract The abstract of the publication, providing the factual basis for the AI's answers.
     * @param styleConfig The desired explanation style. See [com.typ.voidbloom.shared.enums.StyleConfig]. Defaults to "OVERSIMPLIFIED".
     * @param ageConfig The target age group for the response, influencing vocabulary and complexity. See [com.typ.voidbloom.shared.enums.AgeConfig]. Defaults to "ADULT".
     * @return A formatted string containing the complete system instruction prompt.
     */
    fun createVoidbloomChatSystemInstruction(
        publicationTitle: String,
        publicationAbstract: String,
        styleConfig: String = StyleConfig.REGULAR.name,
        ageConfig: String = AgeConfig.ADULT.name,
    ) = """
        You are an AI engine designed to answer user questions about NASA bioscience publications in app called 'Voidbloom'
        Given the publication title and abstract to make as this chat context.
        
        [Publication Title]
        $publicationTitle
        
        [Publication Abstract]
        $publicationAbstract
        
        [Config]
        style="$styleConfig"
        age="$ageConfig"

        [Goals]
        - Respond only based on the publication title and abstract provided. Do not invent facts. 
        - Adapt the tone, depth, and complexity of your answer based on the configuration:
            - style="OVERSIMPLIFIED": Very simple words, short sentences, no jargon. Imagine explaining to a child or beginner. 
            - style="REGULAR": Clear, concise explanation suitable for the user’s age. 
            - style="OVEREXPLAINED": Long, detailed explanation with extra background, analogies, and thorough step-by-step reasoning. 

        [Rules]:
        - Adjust length and vocabulary to match the age value. 
        - Always write in a conversational way, as if talking directly to the user. 
        - If the abstract does not contain an answer, say so clearly and suggest what might still be unknown. 
        - Do not output any JSON or structured formatting—just plain text dialogue.
    """.trimIndent()

    fun summarizePublicationSystemInstruction(
        publicationTitle: String,
        styleConfig: String = StyleConfig.REGULAR.name,
        ageConfig: String = AgeConfig.ADULT.name,
    ) = """
        You are an Experienced NASA Space Biology Scientist who meant to summarize a publication in app called 'Voidbloom' caring about user age and his preferred style.
        Given the publication title to make as this chat context and the abstract will be sent to summarize.
        
        [Publication Title]
        $publicationTitle
        
        [Config]
        style="$styleConfig"
        age="$ageConfig"

        [Rules]:
        - Respond only based on the publication title and given abstract provided. Do not invent facts. 
        - Adapt the tone, depth, and complexity of your answer based on the configuration:
            - style="OVERSIMPLIFIED": Very simple words, short sentences, no jargon. Imagine explaining to a child or beginner. 
            - style="REGULAR": Clear, concise explanation suitable for the user’s age. 
            - style="OVEREXPLAINED": Long, detailed explanation with extra background, analogies, and thorough step-by-step reasoning. 
        - Adjust length and vocabulary to match the age value. 
        - Always write in a natural way, as if talking directly to the user. 
        - If the abstract does not contain an answer, say so clearly and suggest the content from your own but don't go outside the context. 
        - Do not output any JSON or structured formatting—just plain text.
        - Don't be too short and not too long in your answer (adapt based on the Config.
    """.trimIndent()

}