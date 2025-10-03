package com.typ.voidbloom.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.typ.voidbloom.common.ui.components.TitledContainer
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.helpers.HomeActionsHelper
import com.typ.voidbloom.models.HomeAction
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeActionsWidget(
    title: String,
    actions: List<HomeAction>,
    modifier: Modifier = Modifier,
    onClickAction: (HomeAction) -> Unit,
) {
    TitledContainer(
        title = title,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            actions.fastForEach { homeAction ->
                HomeActionCard(
                    homeAction = homeAction,
                    onClickAction = onClickAction,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeActionsWidgetPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        HomeActionsWidget(
            title = "Explore Voidbloom",
            actions = remember { HomeActionsHelper.allActions },
            modifier = Modifier.fillMaxWidth(),
        ) {}
    }
}