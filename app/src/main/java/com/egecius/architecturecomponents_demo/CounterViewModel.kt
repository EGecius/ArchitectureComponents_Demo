package com.egecius.architecturecomponents_demo

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private var counterImpl = 0

    fun increaseCounter() {
        counterImpl++
    }

    fun getCounter() : Int {
        return counterImpl
    }
}