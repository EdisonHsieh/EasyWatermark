package me.rosuh.easywatermark.ktx

import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.ColorInt
import me.rosuh.easywatermark.model.WaterMarkConfig
import me.rosuh.easywatermark.utils.ContextHelper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations


class PainKtxKtTest {
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun applyConfig() {
        val paint = Paint()
        val config = WaterMarkConfig.pull(ContextHelper.sharedPrefs)
        println(config.toString())
        paint.applyConfig(config)
        assertEquals(paint.alpha, config.alpha)
        assertEquals(config.textSize / config.imageScale, paint.textSize)
        assertEquals(adjustAlpha(config.textColor, config.alpha), paint.color)
        assertEquals(config.textStyle, paint.style)
        assertTrue(paint.isDither)
        assertTrue(paint.isAntiAlias)
    }

    private fun adjustAlpha(@ColorInt color: Int, alpha: Int): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        return Color.argb(alpha, red, green, blue)
    }
}