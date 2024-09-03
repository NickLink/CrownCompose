package com.example.crowncompose.data.remote.api

import com.example.crowncompose.data.remote.dto.DetailsPageDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class DetailsApiImpl(
    private val client: HttpClient
) : DetailsApi {
    override suspend fun getDetailsPage(url: String): DetailsPageDto = client.get(url)

}