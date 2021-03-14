package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.*

//TODO contentDescription
@Composable
fun WelcomeScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val welcomeBgRes = if (darkTheme) R.drawable.ic_dark_welcome_bg else R.drawable.ic_light_welcome_bg
    val welcomeIllosRes = if (darkTheme) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos
    val welcomeLogoRes = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        // background
        Image(
            painter = painterResource(id = welcomeBgRes),
            contentDescription = null
        )

        Column {
            Spacer(modifier = Modifier.height(72.dp))
            Image(
                painter = painterResource(id = welcomeIllosRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 88.dp)
                    .requiredSize(width = 310.dp, height = 280.dp),
                contentScale = ContentScale.None
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = welcomeLogoRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = R.string.welcome_subtitle),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 40.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center
            )


            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_create_account),
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.onSecondary,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_login),
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.fillMaxWidth(),
                    color = if (darkTheme) white else pink900,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun WelcomePreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(darkTheme = true)
    }
}
