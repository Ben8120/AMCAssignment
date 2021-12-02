package com.example.amcassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amcassignment.model.Post
import com.example.amcassignment.model.Services
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainViewModel (
    private val repository: Repository
    ): ViewModel() {

    /* Test API
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response: Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response: Response<Post> = repository.pushPost(post)
            myResponse2.value = response
        }
    }
     */
    val userCredentialsResponse: MutableLiveData<Response<UserCredentials>> = MutableLiveData()
    var userCredentialsListResponse: MutableLiveData<Response<List<UserCredentials>>> = MutableLiveData()
    var servicesListResponse: MutableLiveData<Response<List<Services>>> = MutableLiveData()
    var userCredentialsPostResponse: MutableLiveData<Response<UserCredentials>> = MutableLiveData()

    fun getUserCredentials(userId: Int) {
        viewModelScope.launch {
            val response : Response<UserCredentials> = repository.getUserCredentials(userId)
            userCredentialsResponse.value = response
        }
    }

    fun getUserCredentialsList() {
        viewModelScope.launch {
            val response : Response<List<UserCredentials>> = repository.getUserCredentialsList()
            userCredentialsListResponse.value = response
        }
    }

    fun getServicesList() {
        viewModelScope.launch {
            val response : Response<List<Services>> = repository.getServices()
            servicesListResponse.value = response
        }
    }

    fun postUserCredentials(userCredentials: UserCredentials) {
        viewModelScope.launch  {
            val response : Response<UserCredentials> = repository.postUserCredentials(userCredentials)
            userCredentialsPostResponse.value = response
        }
    }
}