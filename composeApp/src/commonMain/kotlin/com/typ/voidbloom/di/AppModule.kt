package com.typ.voidbloom.di

import com.typ.voidbloom.screens.chat.ChatViewModel
import com.typ.voidbloom.screens.onboarding.OnboardingViewModel
import com.typ.voidbloom.screens.pubs.PublicationViewerViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::ChatViewModel)
    viewModelOf(::PublicationViewerViewModel)
}