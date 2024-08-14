package com.example.koindemo

import android.util.Log

class MainRepositoryImpl(
    private val api: MyApi
): MainRepository {

    companion object {
        private val TAG = MainRepositoryImpl::class.simpleName
    }

    override fun doNetworkCall() {
        // api.callApi()
        Log.d(TAG, "Doing Network Call...")
    }
}