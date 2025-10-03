package com.typ.voidbloom.common.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.typ.voidbloom.common.ui.Poppins_Black
import com.typ.voidbloom.common.ui.Poppins_Bold
import com.typ.voidbloom.common.ui.Poppins_ExtraBold
import com.typ.voidbloom.common.ui.Poppins_ExtraLight
import com.typ.voidbloom.common.ui.Poppins_Light
import com.typ.voidbloom.common.ui.Poppins_Medium
import com.typ.voidbloom.common.ui.Poppins_Regular
import com.typ.voidbloom.common.ui.Poppins_SemiBold
import com.typ.voidbloom.common.ui.VbRes
import pro.respawn.kmmutils.compose.resources.font

@Composable
@Stable
fun initVbTypography(): Typography {
    val fontFamily = FontFamily(
        VbRes.font.Poppins_Black.font(FontWeight.Thin),
        VbRes.font.Poppins_ExtraLight.font(FontWeight.ExtraLight),
        VbRes.font.Poppins_Light.font(FontWeight.Light),
        VbRes.font.Poppins_Regular.font(FontWeight.Normal),
        VbRes.font.Poppins_Medium.font(FontWeight.Medium),
        VbRes.font.Poppins_SemiBold.font(FontWeight.SemiBold),
        VbRes.font.Poppins_Bold.font(FontWeight.Bold),
        VbRes.font.Poppins_ExtraBold.font(FontWeight.ExtraBold),
        VbRes.font.Poppins_Black.font(FontWeight.Black),
    )
    return with(Typography()) {
        copy(
            displayLarge = this.displayLarge.copy(fontFamily = fontFamily),
            displayMedium = this.displayMedium.copy(fontFamily = fontFamily),
            displaySmall = this.displaySmall.copy(fontFamily = fontFamily),
            headlineLarge = this.headlineLarge.copy(fontFamily = fontFamily),
            headlineMedium = this.headlineMedium.copy(fontFamily = fontFamily),
            headlineSmall = this.headlineSmall.copy(fontFamily = fontFamily),
            titleLarge = this.titleLarge.copy(fontFamily = fontFamily),
            titleMedium = this.titleMedium.copy(fontFamily = fontFamily),
            titleSmall = this.titleSmall.copy(fontFamily = fontFamily),
            bodyLarge = this.bodyLarge.copy(fontFamily = fontFamily),
            bodyMedium = this.bodyMedium.copy(fontFamily = fontFamily),
            bodySmall = this.bodySmall.copy(fontFamily = fontFamily),
            labelLarge = this.labelLarge.copy(fontFamily = fontFamily),
            labelMedium = this.labelMedium.copy(fontFamily = fontFamily),
            labelSmall = this.labelSmall.copy(fontFamily = fontFamily),
        )
    }
}

val VbTypography: Typography
    @Composable get() = MaterialTheme.typography