package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var clickableViews: List<View>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)

        /**
         * One - click solution
         * ***
            binding.buExistLogin.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_welcomeFragment)    //    3rd approach
            )
            binding.buNewLogin.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_welcomeFragment)    //    3rd approach
            )
         *
         */

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        clickableViews = listOf(buNewLogin, buExistLogin)
        for (item in clickableViews) {
            item.setOnClickListener { sendToWelcome(it) }
        }
    }

    /** Two - click approach */
    private fun sendToWelcome(view: View?) {
        when(view?.id){
            R.id.buExistLogin -> binding.buExistLogin.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_welcomeFragment)    //    3rd approach
            )

            R.id.buNewLogin -> binding.buNewLogin.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_welcomeFragment)    //    3rd approach
            )
        }
    }

}