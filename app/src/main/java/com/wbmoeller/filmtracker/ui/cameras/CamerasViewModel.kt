package com.wbmoeller.filmtracker.ui.cameras

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CamerasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is cameras Fragment"
    }
    val text: LiveData<String> = _text
}