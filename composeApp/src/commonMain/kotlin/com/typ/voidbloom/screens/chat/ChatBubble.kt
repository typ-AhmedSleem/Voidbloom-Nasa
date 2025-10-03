package com.typ.voidbloom.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.m3.Markdown
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.data.models.ChatMessage

@Composable
fun LazyItemScope.ChatBubble(message: ChatMessage) {
    val alignment = remember(message) {
        if (message.byUser) Alignment.TopEnd else Alignment.TopStart
    }
    val bubbleContainerColor = when (message) {
        is ChatMessage.Error -> VbColors.errorContainer
        is ChatMessage.Message -> {
            if (message.byUser) VbColors.secondaryContainer else VbColors.tertiaryContainer
        }

        is ChatMessage.Thinking -> VbColors.background
    }

    when (message) {
        is ChatMessage.Error -> VbColors.onErrorContainer
        is ChatMessage.Message -> {
            if (message.byUser) VbColors.onSecondaryContainer else VbColors.onTertiaryContainer
        }

        is ChatMessage.Thinking -> VbColors.onBackground
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 0.dp
            ).animateItem(),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .widthIn(max = 300.dp)
                .clip(VbShapes.large)
                .background(bubbleContainerColor)
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                )
        ) {
            Markdown(
                content = message.content,
                modifier = Modifier,
            )
        }
    }

}