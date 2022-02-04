package com.example.myfirstapp_v2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    //Update Counter
    private val _updatedCount = MutableLiveData<Int>()
    val updatedCount: LiveData<Int> = _updatedCount

    //Store Random Number
    private val _randomNumber = MutableLiveData<Int>()
    val randomNumber: LiveData<Int> = _randomNumber

    //Update and store count number
    fun setCount(count: Int){
        //Convert value to a number and increment it
        var newCount: Int = count
        newCount++

        _updatedCount.value = newCount
    }

    //Generate random number and store
    fun setRandomNumber(count: Int){
        val random = java.util.Random()
        if (count > 0) {
            val randomNumber = random.nextInt(count + 1)
            _randomNumber.value = randomNumber
        }
    }

    //Initialise all values
    init {
        resetCount()
    }

    //Reset all values
    fun resetCount() {
        _updatedCount.value = 0
    }
}