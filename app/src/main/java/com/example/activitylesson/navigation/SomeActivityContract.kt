package com.example.activitylesson.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.activitylesson.navigation.NavConsts.NAVIGATION_KEY

class SomeActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, ResultTestActivity::class.java)
            .putExtra(NAVIGATION_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getStringExtra(NAVIGATION_KEY)
    }

    override fun getSynchronousResult(
        context: Context,
        input: String
    ): SynchronousResult<String?>? {
        return if (input.isEmpty()) {
            SynchronousResult("bad args!")
        } else {
            null
        }
    }
}