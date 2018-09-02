package com.egecius.architecturecomponents_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

/**
 * Single responsibility:
 * //todo
 */
class DemoActivity : AppCompatActivity() {

    internal var imagesLiveData = ImagesLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imagesLiveData.observe(this, Observer { })
    }
}
