package com.typ.voidbloom.shared.models

import com.typ.voidbloom.shared.enums.AgeConfig
import com.typ.voidbloom.shared.enums.StyleConfig
import kotlinx.serialization.Serializable

@Serializable
data class AiEngineConfig(
    val age: AgeConfig,
    val style: StyleConfig
)
