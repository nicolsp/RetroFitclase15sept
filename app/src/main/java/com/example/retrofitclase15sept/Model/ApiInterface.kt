package com.example.retrofitclase15sept.Model

import retrofit2.http.GET

interface ApiInterface {

    @GET("realestate")
    fun getDataFromApi() : retrofit2.Call<List<Terrain>>




}