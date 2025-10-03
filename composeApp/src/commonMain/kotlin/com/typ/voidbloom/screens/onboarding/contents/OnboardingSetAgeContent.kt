package com.typ.voidbloom.screens.onboarding.contents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.typ.voidbloom.common.ui.models.SelectorChoice
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.shared.enums.AgeConfig
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.adult
import voidbloom.composeapp.generated.resources.confirmAge
import voidbloom.composeapp.generated.resources.grownup
import voidbloom.composeapp.generated.resources.kid
import voidbloom.composeapp.generated.resources.onboardingSetAgeMsg

@Composable
fun OnboardingSetAgeContent(
    age: AgeConfig? = null,
    onClickConfirm: (AgeConfig) -> Unit,
) {
    // * Strings
    val kid = Res.string.kid.string()
    val adult = Res.string.adult.string()
    val grownup = Res.string.grownup.string()

    // * Runtime
    var selectedChoice by remember { mutableIntStateOf(age?.ordinal ?: -1) }
    val selectorChoices = remember {
        listOf(
            SelectorChoice(title = kid),
            SelectorChoice(title = adult),
            SelectorChoice(title = grownup),
        )
    }

    // * UI
    BaseOnboardingSetConfigContent(
        message = Res.string.onboardingSetAgeMsg.string(),
        buttonText = Res.string.confirmAge.string(),
        selectedChoice = selectedChoice,
        selectorChoices = selectorChoices,
        onSelectChoice = { selectedChoice = it },
        onClickButton = {
            AgeConfig
                .entries
                .getOrNull(selectedChoice)
                ?.also(onClickConfirm)
        }
    )
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    PreviewContainer {
        OnboardingSetAgeContent {}
    }
}