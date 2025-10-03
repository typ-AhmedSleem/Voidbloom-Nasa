package com.typ.voidbloom.helpers

import androidx.compose.ui.util.fastFirstOrNull
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.models.HomeSubAction
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.screens.chat.ChatScreen
import com.typ.voidbloom.screens.facts.FactsScreen
import com.typ.voidbloom.screens.nsbp.NasaLibraryScreen
import com.typ.voidbloom.screens.pubs.PublicationsScreen
import com.typ.voidbloom.screens.settings.SettingsScreen
import com.typ.voidbloom.screens.tools.AdvancedToolsScreen
import com.typ.voidbloom.screens.tools.search.SearchAndFilterScreen
import com.typ.voidbloom.screens.tools.visualize.VisualizeScreen

object HomeActionsHelper {

    val allActions: List<HomeAction> = listOf(
        HomeAction.Publications,
        HomeAction.AdvancedTools,
        HomeAction.VoidbloomChat,
        HomeAction.Library,
        HomeAction.Facts,
        HomeAction.Settings,
    )

    fun actionsByHash(hash: Int): HomeAction? {
        return allActions.fastFirstOrNull { it.hashCode() == hash }
    }

    fun screenForAction(action: HomeAction): BaseActionScreen {
        return when (action) {
            HomeAction.Publications -> PublicationsScreen
            HomeAction.AdvancedTools -> AdvancedToolsScreen
            HomeAction.VoidbloomChat -> ChatScreen
            HomeAction.Library -> NasaLibraryScreen
            HomeAction.Facts -> FactsScreen
            HomeAction.Settings -> SettingsScreen
        }
    }

    fun screenForSubAction(subAction: HomeSubAction): BaseActionScreen {
        return when (subAction) {
            HomeSubAction.Search -> SearchAndFilterScreen
//            HomeSubAction.Relate -> AdvancedToolsScreen
            HomeSubAction.Visualize -> VisualizeScreen
        }
    }

}