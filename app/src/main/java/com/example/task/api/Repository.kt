package com.example.task.api

import com.example.task.model.Data


class Repository(
    private val apiService: ApiService,
) {
    suspend fun getData(): Data = apiService.getData()
}
