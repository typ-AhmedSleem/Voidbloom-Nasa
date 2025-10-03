package com.typ.voidbloom.utils

import com.typ.voidbloom.data.repo.PublicationsAbstracts
import com.typ.voidbloom.shared.models.Publication

fun Publication.abstract(): String {
    return PublicationsAbstracts[id] ?: ""
}