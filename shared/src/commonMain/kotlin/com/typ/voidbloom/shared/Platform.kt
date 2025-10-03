package com.typ.voidbloom.shared

sealed interface Platform {
    object Android : Platform
    object IOS : Platform
}

expect fun getPlatform(): Platform