package app.songa.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://your-api-url.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

