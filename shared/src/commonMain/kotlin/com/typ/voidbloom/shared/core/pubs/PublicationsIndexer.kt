package com.typ.voidbloom.shared.core.pubs

import com.typ.voidbloom.shared.core.pubs.PublicationTitleTokenizer.tokenize
import com.typ.voidbloom.shared.core.pubs.PubsToolsConstants.categories

object PublicationsIndexer {
    // Reverse index: Map each title -> list of categories
    fun mapTitlesToCategories(titles: List<String>): Map<String, List<String>> {
        val result = mutableMapOf<String, MutableList<String>>()
        for (title in titles) {
            val tokens = tokenize(title)
            val matchedCats = mutableSetOf<String>()
            for (token in tokens) {
                for ((category, words) in categories) {
                    if (token in words) {
                        matchedCats.add(category)
                    }
                }
            }
            result[title] = matchedCats.toMutableList()
        }
        return result
    }
}