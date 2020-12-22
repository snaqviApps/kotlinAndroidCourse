package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber


class ShoeListFragment : Fragment() {

//    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
       )

       Timber.d("called ViewModelProvider()")
//       viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)


        binding.buFab.setOnClickListener {           // navigation 1st - method
            it.findNavController().navigate(
                R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        return binding.root
    }


}