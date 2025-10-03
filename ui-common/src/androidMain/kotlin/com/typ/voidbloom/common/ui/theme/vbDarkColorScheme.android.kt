package com.typ.voidbloom.common.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import org.koin.mp.KoinPlatform.getKoin

actual fun vbDarkColorScheme() = try {
    dynamicDarkColorScheme(getKoin().get())
} catch (e: Throwable) {
    darkColorScheme()
}