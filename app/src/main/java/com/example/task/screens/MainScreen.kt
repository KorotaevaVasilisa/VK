package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.R

@Composable
fun MainScreen() {
    var list = listOf<String>("10", "20")
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        items(list) {
            CardOfService()
        }
    }
}

@Composable
fun CardOfService(modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .fillMaxSize()
        .padding(6.dp)) {
        Row(modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                modifier = modifier.size(60.dp),
                contentDescription = null)
            Spacer(modifier = modifier.fillMaxHeight().width(8.dp))
            Text(text = "Text")
        }
    }
}

@Preview
@Composable
fun Show() {
    MainScreen()
}
