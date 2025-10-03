package com.typ.voidbloom.screens.pubs

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import com.mikepenz.markdown.m3.Markdown
import com.typ.voidbloom.common.ui.components.KottieAnimationView
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.utils.abstract
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.displayContent
import voidbloom.composeapp.generated.resources.summarizing

class PublicationViewerScreen(private val pubId: String) : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val publication = remember(pubId) { PublicationsRepository.publicationById(pubId) }

        val viewModel = remember {
            get<PublicationViewerViewModel>(
                parameters = {
                    parametersOf(publication)
                }
            )
        }
        var articlePubDisplayMode by remember { mutableStateOf(PubDisplayMode.ORIGINAL) }
        val summarizedContent by viewModel.summarizedContent.collectAsStateWithLifecycle()
        val isSummarizing by viewModel.isSummarizing.collectAsStateWithLifecycle()

        AnimatedContent(
            targetState = isSummarizing,
            modifier = Modifier.fillMaxSize()
        ) { summarizing ->
            if (summarizing) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        alignment = Alignment.CenterVertically,
                        space = 24.dp,
                    )
                ) {
                    KottieAnimationView(
                        iterations = 9999,
                        lottieFilenameInVbRes = "lottie_dna_animation.json",
                        onAnimationCompleted = {},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.25f),
                    )

                    Text(
                        text = Res.string.summarizing.string(),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold,
                        style = VbTypography.titleLarge,
                        textAlign = TextAlign.Center,
                        color = VbColors.secondary,
                        maxLines = 1,
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        alignment = Alignment.Top,
                        space = 8.dp,
                    )
                ) {
                    Text(
                        text = Res.string.displayContent.string(),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold,
                        style = VbTypography.titleMedium,
                        color = VbColors.secondary,
                    )

                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.fillMaxWidth(),
                        space = (-8).dp
                    ) {
                        PubDisplayMode
                            .entries
                            .fastForEach { displayMode ->
                                SegmentedButton(
                                    label = { Text(text = displayMode.title.string()) },
                                    onClick = {
                                        if (displayMode == PubDisplayMode.SUMMARIZED) {
                                            // * Check if content needs to be summarized
                                            viewModel.summarizeIfNeeded()
                                        }
                                        articlePubDisplayMode = displayMode
                                    },
                                    selected = articlePubDisplayMode == displayMode,
                                    shape = VbShapes.extraLarge,
                                )
                            }
                    }

                    VSpacer(8.dp)

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = VbTypography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = VbColors.primary,
                        text = publication.title,
                    )

                    if (articlePubDisplayMode == PubDisplayMode.ORIGINAL) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = VbTypography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Justify,
                            text = publication.abstract(),
                            color = VbColors.onSurface,
                        )
                    } else {
                        Markdown(
                            modifier = Modifier.fillMaxWidth(),
                            content = summarizedContent,
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
private fun PublicationViewerScreenPreview() {
    PreviewContainer {
        PublicationViewerScreen("PMC11271499").Content()
    }
}