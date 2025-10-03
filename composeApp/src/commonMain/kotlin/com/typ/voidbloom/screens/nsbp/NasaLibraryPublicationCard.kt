package com.typ.voidbloom.screens.nsbp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.shared.models.Publication

@Composable
fun NasaLibraryPublicationCard(
    publication: Publication,
    containerColor: Color = VbColors.background,
    contentColor: Color = VbColors.onBackground,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .heightIn(min = 100.dp)
            .clip(VbShapes.extraLarge)
            .background(containerColor)
            .vbClickable(onClick = onClick)
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp
            )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = VbTypography.titleLarge,
            fontWeight = FontWeight.Medium,
            text = publication.title,
            color = contentColor,
        )
    }
}