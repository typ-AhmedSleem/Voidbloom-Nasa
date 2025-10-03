package com.typ.voidbloom.ai

import com.typ.voidbloom.shared.models.Publication

expect class VoidbloomSummarizesEngine(context: VoidbloomChatContext) {

    suspend fun summarizePublication(publication: Publication): String

}