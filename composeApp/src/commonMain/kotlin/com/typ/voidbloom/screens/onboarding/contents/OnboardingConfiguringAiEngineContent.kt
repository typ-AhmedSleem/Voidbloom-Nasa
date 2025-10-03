package com.typ.voidbloom.screens.onboarding.contents

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import com.typ.voidbloom.common.ui.components.AnimatedSwitchableText
import com.typ.voidbloom.common.ui.components.CenteredBox
import com.typ.voidbloom.common.ui.components.KottieAnimationView
import com.typ.voidbloom.common.ui.components.VbFilledButton
import com.typ.voidbloom.common.ui.preview.PreviewContainer
import com.typ.voidbloom.common.ui.theme.VbColors
import com.typ.voidbloom.common.ui.theme.VbTypography
import org.jetbrains.compose.ui.tooling.preview.Preview
import pro.respawn.kmmutils.compose.resources.string
import voidbloom.composeapp.generated.resources.Res
import voidbloom.composeapp.generated.resources.enterVoidbloom
import voidbloom.composeapp.generated.resources.ready
import voidbloom.composeapp.generated.resources.settingUp

@Composable
fun OnboardingConfiguringAiEngineContent(
    onFinish: () -> Unit,
) {
    var finishedConfiguringAiEngine by remember { mutableStateOf(false) }
    val (statusText, statusTextColor) = if (finishedConfiguringAiEngine) {
        Res.string.ready.string() to VbColors.primary
    } else {
        Res.string.settingUp.string() to VbColors.onBackground
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        CenteredBox(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .animateContentSize()
        ) {
            KottieAnimationView(
                restartOnPlay = true,
                backgroundColor = VbColors.surfaceContainer,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.4f),
                lottieFilenameInVbRes = "lottie_space_animation.json",
                onAnimationCompleted = {
                    finishedConfiguringAiEngine = true
                }
            )

            AnimatedSwitchableText(
                fontWeight = FontWeight.SemiBold,
                style = VbTypography.titleLarge,
                color = statusTextColor,
                text = statusText,
                maxLines = 1,
            )
        }

        val animatedAlpha by animateFloatAsState(
            targetValue = if (finishedConfiguringAiEngine) 1f else 0f
        )
        VbFilledButton(
            onClick = onFinish,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(animatedAlpha),
            enabled = finishedConfiguringAiEngine,
            text = Res.string.enterVoidbloom.string(),
        )
    }
}

@Preview
@Composable
private fun OnboardingConfiguringAiEngineContentPreview() {
    PreviewContainer {
        OnboardingConfiguringAiEngineContent {}
    }
}