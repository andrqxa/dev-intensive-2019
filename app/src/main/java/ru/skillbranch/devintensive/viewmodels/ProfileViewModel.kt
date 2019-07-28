package ru.skillbranch.devintensive.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    init {
        Log.d("M_ProfileViewModel", "init view model")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel", "view model cleared")
    }

    fun geProfileData() {

    }

    fun saveProfileData() {

    }
}