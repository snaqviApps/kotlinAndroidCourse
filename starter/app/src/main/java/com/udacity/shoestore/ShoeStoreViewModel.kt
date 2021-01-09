package com.udacity.shoestore

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {

//     Shoe - model internal
//    private val _shoeDataList = MutableLiveData<List<Shoe>>()
    private val _shoeDataList = mutableListOf<Shoe>()
    val shoeDataList : MutableList<Shoe>
        get() {
            return _shoeDataList
        }

    private val _shoeData = MutableLiveData<List<Shoe>>()
    val shoeData : MutableLiveData<List<Shoe>>
        get() {
            return _shoeData
        }

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

    fun addShoe(shoe: Shoe) {

        _eventSave.value = true

        _shoeDataList.add(shoe)         // step 1

        _shoeData.value = _shoeDataList // step 2

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