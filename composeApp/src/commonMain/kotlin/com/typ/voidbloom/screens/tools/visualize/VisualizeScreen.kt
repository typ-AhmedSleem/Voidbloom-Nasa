package com.typ.voidbloom.screens.tools.visualize

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastMap
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.components.headerMessage
import com.typ.voidbloom.components.headerSubMessage
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.screens.BaseActionScreen
import com.typ.voidbloom.shared.core.pubs.PublicationCategorizer
import com.typ.voidbloom.shared.core.pubs.PublicationsKeywordExtractor
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.headerMsgVisualize
import voidbloom.composeapp.generated.resources.publications
import voidbloom.composeapp.generated.resources.visualInsights

object VisualizeScreen : BaseActionScreen(0) {

    @Composable
    override fun Content() {
        val publications = remember {
            PublicationsRepository.getAllPubs()
        }
        val categories = remember {
            PublicationCategorizer.categorizeKeywords(
                showUncategorized = false,
                keywords = PublicationsKeywordExtractor.extractKeywords(publications.fastMap { pub -> pub.title }
                )
            )
        }

        ScreenLazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            headerMessage(Res.string.headerMsgVisualize)
            headerSubMessage(Res.string.visualInsights)
            item { HorizontalDivider() }

            item {
                CategoriesVisualGraph(
                    categoriesMap = categories,
                    modifier = Modifier.fillParentMaxWidth().heightIn(min = 300.dp),
                )
            }

            item { HorizontalDivider() }

            item {
                VSpacer(8.dp)
            }

            items(
                items = categories
                    .entries
                    .toList()
                    .sortedByDescending { it.value.size },
                key = { it.key }
            ) { (categoryName, categoryPubs) ->
                CategoryStatsCard(
                    categoryName = categoryName,
                    categoryPubsCount = categoryPubs.size,
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
    }

    @Composable
    private fun CategoryStatsCard(
        categoryName: String,
        categoryPubsCount: Int,
        modifier: Modifier = Modifier,
    ) {
        Row(
            modifier = modifier
                .clip(VbShapes.large)
                .background(VbColors.background)
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Medium,
                style = VbTypography.titleSmall,
                color = VbColors.onBackground,
                text = categoryName,
                maxLines = 1,
            )

            Text(
                text = "$categoryPubsCount ${Res.string.publications.string()}",
                style = VbTypography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = VbColors.primary,
                maxLines = 1,
            )
        }
    }

}

@Preview
@Composable
private fun VisualizeScreenPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        VisualizeScreen.Content()
    }
}