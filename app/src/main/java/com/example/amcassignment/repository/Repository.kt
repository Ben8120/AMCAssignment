package com.example.amcassignment.repository

import com.example.amcassignment.model.Post
import com.example.amcassignment.utils.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}