package com.typ.voidbloom.shared.core.pubs

object PubsToolsConstants {
    /**
     * A set of common English words to be ignored during keyword extraction and analysis.
     * These words, known as stop words, typically have little semantic value and can be
     * filtered out to improve the accuracy of text processing tasks.
     */
    val stopWords = setOf(
        "the", "and", "of", "in", "to", "for", "on", "with", "by", "at", "a", "an",
        "is", "are", "as", "from", "this", "that", "between", "during", "into",
        "versus", "against", "one", "two", "many"
    )

    /**
     * A map defining the categories for scientific publications.
     *
     * Each entry consists of a category name (e.g., "Space") and a set of keywords
     * associated with that category. This map is used to classify publications based on
     * the presence of these keywords in their title or abstract.
     */
    val categories = mapOf(
        "Experimental" to setOf("simulated", "analysis", "characterization", "changes", "growth", "responses", "development", "exercise", "involved"),
        "Space" to setOf("space", "spaceflight", "flight", "station", "iss", "microgravity", "gravity", "nasa"),
        "Radiation" to setOf("radiation", "hze", "cosmic", "dna", "methylation"),
        "Immunity" to setOf("immune", "immunoglobulin", "macrophage", "antibody", "repertoire", "infection"),
        "Plants" to setOf("arabidopsis", "thaliana", "chloroplast", "auxin", "photosynthesis", "root", "plant", "reticulum", "bloom", "plants", "roots"),
        "Anatomy" to setOf("bone", "muscle", "skeletal", "osteoblast", "osteoclast", "atrophy"),
        "Animals" to setOf("mice", "mouse", "drosophila", "flies", "worms", "snail", "fish", "animal", "rats"),
        "Microbes" to setOf("bacteria", "biofilm", "pseudomonas", "enterococcus", "pathogenicity"),
        "Neurology" to setOf("brain", "neuro", "neuron", "synapse", "vestibular", "nervous", "neural"),
        "Cardiovascular" to setOf("heart", "cardiac", "blood", "vessel", "vascular", "artery"),
        "General Biology" to setOf(
            "genome", "protein", "gene", "genomic", "response", "stress", "expression", "cell", "cells", "cellular", "cytokine", "mitochondria", "telomere", "apoptosis",
            "tissue", "sequences", "species", "proteins", "calcium", "molecular", "biology", "genomes"
        )
    )

}