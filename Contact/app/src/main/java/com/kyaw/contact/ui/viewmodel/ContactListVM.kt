package com.kyaw.contact.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kyaw.contact.model.dao.ContactDao
import com.kyaw.contact.model.entity.Contact

class ContactListVM(dao: ContactDao) : ViewModel() {

    val contactList: LiveData<List<Contact>> = dao.getAll()
}

class ContactListVMFactory(private val dao: ContactDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactListVM::class.java)) {
            return ContactListVM(dao) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }

}
