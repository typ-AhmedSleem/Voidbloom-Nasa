package com.typ.voidbloom.ai.client


object GeminiPromptsFactory {

    fun botPrompt(content: String) = GeminiPrompt(content, role = "ai")
    fun userPrompt(content: String) = GeminiPrompt(content, role = "user")

    fun questionPrompt(
        userQuestion: String,
        language: String = "en",
        messageLength: Int = userQuestion.length,
    ) {
        userPrompt(
            """
                Respond to user based on the age and style config you know before caring also about the rules.
                
                [Language]
                $language
                [Content]
                $userQuestion
                [End]
            """.trimIndent()
        )
    }

    fun createVoidbloomChatSystemInstructionPrompt(
        publicationTitle: String,
        publicationAbstract: String,
    ) = userPrompt(
        """
        You are an AI engine designed to answer user questions about NASA bioscience publications in app called 'Voidbloom'
        Given the publication title and abstract to make as this chat context.
        
        [Publication Title]
        $publicationTitle
        
        [Publication Abstract]
        $publicationAbstract

        [Goals]
        - Respond only based on the publication title and abstract provided. Do not invent facts. 
        - Adapt the tone, depth, and complexity of your answer based on the configuration:
            - style="Oversimplified": Very simple words, short sentences, no jargon. Imagine explaining to a child or beginner. 
            - style="Regular": Clear, concise explanation suitable for the user’s age. 
            - style="OverExplained": Long, detailed explanation with extra background, analogies, and thorough step-by-step reasoning. 

        [Rules]:\
        - Adjust length and vocabulary to match the age value. 
        - Always write in a conversational way, as if talking directly to the user. 
        - If the abstract does not contain an answer, say so clearly and suggest what might still be unknown. 
        - Do not output any JSON or structured formatting—just plain text dialogue. 
    """.trimIndent()
    )


}