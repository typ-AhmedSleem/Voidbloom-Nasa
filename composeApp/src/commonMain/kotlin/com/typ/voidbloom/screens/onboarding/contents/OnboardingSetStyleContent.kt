package com.typ.voidbloom.screens.onboarding.contents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.typ.voidbloom.common.ui.models.SelectorChoice
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.shared.enums.StyleConfig
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.descOverexplained
import voidbloom.composeapp.generated.resources.descOversimplified
import voidbloom.composeapp.generated.resources.descRegular
import voidbloom.composeapp.generated.resources.finishSetup
import voidbloom.composeapp.generated.resources.onboardingSetStyleMsg
import voidbloom.composeapp.generated.resources.titleOverexplained
import voidbloom.composeapp.generated.resources.titleOversimplified
import voidbloom.composeapp.generated.resources.titleRegular

@Composable
fun OnboardingSetStyleContent(
    style: StyleConfig? = null,
    onClickConfirm: (StyleConfig) -> Unit,
) {
    // * Titles
    val titleOversimplified = Res.string.titleOversimplified.string()
    val titleRegular = Res.string.titleRegular.string()
    val titleOverexplained = Res.string.titleOverexplained.string()
    // * Descriptions
    val descOversimplified = Res.string.descOversimplified.string()
    val descRegular = Res.string.descRegular.string()
    val descOverexplained = Res.string.descOverexplained.string()


    // * Runtime
    var selectedChoice by remember { mutableIntStateOf(style?.ordinal ?: -1) }
    val selectorChoices = remember {
        listOf(
            SelectorChoice(
                title = titleOversimplified,
                desc = descOversimplified
            ),
            SelectorChoice(
                title = titleRegular,
                desc = descRegular
            ),
            SelectorChoice(
                title = titleOverexplained,
                desc = descOverexplained
            ),
        )
    }

    // * UI
    BaseOnboardingSetConfigContent(
        message = Res.string.onboardingSetStyleMsg.string(),
        buttonText = Res.string.finishSetup.string(),
        selectedChoice = selectedChoice,
        selectorChoices = selectorChoices,
        onSelectChoice = { selectedChoice = it },
        onClickButton = {
            StyleConfig
                .entries
                .getOrNull(selectedChoice)
                ?.also(onClickConfirm)
        }
    )
}

@Preview
@Composable
private fun OnboardingSetStyleContentPreview() {
    PreviewContainer {
        OnboardingSetStyleContent {}
    }
}