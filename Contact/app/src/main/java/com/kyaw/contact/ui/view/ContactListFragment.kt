package com.kyaw.contact.ui.view

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kyaw.contact.R
import com.kyaw.contact.adapter.ContactListAdapter
import com.kyaw.contact.databinding.FragmentContactListBinding
import com.kyaw.contact.model.ContactDatabase
import com.kyaw.contact.ui.viewmodel.ContactListVM
import com.kyaw.contact.ui.viewmodel.ContactListVMFactory

class ContactListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentContactListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        // get database instance via application
        val application: Application = requireNotNull(this.activity).application
        val database = ContactDatabase.getInstance(application)

        // Create a view model with factory
        val factory = ContactListVMFactory(database.getContactDao())
        val viewModel: ContactListVM = ViewModelProvider(this, factory).get(ContactListVM::class.java)

        val adapter = ContactListAdapter()

        viewModel.contactList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        // Set up adapter here
        binding.contactList.adapter = adapter

        return binding.root
    }
}