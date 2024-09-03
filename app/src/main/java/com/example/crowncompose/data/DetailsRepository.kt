package com.example.crowncompose.data

import com.example.crowncompose.data.remote.dto.DetailsPageDto

interface DetailsRepository {
    suspend fun getDetails(url: String): Result<DetailsPageDto>
}