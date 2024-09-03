package com.example.crowncompose.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsPageDto(
    @SerialName("date")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("type")
        val type: String
    )
}
