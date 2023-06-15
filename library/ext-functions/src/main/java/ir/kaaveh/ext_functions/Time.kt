package ir.kaaveh.ext_functions

val Long.minutes: Long
    get() = this / 60

val Long.seconds: Long
    get() = this % 60

fun String.toTowDigitFormat(): String =
    if (this.length == 1) {
        "0$this"
    } else {
        this
    }