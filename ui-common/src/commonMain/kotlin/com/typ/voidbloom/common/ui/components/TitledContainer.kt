package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import kotlinx.serialization.json.JsonNull.content

@Composable
fun TitledContainer(
    title: String,
    color: Color = VbColors.secondary,
    style: TextStyle = VbTypography.bodyLarge,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            fontWeight = FontWeight.SemiBold,
            style = style,
            color = color,
            text = title,
            maxLines = 1,
        )
        content()
    }
}