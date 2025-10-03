package com.typ.voidbloom

import android.app.Application
import com.typ.voidbloom.di.initKoin
import org.koin.android.ext.koin.androidContext

class VoidbloomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@VoidbloomApplication)
        }
    }

}