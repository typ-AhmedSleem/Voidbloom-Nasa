package com.typ.voidbloom.support

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual object WebBrowser {

    actual fun openUrl(url: String): Boolean {
        return try {
            val website = NSURL(string = url)
            val canOpenURL = UIApplication.sharedApplication.canOpenURL(website).also {
                println("[WebBrowser::openUrl]: Checked whether browser can open url '$url' resulted '$it'.")
            }

            if (canOpenURL) {
                UIApplication
                    .sharedApplication
                    .openURL(
                        url = website,
                        options = mapOf(Unit to Unit),
                        completionHandler = {
                            println("[WebBrowser::openUrl]: openURL completed with result '$it'.")
                        }
                    ).also {
                        println("[WebBrowser::openUrl]: openURL returned '$it'.")
                    }
                true
            } else {
                println("[WebBrowser::openUrl]: Can't open url '$url' in the browser.")
                false
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            false
        }
    }

}