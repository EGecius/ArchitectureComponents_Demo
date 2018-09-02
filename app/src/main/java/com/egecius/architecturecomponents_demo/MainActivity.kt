package com.egecius.architecturecomponents_demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private val imagesLiveData = ImagesLiveData()
    private lateinit var viewModel: CounterViewModel
    private lateinit var counterView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initLiveData()

        counterView = findViewById(R.id.counter)
        setOnClickListener()
        updateCounterView()
    }

    private fun initLiveData() {
        imagesLiveData.observe(this, Observer {
            showImages(it)
        })
    }

    private fun showImages(imagesList: List<String>) {

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
