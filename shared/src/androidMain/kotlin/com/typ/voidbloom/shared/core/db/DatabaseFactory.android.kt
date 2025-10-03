package com.typ.voidbloom.shared.core.db

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.typ.voidbloom.db.VoidbloomDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

actual class VoidbloomDatabaseFactory actual constructor() : KoinComponent {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = VoidbloomDatabase.Schema.synchronous(),
            context = get<Context>(),
            name = "voidbloom.db"
        )
    }
}