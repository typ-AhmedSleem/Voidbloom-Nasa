package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.CarouselItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.shared.models.Publication

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselItemScope.PublicationCard(
    pub: Publication,
    containerColor: Color = Color.Unspecified,
    contentColor: Color = VbColors.onBackground,
    borderColor: Color = VbColors.surfaceContainer,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .height(180.dp)
            .maskClip(VbShapes.extraLarge)
//            .background(containerColor)
            .maskBorder(
                shape = VbShapes.extraLarge,
                border = BorderStroke(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            VbColors.primary,
                            VbColors.secondary,
                            VbColors.tertiary,
                        ),
                        start = Offset(0.0f, 50.0f),
                        end = Offset(0.0f, 100.0f)
                    ),
                    width = 2.dp,
                )
            )
            .vbClickable(onClick = onClick)
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            style = VbTypography.titleLarge,
            autoSize = TextAutoSize.StepBased(
                minFontSize = VbTypography.titleMedium.fontSize,
                maxFontSize = VbTypography.headlineMedium.fontSize,
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold,
            color = contentColor,
            text = pub.title,
        )
    }
}