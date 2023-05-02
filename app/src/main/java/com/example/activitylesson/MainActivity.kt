package com.example.activitylesson

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylesson.lifecycle.LifecycleActivity
import com.example.activitylesson.navigation.NavActivityMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_go_intent).setOnClickListener {
            startActivity(Intent(this, IntentActivity::class.java))
        }

        findViewById<Button>(R.id.btn_go_lifecycle).setOnClickListener {
            startActivity(Intent(this, LifecycleActivity::class.java))
        }

        findViewById<Button>(R.id.btn_go_to_nav).setOnClickListener {
            startActivity(Intent(this, NavActivityMain::class.java))
        }
    }
}