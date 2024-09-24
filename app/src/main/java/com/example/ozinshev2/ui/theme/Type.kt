package com.example.ozinshev2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.ozinshev2.R
import com.example.ozinshev2.ui.util.Dimensions

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sfprodisplaybold)),
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
        lineHeight = TextUnit(28.8f, TextUnitType.Sp)
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sfprodisplayregular)),
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sfprodisplaymedium)),
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
        lineHeight = TextUnit(22f, TextUnitType.Sp)
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sfprodisplaymedium)),
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
        lineHeight = TextUnit(16.2f, TextUnitType.Sp)
    ),

)