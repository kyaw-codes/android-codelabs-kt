package com.kyaw.contact.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var contactId: Long = 0,
    var name: String,
    var phone: String,
    var mail: String,
    var address: String
) {
    val header: String
        get() = name.substring(0, 1).toUpperCase()
}