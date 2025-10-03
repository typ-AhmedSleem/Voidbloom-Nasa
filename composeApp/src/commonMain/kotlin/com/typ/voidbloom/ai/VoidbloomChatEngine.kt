package com.typ.voidbloom.ai

import org.koin.core.component.KoinComponent

expect class VoidbloomChatEngine(chatContext: VoidbloomChatContext) : KoinComponent {

    suspend fun askQuestion(question: String): String

}