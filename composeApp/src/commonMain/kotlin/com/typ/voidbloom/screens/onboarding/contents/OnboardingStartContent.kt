package com.typ.voidbloom.screens.onboarding.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.typ.voidbloom.common.ui.components.VSpacer
import com.typ.voidbloom.common.ui.components.VbFilledButton
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.letsBeginJourney
import voidbloom.composeapp.generated.resources.onboardingStartContentBody1
import voidbloom.composeapp.generated.resources.onboardingStartContentBody2
import voidbloom.composeapp.generated.resources.onboardingStartContentBody3
import voidbloom.composeapp.generated.resources.onboardingStartContentTitle

@Composable
fun OnboardingStartContent(onClickStart: () -> Unit) {
    val primaryColor = VbColors.tertiary
    // * Body texts
    val textBody1 = Res.string.onboardingStartContentBody1.string()
    val textBody2 = Res.string.onboardingStartContentBody2.string()
    val textBody3 = Res.string.onboardingStartContentBody3.string()
    val finalBodyText = remember(Locale.current) {
        buildAnnotatedString {
            append("$textBody1 ")

            withStyle(
                SpanStyle(
                    color = primaryColor,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append(textBody2)
            }

            append(" $textBody3")
        }
    }


    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            Text(
                text = Res.string.onboardingStartContentTitle.string(),
                style = VbTypography.displayMedium,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Black,
                color = VbColors.primary
            )

            VSpacer(32.dp)

            Text(
                style = VbTypography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal,
                color = VbColors.secondary,
                text = finalBodyText,
            )
        }

        VbFilledButton(
            onClick = onClickStart,
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.letsBeginJourney.string(),
        )
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    PreviewContainer {
        OnboardingStartContent {}
    }
}