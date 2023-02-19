package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.task.api.DataApi
import com.example.task.api.Repository
import com.example.task.screens.MainScreen
import com.example.task.screens.MainViewModel
import com.example.task.screens.ViewModelProviderFactory
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository =
            Repository(DataApi.retrofitService)
        val viewModelProviderFactory = ViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
        setContent {
            TaskTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen(mainViewModel = viewModel)
                }
            }
        }
    }
}

