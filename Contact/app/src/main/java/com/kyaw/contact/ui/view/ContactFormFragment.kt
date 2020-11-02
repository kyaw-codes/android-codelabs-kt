package com.kyaw.contact.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kyaw.contact.R
import com.kyaw.contact.databinding.FragmentContactFormBinding
import com.kyaw.contact.model.ContactDatabase
import com.kyaw.contact.model.entity.Contact
import com.kyaw.contact.ui.viewmodel.ContactFormVM
import com.kyaw.contact.ui.viewmodel.ContactFormVMFactory

class ContactFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentContactFormBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_form, container, false)
        binding.lifecycleOwner = this

        val application = requireNotNull(activity).application
        val dao = ContactDatabase.getInstance(application).getContactDao()

        val factory = ContactFormVMFactory(dao)
        val viewModel = ViewModelProvider(this, factory).get(ContactFormVM::class.java)

        binding.viewModel = viewModel

        binding.save.setOnClickListener {
            viewModel.saveContact()
            findNavController().navigate(ContactFormFragmentDirections.actionContactFormFragmentToContactListDestination())
        }

        return binding.root
    }
}