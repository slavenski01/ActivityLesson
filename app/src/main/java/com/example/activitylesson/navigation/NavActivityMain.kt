package com.example.activitylesson.navigation

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylesson.R

class NavActivityMain : AppCompatActivity() {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_main)

        val gotToResultBtn = findViewById<Button>(R.id.btn_go_to_result)
        gotToResultBtn.setOnClickListener { 
            getContent.launch("image/*")
        }
    }
}