package com.typ.voidbloom.common.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.typ.voidbloom.common.ui.models.SelectorChoice
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChoiceSelectorCardsContainer(
    selection: Int,
    choices: List<SelectorChoice>,
    modifier: Modifier = Modifier,
    itemSpacing: Dp = 16.dp,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    onChoiceSelected: (Int) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            alignment = verticalAlignment,
            space = itemSpacing,
        )
    ) {
        choices.fastForEachIndexed { index, choice ->
            ChoiceSelectorCard(
                choice = choice,
                selected = index == selection,
                onClick = { onChoiceSelected(choices.indexOf(choice)) },
            )
        }
    }
}

@Preview
@Composable
private fun ChoiceSelectorCardsContainerPreview() {
    var selection by remember {
        mutableIntStateOf(-1)
    }
    val choices = remember {
        listOf(
            SelectorChoice(title = "Kid"),
            SelectorChoice(title = "Adult"),
            SelectorChoice(title = "Grownup")
        )
    }

    PreviewContainer {
        ChoiceSelectorCardsContainer(
            choices = choices,
            selection = selection,
            modifier = Modifier.fillMaxWidth(),
            onChoiceSelected = { selection = it }
        )
    }
}