package com.example.task.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.task.model.Item

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val data = mainViewModel.data.collectAsState()
    LazyColumn(modifier = Modifier
        .fillMaxSize()) {
        items(data.value) { item ->
            CardOfService(item)
        }
    }
}

@Composable
fun CardOfService(item: Item, modifier: Modifier = Modifier) {
    val openDialog = remember { mutableStateOf(false) }
    Card(modifier = modifier
        .fillMaxSize()
        .clickable {
            openDialog.value = true
        }
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
    if (openDialog.value) {
        Dialog(
            onDismissRequest = {},
            content = {
                Card() {
                    Column(Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        AsyncImage(
                            model = item.iconUrl,
                            contentDescription = null
                        )
                        Text(text = item.name, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
                        Text(text = item.description)
                        Text(text = item.serviceUrl, color = Color.Blue)
                        Button(
                            onClick = { openDialog.value = false }
                        ) {
                            Text("OK", fontSize = 22.sp)
                        }
                    }
                }
            },
        )
    }
}

