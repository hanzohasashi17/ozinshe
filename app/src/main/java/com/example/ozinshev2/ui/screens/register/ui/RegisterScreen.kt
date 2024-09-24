package com.example.ozinshev2.ui.screens.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ozinshev2.R
import com.example.ozinshev2.ui.composables.AuthTextButton
import com.example.ozinshev2.ui.composables.AuthTextField
import com.example.ozinshev2.ui.composables.AuthTitleText
import com.example.ozinshev2.ui.composables.BackButton
import com.example.ozinshev2.ui.composables.SubmitButton
import com.example.ozinshev2.ui.util.Dimensions

@Composable
fun RegisterScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.COMMON_HORIZONTAL_PADDING.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        BackButton()
        Spacer(modifier = Modifier.height(24.dp))
        AuthTitleText(
            title = R.string.register_title,
            description = R.string.register_desc
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
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(
            type = "password",
            title = R.string.register_passw_again,
            placeholder = R.string.passw_ph,
            leadIcon = R.drawable.passw_icon,
            trailIcon = R.drawable.passw_show_icon
        )
        Spacer(modifier = Modifier.height(40.dp))
        SubmitButton(btnText = R.string.register_btn)
        Spacer(modifier = Modifier.height(24.dp))
        AuthTextButton(
            text = R.string.to_login,
            btnText = R.string.register_btn_to_login
        )
    }
}