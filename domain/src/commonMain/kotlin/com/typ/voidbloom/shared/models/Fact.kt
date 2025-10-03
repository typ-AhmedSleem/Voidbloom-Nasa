package com.typ.voidbloom.shared.models

data class Fact(
    val title: String,
)

data class SpaceFact(
    val category: String,
    val title: String,
    val description: String,
)

fun SpaceFact.toFact() = Fact(
    title = description,
)