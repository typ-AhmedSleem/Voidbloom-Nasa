package com.typ.voidbloom.data.models

import com.typ.voidbloom.utils.millisNow

sealed class ChatMessage(
    open val byUser: Boolean,
    open val content: String,
    val timestamp: Long = millisNow(),
) {

    data class Message(
        override val byUser: Boolean,
        override val content: String,
    ) : ChatMessage(byUser, content)

    data object Thinking : ChatMessage(
        byUser = false,
        content = "Thinking..."
    )

    data class Error(
        override val content: String,
    ) : ChatMessage(
        byUser = false,
        content = content
    )

    companion object

}