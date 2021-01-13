package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel: ViewModel() {

    var shoeDetailsObj:Shoe = Shoe("",0.0,"","")
    private val _shoeDataList = mutableListOf<Shoe>()
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
        _shoeDataList.add(shoe)
        _shoeData.value = _shoeDataList
        if(_shoeDataList.size != 0)
            shoeDetailsObj= Shoe("",0.0,"","")
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