package com.typ.voidbloom.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography

@Composable
fun SettingsCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    trailingContent: @Composable () -> Unit = {},
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .heightIn(min = 100.dp)
            .clip(VbShapes.extraLarge)
            .background(VbColors.background)
            .vbClickable(onClick = onClick)
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
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
                fontWeight = FontWeight.Normal,
                style = VbTypography.titleLarge,
                color = VbColors.onBackground,
                maxLines = 1,
                text = title
            )

            Text(
                fontWeight = FontWeight.SemiBold,
                style = VbTypography.bodyMedium,
                color = VbColors.primary,
                maxLines = 3,
                text = value
            )
        }

        trailingContent()
    }
}