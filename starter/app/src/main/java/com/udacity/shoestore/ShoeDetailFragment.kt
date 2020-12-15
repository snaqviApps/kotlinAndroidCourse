package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private val viewModelDetails: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
        inflater, R.layout.fragment_shoe_detail, container, false)

//        viewModelFactory = ShoeStoreViewModelFactory()
//        viewModelStore = ViewModelProvider(this, viewModelFactory).get(ShoeStoreViewModel::class.java)
//        binding.shoeDatailsViewModel = viewModelStore

        binding.shoeStoreViewModel = viewModelDetails





        return binding.root
    }


}