package com.typ.voidbloom.common.ui.theme

import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import org.koin.mp.KoinPlatform.getKoin

actual fun vbLightColorScheme() = try {
    dynamicLightColorScheme(getKoin().get())
} catch (e: Throwable) {
    lightColorScheme()
}