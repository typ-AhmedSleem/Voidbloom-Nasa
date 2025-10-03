package com.typ.voidbloom.screens.nsbp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.support.WebBrowser
import org.jetbrains.compose.ui.tooling.preview.Preview
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.headerMsgNasaLibrary

object NasaLibraryScreen : BaseActionScreen(HomeAction.Publications.hashCode()) {

    @Composable
    override fun Content() {
        val publications = remember { PublicationsRepository.getAllPubs() }

        ScreenLazyColumn {
            headerMessage(Res.string.headerMsgNasaLibrary)

            items(
                items = publications,
                key = { it.id },
            ) { publication ->
                NasaLibraryPublicationCard(
                    onClick = { WebBrowser.openUrl(publication.link) },
                    modifier = Modifier.fillParentMaxWidth(),
                    publication = publication,
                )
            }
        }
    }
}

@Preview
@Composable
private fun NasaLibraryScreenPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        NasaLibraryScreen.Content()
    }
}