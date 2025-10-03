package com.typ.voidbloom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.CrossfadeTransition
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VoidbloomTheme
import com.typ.voidbloom.components.VbTopAppBar
import com.typ.voidbloom.helpers.determineStartupScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    VoidbloomTheme {
        Navigator(determineStartupScreen()) { voyager ->
            Scaffold(
                containerColor = VbColors.surfaceContainer,
                modifier = Modifier.fillMaxSize(),
                topBar = { VbTopAppBar() }
            ) { innerPaddings ->
                CrossfadeTransition(
                    navigator = voyager,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPaddings)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    PreviewContainer(
        PaddingValues(0.dp)
    ) {
        App()
    }
}