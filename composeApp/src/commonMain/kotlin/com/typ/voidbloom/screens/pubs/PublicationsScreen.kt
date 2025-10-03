package com.typ.voidbloom.screens.pubs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.navigator.LocalNavigator
import com.typ.voidbloom.common.ui.components.SuggestedPublicationsWidget
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.data.repo.PublicationsRepository.MAX_SUGGESTIONS_SIZE
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.screens.nsbp.NasaLibraryPublicationCard
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.headerMsgPublications
import voidbloom.composeapp.generated.resources.publicationsLibrary
import voidbloom.composeapp.generated.resources.titleSuggestedPublications

object PublicationsScreen : BaseActionScreen(HomeAction.Publications.hashCode()) {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val publications = remember {
            PublicationsRepository.getAllPubs()
        }
        val suggestedPublications = remember(publications) {
            publications
                .shuffled()
                .take(MAX_SUGGESTIONS_SIZE)
        }

        ScreenLazyColumn {
            headerMessage(Res.string.headerMsgPublications)

            item {
                HorizontalDivider()
            }

            item {
                SuggestedPublicationsWidget(
                    title = Res.string.titleSuggestedPublications.string(),
                    modifier = Modifier.fillMaxWidth(),
                    pubs = suggestedPublications,
                    onClickPublication = { publication ->
                        navigator?.push(PublicationViewerScreen(publication.id))
                    }
                )
            }

            item {
                Text(
                    fontWeight = FontWeight.SemiBold,
                    style = VbTypography.bodyLarge,
                    color = VbColors.secondary,
                    text = Res.string.publicationsLibrary.string(),
                    maxLines = 1,
                )
            }

            items(
                items = publications,
                key = { it.id }
            ) { publication ->
                NasaLibraryPublicationCard(
                    publication = publication,
                    modifier = Modifier.fillParentMaxWidth()
                ) {
                    navigator?.push(PublicationViewerScreen(publication.id))
                }
            }
        }
    }
}

@Preview
@Composable
private fun PublicationsScreenPreview() {
    PreviewContainer {
        PublicationsScreen.Content()
    }
}