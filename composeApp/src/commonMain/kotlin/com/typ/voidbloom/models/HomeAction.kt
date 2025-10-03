package com.typ.voidbloom.models

import org.jetbrains.compose.resources.StringResource
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.headerMsgFactsScreen
import voidbloom.composeapp.generated.resources.homeActionAdvancedToolsDesc
import voidbloom.composeapp.generated.resources.homeActionAdvancedToolsTitle
import voidbloom.composeapp.generated.resources.homeActionAiChatDesc
import voidbloom.composeapp.generated.resources.homeActionAiChatTitle
import voidbloom.composeapp.generated.resources.homeActionFactsTitle
import voidbloom.composeapp.generated.resources.homeActionLibraryDesc
import voidbloom.composeapp.generated.resources.homeActionLibraryTitle
import voidbloom.composeapp.generated.resources.homeActionPublicationDesc
import voidbloom.composeapp.generated.resources.homeActionPublicationTitle
import voidbloom.composeapp.generated.resources.homeActionSettingsDesc
import voidbloom.composeapp.generated.resources.homeActionSettingsTitle

sealed class HomeAction(
    val title: StringResource,
    val desc: StringResource,
    val subActions: List<HomeSubAction> = emptyList(),
) {

    data object Publications : HomeAction(
        title = Res.string.homeActionPublicationTitle,
        desc = Res.string.homeActionPublicationDesc,
    )

    data object AdvancedTools : HomeAction(
        title = Res.string.homeActionAdvancedToolsTitle,
        desc = Res.string.homeActionAdvancedToolsDesc,
        subActions = listOf(
            HomeSubAction.Search,
//            HomeSubAction.Relate,
            HomeSubAction.Visualize,
        )
    )

    data object VoidbloomChat : HomeAction(
        title = Res.string.homeActionAiChatTitle,
        desc = Res.string.homeActionAiChatDesc,
    )

    data object Library : HomeAction(
        title = Res.string.homeActionLibraryTitle,
        desc = Res.string.homeActionLibraryDesc,
    )

    data object Facts : HomeAction(
        title = Res.string.homeActionFactsTitle,
        desc = Res.string.headerMsgFactsScreen,
    )

    data object Settings : HomeAction(
        title = Res.string.homeActionSettingsTitle,
        desc = Res.string.homeActionSettingsDesc,
    )

}