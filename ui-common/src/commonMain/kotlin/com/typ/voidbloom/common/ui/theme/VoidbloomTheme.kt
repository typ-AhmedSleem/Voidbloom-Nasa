package com.typ.voidbloom.common.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun VoidbloomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = initVbTypography(),
        colorScheme = initVbColors(),
        shapes = initVbShapes(),
        content = content
    )
}