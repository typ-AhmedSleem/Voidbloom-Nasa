package com.typ.voidbloom.shared.core.db

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.typ.voidbloom.db.VoidbloomDatabase
import org.koin.core.component.KoinComponent

actual class VoidbloomDatabaseFactory actual constructor() : KoinComponent {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = VoidbloomDatabase.Schema.synchronous(),
            name = "resort.db"
        )
    }
}