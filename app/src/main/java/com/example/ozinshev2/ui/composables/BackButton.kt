package com.example.ozinshev2.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.R

@Composable
fun BackButton(text: Int? = null, icon: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            modifier = Modifier.size(40.dp),
            onClick = { }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.back_icon),
                contentDescription = null
            )
        }
        if (text != null) {
            Text(
                text = stringResource(id = text)
            )
        }
        if (icon != null) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null
            )
        }
    }
}