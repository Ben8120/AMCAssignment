package com.example.amcassignment.viewmodel

import com.example.amcassignment.model.Services
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface ApiInterface {
    @GET("api/UserCredentials")
    fun getList() : Call<List<UserCredentials>>

    @GET("api/UserCredentials/{userId}")
    fun getUser(
        @Path("userId") userId: Int
    ): Response<UserCredentials>

    @PUT("api/UserCredentials/{userId}")
    fun putUser(
        @Path("userId") userId: Int
    ): Response<UserCredentials>

    @Headers("Content-Type:application/json")
    @POST("api/UserCredentials")
    fun postUser(@Body userCredentials: UserCredentials) : Call<UserCredentials>

    @GET("api/Services")
    fun getService() : Call<List<Services>>

    //@FormUrlEncoded
    @Headers("Content-Type:application/json")
    @POST("api/Services")
    fun postService(
        @Body services: Services
        //@Field("service1") service1 : String,
        //@Field("description") description: String
    ) : Call<Services>

    companion object {
        fun create() : ApiInterface {

            val okHttpClient = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}