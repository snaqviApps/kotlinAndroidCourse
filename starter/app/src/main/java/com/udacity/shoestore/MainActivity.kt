package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

//        viewModelFactory = ShoeStoreViewModelFactory()
//        viewModelStore = ViewModelProvider(this, viewModelFactory).get(ShoeStoreViewModel::class.java)
//        binding.shoeDatailsViewModel = viewModelStore

        /** viewModel implementation
         * using Activity-based access, while
         * viewModelFactory approach, above,
         * is withheld
         */
        val modelActivity: ShoeStoreViewModel by viewModels()
        modelActivity.shoeData.observe(this, Observer { shoe ->
            // update UI in Fragments
        })
        binding.lifecycleOwner = this

        /** navigation UI (library) getting access to Navigation-Controller    */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        val navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
