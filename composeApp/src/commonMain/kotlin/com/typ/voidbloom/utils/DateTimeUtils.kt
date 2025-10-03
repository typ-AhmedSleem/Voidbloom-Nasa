package com.typ.voidbloom.utils

import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun millisNow() = Clock.System.now().toEpochMilliseconds()