package ir.kaaveh.countdown.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ir.kaaveh.countdown.model.CountdownState
import ir.kaaveh.designesystem.ThemePreviews
import ir.kaaveh.designesystem.theme.ComposeBreakTheme
import ir.kaaveh.designesystem.widget.AnimatedCounter
import ir.kaaveh.ext_functions.minutes
import ir.kaaveh.ext_functions.seconds
import ir.kaaveh.ext_functions.toTowDigitFormat

@Composable
fun Counter(countdownState: CountdownState) {

    val minutes = countdownState.remainTime.minutes.toString().toTowDigitFormat()

    val seconds = countdownState.remainTime.seconds.toString().toTowDigitFormat()

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AnimatedCounter(count = minutes)

        Text(text = " : ")

        AnimatedCounter(count = seconds)
    }
}

@ThemePreviews
@Composable
private fun CounterPreview() {
    ComposeBreakTheme {
        Surface {
            Counter(countdownState = CountdownState())
        }
    }
}