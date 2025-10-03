package com.typ.voidbloom.shared.di

import com.typ.voidbloom.shared.VbSettings
import com.typ.voidbloom.shared.core.db.ChatHistoryManager
import com.typ.voidbloom.shared.core.db.VoidbloomDatabaseFactory
import com.typ.voidbloom.shared.core.db.createVoidbloomDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::VbSettings)
    singleOf(::VoidbloomDatabaseFactory)
    single { createVoidbloomDatabase(get()) }
    singleOf(::ChatHistoryManager)
}