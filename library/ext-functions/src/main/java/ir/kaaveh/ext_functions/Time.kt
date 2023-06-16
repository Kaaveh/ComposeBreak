package ir.kaaveh.ext_functions

val Int.minutes: Int
    get() = this / 60

val Int.seconds: Int
    get() = this % 60

fun String.toTowDigitFormat(): String =
    if (this.length == 1) {
        "0$this"
    } else {
        this
    }