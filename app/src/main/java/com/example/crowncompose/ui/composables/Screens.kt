package com.example.crowncompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WhatsOnScreen() {
    Column() {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(text = "Whats On screen")
        }
    }


}

@Composable
fun RewardsScreen() {

}

@Composable
fun NotificationScreen() {

}

@Composable
fun DetailsScreen(onClickItem: (String) -> Unit) {
    LazyColumn() {
        items(detailsItemList) { item ->
            if (item.type == 1) {
                DetailHeaderCompose(name = item.name)
            } else {
                DetailItemCompose(name = item.name) {
                    onClickItem.invoke(item.name)
                }
            }
        }
    }
}

@Composable
fun DetailItemCompose(name: String, callback: () -> Unit) {
    Box(modifier = Modifier
        .height(48.dp)
        .fillMaxWidth()
        .clickable { callback }) {
        Text(
            modifier = Modifier
                .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                .align(Alignment.CenterStart),
            text = name,
        )
    }
}

@Composable
fun DetailHeaderCompose(name: String) {
    Box(modifier = Modifier
        .height(52.dp)
        .background(MaterialTheme.colorScheme.error)
        .fillMaxWidth()) {
        Text(
            modifier = Modifier
                .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                .align(Alignment.CenterStart),
            color = MaterialTheme.colorScheme.onError,
            text = name,
        )
    }
}

val detailsItems = listOf(
    "--Settings",
    "Login into Crown Rewards",
    "Change your PIN",
    "Reset Password",
    "Switch property",
    "Change app theme",
    "--Another Header",
    "Dressing code",
    "Alcohol policy",
    "Dancing floor",
    "Drink party",
    "Drugs alert",
    "Best bar choice",
    "--Third Header",
    "Extra code",
    "Alcohol policy",
    "Dancing floor",
    "Drink party",
    "Drugs alert",
    "Best bar choice",
)

val detailsItemList = List<DetailsItem>(detailsItems.size) { pos ->
    DetailsItem(
        id = pos,
        type = if (detailsItems[pos].startsWith("--")) 1 else 2,
        name = detailsItems[pos])
}

@Immutable
data class DetailsItem(
    val id: Int,
    val type: Int,
    val name: String
)

@Composable
fun DetailsScreen(
    item: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = item)
    }
}


