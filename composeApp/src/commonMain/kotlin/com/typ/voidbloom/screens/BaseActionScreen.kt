package com.typ.voidbloom.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen


abstract class BaseActionScreen(private val actionHash: Int) : Screen {

    @Composable
    fun ScreenLazyColumn(
        state: LazyListState = rememberLazyListState(),
        modifier: Modifier = Modifier.fillMaxSize(),
        contentPadding: PaddingValues = PaddingValues(0.dp),
        verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(16.dp),
        content: LazyListScope.() -> Unit,
    ) {
        LazyColumn(
            state = state,
            modifier = modifier,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
            content = content
        )
    }

}