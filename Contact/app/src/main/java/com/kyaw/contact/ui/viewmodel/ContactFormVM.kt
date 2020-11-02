package com.kyaw.contact.ui.viewmodel

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kyaw.contact.model.dao.ContactDao
import com.kyaw.contact.model.entity.Contact
import kotlinx.coroutines.launch

class ContactFormVM(private val dao: ContactDao) : ViewModel() {

    val name = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val mail = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    fun saveContact() {
        val nameVal = name.value
        val phoneVal = phone.value

        if (TextUtils.isEmpty(nameVal) || TextUtils.isEmpty(phoneVal)) return

        Contact(
            name = nameVal!!,
            phone = phoneVal!!,
            mail = mail.value ?: "",
            address = address.value ?: ""
        ).also {
            viewModelScope.launch {
                dao.add(it)
            }
        }
    }

}

class ContactFormVMFactory(private val dao: ContactDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactFormVM::class.java)) {
            return ContactFormVM(dao) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }

}