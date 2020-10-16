package me.rosuh.easywatermark.ktx

import org.junit.Assert.assertEquals
import org.junit.Test

class LongExtensionKtTest {

    @Test
    fun formatDate() {
        var longValue = 1602576229000L
        assertEquals("2020_10_13_04_03", longValue.formatDate())
    }
}