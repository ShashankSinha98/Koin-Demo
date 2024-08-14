package com.example.koindemo

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    fun doNetworkCall() {
        repository.doNetworkCall()
    }
}