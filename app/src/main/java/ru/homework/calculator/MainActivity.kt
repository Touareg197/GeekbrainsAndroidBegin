package ru.homework.calculator

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button

    private lateinit var layoutFirst: LinearLayout
    private lateinit var layoutSecond: LinearLayout
    private lateinit var layoutThird: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initButtonListeners()
    }

    private fun initView() {
        buttonOne = findViewById(R.id.first_task_btn)
        buttonTwo = findViewById(R.id.second_task_btn)
        buttonThree = findViewById(R.id.third_task_btn)

        layoutFirst = findViewById(R.id.first_task_layout)
        layoutSecond = findViewById(R.id.second_task_layout)
        layoutThird = findViewById(R.id.third_task_layout)
    }

    private fun initButtonListeners() {
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        hideAll()
        v?.hideKeyboard()
        when (v?.id) {
            R.id.first_task_btn -> layoutFirst.visibility = View.VISIBLE
            R.id.second_task_btn -> layoutSecond.visibility = View.VISIBLE
            R.id.third_task_btn -> layoutThird.visibility = View.VISIBLE
        }
    }

    private fun hideAll() {
        layoutFirst.visibility = View.GONE
        layoutSecond.visibility = View.GONE
        layoutThird.visibility = View.GONE
    }

    fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}