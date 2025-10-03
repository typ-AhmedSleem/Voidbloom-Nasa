package com.typ.voidbloom.shared

import android.content.Context
import com.liftric.kvault.KVault
import org.koin.mp.KoinPlatform.getKoin

internal actual class VbSecureSettings : KVault(
    context = getKoin().get<Context>(),
    fileName = "Voidbloom_SecureVault"
)