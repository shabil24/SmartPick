package com.smartpick.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartpick.model.Phone

class FavoriteViewModel : ViewModel() {

    private val _favoriteList = MutableLiveData<MutableList<Phone>>(mutableListOf())
    val favoriteList: LiveData<MutableList<Phone>> get() = _favoriteList

    fun add(phone: Phone) {
        if (!_favoriteList.value!!.contains(phone)) {
            _favoriteList.value = _favoriteList.value!!.toMutableList().apply {
                add(phone)
            }
        }
    }

    fun remove(phone: Phone) {
        _favoriteList.value = _favoriteList.value!!.toMutableList().apply {
            remove(phone)
        }
    }
}
