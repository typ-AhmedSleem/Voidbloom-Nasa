package com.typ.voidbloom.screens.onboarding.helpers

sealed interface OnboardingScreenRoute {
    data object Start : OnboardingScreenRoute
    data object SetAge : OnboardingScreenRoute
    data object SetStyle : OnboardingScreenRoute
    data object Finish : OnboardingScreenRoute
}