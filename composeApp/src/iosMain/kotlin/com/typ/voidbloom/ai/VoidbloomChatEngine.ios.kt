package com.typ.voidbloom.ai

import org.koin.core.component.KoinComponent

actual class VoidbloomChatEngine actual constructor(val chatContext: VoidbloomChatContext) : KoinComponent {

    actual suspend fun askQuestion(question: String): String {
        return "Not yet implemented"
    }

}