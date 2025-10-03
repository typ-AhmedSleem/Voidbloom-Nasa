package com.typ.voidbloom.core

import androidx.compose.ui.util.fastForEach
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.shared.core.pubs.PublicationCategorizer
import com.typ.voidbloom.shared.core.pubs.PublicationsIndexer
import com.typ.voidbloom.shared.core.pubs.PublicationsKeywordExtractor
import com.typ.voidbloom.shared.core.pubs.PublicationsSearchEngine.performSearchWithFilters
import kotlin.test.Test
import kotlin.time.measureTime

class PublicationsToolsTests {

    private fun getPublications() = PublicationsRepository.getAllPubs()
    private fun getPublicationsTitles() = getPublications().map { it.title }

    @Test
    fun toolsTest() {
        val time = measureTime {
            val titles = getPublicationsTitles()
            val keywords = PublicationsKeywordExtractor.extractKeywords(titles, topN = 800)
            val categorized = PublicationCategorizer.categorizeKeywords(keywords)
            val reverseIndex = PublicationsIndexer.mapTitlesToCategories(titles)

            println("Categorized Keywords:")
            categorized.forEach { (cat, words) ->
                println("$cat -> ${words.joinToString { "${it.first}(${it.second})" }}")
            }

            println("\nTitle to Categories:")
            reverseIndex
                .forEach { (title, cats) ->
                    println("$title -> $cats")
                }
        }

        println("Took '${time.inWholeMilliseconds}' ms to finish.")
    }

    @Test
    fun testPublicationsSearchEngine() {
        val pubs = getPublications()
        val queries = listOf(
            "",
            "genome",
            "cosmic",
            "animal",
        )

        queries.fastForEach { query ->
            val matches = performSearchWithFilters(pubs, query)
            println("START OF QUERY RESULTS =========")
            println("Found '${matches.size}' matches for query '$query'.")
            // Find duplications
            val duplications = matches.groupBy { it.id }.filter { it.value.size > 1 }
            if (duplications.isNotEmpty()) {
                println("Found '${duplications.size}' duplications:")
                duplications.forEach { (title, pubs) ->
                    println("- '${title}' appeared '${pubs.size}' times.")
                    pubs.forEach {
                        println("  - ${it.id} -> '${it.title}'.")
                    }
                }
            } else {
                println("No duplications found.")
            }
            println("END OF QUERY RESULTS =========\n")

        }
    }

}