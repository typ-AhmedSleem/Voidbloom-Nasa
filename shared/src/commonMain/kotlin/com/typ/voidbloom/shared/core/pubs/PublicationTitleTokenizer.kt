package com.typ.voidbloom.shared.core.pubs

object PublicationTitleTokenizer {
    fun tokenize(text: String): List<String> {
        val regex = Regex("[a-zA-Z]+")
        return regex.findAll(text.lowercase())
            .map { it.value }
            .filter { it.length > 2 && it !in PubsToolsConstants.stopWords }
            .toList()
    }
}