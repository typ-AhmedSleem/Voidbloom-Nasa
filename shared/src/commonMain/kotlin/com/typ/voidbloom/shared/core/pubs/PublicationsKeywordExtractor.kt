package com.typ.voidbloom.shared.core.pubs

object PublicationsKeywordExtractor {

    fun extractKeywords(titles: List<String>, topN: Int = -1): List<Pair<String, Int>> {
        val counts = mutableMapOf<String, Int>()
        for (title in titles) {
            val tokens = PublicationTitleTokenizer.tokenize(title)
            for (token in tokens) {
                counts[token] = counts.getOrElse(token) { 0 } + 1
            }
        }
        return counts
            .entries
            .sortedByDescending { it.value }
            .take(if (topN >= 0) topN else counts.size)
            .map { it.key to it.value }
    }

}