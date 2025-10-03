package com.typ.voidbloom.support

expect object WebBrowser {
    fun openUrl(url: String): Boolean
}