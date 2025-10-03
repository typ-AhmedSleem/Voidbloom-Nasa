package com.typ.voidbloom.helpers

import com.typ.voidbloom.data.models.ChatMessage

fun ChatMessage.Companion.botMessage(content: String): ChatMessage.Message {
    return ChatMessage.Message(false, content)
}

fun ChatMessage.Companion.userMessage(content: String): ChatMessage.Message {
    return ChatMessage.Message(true, content)
}

fun ChatMessage.Companion.thinking(): ChatMessage.Thinking {
    return ChatMessage.Thinking
}

fun ChatMessage.Companion.error(content: String): ChatMessage.Error {
    return ChatMessage.Error(content)
}