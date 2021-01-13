package com.udacity.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeStoreViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding


class ShoeListFragment : Fragment() {

    private val viewModelList: ShoeStoreViewModel by activityViewModels()
    private lateinit var shoeListBinding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
       )
        shoeListBinding.sStoreViewModelList = viewModelList
        shoeListBinding.lifecycleOwner = this

        viewModelList.shoeData.observe(this.viewLifecycleOwner, { shoeReceived ->
            if(shoeReceived != null){
                shoeReceived.forEach { shoeItem ->
                    val shoeItemBinding = ItemShoeBinding.inflate(
                        layoutInflater,
                        null,
                        false
                    )
                    shoeItemBinding.shoeToList = shoeItem
                    shoeListBinding.listLinearLayout.addView(shoeItemBinding.root)
                }
            }
        })

        shoeListBinding.buFab.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_shoeListFragment_to_shoeDetailFragment
            )
        }
        return shoeListBinding.root
    }

}