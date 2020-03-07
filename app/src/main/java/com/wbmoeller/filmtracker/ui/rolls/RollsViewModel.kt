package com.wbmoeller.filmtracker.ui.rolls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RollsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rolls Fragment"
    }
    val text: LiveData<String> = _text
}