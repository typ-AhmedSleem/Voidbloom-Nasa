package com.typ.voidbloom.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import com.typ.voidbloom.screens.home.HomeScreen
import com.typ.voidbloom.screens.onboarding.OnboardingScreen
import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.VbSettingsKeys.ONBOARDING_DONE
import org.koin.compose.getKoin

@Composable
fun determineStartupScreen(): Screen {
    val koin = getKoin()
    val settings = remember { koin.get<VbSettings>() }

    val isOnboardingDone = remember {
        settings.getBoolean(
            key = ONBOARDING_DONE,
            defaultValue = false
        )
    }
    return remember {
        if (isOnboardingDone) HomeScreen
        else OnboardingScreen
    }
}