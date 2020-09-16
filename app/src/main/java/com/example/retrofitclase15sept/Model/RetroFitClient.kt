package com.example.retrofitclase15sept.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitClient {

   companion object {
       private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"


       fun getRetroFitClient() : ApiInterface {
           val mretrofit = Retrofit.Builder()
               .baseUrl(URL_BASE)
               .addConverterFactory(GsonConverterFactory.create())
               .build()

           return mretrofit.create(ApiInterface::class.java)
       }
   }





}