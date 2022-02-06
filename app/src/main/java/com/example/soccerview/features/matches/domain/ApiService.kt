package com.example.soccerview.features.matches.domain

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("soccer/matches")
    fun getMatches(
        @Query("apikey") apikey: String = API_KEY,
        @Query("season_id") seasonId: Int = 1193
    ): Single<ApiResponse>

    companion object {
        private const val BASE_URL = "https://app.sportdataapi.com/api/v1/"
        private const val API_KEY = "da6f0b30-8658-11ec-9704-0d09c65b3e97"

        fun create(): ApiService {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
                .apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            okHttpClient.addInterceptor(httpLoggingInterceptor)

            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build()).build().create(ApiService::class.java)
        }
    }
}