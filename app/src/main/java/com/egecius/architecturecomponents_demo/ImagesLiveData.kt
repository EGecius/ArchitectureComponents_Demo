package com.egecius.architecturecomponents_demo

import android.util.Log
import androidx.lifecycle.LiveData

class ImagesLiveData : LiveData<List<String>>(){

    val picassoImg = "http://i.imgur.com/DvpvklR.png"

    override fun onActive() {
        Log.v("Eg:ImagesLiveData:8", "onActive ")
        value = listOf(picassoImg)
    }

    override fun onInactive() {
        Log.v("Eg:ImagesLiveData:14", "onInactive ")
    }

}
