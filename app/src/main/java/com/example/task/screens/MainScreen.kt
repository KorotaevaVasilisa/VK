package com.example.task.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import com.example.task.model.Item

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val data = mainViewModel.data.collectAsState()
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        items(data.value) { item ->
            CardOfService(item)
        }
    }
}

@Composable
fun CardOfService(item: Item, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .fillMaxSize()
        .clickable { }
        .padding(6.dp)) {
        Row(modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

            AsyncImage(
                model = item.iconUrl,
                contentDescription = null
            )
            Spacer(modifier = modifier
                .fillMaxHeight()
                .width(8.dp))
            Text(text = item.name)
        }
    }
}

