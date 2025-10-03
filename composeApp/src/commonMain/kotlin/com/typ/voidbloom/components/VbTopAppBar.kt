package com.typ.voidbloom.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.navigator.LocalNavigator
import com.typ.voidbloom.common.ui.components.TextBubble
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.appName
import voidbloom.composeapp.generated.resources.back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VbTopAppBar() {
    val navigator = LocalNavigator.current

    CenterAlignedTopAppBar(
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
        colors = TopAppBarDefaults.topAppBarColors(titleContentColor = VbColors.primary),
        title = {
            TextBubble(
                text = Res.string.appName.string(),
//                containerColor = VbColors.surface,
                textColor = VbColors.onSurface,
                style = VbTypography.titleLarge
                    .copy(fontWeight = FontWeight.SemiBold),
            )
        },
        navigationIcon = {
            if (navigator?.canPop == true) {
                Button(
                    colors = ButtonDefaults.textButtonColors(),
                    onClick = { navigator.pop() }
                ) {
                    Text(Res.string.back.string())
                }
            }
        }
    )
}

@Preview
@Composable
private fun VbTopAppBarPreview() {
    PreviewContainer {
        VbTopAppBar()
    }
}