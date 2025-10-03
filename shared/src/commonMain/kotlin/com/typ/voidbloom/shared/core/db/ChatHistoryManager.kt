package com.typ.voidbloom.shared.core.db

import com.typ.voidbloom.db.Chat
import com.typ.voidbloom.db.VoidbloomDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class ChatHistoryManager : KoinComponent {
    private val db = get<VoidbloomDatabase>()

    suspend fun getHistoryForContext(contextId: String): List<Chat> {
        return db
            .chatQueries
            .selectByPubId(contextId)
            .executeAsList()
    }

    suspend fun persistChatMessage(role: String, content: String, context: String) {
        db
            .chatQueries
            .insertMessage(
                pubId = context,
                content = content,
                role = role
            )
    }

}