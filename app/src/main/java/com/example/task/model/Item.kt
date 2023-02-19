package com.example.task.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "description")
    val description: String,
    @Json(name = "icon_url")
    val iconUrl: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "service_url")
    val serviceUrl: String
)
