package ir.kaaveh.ext_functions

import org.junit.Assert
import org.junit.Test

class TimeTest {

    @Test
    fun timeToMinutes() {
        Assert.assertEquals(0.minutes, 0)
        Assert.assertEquals(20.minutes, 0)
        Assert.assertEquals(60.minutes, 1)
        Assert.assertEquals(90.minutes, 1)
        Assert.assertEquals(120.minutes, 2)
        Assert.assertEquals(121.minutes, 2)
    }

    @Test
    fun timeToSeconds() {
        Assert.assertEquals(0.seconds, 0)
        Assert.assertEquals(20.seconds, 20)
        Assert.assertEquals(60.seconds, 0)
        Assert.assertEquals(90.seconds, 30)
        Assert.assertEquals(120.seconds, 0)
        Assert.assertEquals(121.seconds, 1)
    }

    @Test
    fun timeToSecondsInTowDigitStyle() {
        Assert.assertEquals(0.seconds.toString().toTowDigitFormat(), "00")
        Assert.assertEquals(1.seconds.toString().toTowDigitFormat(), "01")
        Assert.assertEquals(10.seconds.toString().toTowDigitFormat(), "10")
        Assert.assertEquals(20.seconds.toString().toTowDigitFormat(), "20")
        Assert.assertEquals(100.seconds.toString().toTowDigitFormat(), "40")
        Assert.assertEquals(1200.seconds.toString().toTowDigitFormat(), "00")
        Assert.assertEquals(1200.minutes.toString().toTowDigitFormat(), "20")
    }

}