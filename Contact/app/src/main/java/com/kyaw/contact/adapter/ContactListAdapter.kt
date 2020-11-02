package com.kyaw.contact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kyaw.contact.databinding.ItemContactBinding
import com.kyaw.contact.model.entity.Contact

class ContactListAdapter :
    ListAdapter<Contact, ContactListAdapter.ViewHolder>(ContactListCallback()) {

    class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun bind(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemContactBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(contact: Contact?) {
            binding.header.text = contact?.header
            binding.name.text = contact?.name
            binding.phone.text = contact?.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.bind(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)

        holder.itemView.setOnClickListener {
            // TODO navigate to Contact Detail
        }
    }
}

class ContactListCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean =
        oldItem.contactId == newItem.contactId

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean =
        oldItem == newItem
}
