package com.typ.voidbloom.common.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.models.SelectorChoice
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun ChoiceSelectorCard(
    selected: Boolean,
    choice: SelectorChoice,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val borderStrokeAnimated = animateDpAsState(
        targetValue = if (selected) 2.dp else 0.dp
    )

    Row(
        modifier = modifier
            .heightIn(min = 100.dp)
            .clip(VbShapes.extraLarge)
            .background(VbColors.background)
            .border(
                color = if (selected) VbColors.primary else Color.Transparent,
                shape = VbShapes.extraLarge,
                width = borderStrokeAnimated.value,
            )
            .vbClickable(onClick = onClick)
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 24.dp,
                end = 8.dp
            ),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterVertically,
                space = 4.dp,
            )
        ) {
            Text(
                color = if (selected) VbColors.primary else VbColors.onBackground,
                style = VbTypography.titleLarge,
                fontWeight = FontWeight.Medium,
                text = choice.title,
                maxLines = 1
            )
            if (choice.desc.isNotBlank()) {
                Text(
                    style = VbTypography.bodyMedium,
                    text = choice.desc,
                    maxLines = 3
                )
            }
        }

        RadioButton(
            selected = selected,
            onClick = onClick
        )
    }
}

@Preview
@Composable
private fun ChoiceSelectorCardPreview() {
    PreviewContainer {
        Column(modifier = Modifier.fillMaxWidth()) {
            ChoiceSelectorCard(
                selected = true,
                choice = SelectorChoice(
                    title = "Kid"
                ),
            ) {}

            VSpacer(8.dp)

            ChoiceSelectorCard(
                selected = false,
                choice = SelectorChoice(
                    title = "Adult",
                    desc = "Regular information verbosityRegular information verbosityRegular information verbosityRegular information verbosityRegular information verbosityRegular information verbosityRegular information verbosity"
                ),
            ) {}
        }
    }
}