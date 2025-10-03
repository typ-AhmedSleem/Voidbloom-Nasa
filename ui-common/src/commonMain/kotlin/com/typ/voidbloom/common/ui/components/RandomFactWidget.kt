package com.typ.voidbloom.common.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.shared.models.Fact
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Duration.Companion.seconds

@Composable
fun RandomFactWidget(
    title: String,
    facts: List<Fact>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    var randomFact by remember {
        mutableStateOf(facts.random())
    }

    LaunchedEffect(Unit) {
        while (isActive) {
            delay(5.seconds)
            randomFact = facts.random()
        }
    }

    TitledContainer(
        title = title,
        modifier = modifier
    ) {
        AnimatedContent(
            targetState = randomFact,
            modifier = Modifier
                .fillMaxWidth()
        ) { fact ->
            FactCard(
                containerColor = Color.Transparent,
                contentColor = VbColors.onSurface,
                modifier = Modifier.fillMaxWidth(),
                borderColor = VbColors.secondaryContainer,
                shape = VbShapes.extraLarge,
                onClick = onClick,
                fact = fact,
            )
        }
    }
}

@Preview
@Composable
private fun RandomFactWidgetPreview() {
    PreviewContainer {
        RandomFactWidget(
            title = "Random Fact",
            facts = listOf(
                Fact("A day on Venus is longer than a year on Venus."),
                Fact("Humans share 50% of their DNA with bananas."),
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}