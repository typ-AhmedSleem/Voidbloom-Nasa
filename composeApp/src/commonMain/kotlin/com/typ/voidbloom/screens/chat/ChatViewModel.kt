package com.typ.voidbloom.screens.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.typ.voidbloom.ai.VoidbloomChatContext
import com.typ.voidbloom.ai.VoidbloomChatEngine
import com.typ.voidbloom.data.models.ChatMessage
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.helpers.botMessage
import com.typ.voidbloom.helpers.thinking
import com.typ.voidbloom.helpers.userMessage
import com.typ.voidbloom.shared.core.db.ChatHistoryManager
import com.typ.voidbloom.shared.models.Publication
import com.typ.voidbloom.utils.abstract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import pro.respawn.kmmutils.common.replaceWith
import pro.respawn.kmmutils.compose.resources.getString
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.botWelcomeMsg

class ChatViewModel : ViewModel(), KoinComponent {
    val publications: List<Publication> = PublicationsRepository.getAllPubs()

    private val _isPickerVisible = MutableStateFlow(false)
    val isPickerVisible = _isPickerVisible.asStateFlow()

    private val _publicationContext = MutableStateFlow<Publication?>(null)
    val publicationContext = _publicationContext.asStateFlow()

    private val _userMessageText = MutableStateFlow<String>("")
    val userMessageText = _userMessageText.asStateFlow()

    private val _isBotReady = MutableStateFlow(true)
    val isBotReady = _isBotReady.asStateFlow()

    // Expose the SnapshotStateList directly to Compose for automatic recomposition.
    val chatMessages: SnapshotStateList<ChatMessage> = mutableStateListOf()

    val chatHistoryManager = get<ChatHistoryManager>()
    var chatEngine: VoidbloomChatEngine? = null

    suspend fun loadChatHistory(contextId: String) {
        withContext(Dispatchers.IO) {
            val chatHistory = chatHistoryManager.getHistoryForContext(contextId)
            chatHistory
                .map { chatMsg ->
                    if (chatMsg.role == "user") {
                        ChatMessage.userMessage(chatMsg.content)
                    } else {
                        ChatMessage.botMessage(chatMsg.content)
                    }
                }
                .also { chatMessages.replaceWith(it) }
        }
    }

    fun showContextPicker() {
        _isPickerVisible.value = true
    }

    fun hideContextPicker() {
        _isPickerVisible.value = false
    }

    fun attachPublicationContext(publication: Publication) {
        viewModelScope.launch {
            val botWelcomeText = Res.string.botWelcomeMsg.getString()


            // * Initialize chat engine
            disableBot()
            chatEngine = VoidbloomChatEngine(
                VoidbloomChatContext(
                    abstract = publication.abstract(),
                    title = publication.title,
                )
            )

            // * Show actual chat
            hideContextPicker()
            _publicationContext.value = publication

            // * Load chat history (if has)
            loadChatHistory(publication.id)

            // * Check if chat history is empty
            if (chatMessages.isEmpty()) {
                // * Send welcome message to user
                addBotBubble(botWelcomeText)
            }
            enableBot()
        }
    }

    fun updateInputFieldText(newContent: String) {
        _userMessageText.value = newContent
    }

    private fun disableBot() {
        _isBotReady.value = false
    }

    private fun enableBot() {
        _isBotReady.value = true
    }

    private fun addChatBubble(chatMessage: ChatMessage) {
        val context = publicationContext.value?.id ?: return
        viewModelScope.launch {
            disableBot()

            if (chatMessage != ChatMessage.Thinking) {
                chatHistoryManager.persistChatMessage(
                    role = if (chatMessage.byUser) "user" else "bot",
                    content = chatMessage.content,
                    context = context
                )
            }
            chatMessages.add(chatMessage)

            enableBot()
        }
    }

    private fun addUserBubble(content: String) {
        addChatBubble(ChatMessage.userMessage(content))
    }

    private fun addBotBubble(content: String, isError: Boolean = false) {
        val context = publicationContext.value?.id ?: return
        viewModelScope.launch {
            if (chatMessages.lastOrNull() is ChatMessage.Thinking) {
                // Replace the 'thinking' indicator with the actual bot message
                chatMessages[chatMessages.lastIndex] = ChatMessage.botMessage(content)
                // Persist the message
                chatHistoryManager.persistChatMessage(
                    role = "bot",
                    content = content,
                    context = context
                )
            } else {
                if (isError) addErrorBubble(content)
                else addChatBubble(ChatMessage.botMessage(content))
            }
        }
    }

    private fun addThinkingBubble() {
        addChatBubble(ChatMessage.thinking())
    }

    private fun addErrorBubble(content: String) {
        addChatBubble(ChatMessage.Error(content))
    }


    fun askQuestion() {
        val question = userMessageText.value
        if (!isBotReady.value || question.isBlank()) return
        val engine = chatEngine ?: return

        viewModelScope.launch {
            // * Update ui
            updateInputFieldText("")
            disableBot()
            addUserBubble(question)
            addThinkingBubble()

            // * Ask question to AiEngine
            val answer = engine.askQuestion(question)

            // * Show answer to user
            addBotBubble(answer)

            // * Enable bot again
            enableBot()
        }
    }

}