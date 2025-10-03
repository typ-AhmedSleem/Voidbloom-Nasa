package com.typ.voidbloom.di

import com.typ.voidbloom.shared.di.sharedModule
import org.koin.core.context.startKoin
import org.koin.core.error.KoinApplicationAlreadyStartedException
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    try {
        startKoin {
            config?.invoke(this)
            modules(
                sharedModule,
//                aiModule,
                appModule
            )
        }
    } catch (_: KoinApplicationAlreadyStartedException) {
        println("Koin has already started !!.")
    }
}