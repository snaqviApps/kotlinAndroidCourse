package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {

    // Shoe - model internal
//    private val _shoeData = MutableLiveData<List<Shoe>>()
//    val shoeData : LiveData<List<Shoe>>
//        get() {
//            return _shoeData
//        }
    private val _shoeData = MutableLiveData<Shoe>()
    val shoeData : LiveData<Shoe>
        get() {
            return _shoeData
        }

    init {
        Timber.d("ShoeListViewModel created")

    }


    override fun onCleared() {
        super.onCleared()
        Timber.d("ShoeListViewModel destroyed ")
    }

}
