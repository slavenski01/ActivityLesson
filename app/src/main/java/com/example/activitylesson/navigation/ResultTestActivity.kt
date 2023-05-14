package com.example.activitylesson.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylesson.R
import com.example.activitylesson.navigation.NavConsts.NAVIGATION_KEY

class ResultTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_test)

        findViewById<Button>(R.id.btn_send_result).setOnClickListener {
            val result = Intent().putExtra(
                NAVIGATION_KEY,
                findViewById<EditText>(R.id.tv_label_result).editableText.toString()
            )
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}