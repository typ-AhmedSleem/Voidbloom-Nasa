package com.typ.voidbloom.shared

import com.typ.voidbloom.shared.core.pubs.PublicationCategorizer.categorizeKeywords
import com.typ.voidbloom.shared.core.pubs.PublicationsIndexer.mapTitlesToCategories
import com.typ.voidbloom.shared.core.pubs.PublicationsKeywordExtractor.extractKeywords
import kotlin.test.Test

class PublicationsToolsTests {

    val titles = listOf(
        "Unfolded protein response in plants: one master, many questions.",
        "Spaceflight promotes biofilm formation by Pseudomonas aeruginosa.",
        "Effects of spaceflight on the immunoglobulin repertoire of unimmunized C57BL/6 mice",
        "Genomic stability in response to high versus low linear energy transfer radiation in Arabidopsis thaliana"
    )

    @Test
    fun toolsTest() {
        val keywords = extractKeywords(titles, topN = 20)
        val categorized = categorizeKeywords(keywords)
        val reverseIndex = mapTitlesToCategories(titles)

        println("Categorized Keywords:")
        categorized.forEach { (cat, words) ->
            println("$cat -> ${words.joinToString { "${it.first}(${it.second})" }}")
        }

        println("\nTitle to Categories:")
        reverseIndex.forEach { (title, cats) ->
            println("$title -> $cats")
        }
    }

}