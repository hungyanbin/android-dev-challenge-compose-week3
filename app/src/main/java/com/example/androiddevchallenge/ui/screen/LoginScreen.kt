package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.widget.BloomRoundedButtonBig
import com.example.androiddevchallenge.ui.widget.BloomBigTextField

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    val email: String = ""
    val password = ""

    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.login_title),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.fillMaxWidth()
                    .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            BloomBigTextField(
                value = email,
                onValueChange = { /*TODO*/ },
                modifier = Modifier,
                labelText = stringResource(id = R.string.login_field_email),
                keyboardType = KeyboardType.Email
            )

            BloomBigTextField(
                value = password,
                onValueChange = { /*TODO*/ },
                modifier = Modifier,
                labelText = stringResource(id = R.string.login_field_password),
                keyboardType = KeyboardType.Password
            )

            // TODO spanned text
            Text(
                text = stringResource(id = R.string.login_terms),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            BloomRoundedButtonBig(
                onClick = { onLoginClick() },
                modifier = Modifier,
                text = stringResource(id = R.string.welcome_login)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    val darkTheme = true
    MyTheme(darkTheme = darkTheme) {
        LoginScreen {}
    }
}