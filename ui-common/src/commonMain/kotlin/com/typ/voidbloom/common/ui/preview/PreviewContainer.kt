package com.typ.voidbloom.common.ui.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VoidbloomTheme

@Composable
fun PreviewContainer(
    contentPaddings: PaddingValues = PaddingValues(16.dp),
    containerColor: Color = VbColors.surfaceContainer,
    content: @Composable () -> Unit,
) {
    VoidbloomTheme {
        Scaffold(containerColor = containerColor) { innerPaddings ->
            Box(
                modifier = Modifier
                    .padding(innerPaddings)
                    .padding(contentPaddings),
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }
    }
}