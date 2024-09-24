package com.example.ozinshev2.ui.composables

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthTextButton(
    text: Int?,
    btnText: Int?,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    textAlpha: Float = 0.75f
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (text != null) {
            Text(
                text = stringResource(text),
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = textAlpha),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        if (btnText != null) {
            Text(
                modifier = Modifier.clickable {
                    //
                },
                text = stringResource(id = btnText),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        }
    }
}