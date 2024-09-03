package com.example.crowncompose.data.remote.api

import com.example.crowncompose.data.remote.dto.DetailsPageDto

interface DetailsApi {

    suspend fun getDetailsPage(url: String): DetailsPageDto
}