package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

//    private var shoeObj: Shoe = Shoe("", 0.00, "", "", null)

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

//        bindingDetails.newShoe = shoeObj                    // causes data-lost when configuration change
        bindingDetails.newShoe = viewModelDetails.shoeDetailsObj

        bindingDetails.shoeStoreViewModel = viewModelDetails
        bindingDetails.lifecycleOwner = this.viewLifecycleOwner

        viewModelDetails.eventSave.observe(this.viewLifecycleOwner, Observer { saveNewShoe ->
            if (saveNewShoe) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
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