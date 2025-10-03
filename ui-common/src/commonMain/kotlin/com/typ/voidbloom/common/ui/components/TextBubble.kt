package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextBubble(
    text: String,
    style: TextStyle = TextStyle.Default,
    textColor: Color = VbColors.onSurface,
    containerColor: Color = VbColors.surfaceContainer,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(containerColor)
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            )
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            style = style,
            text = text,
            maxLines = 1
        )
    }
}

@Preview
@Composable
private fun TextBubblePreview() {
    PreviewContainer {
        TextBubble(
            text = "Voidbloom"
        )
    }
}

