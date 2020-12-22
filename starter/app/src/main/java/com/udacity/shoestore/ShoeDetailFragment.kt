package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private val viewModelDetails: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.shoeStoreViewModel = viewModelDetails
        /**  apparently the MainActivity is right place, but put here as well */
        binding.lifecycleOwner = this

        val shoeObj = Shoe(
            binding.etShoeName.text.toString(),
            binding.etShoeSize.text.toString().toDouble(),
            binding.etCompany.text.toString(),
            binding.etDescription.text.toString(),
//                null

        )
        viewModelDetails.addShoe(shoeObj)

        viewModelDetails.eventSave.observe(viewLifecycleOwner, { saveNewShoe ->
            if (saveNewShoe) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModelDetails.onSaveComplete()
            }
        })
        viewModelDetails.eventCancel.observe(viewLifecycleOwner, { cancelSaving ->
            if (cancelSaving) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModelDetails.onCancelComplete()
            }
        })

        return binding.root
    }


}