package com.typ.voidbloom.ai

import com.typ.voidbloom.shared.models.Publication
import com.typ.voidbloom.utils.abstract

actual class VoidbloomSummarizesEngine actual constructor(context: VoidbloomChatContext) {
    actual suspend fun summarizePublication(publication: Publication): String {
        return publication.abstract()
    }
}