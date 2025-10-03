package com.typ.voidbloom.screens.facts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.data.repo.FactsRepository
import com.typ.voidbloom.models.HomeAction
import com.typ.voidbloom.screens.BaseActionScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

object FactsScreen : BaseActionScreen(HomeAction.Facts.hashCode()) {

    @Composable
    override fun Content() {
        val facts = remember { FactsRepository.getAllSpaceFacts().shuffled() }
        val pagerState = rememberPagerState { facts.size }

        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) { factIdx ->
            val fact = facts[factIdx]
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = VbTypography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = VbColors.secondary,
                    text = fact.title,
                )

                HorizontalDivider()

                VSpacer(24.dp)

                Text(
                    style = VbTypography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = VbColors.primary,
                    text = fact.description,
                )
            }
        }
    }

}

@Preview
@Composable
private fun FactsScreenPreview() {
    PreviewContainer {
        FactsScreen.Content()
    }
}