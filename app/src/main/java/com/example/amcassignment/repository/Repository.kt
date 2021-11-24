package com.example.amcassignment.repository

import com.example.amcassignment.model.Post
import com.example.amcassignment.utils.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }
}