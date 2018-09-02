package com.egecius.architecturecomponents_demo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel
    private lateinit var counterView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initLifecycleObserver()

        counterView = findViewById(R.id.counter)
        imageView = findViewById(R.id.image_view)

        setOnClickListener()
        updateCounterView()
    }

    private fun initLifecycleObserver() {
        MyLifecycleObserver().bindTo(this)
    }

    override fun onStart() {
        super.onStart()
        initLiveData()
    }

    private fun initLiveData() {

        val imagesLiveData: ImagesLiveData = viewModel.getImagesLiveData()
        imagesLiveData.observe(this, Observer {
            showImages(it)
        })
    }

    private fun showImages(imagesList: List<String>) {
        Picasso.get().load(imagesList[0]).into(imageView)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
    }

    private fun setOnClickListener() {
        findViewById<Button>(R.id.increase_counter).setOnClickListener {
            viewModel.increaseCounter()
            updateCounterView()
        }
    }

    private fun updateCounterView() {
        val counter: String = viewModel.getCounter().toString()
        counterView.text = counter
    }
}
