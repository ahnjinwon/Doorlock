package com.example.doorlock

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query


interface MyApi {

    @GET("DbInfo.php")
    fun getInfo(): Call<List<UserInfo>>

    @Multipart
    @POST("upload.php")
    fun uploadRequest(@Part file: MultipartBody.Part): Call<String>

    @DELETE("delete.php")
    fun deleteRequest(
        @Query("name") imageName: String
    ): Call<String>

    companion object {
        private const val BASE_URL = "http://52.79.155.171//"
        private val gson = GsonBuilder().setLenient().create()
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(MyApi::class.java)
        }
    }
}