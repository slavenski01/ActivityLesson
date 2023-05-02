package com.example.activitylesson.lifecycle

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylesson.R

class LifecycleActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var status: String? = null

    private var someComponent: SomeComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        status = savedInstanceState?.getString(STATUS_KEY)
        Log.e(TAG, "status: $status")

        setContentView(R.layout.activity_lifecycle)

        textView = findViewById(R.id.tv_status)
        status?.let { textView?.text = it }

        someComponent = SomeComponent()
        someComponent?.onCreate(this)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.let { it.text = savedInstanceState.getString(STATUS_KEY) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(TAG, "onSaveInstanceState")
        outState.run {
            status?.let {
                Log.e(TAG, "status put: $it")
                putString(STATUS_KEY, it)
            }
            textView?.let { putString(TEXT_VIEW_KEY, it.text.toString()) }
        }

        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        status = "onStart"
    }

    override fun onResume() {
        super.onResume()
        status = "onResume"
    }

    override fun onPause() {
        super.onPause()
        someComponent?.onPause(this)
        status = "onPause"
    }

    override fun onStop() {
        status = "onStop"
        super.onStop()
    }

    override fun onDestroy() {
        status = "onDestroy"
        super.onDestroy()
    }

    companion object {
        private const val TAG = "LifecycleActivity"
        private const val STATUS_KEY = "STATUS_KEY"
        private const val TEXT_VIEW_KEY = "TEXT_VIEW_KEY"
    }
}