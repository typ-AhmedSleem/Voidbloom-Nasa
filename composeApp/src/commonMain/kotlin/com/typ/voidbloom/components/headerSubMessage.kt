package com.typ.voidbloom.components

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import org.jetbrains.compose.resources.StringResource
import pro.respawn.kmmutils.compose.resources.string

fun LazyListScope.headerSubMessage(headerMessage: StringResource) {
    item {
        Text(
            style = VbTypography.titleMedium,
            text = headerMessage.string(),
            color = VbColors.tertiary,
        )
    }
}