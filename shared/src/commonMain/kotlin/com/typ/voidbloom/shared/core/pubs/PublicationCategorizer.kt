package com.typ.voidbloom.shared.core.pubs

object PublicationCategorizer {
    fun categorizeKeywords(
        keywords: List<Pair<String, Int>>,
        showUncategorized: Boolean = false,
    ): Map<String, List<Pair<String, Int>>> {
        val categorized = mutableMapOf<String, MutableList<Pair<String, Int>>>()
        for ((word, count) in keywords) {
            var added = false
            for ((category, words) in PubsToolsConstants.categories) {
                if (word in words) {
                    categorized.getOrPut(category) { mutableListOf() }.add(word to count)
                    added = true
                }
            }
            if (!added && showUncategorized) {
                categorized.getOrPut("Uncategorized") { mutableListOf() }.add(word to count)
            }
        }
        return categorized
    }
}