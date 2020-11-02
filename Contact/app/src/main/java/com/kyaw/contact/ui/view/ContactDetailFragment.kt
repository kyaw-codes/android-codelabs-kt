package com.kyaw.contact.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kyaw.contact.R
import com.kyaw.contact.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentContactDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}