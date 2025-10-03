package com.typ.voidbloom.screens.tools

import androidx.compose.runtime.Composable
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.headerMsgAdvancedTools

object AdvancedToolsScreen : BaseActionScreen(HomeAction.AdvancedTools.hashCode()) {

    @Composable
    override fun Content() {
        ScreenLazyColumn {
            headerMessage(Res.string.headerMsgAdvancedTools)
        }
    }

}