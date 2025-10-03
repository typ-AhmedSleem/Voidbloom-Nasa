package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.shared.models.Publication
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestedPublicationsWidget(
    title: String,
    pubs: List<Publication>,
    modifier: Modifier = Modifier,
    onClickPublication: (Publication) -> Unit = {},
) {
    val carouselState = rememberCarouselState { pubs.size }

    LaunchedEffect(Unit) {
        while (isActive) {
            delay(5.seconds)
            if (!carouselState.isScrollInProgress){
                val nextItem = (carouselState.currentItem + 1) % pubs.size
                carouselState.animateScrollToItem(nextItem)
            }
        }
    }

    TitledContainer(
        title = title,
        modifier = modifier
    ) {
        BoxWithConstraints {
            HorizontalMultiBrowseCarousel(
                state = carouselState,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .heightIn(max = 160.dp)
                    .padding(
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                contentPadding = PaddingValues(horizontal = 0.dp),
                preferredItemWidth = this.maxWidth.times(0.95f),
                itemSpacing = 16.dp,
            ) { idx ->
                val publication = pubs[idx]
                PublicationCard(
                    modifier = Modifier.alpha(
                        this.carouselItemDrawInfo.size / this.carouselItemDrawInfo.maxSize
                    ),
                    containerColor = VbColors.secondaryContainer.copy(0.5f),
                    onClick = { onClickPublication(publication) },
                    contentColor = VbColors.primary,
                    borderColor = Color.Unspecified,
                    pub = publication,
                )
            }
        }
    }
}