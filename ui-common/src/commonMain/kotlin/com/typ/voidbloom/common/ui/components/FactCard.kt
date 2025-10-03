package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.shared.models.Fact
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FactCard(
    fact: Fact,
    shape: Shape = VbShapes.medium,
    containerColor: Color = Color.Unspecified,
    contentColor : Color = VbColors.onBackground,
    borderColor: Color = VbColors.surfaceContainer,
    textStyle: TextStyle = VbTypography.titleMedium,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    CenteredBox(
        modifier = modifier
            .heightIn(min = 100.dp)
            .clip(shape)
            .background(containerColor)
            .border(
                shape = shape,
                color = borderColor,
                width = if (borderColor.isSpecified) 3.dp else 0.dp,
            )
            .vbClickable(onClick = onClick)
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
    ) {
        Text(
            style = textStyle,
            color= contentColor,
            text = fact.title,
        )
    }
}

@Preview
@Composable
private fun FactCardPreview() {
    PreviewContainer {
        FactCard(
            fact = Fact(
                title = "Do you know that Voidbloom is your first NASA Space Biology ai companion app."
            )
        )
    }
}