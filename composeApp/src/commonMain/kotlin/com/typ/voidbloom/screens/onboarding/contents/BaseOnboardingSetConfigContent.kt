package com.typ.voidbloom.screens.onboarding.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.components.ChoiceSelectorCardsContainer
import com.typ.voidbloom.common.ui.components.VbFilledButton
import com.typ.voidbloom.common.ui.models.SelectorChoice
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography

@Composable
fun BaseOnboardingSetConfigContent(
    message: String,
    buttonText: String,
    selectedChoice: Int,
    selectorChoices: List<SelectorChoice>,
    onSelectChoice: (Int) -> Unit,
    onClickButton: () -> Unit,
) {
    val buttonEnabled by remember(selectedChoice) {
        derivedStateOf { selectedChoice != -1 }
    }
    // * UI
    Column(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = 8.dp,
                    bottom = 12.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = message,
                modifier = Modifier.fillMaxWidth(),
                style = VbTypography.displaySmall,
                fontWeight = FontWeight.Medium,
                color = VbColors.primary,
            )

            ChoiceSelectorCardsContainer(
                choices = selectorChoices,
                selection = selectedChoice,
                modifier = Modifier.weight(1f),
                onChoiceSelected = { onSelectChoice(it) },
                verticalAlignment = Alignment.CenterVertically,
            )
        }

        VbFilledButton(
            text = buttonText,
            onClick = onClickButton,
            enabled = buttonEnabled,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}