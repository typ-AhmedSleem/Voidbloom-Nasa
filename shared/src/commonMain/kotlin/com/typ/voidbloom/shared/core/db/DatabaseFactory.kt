package com.typ.voidbloom.shared.core.db

import app.cash.sqldelight.db.SqlDriver
import com.typ.voidbloom.db.VoidbloomDatabase
import org.koin.core.component.KoinComponent

expect class VoidbloomDatabaseFactory() : KoinComponent {
    fun createDriver(): SqlDriver
}

fun createVoidbloomDatabase(driverFactory: VoidbloomDatabaseFactory): VoidbloomDatabase {
    val driver = driverFactory.createDriver()
    return VoidbloomDatabase(driver)
}