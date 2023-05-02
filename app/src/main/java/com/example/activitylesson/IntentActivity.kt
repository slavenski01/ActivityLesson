package com.example.activitylesson

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        findViewById<Button>(R.id.btn_intent).setOnClickListener {
            val text = findViewById<EditText>(R.id.tv_intent).text.toString()
            click(text)
        }
    }

    private fun click(text: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(sendIntent)
    }
}