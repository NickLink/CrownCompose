package com.example.crowncompose.data

import com.example.crowncompose.data.remote.api.DetailsApi
import com.example.crowncompose.data.remote.dto.DetailsPageDto


class DetailsRepositoryImpl(
    private val api: DetailsApi
) : DetailsRepository {
    override suspend fun getDetails(url: String): Result<DetailsPageDto> {
        return try {
            Result.success(api.getDetailsPage(url))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}