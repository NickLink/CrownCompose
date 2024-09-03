package com.example.crowncompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crowncompose.data.DetailsRepository
import com.example.crowncompose.data.DetailsRepositoryImpl
import com.example.crowncompose.data.remote.KtorClient
import com.example.crowncompose.data.remote.api.DetailsApi
import com.example.crowncompose.data.remote.api.DetailsApiImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val api: DetailsApi = DetailsApiImpl(client = KtorClient().ktorHttpClient)
    private val repository: DetailsRepository = DetailsRepositoryImpl(api)

    private val _response: MutableLiveData<Result<Any>> = MutableLiveData()
    val response: LiveData<Result<Any>> = _response

    fun getDetails(url: String) {
        viewModelScope.launch(Dispatchers.Main) {
            _response.value = repository.getDetails(url = url)
        }
    }
}