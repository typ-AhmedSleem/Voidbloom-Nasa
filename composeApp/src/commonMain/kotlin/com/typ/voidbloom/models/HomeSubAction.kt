package com.typ.voidbloom.models

import org.jetbrains.compose.resources.StringResource
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.toolsSearchTitle
import voidbloom.composeapp.generated.resources.toolsVisualizeTitle

sealed class HomeSubAction(
    val title: StringResource,
) {
    data object Search : HomeSubAction(Res.string.toolsSearchTitle)

    //    data object Filter : HomeSubAction(Res.string.toolsFilterTitle)
//    data object Relate : HomeSubAction(Res.string.toolsRelateTitle)
    data object Visualize : HomeSubAction(Res.string.toolsVisualizeTitle)
}
