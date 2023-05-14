package com.example.activitylesson.navigation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylesson.R

class NavActivityMain : AppCompatActivity() {

    private val activityResultLauncher =
        registerForActivityResult(SomeActivityContract()) { result ->
            if (result != null) {
                findViewById<TextView>(R.id.tv_nav_main).text = result
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_main)

        val gotToResultBtn = findViewById<Button>(R.id.btn_go_to_result)
        gotToResultBtn.setOnClickListener {
            activityResultLauncher.launch("hello, 6*7?")
        }
    }
}