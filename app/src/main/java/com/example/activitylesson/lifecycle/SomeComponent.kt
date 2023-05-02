package com.example.activitylesson.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class SomeComponent : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e(TAG, "event: onCreate")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.e(TAG, "event: onPause")
    }

    companion object {
        private const val TAG = "SomeComponent"
    }
}