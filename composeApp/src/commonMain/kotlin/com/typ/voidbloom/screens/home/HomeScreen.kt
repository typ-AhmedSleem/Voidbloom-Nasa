package com.typ.voidbloom.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.typ.voidbloom.common.ui.components.RandomFactWidget
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.data.repo.FactsRepository
import com.typ.voidbloom.data.repo.PublicationsRepository
import com.typ.voidbloom.helpers.HomeActionsHelper
import com.typ.voidbloom.screens.facts.FactsScreen
import com.typ.voidbloom.shared.models.toFact
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.exploreVoidbloom
import voidbloom.composeapp.generated.resources.homeAppDescText
import voidbloom.composeapp.generated.resources.titleRandomFact

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val homeActions = remember { HomeActionsHelper.allActions }
        val facts = remember {
            FactsRepository
                .getAllSpaceFacts()
                .map { it.toFact() }
        }
        remember {
            PublicationsRepository.suggestPublications()
        }

        // * UI * //
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 0.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp
            )
        ) {
            Text(
                text = Res.string.homeAppDescText.string(),
                modifier = Modifier.fillMaxWidth(),
                style = VbTypography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                color = VbColors.secondary
            )

            HorizontalDivider()

            RandomFactWidget(
                onClick = { navigator?.push(FactsScreen) },
                title = Res.string.titleRandomFact.string(),
                modifier = Modifier.fillMaxWidth(),
                facts = facts,
            )

            HomeActionsWidget(
                actions = homeActions,
                modifier = Modifier.fillMaxWidth(),
                title = Res.string.exploreVoidbloom.string(),
                onClickAction = { action ->
                    navigator?.push(HomeActionsHelper.screenForAction(action))
                }
            )
        }
    }

}

@Preview
@Composable
private fun HomeScreenPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        HomeScreen.Content()
    }
}