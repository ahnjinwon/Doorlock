package com.example.doorlock.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doorlock.Users

class HomeViewModel : ViewModel() {
    val userList = MutableLiveData<List<Users>>()
    private val _userList = arrayListOf<Users>()

    fun toggleUser() {
        userList.value = _userList
    }

    fun addUser(user: Users) {
        _userList.add(user)
        userList.value = _userList
    }

    fun deleteUser(user: Users) {
        _userList.remove(user)
        userList.value = _userList
    }
}