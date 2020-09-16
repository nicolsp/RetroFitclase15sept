package com.example.retrofitclase15sept.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private  val service = RetroFitClient.getRetroFitClient()
    val mLiveData : MutableLiveData<List<Terrain>> = MutableLiveData()

// la vieja confiable 
fun getDataFromServer() {
    val call = service.getDataFromApi()
    call.enqueue(object : Callback<List<Terrain>>   {
        override fun onFailure(call: Call<List<Terrain>>, t: Throwable) {
            Log.e("Repository", t.message.toString())
        }

        override fun onResponse(call: Call<List<Terrain>>, response: Response<List<Terrain>>) {
        when(response.code()) {
            in 200..299 -> mLiveData.postValue(response.body())
            in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
        }
        }

    })
}





}