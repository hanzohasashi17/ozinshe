package com.example.ozinshev2.ui.screens.onboard.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.R
import com.example.ozinshev2.ui.screens.onboard.data.onboardingItems
import com.example.ozinshev2.ui.util.Dimensions
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { onboardingItems.size },
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            key = { index -> onboardingItems[index].itemOrder },
            userScrollEnabled = false
        ) { page ->
            OnboardingItem(
                onboardingItem = onboardingItems[page]
            )
        }
        OnboardingSkipButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    vertical = Dimensions.ONBOARDING_SKIP_BUTTON_PADDING_Y.dp,
                    horizontal = Dimensions.ONBOARDING_SKIP_BUTTON_PADDING_X.dp
                )
                .defaultMinSize(70.dp, 24.dp),
            pagerState = pagerState
        )
        PageIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 152.dp),
            pagerState = pagerState
        )
        OnboardingNextScreenButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 72.dp, horizontal = 24.dp),
            pagerState = pagerState
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(
    pagerState: PagerState,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            if (pagerState.currentPage != iteration) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .width(6.dp)
                        .height(6.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .width(20.dp)
                        .height(6.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingSkipButton(
    modifier: Modifier,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()

    TextButton(
        modifier = modifier,
        onClick = {
            coroutineScope.launch {
                pagerState.scrollToPage(pagerState.currentPage + 1)
            }
        },
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(16.dp, 8.dp),
        enabled = pagerState.currentPage != 2
    ) {
        Text(
            text = stringResource(id = R.string.onboarding_skip_button),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingNextScreenButton(
    modifier: Modifier,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()

    Button(
        modifier = modifier,
        onClick = {
            coroutineScope.launch {
                //
            }
        },
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(16.dp),
        enabled = pagerState.currentPage != 1 && pagerState.currentPage != 0
    ) {
        Text(
            text = stringResource(id = R.string.onboarding_next_button),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}