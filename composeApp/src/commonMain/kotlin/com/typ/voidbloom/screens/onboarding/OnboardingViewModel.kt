package com.typ.voidbloom.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import com.typ.voidbloom.screens.home.HomeScreen
import com.typ.voidbloom.screens.onboarding.helpers.OnboardingScreenRoute
import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.VbSettingsKeys
import com.typ.voidbloom.shared.enums.AgeConfig
import com.typ.voidbloom.shared.enums.StyleConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val settings: VbSettings,
) : ViewModel() {

    // * States
    private val _currentRoute = MutableStateFlow<OnboardingScreenRoute>(OnboardingScreenRoute.Start)
    val currentRoute = _currentRoute.asStateFlow()

    private val _ageConfig = MutableStateFlow<AgeConfig?>(null)
    val ageConfig
        get() = _ageConfig.asStateFlow().value

    private val _styleConfig = MutableStateFlow<StyleConfig?>(null)
    val styleConfig
        get() = _styleConfig.asStateFlow().value

    private val _isAiEngineConfigured = MutableStateFlow(false)

    fun setAgeConfig(ageConfig: AgeConfig) {
        _ageConfig.value = ageConfig
    }

    fun setStyleConfig(styleConfig: StyleConfig) {
        _styleConfig.value = styleConfig
    }

    fun configureEngine() {
        if (_isAiEngineConfigured.value) return
        _isAiEngineConfigured.value = false

        val ageConfig = _ageConfig.value
        val styleConfig = _styleConfig.value
        if (ageConfig == null || styleConfig == null) return

        settings.putBoolean(VbSettingsKeys.ONBOARDING_DONE, true)
        settings.putString(VbSettingsKeys.AGE_CONFIG, ageConfig.name)
        settings.putString(VbSettingsKeys.STYLE_CONFIG, styleConfig.name)

        _isAiEngineConfigured.value = true
    }

    fun navigateToRoute(route: OnboardingScreenRoute) {
        _currentRoute.value = route
    }

    fun finishOnboarding(navigator: Navigator) {
        viewModelScope.launch {
            configureEngine()
            navigator.replaceAll(HomeScreen)
        }
    }

}