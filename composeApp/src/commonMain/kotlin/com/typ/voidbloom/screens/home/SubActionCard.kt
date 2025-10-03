package com.typ.voidbloom.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography

@Composable
fun SubActionCard(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .heightIn(min = 64.dp)
            .clip(VbShapes.extraLarge)
            .background(VbColors.secondaryContainer)
            .vbClickable(onClick = onClick)
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Text(
            style = VbTypography.titleLarge,
            color = VbColors.onSecondaryContainer,
            text = title,
        )
    }
}