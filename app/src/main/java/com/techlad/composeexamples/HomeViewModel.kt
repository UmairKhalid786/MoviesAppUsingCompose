package com.techlad.composeexamples

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Created by umair.khalid on 01,October,2021
 **/

class HomeViewModel : ViewModel() {

    private lateinit var job: Job

    suspend fun makeApiCall(param: String) =
        calculateSomeResult()

//    fun makeCoroutine() {
//        job = viewModelScope.launch(handler) {
//            Timber.e("Inside MakeCoroutine")
//            calculateSomeResult()
//            yield()
//            Timber.e("MakeCoroutine Complete")
//        }
//    }

    private suspend fun calculateSomeResult() = viewModelScope.launch {
        delay(3000)
        Timber.e("Some API Calls result")
    }

//    fun cancelJob() {
//        job.cancel()
//    }

    private val handler = CoroutineExceptionHandler { context, exception ->
        Timber.e("Caught $exception")
    }
}