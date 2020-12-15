package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeStoreViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShoeStoreViewModel::class.java)){
            return ShoeStoreViewModel() as T
        }
        throw IllegalArgumentException("Unkown ViewModelClass")
    }


}
