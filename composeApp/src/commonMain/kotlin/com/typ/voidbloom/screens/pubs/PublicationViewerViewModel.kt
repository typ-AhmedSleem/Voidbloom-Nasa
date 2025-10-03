package com.typ.voidbloom.screens.pubs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.typ.voidbloom.ai.VoidbloomChatContext
import com.typ.voidbloom.ai.VoidbloomSummarizesEngine
import com.typ.voidbloom.shared.models.Publication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class PublicationViewerViewModel(
    private val publication: Publication,
) : ViewModel(), KoinComponent {

    private val context = VoidbloomChatContext(title = publication.title, abstract = "")

    private val _isSummarizing = MutableStateFlow(false)
    val isSummarizing: StateFlow<Boolean> = _isSummarizing

    private val _summarizedContent = MutableStateFlow("")
    val summarizedContent = _summarizedContent.asStateFlow()

    private val summarizerEngine = VoidbloomSummarizesEngine(context)

    private fun summarize() {
        viewModelScope.launch {
            _isSummarizing.value = true
            _summarizedContent.value = summarizerEngine.summarizePublication(publication)
            _isSummarizing.value = false
        }
    }

    fun summarizeIfNeeded() {
        if (isSummarizing.value) return
        if (summarizedContent.value.isBlank()) {
            summarize()
        }
    }

}