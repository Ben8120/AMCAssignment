package com.example.amcassignment.api

import com.example.amcassignment.model.Post
import com.example.amcassignment.model.Services
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

    //GET UserCredentials by id
    @GET("api/UserCredentials/{userId}")
    suspend fun getUserCredentials(
        @Path("userId") userId: Int
    ): Response<UserCredentials>

    //GET all UserCredentials
    @GET("api/UserCredentials")
    suspend fun getUserCredentialsList(): Response<List<UserCredentials>>

    //POST UserCredentials
    @POST("api/UserCredentials")
    suspend fun postUserCredentials(
        @Body userCredential: UserCredentials
    ): Response<UserCredentials>

    //GET all services
    @GET("api/Services")
    suspend fun getServices(): Response<List<Services>>
}