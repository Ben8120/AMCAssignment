package com.example.amcassignment.api

import com.example.amcassignment.model.Post
import com.example.amcassignment.model.UserCredentials
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    /*TEST
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
     */

    //my api here
    @GET("api/UserCredentials/0")
    suspend fun getUserCredentials(): Response<UserCredentials>

    @GET("api/UserCredentials")
    suspend fun getUserCredentialsList(
        @Query("name") name: String
    ) : Response<List<UserCredentials>>
}