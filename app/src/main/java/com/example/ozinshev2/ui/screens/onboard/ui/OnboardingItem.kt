package com.example.ozinshev2.ui.screens.onboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.ui.screens.onboard.data.OnboardingItem
import com.example.ozinshev2.ui.util.Dimensions

@Composable
fun OnboardingItem(
    onboardingItem: OnboardingItem,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        OnboardingBlurredImage(
            image = onboardingItem.image
        )
        OnboardingText(
            title = onboardingItem.title,
            text = onboardingItem.text
        )
    }
}

@Composable
fun OnboardingBlurredImage(image: Int) {
    val density = LocalDensity.current

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, MaterialTheme.colorScheme.background),
        startY = with(density) { Dimensions.ONBOARDING_IMAGE_HEIGHT.dp.toPx() / 2 },
        endY = with(density) { Dimensions.ONBOARDING_IMAGE_HEIGHT.dp.toPx() },
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.ONBOARDING_IMAGE_HEIGHT.dp)
                .drawWithContent {
                    drawContent()
                    drawRect(gradient)
                },
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
    }
}

@Composable
fun OnboardingText(title: Int, text: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = Dimensions.ONBOARDING_TITLE_TOP_PADDING.dp)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier
                .width(Dimensions.ONBOARDING_TEXT_WIDTH_WRAPPER.dp),
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}