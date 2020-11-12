package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentMainBinding
import timber.log.Timber


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)

       /**
        *  1st, 2nd approach
       binding.buExistLogin.setOnClickListener {
            view: View ->
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_welcomeFragment)      1st approach
            view.findNavController().navigate(R.id.action_mainFragment_to_welcomeFragment)                2nd approach
        }
        */
        
        /**
         * 3rd approach
         */
        binding.buExistLogin.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_welcomeFragment)    //    3rd approach
        )

    return binding.root
    }

}