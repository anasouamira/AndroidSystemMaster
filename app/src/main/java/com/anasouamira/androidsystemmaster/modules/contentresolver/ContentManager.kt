package com.anasouamira.androidsystemmaster.modules.contentresolver

import android.content.Context
import android.provider.ContactsContract

class ContentManager(private val context: Context) {
    fun getContacts(): List<String> {
        val contacts = mutableListOf<String>()
        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )
        cursor?.use {
            while (it.moveToNext()) {
                val name = it.getString(
                    it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                )
                contacts.add(name)
            }
        }
        return contacts
    }
}
