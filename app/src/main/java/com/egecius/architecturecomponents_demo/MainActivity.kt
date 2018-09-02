package com.egecius.architecturecomponents_demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel
    private lateinit var counterView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterView = findViewById(R.id.counter)
        setOnClickListener()

        val fragmentActivity: FragmentActivity = this
        viewModel = ViewModelProviders.of(fragmentActivity).get(CounterViewModel::class.java)
        updateCounterView()
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
