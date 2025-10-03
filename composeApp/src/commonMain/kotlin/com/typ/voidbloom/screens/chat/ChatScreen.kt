package com.typ.voidbloom.screens.chat

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.components.VbFilledButton
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.components.PublicationsBottomSheet
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.components.headerSubMessage
import com.typ.voidbloom.data.models.ChatMessage
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.shared.models.Publication
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.ask
import voidbloom.composeapp.generated.resources.attachPublicationContext
import voidbloom.composeapp.generated.resources.chatContext
import voidbloom.composeapp.generated.resources.headerMsgAttachContext
import voidbloom.composeapp.generated.resources.headerMsgVoidbloomChat
import voidbloom.composeapp.generated.resources.placeholderAskAI

object ChatScreen : BaseActionScreen(HomeAction.VoidbloomChat.hashCode()), KoinComponent {

    @Composable
    override fun Content() {
        val lazyListState = rememberLazyListState()

        val viewModel: ChatViewModel = remember { get() }

        val isPickerVisible by viewModel.isPickerVisible.collectAsStateWithLifecycle()
        val publicationContext by viewModel.publicationContext.collectAsStateWithLifecycle()
        val userMessageText by viewModel.userMessageText.collectAsStateWithLifecycle()
        val isBotReady by viewModel.isBotReady.collectAsStateWithLifecycle()

        val chatMessages: List<ChatMessage> = remember { viewModel.chatMessages }

        LaunchedEffect(chatMessages.size) {
            val lastIdx = chatMessages.lastIndex
            if (lastIdx >= 0) {
                delay(250)
                lazyListState.animateScrollToItem(lastIdx)
            }
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ScreenLazyColumn(
                state = lazyListState,
                modifier = Modifier
                    .weight(1f)
                    .animateContentSize(),
                verticalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.Bottom,
                    space = 16.dp,
                )
            ) {
                if (publicationContext == null) {
                    headerMessage(Res.string.headerMsgVoidbloomChat)
                    headerSubMessage(Res.string.headerMsgAttachContext)
                    item { VSpacer(8.dp) }
                } else {
                    item {
                        publicationContext?.let { publication ->
                            ChatPublicationContextCard(
                                modifier = Modifier.fillParentMaxWidth(),
                                publication = publication,
                            )
                        }
                    }
                }

                if (publicationContext == null) {
                    item {
                        VbFilledButton(
                            text = Res.string.attachPublicationContext.string(),
                            onClick = viewModel::showContextPicker,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                } else {
                    items(
                        items = chatMessages,
                    ) { chatMessage ->
                        ChatBubble(chatMessage)
                    }
                }
            }

            if (publicationContext != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        alignment = Alignment.CenterHorizontally,
                        space = 8.dp,
                    )
                ) {
                    TextField(
                        singleLine = true,
                        value = userMessageText,
                        shape = VbShapes.extraLarge,
                        modifier = Modifier.weight(1f),
                        onValueChange = { viewModel.updateInputFieldText(it) },
                        placeholder = { Text(Res.string.placeholderAskAI.string()) }
                    )

                    VbFilledButton(
                        onClick = viewModel::askQuestion,
                        text = Res.string.ask.string(),
                        shape = VbShapes.extraLarge,
                        enabled = isBotReady,
                    )
                }
            }
        }

        // Publication context picker
        PublicationsBottomSheet(
            isVisible = isPickerVisible,
            publications = viewModel.publications,
            onDismissSheet = viewModel::hideContextPicker,
            onClickPublication = { publication ->
                viewModel.attachPublicationContext(publication)
                true
            },
        )
    }

    @Composable
    private fun ChatPublicationContextCard(
        publication: Publication,
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier
                .heightIn(min = 64.dp)
//                .clip(VbShapes.large)
//                .background(VbColors.secondaryContainer)
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(
                text = Res.string.chatContext.string(),
                style = VbTypography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = VbColors.tertiary,
            )
            HorizontalDivider(
                color = VbColors.onSecondaryContainer.copy(0.25f)
            )
            Text(
                style = VbTypography.headlineSmall,
                fontWeight = FontWeight.Medium,
                color = VbColors.secondary,
                text = publication.title,
            )
        }
    }

}

@Preview
@Composable
private fun ChatScreenPreview() {
    PreviewContainer {
        ChatScreen.Content()
    }
}