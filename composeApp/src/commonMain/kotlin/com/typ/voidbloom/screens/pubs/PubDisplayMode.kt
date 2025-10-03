package com.typ.voidbloom.screens.pubs

import org.jetbrains.compose.resources.StringResource
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.original
import voidbloom.composeapp.generated.resources.summarized

enum class PubDisplayMode(val title: StringResource) {
    ORIGINAL(Res.string.original),
    SUMMARIZED(Res.string.summarized)
}