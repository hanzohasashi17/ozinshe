package com.example.ozinshev2.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.R
import kotlinx.coroutines.launch

@Composable
fun SubmitButton(btnText: Int) {
    val coroutineScope = rememberCoroutineScope()

    Button(
        modifier = Modifier.fillMaxWidth(),
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
    ) {
        Text(
            text = stringResource(id = btnText),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}