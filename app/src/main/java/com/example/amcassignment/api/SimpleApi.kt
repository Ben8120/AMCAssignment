package com.example.amcassignment.api

import com.example.amcassignment.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
}