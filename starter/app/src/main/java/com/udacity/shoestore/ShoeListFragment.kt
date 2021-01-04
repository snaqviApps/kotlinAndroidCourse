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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private val viewModelList: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val bindingList: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
       )

        Timber.d("called ViewModelProvider()%s", "")


        bindingList.sStoreViewModelList = viewModelList

        /**  apparently the MainActivity is right place, but put here as well */
        bindingList.lifecycleOwner = this
//        bindingList.setLifecycleOwner(this.viewLifecycleOwner)

        viewModelList.shoeData.observe(this.viewLifecycleOwner, Observer { shoeReceived ->
            if(shoeReceived != null){
                Timber.d("shoe size received in listFrag is: %s", shoeReceived.size)
            }
        })

        bindingList.buFab.setOnClickListener {           // navigation 1st - method
            it.findNavController().navigate(
                R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return bindingList.root
    }

}