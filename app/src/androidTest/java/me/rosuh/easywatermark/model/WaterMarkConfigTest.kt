package me.rosuh.easywatermark.model

import android.content.SharedPreferences
import me.rosuh.easywatermark.utils.ContextHelper
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.nio.charset.Charset
import kotlin.random.Random

class WaterMarkConfigTest {

    private lateinit var sharedPrefs: SharedPreferences

    @Before
    fun setUp() {
        // Context of the app under test.
        sharedPrefs = ContextHelper.sharedPrefs
    }

    @Test
    fun testSp() {
        val config = WaterMarkConfig.pull(sharedPrefs)
        println("$config")
    }

    @After
    fun tearDown() {
    }

    private fun randomString(): String {
        val array = ByteArray(7) // length is bounded by 7
        Random.nextBytes(array)
        return String(array, Charset.forName("UTF-8"))
    }

}