package com.kyaw.contact.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kyaw.contact.model.entity.Contact

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Query("select * from contact where contactId == :key")
    suspend fun get(key: Long): Contact?

    @Delete
    suspend fun delete(contact: Contact)

    @Query("select * from contact")
    fun getAll(): LiveData<List<Contact>>

}