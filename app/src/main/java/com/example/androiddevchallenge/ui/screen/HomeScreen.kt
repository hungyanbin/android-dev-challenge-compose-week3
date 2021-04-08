package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.BloomTheme
import com.example.androiddevchallenge.model.Plant
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.glide.GlideImage

@Composable
fun HomeScreen(themes: List<BloomTheme>, plants: List<Plant>) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = { BloomBottomNavigation(selectedIndex = 0) }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            SearchBar("", {}, Modifier.padding(top = 40.dp))

            Text(
                text = stringResource(R.string.home_browse_themes),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .paddingFromBaseline(
                        top = 32.dp,
                        bottom = 16.dp
                    ),
                style = MaterialTheme.typography.h1,
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
            ) {
                item { Spacer(modifier = Modifier.width(16.dp)) }

                items(themes) { theme ->
                    ThemeCard(theme)
                }

                item { Spacer(modifier = Modifier.width(16.dp)) }
            }
        }

    }
}

@Composable
fun ThemeCard(theme: BloomTheme) {
    Card {
        Column(
            modifier = Modifier.height(136.dp)
        ) {
            // 96 * 136
            GlideImage(
                data = theme.imageUrl,
                contentDescription = theme.title,
                modifier = Modifier.size(height = 96.dp, width = 136.dp),
                fadeIn = true
            )

            Text(
                text = theme.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .height(40.dp)
            )
        }
    }
}

@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit, modifier: Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = stringResource(id = R.string.home_search),
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = stringResource(id = R.string.home_search),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary,
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun BloomBottomNavigation(selectedIndex: Int) {
    val tabs = listOf(
        BloomTab(R.drawable.ic_home, R.string.tab_home),
        BloomTab(R.drawable.ic_favorite_border, R.string.tab_favorites),
        BloomTab(R.drawable.ic_account_circle, R.string.tab_profile),
        BloomTab(R.drawable.ic_shopping_cart, R.string.tab_cart),
    )

    BottomNavigation {
        tabs.forEachIndexed { index, tab ->
            BottomNavigationItem(
                selected = index == selectedIndex,
                onClick = {},
                icon = { Icon(painter = painterResource(id = tab.iconRes), contentDescription = stringResource(id = tab.stringRes)) },
                label = { Text(text = stringResource(id = tab.stringRes)) }
            )
        }
    }
}

data class BloomTab(val iconRes: Int, val stringRes: Int)

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    val darkTheme = false
    MyTheme(darkTheme = darkTheme) {
        HomeScreen(
            listOf(
                BloomTheme("1", "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Deseert chic"),
                BloomTheme("2", "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Tiny terrariums"),
                BloomTheme("3", "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Deseert chic"),
                BloomTheme("4", "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Deseert chic"),
                BloomTheme("5", "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Deseert chic"),
            ),
            listOf(

            )
        )
    }
}