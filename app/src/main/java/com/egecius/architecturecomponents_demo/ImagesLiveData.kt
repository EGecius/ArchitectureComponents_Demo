package com.egecius.architecturecomponents_demo

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData

class ImagesLiveData : LiveData<List<String>>(){

    private val picassoImg = "http://i.imgur.com/DvpvklR.png"

    override fun onActive() {
        Log.v("Eg:ImagesLiveData:8", "onActive ")
        loadImageWithDelay()
    }

    private fun loadImageWithDelay() {
        val handler = Handler()
        handler.postDelayed({
            Log.d("Eg:ImagesLiveData:21", "loadImageWithDelay loading value now! " + hashCode())
            value = listOf(picassoImg)
        }, 3000)
    }

    override fun onInactive() {
        Log.v("Eg:ImagesLiveData:14", "onInactive ")
    }

}
