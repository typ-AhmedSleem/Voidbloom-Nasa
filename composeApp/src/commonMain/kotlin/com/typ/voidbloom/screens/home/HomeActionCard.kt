package com.typ.voidbloom.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import cafe.adriel.voyager.navigator.LocalNavigator
import com.typ.voidbloom.common.ui.modifiers.vbClickable
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbShapes
import com.typ.voidbloom.common.ui.theme.VbTypography
import com.typ.voidbloom.helpers.HomeActionsHelper
import com.typ.voidbloom.models.HomeAction
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string

@Composable
fun HomeActionCard(
    homeAction: HomeAction,
    modifier: Modifier = Modifier,
    onClickAction: (HomeAction) -> Unit,
) {
    val navigator = LocalNavigator.current
    val canExpand = remember(homeAction) {
        homeAction.subActions.isNotEmpty()
    }
    var expanded by remember {
        mutableStateOf(false)
    }

    // * Animated ui states
    val containerColor by animateColorAsState(
        targetValue = if (expanded) VbColors.surfaceContainer else VbColors.background
    )
    val borderColor by animateColorAsState(
        targetValue = if (expanded) VbColors.outline.copy(0.25f) else Color.Transparent
    )

    Row(
        modifier = modifier
            .heightIn(min = 100.dp)
            .clip(VbShapes.extraLarge)
            .background(containerColor)
            .border(
                width = 3.dp,
                color = borderColor,
                shape = VbShapes.extraLarge
            )
            .vbClickable {
                if (canExpand) expanded = !expanded
                else onClickAction(homeAction)
            }
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 8.dp
            )
            .animateContentSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterVertically,
                space = 4.dp,
            )
        ) {
            Text(
                text = homeAction.title.string(),
                fontWeight = FontWeight.SemiBold,
                style = VbTypography.titleLarge,
                color = VbColors.onBackground,
                maxLines = 1
            )

            Text(
                style = VbTypography.bodyMedium,
                text = homeAction.desc.string(),
                color = VbColors.secondary,
                maxLines = 3,
            )

            AnimatedVisibility(
                visible = expanded,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp,
                            bottom = 8.dp,
                            start = 8.dp,
                            end = 8.dp,
                        ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    homeAction
                        .subActions
                        .fastForEach { subAction ->
                            SubActionCard(
                                modifier = Modifier.fillMaxWidth(),
                                title = subAction.title.string(),
                            ) {
                                navigator?.push(HomeActionsHelper.screenForSubAction(subAction))
                            }
                        }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeActionCardPreview() {
    PreviewContainer(PaddingValues(16.dp)) {
        HomeActionCard(
            modifier = Modifier.fillMaxWidth(),
            homeAction = remember { HomeAction.AdvancedTools }
        ) {}
    }
}