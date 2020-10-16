package me.rosuh.easywatermark.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.test.platform.app.InstrumentationRegistry
import me.rosuh.easywatermark.debug.test.BuildConfig

object ContextHelper {

    val sharedPrefs: SharedPreferences
    val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    init {
        val spName = "sp_${BuildConfig.BUILD_TYPE}"
        val spMode = Context.MODE_PRIVATE
        sharedPrefs =
            appContext.getSharedPreferences(spName, spMode)
    }
}