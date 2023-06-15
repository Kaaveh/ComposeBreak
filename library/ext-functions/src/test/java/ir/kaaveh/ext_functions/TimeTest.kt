package ir.kaaveh.ext_functions

import org.junit.Assert
import org.junit.Test

class TimeTest {

    @Test
    fun timeToMinutes() {
        Assert.assertEquals(0L.minutes, 0L)
        Assert.assertEquals(20L.minutes, 0L)
        Assert.assertEquals(60L.minutes, 1L)
        Assert.assertEquals(90L.minutes, 1L)
        Assert.assertEquals(120L.minutes, 2L)
        Assert.assertEquals(121L.minutes, 2L)
    }

    @Test
    fun timeToSeconds() {
        Assert.assertEquals(0L.seconds, 0L)
        Assert.assertEquals(20L.seconds, 20L)
        Assert.assertEquals(60L.seconds, 0L)
        Assert.assertEquals(90L.seconds, 30L)
        Assert.assertEquals(120L.seconds, 0L)
        Assert.assertEquals(121L.seconds, 1L)
    }

    @Test
    fun timeToSecondsInTowDigitStyle() {
        Assert.assertEquals(0L.seconds.toString().toTowDigitFormat(), "00")
        Assert.assertEquals(1L.seconds.toString().toTowDigitFormat(), "01")
        Assert.assertEquals(10L.seconds.toString().toTowDigitFormat(), "10")
        Assert.assertEquals(20L.seconds.toString().toTowDigitFormat(), "20")
        Assert.assertEquals(100L.seconds.toString().toTowDigitFormat(), "40")
        Assert.assertEquals(1200L.seconds.toString().toTowDigitFormat(), "00")
        Assert.assertEquals(1200L.minutes.toString().toTowDigitFormat(), "20")
    }

}