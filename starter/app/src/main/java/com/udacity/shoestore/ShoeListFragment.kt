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
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var shoeItem: Shoe

    private val viewModelList: ShoeStoreViewModel by activityViewModels()

    private lateinit var shoeListBinding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
       )

        Timber.d("called ViewModelProvider()%s", "")

        shoeListBinding.sStoreViewModelList = viewModelList
        shoeListBinding.lifecycleOwner = this

//        viewModelDetails.eventCancel.observe(this.viewLifecycleOwner, Observer { cancelSaving ->
        viewModelList.shoeData.observe(this.viewLifecycleOwner, { shoeReceived ->
            if(shoeReceived != null){

                shoeReceived.forEach { shoeItem ->
                    Timber.d("shoe size received in listFrag is: %s", shoeItem.size)

                    // add each list member to a new LinearLayout


                    val shoeItemBinding = ItemShoeBinding.inflate(
                        layoutInflater,
                        null,
                        false
                    )
                    shoeItemBinding.shoeToList = shoeItem
//                    shoeItemBinding.listLinearLayout.addView(shoeItemBinding.root)
                    shoeListBinding.listLinearLayout.addView(shoeItemBinding.root)
                }

                Timber.d("shoe size received in listFrag is: %s", shoeReceived.size)

            }
        })

        shoeListBinding.buFab.setOnClickListener {           // navigation 1st - method
            it.findNavController().navigate(
                R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return shoeListBinding.root
    }

}