package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {

//     Shoe - model internal
    private val shoesList = mutableListOf<Shoe>()
    private val _shoeData = MutableLiveData<List<Shoe>>()
    val shoeData : LiveData<List<Shoe>>
        get() {
            return _shoeData
        }

//    private val _shoeData = MutableLiveData<Shoe>()
//    val shoeData : LiveData<Shoe>
//        get() {
//            return _shoeData
//        }

    private val _eventSave = MutableLiveData<Boolean>()
    val eventSave: LiveData<Boolean>
        get() = _eventSave

    private val _eventCancel = MutableLiveData<Boolean>()
    val eventCancel: LiveData<Boolean>
        get() = _eventCancel

    init {
        Timber.d("ShoeListViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("ShoeListViewModel destroyed ")
    }

    //sample method to add shoe
    fun addShoe(shoe: Shoe) {
//        _shoeData.value = shoe
        shoesList.add(shoe)
    }

    fun onSave() {
        _eventSave.value = true
    }

    fun onSaveComplete() {
        _eventSave.value = false
    }

    fun onCancel() {
        _eventCancel.value = true
    }

    fun onCancelComplete() {
        _eventCancel.value = false
    }

}