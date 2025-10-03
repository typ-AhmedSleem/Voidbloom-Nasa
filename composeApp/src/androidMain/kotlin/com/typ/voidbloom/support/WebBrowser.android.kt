package com.typ.voidbloom.support

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import androidx.core.net.toUri

actual object WebBrowser : KoinComponent {

    actual fun openUrl(url: String): Boolean {
        val context = get<Context>()
        return try {
            val intent = CustomTabsIntent.Builder()
                .setShowTitle(true)
                .build()
                .apply { intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK }

            intent.launchUrl(context, url.toUri())
            true
        } catch (e: Throwable) {
            e.printStackTrace()
            false
        }
    }

}