package com.example.amcassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amcassignment.model.Post
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

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
}