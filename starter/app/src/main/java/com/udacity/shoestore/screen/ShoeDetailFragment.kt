package com.udacity.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
//import com.udacity.shoestore.ShoeDetailFragmentDirections
import com.udacity.shoestore.ShoeStoreViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {


    private val viewModelDetails: ShoeStoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bindingDetails: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        bindingDetails.newShoe = viewModelDetails.shoeDetailsObj

        bindingDetails.shoeStoreViewModel = viewModelDetails
        bindingDetails.lifecycleOwner = this.viewLifecycleOwner
        viewModelDetails.eventSave.observe(this.viewLifecycleOwner, Observer { saveNewShoe ->
            if (saveNewShoe) {
                findNavController().navigateUp()
                bindingDetails.newShoe = null
                viewModelDetails.onSaveComplete()
            }
        })
        viewModelDetails.eventCancel.observe(this.viewLifecycleOwner, Observer { cancelSaving ->
            if (cancelSaving) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModelDetails.onCancelComplete()
            }
        })
        return bindingDetails.root
    }

}