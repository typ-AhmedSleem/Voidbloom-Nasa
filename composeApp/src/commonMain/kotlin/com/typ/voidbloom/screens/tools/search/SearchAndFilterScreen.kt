package com.typ.voidbloom.screens.tools.search

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.screens.nsbp.NasaLibraryPublicationCard
import com.typ.voidbloom.screens.pubs.PublicationViewerScreen
import com.typ.voidbloom.shared.core.pubs.PublicationsSearchEngine
import com.typ.voidbloom.shared.models.Publication
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.found
import voidbloom.composeapp.generated.resources.headerMsgSearchAndFilter
import voidbloom.composeapp.generated.resources.headerMsgSearchEmpty
import voidbloom.composeapp.generated.resources.placeholderSearchAndFilter
import voidbloom.composeapp.generated.resources.publications

object SearchAndFilterScreen : BaseActionScreen(0) {

    // todo: Better use SearchViewModel instead of these variables (if still have time)

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var query: String by remember { mutableStateOf("") }
        var searchQuery: String by remember { mutableStateOf("") }
        val publications: List<Publication> = remember { PublicationsRepository.getAllPubs() }
        var filteredPubs: List<Publication> by remember { mutableStateOf(emptyList()) }

        LaunchedEffect(searchQuery) {
            filteredPubs = PublicationsSearchEngine.performSearchWithFiltersBlocking(publications, query)
        }

        val headerMessageText = if (filteredPubs.isEmpty()) {
            if (searchQuery.isBlank()) {
                Res.string.headerMsgSearchAndFilter.string()
            } else {
                "${Res.string.headerMsgSearchEmpty.string()} '$query'."
            }
        } else {
            "${Res.string.found.string()} ${filteredPubs.size} ${Res.string.publications.string()}"
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ScreenLazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .animateContentSize(),
            ) {
                searchHeaderMessage(headerMessageText)

                items(
                    items = filteredPubs,
                    key = { it.id },
                ) { publication ->
                    NasaLibraryPublicationCard(
                        modifier = Modifier.fillParentMaxWidth().animateItem(),
                        publication = publication,
                    ) {
                        navigator?.push(PublicationViewerScreen(publication.id))
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.CenterHorizontally,
                    space = 8.dp,
                )
            ) {
                TextField(
                    value = query,
                    singleLine = true,
                    shape = VbShapes.extraLarge,
                    onValueChange = { query = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text(Res.string.placeholderSearchAndFilter.string()) }
                )

                FloatingActionButton(
                    shape = VbShapes.extraLarge,
                    onClick = { searchQuery = query },
                    containerColor = VbColors.primaryContainer,
                ) {
                    Text("Search")
                }
            }
        }
    }

    private fun LazyListScope.searchHeaderMessage(text: String) {
        item {
            Text(
                style = VbTypography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                color = VbColors.secondary,
                text = text,
            )
        }
    }

}

@Preview
@Composable
private fun SearchAndFilterScreenPreview() {
    PreviewContainer {
        SearchAndFilterScreen.Content()
    }
}