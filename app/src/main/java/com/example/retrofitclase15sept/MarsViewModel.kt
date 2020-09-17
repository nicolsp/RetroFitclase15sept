package com.example.retrofitclase15sept

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitclase15sept.Model.Repository
import com.example.retrofitclase15sept.Model.Terrain

class MarsViewModel : ViewModel() {
// una variable referencia al respositorio
    private val repository = Repository()

            init{
                //indico el metodo que traera el val respositorio
                repository.getDataFromServer()
            }
        fun exposeLiveDataFromServer(): LiveData<List<Terrain>> {
            return repository.mLiveData
        }




}