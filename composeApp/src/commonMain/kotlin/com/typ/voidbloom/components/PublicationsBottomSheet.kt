package com.typ.voidbloom.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.screens.nsbp.NasaLibraryPublicationCard
import com.typ.voidbloom.shared.core.pubs.PublicationsSearchEngine
import com.typ.voidbloom.shared.models.Publication
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.pickPublication
import voidbloom.composeapp.generated.resources.placeHolderSearchForPublication

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublicationsBottomSheet(
    isVisible: Boolean,
    publications: List<Publication>,
    title: StringResource = Res.string.pickPublication,
    onDismissSheet: () -> Unit,
    onClickPublication: (Publication) -> Boolean = { true },
) {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(true) {
        isVisible || it != SheetValue.Expanded
    }

    var filteredPublications: List<Publication> by remember { mutableStateOf(publications) }
    var searchQuery: String by remember { mutableStateOf("") }

    LaunchedEffect(searchQuery) {
        filteredPublications = PublicationsSearchEngine.performSearchWithFiltersBlocking(
            publications = publications,
            query = searchQuery
        ).takeIf { it.isNotEmpty() } ?: publications
    }

    if (isVisible) {
        ModalBottomSheet(
            containerColor = VbColors.surfaceContainer,
            contentColor = VbColors.onSurface,
            onDismissRequest = onDismissSheet,
            sheetState = sheetState
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                headerMessage(title)

                item {
                    TextField(
                        value = searchQuery,
                        singleLine = true,
                        shape = VbShapes.extraLarge,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillParentMaxWidth(),
                        placeholder = { Text(Res.string.placeHolderSearchForPublication.string()) }
                    )
                }

                item { VSpacer(4.dp) }

                items(
                    items = filteredPublications,
                    key = { it.id }
                ) { publication ->
                    NasaLibraryPublicationCard(
                        publication = publication,
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .animateItem(),
                        onClick = {
                            val shouldHide = onClickPublication(publication)
                            if (shouldHide) {
                                coroutineScope.launch {
                                    sheetState.hide()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}