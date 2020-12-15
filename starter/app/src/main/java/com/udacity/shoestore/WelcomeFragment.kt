package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentMainBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber


class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Timber.d("WelcomeFragment: onCreateView() ")
        val bindingWelcome: FragmentWelcomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_welcome, container, false)

        bindingWelcome.buWelcome.setOnClickListener {           // navigation 1st - method
            it.findNavController().navigate(
                R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return bindingWelcome.root
    }

}