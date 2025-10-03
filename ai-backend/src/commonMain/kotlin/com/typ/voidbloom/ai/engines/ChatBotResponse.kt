package com.typ.voidbloom.ai.engines

data class ChatBotResponse(
    val message: String,
) {
    val isEmpty = message.isEmpty()
}
