package com.typ.voidbloom.ai.di

import com.typ.voidbloom.ai.engines.GenerativeEngine
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val aiModule = module {
    singleOf(::GenerativeEngine)
}