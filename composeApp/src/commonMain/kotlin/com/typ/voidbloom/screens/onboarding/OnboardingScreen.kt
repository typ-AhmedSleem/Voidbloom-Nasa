package com.typ.voidbloom.screens.onboarding

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.typ.voidbloom.screens.onboarding.contents.OnboardingConfiguringAiEngineContent
import com.typ.voidbloom.screens.onboarding.contents.OnboardingSetAgeContent
import com.typ.voidbloom.screens.onboarding.contents.OnboardingSetStyleContent
import com.typ.voidbloom.screens.onboarding.contents.OnboardingStartContent
import com.typ.voidbloom.screens.onboarding.helpers.OnboardingScreenRoute
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object OnboardingScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = remember { get<OnboardingViewModel>() }
        val currentRoute by viewModel.currentRoute.collectAsStateWithLifecycle()

        Crossfade(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                ),
            targetState = currentRoute,
        ) { route ->
            when (route) {
                OnboardingScreenRoute.Start -> {
                    OnboardingStartContent {
                        viewModel.navigateToRoute(OnboardingScreenRoute.SetAge)
                    }
                }

                OnboardingScreenRoute.SetAge -> {
                    OnboardingSetAgeContent(viewModel.ageConfig) { ageConfig ->
                        viewModel.setAgeConfig(ageConfig)
                        viewModel.navigateToRoute(OnboardingScreenRoute.SetStyle)
                    }
                }

                OnboardingScreenRoute.SetStyle -> {
                    OnboardingSetStyleContent(viewModel.styleConfig) { styleConfig ->
                        viewModel.setStyleConfig(styleConfig)
                        viewModel.navigateToRoute(OnboardingScreenRoute.Finish)
                    }
                }

                OnboardingScreenRoute.Finish -> {
                    OnboardingConfiguringAiEngineContent {
                        viewModel.finishOnboarding(navigator)
                    }
                }
            }
        }
    }

}