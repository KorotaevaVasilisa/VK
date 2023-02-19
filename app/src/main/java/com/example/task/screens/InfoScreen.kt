package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R

@Composable
fun InfoScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null)
        Text(text = "Name", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
        Text(text = "Information")
        Text("HTTPS")
    }
}

@Preview(showBackground = true)
@Composable
fun ShowInfo() {
    InfoScreen()
}
