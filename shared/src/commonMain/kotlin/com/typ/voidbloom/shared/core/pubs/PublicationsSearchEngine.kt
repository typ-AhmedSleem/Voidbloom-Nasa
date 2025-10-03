package com.typ.voidbloom.shared.core.pubs

import androidx.compose.ui.util.fastFlatMap
import androidx.compose.ui.util.fastMap
import com.typ.voidbloom.shared.models.Publication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PublicationsSearchEngine {

    fun performSearchWithFilters(
        publications: List<Publication>,
        query: String,
    ): List<Publication> {
        val searchQuery = query.trim()
        if (searchQuery.isBlank()) return emptyList()

        val titles = publications.fastMap { it.title }
        val reverseIndex = PublicationsIndexer.mapTitlesToCategories(titles)

        return reverseIndex
            .entries
            .filter { entry ->
                val (title, categories) = entry

                val titleMatches = title.contains(searchQuery, ignoreCase = true)
                val categoryMatches = categories.any { it.equals(searchQuery, ignoreCase = true) }

                titleMatches || categoryMatches
            }
            .fastFlatMap { (title, _) ->
                publications.filter { it.title == title }
            }
            .distinctBy { it.id }
    }

    suspend fun performSearchWithFiltersBlocking(
        publications: List<Publication>,
        query: String,
    ): List<Publication> {
        return withContext(Dispatchers.Default) { performSearchWithFilters(publications, query) }
    }
}
