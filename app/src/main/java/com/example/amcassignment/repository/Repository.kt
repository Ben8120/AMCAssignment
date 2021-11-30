package com.example.amcassignment.repository

import com.example.amcassignment.model.Post
import com.example.amcassignment.model.Services
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.utils.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    /* TEST
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }
     */

    //User credentials
    suspend fun getUserCredentials(userId: Int): Response<UserCredentials> {
        return RetrofitInstance.api.getUserCredentials(userId)
    }

    //List of User Credentials
    suspend fun getUserCredentialsList(): Response<List<UserCredentials>> {
        return RetrofitInstance.api.getUserCredentialsList()
    }

    ///list of Services
    suspend fun getServices(): Response<List<Services>> {
        return RetrofitInstance.api.getServices()
    }
}