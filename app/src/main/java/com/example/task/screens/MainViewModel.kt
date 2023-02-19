package com.example.task.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.api.Repository
import com.example.task.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException

class MainViewModel(
    private val retrofitRepository: Repository,
) : ViewModel() {

    private val _data = MutableStateFlow<List<Item>>(emptyList())
    val data: StateFlow<List<Item>> = _data.asStateFlow()

    init {
        getItems()
    }

    fun getItem(count: Int): Item = data.value[count]


    private fun getItems() {
        viewModelScope.launch {
            try {
                _data.value = retrofitRepository.getData().items

            } catch (e: ConnectException) {
                Log.e("ERROR", "ConnectException: " + e.localizedMessage)
            } catch (e: SocketException) {
                Log.e("ERROR", "SocketException: " + e.localizedMessage)
            } catch (e: IOException) {
                Log.e("ERROR", "IOE ERROR: " + e.localizedMessage)
            } catch (e: HttpException) {
                Log.e("ERROR", "HTTP ERROR: " + e.localizedMessage)
            }
        }
    }
}
