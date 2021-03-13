package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
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
//TODO Dark theme
@Composable
fun WelcomeScreen() {
    Scaffold(
        backgroundColor = pink100
    ) {
        // background
        Image(
            painter = painterResource(id = R.drawable.ic_light_welcome_bg),
            contentDescription = null
        )

        Column {
            Spacer(modifier = Modifier.height(72.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_light_welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 88.dp)
                    .requiredSize(width = 310.dp, height = 280.dp),
                contentScale = ContentScale.None
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_light_logo),
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
                color = gray,
                textAlign = TextAlign.Center
            )


            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = gray
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
                    color = white,
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
                    color = pink900,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun WelcomePreview() {
    MyTheme() {
        WelcomeScreen()
    }
}
