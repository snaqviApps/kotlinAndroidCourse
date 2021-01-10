package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private val viewModelList: ShoeStoreViewModel by activityViewModels()

    private lateinit var shoeItemBinding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       shoeItemBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
       )

        Timber.d("called ViewModelProvider()%s", "")

        var linearLayout = R.id.listLinearLayout
//        val linearLayout = R.layout.fragment_shoe_

        shoeItemBinding.sStoreViewModelList = viewModelList
        shoeItemBinding.lifecycleOwner = this

//        viewModelDetails.eventCancel.observe(this.viewLifecycleOwner, Observer { cancelSaving ->
        viewModelList.shoeData.observe(this.viewLifecycleOwner, { shoeReceived ->
            if(shoeReceived != null){

                shoeReceived.forEach { shoeItem ->
                    Timber.d("shoe size received in listFrag is: %s", shoeItem.size)

                    // add each list member to a new LinearLayout


                    val shoeItemBinding = FragmentShoeListBinding.inflate(
                        layoutInflater,
                        null,
                        false
                    )
                    shoeItemBinding.shoe = shoeItem
                    shoeItemBinding.listLinearLayout.addView(shoeItemBinding.root)
                }

                Timber.d("shoe size received in listFrag is: %s", shoeReceived.size)

            }
        })

        shoeItemBinding.buFab.setOnClickListener {           // navigation 1st - method
            it.findNavController().navigate(
                R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return shoeItemBinding.root
    }

}