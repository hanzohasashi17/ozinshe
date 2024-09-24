package com.example.ozinshev2.ui.composables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthTextField(title: Int, placeholder: Int, leadIcon: Int, type: String, trailIcon: Int?) {
    var inputText by remember { mutableStateOf("") }
    var isPasswordHidden by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            lineHeight = 21.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = {
                Text(
                    text = stringResource(id = placeholder),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight(400)
                )
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = leadIcon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            trailingIcon = {
                val isPressed by interactionSource.collectIsPressedAsState()

                LaunchedEffect(key1 = isPressed) {
                    if (isPressed) {
                        isPasswordHidden = false
                    } else {
                        isPasswordHidden = true
                    }
                }

                if (trailIcon != null) {
                    IconButton(
                        onClick = {  },
                        interactionSource = interactionSource
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = trailIcon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = when (type) {
                    "email" -> KeyboardType.Email
                    "password" -> KeyboardType.Password
                    else -> KeyboardType.Text
                }
            ),
            visualTransformation = if (type == "password" && isPasswordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
    }
}