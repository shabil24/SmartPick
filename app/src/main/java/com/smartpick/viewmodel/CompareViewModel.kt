package com.smartpick.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartpick.model.Phone

class CompareViewModel : ViewModel() {
    private val _compareList = MutableLiveData<MutableList<Phone>>(mutableListOf())
    val compareList: LiveData<MutableList<Phone>> get() = _compareList

    fun add(phone: Phone) {
        if (_compareList.value?.contains(phone) == false && _compareList.value!!.size < 3) {
            _compareList.value = _compareList.value?.apply { add(phone) }
        }
    }

    fun remove(phone: Phone) {
        _compareList.value = _compareList.value?.apply { remove(phone) }
    }
}
