package com.example.ozinshev2.ui.screens.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.R
import com.example.ozinshev2.ui.composables.AuthTextButton
import com.example.ozinshev2.ui.composables.AuthTextField
import com.example.ozinshev2.ui.composables.AuthTitleText
import com.example.ozinshev2.ui.composables.BackButton
import com.example.ozinshev2.ui.composables.SubmitButton
import com.example.ozinshev2.ui.util.Dimensions
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.COMMON_HORIZONTAL_PADDING.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        BackButton()
        Spacer(modifier = Modifier.height(24.dp))
        AuthTitleText(
            title = R.string.login_title,
            description = R.string.login_desc
        )
        Spacer(modifier = Modifier.height(29.dp))
        AuthTextField(
            type = "email",
            title = R.string.email,
            placeholder = R.string.email_ph,
            leadIcon = R.drawable.email_icon,
            trailIcon = null
        )
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(
            type = "password",
            title = R.string.passw,
            placeholder = R.string.passw_ph,
            leadIcon = R.drawable.passw_icon,
            trailIcon = R.drawable.passw_show_icon
        )
        Spacer(modifier = Modifier.height(17.dp))
        AuthTextButton(
            text = null,
            btnText = R.string.login_passw_forget,
            horizontalArrangement = Arrangement.End
        )
        Spacer(modifier = Modifier.height(40.dp))
        SubmitButton(btnText = R.string.login_btn)
        Spacer(modifier = Modifier.height(24.dp))
        AuthTextButton(
            text = R.string.to_reg,
            btnText = R.string.login_btn_to_reg
        )
        Spacer(modifier = Modifier.height(40.dp))
        AuthTextButton(
            text = R.string.login_or,
            btnText = null,
            textAlpha = 0.5f
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginWithGoogleButton()
    }
}

@Composable
fun LoginWithGoogleButton() {
    val coroutineScope = rememberCoroutineScope()

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            coroutineScope.launch {
                //
            }
        },
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.google_icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.login_via_google),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}