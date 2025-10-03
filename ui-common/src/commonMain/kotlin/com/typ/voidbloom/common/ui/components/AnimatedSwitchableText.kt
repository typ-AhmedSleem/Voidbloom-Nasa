package com.typ.voidbloom.common.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.typ.voidbloom.common.ui.theme.VbColors

@Composable
fun AnimatedSwitchableText(
    text: String,
    style: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    color: Color = VbColors.onSurface,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier,
) {
    AnimatedContent(
        targetState = text,
        transitionSpec = {
            (fadeIn() + slideInVertically()) togetherWith (fadeOut() + slideOutVertically())
        },
        modifier = modifier
    ) {
        Text(
            fontWeight = fontWeight,
            maxLines = maxLines,
            style = style,
            color = color,
            text = text,
        )
    }

}