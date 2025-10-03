package com.typ.voidbloom.common.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Composable
@Stable
fun initVbShapes() = Shapes()

val VbShapes: Shapes
    @Composable get() = MaterialTheme.shapes