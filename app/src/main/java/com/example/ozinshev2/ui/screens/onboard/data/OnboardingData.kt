package com.example.ozinshev2.ui.screens.onboard.data

import com.example.ozinshev2.R

data class OnboardingItem (
    val itemOrder: Int,
    val image: Int,
    val title: Int,
    val text: Int
)

val onboardingItems = listOf(
    OnboardingItem(1, R.drawable.onboarding1, R.string.onboarding_title, R.string.onboarding_text1),
    OnboardingItem(2, R.drawable.onboarding2, R.string.onboarding_title, R.string.onboarding_text2),
    OnboardingItem(3, R.drawable.onboarding3, R.string.onboarding_title, R.string.onboarding_text3),
)