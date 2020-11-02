package com.kyaw.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.kyaw.contact.databinding.ActivityMainBinding
import com.kyaw.contact.ui.view.ContactListFragmentDirections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController: NavController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.contactListDestination) {
                binding.fab.show()
                binding.fab.setOnClickListener {
                    // Navigate to contact form
                    navController.navigate(ContactListFragmentDirections.actionContactListDestinationToContactFormFragment())
                }
            } else {
                binding.fab.hide()
            }
        }
    }
}