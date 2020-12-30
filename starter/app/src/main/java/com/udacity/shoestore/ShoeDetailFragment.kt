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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private var shoeObj: Shoe? = null

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

        bindingDetails.shoeStoreViewModel = viewModelDetails
        /**  apparently the MainActivity is right place, but put here as well */
        bindingDetails.lifecycleOwner = this

        viewModelDetails.shoeData.observe(viewLifecycleOwner, Observer { shoe ->
//        viewModelDetails.shoeData.observe(requireActivity(), Observer{

            // update UI in Fragments
            shoeObj = Shoe(

//                bindingDetails.etShoeName.text.toString(),
                shoe.name,
                when {
                    bindingDetails.etShoeSize.text.toString() == "" -> 0.0
                    else -> bindingDetails.etShoeSize.text.toString()
                } as Double,
                shoe.company,
                shoe.description,
                listOf("Hi", "One", "two")
            )
            viewModelDetails.addShoe(shoeObj!!)
        })
//        viewModelDetails.addShoe(shoeObj)


        val boolSave = viewModelDetails.eventSave.value
        bindingDetails.buSave.setOnClickListener {v ->
            if(v != null){
                Toast.makeText(v.context, "Hi from onSave Method", Toast.LENGTH_SHORT).show()
            }
        }


//        viewModelDetails.eventSave.observe(viewLifecycleOwner, { saveNewShoe ->
        viewModelDetails.eventSave.observe(this.viewLifecycleOwner, Observer{ saveNewShoe ->
            if (saveNewShoe) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoeObj))
                viewModelDetails.onSaveComplete()
            }
        })
        viewModelDetails.eventCancel.observe(this.viewLifecycleOwner, { cancelSaving ->
//        viewModelDetails.eventCancel.observe(requireActivity(), { cancelSaving ->
            if (cancelSaving) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoeObj))
                viewModelDetails.onCancelComplete()
            }
        })

        return bindingDetails.root
    }


}