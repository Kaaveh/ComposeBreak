package ir.kaaveh.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.kaaveh.countdown.component.Counter
import ir.kaaveh.countdown.component.CounterController
import ir.kaaveh.countdown.model.CountdownState
import ir.kaaveh.designesystem.theme.ComposeBreakTheme
import ir.kaaveh.ext_functions.minutes
import ir.kaaveh.ext_functions.seconds
import ir.kaaveh.ext_functions.toTowDigitFormat

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel = hiltViewModel(),
    onCounterUpdate: (String) -> Unit,
) {

    val state = viewModel.countdownState.value
    state.remainTime.apply {
        val minutes = minutes.toString().toTowDigitFormat()
        val seconds = seconds.toString().toTowDigitFormat()

        onCounterUpdate("$minutes : $seconds")
    }

    CountdownScreen(
        countdownState = state,
        onRestClicked = { viewModel.resetCountdown() },
        onStartClicked = { viewModel.startCountdown() },
    )
}

@Composable
fun CountdownScreen(
    countdownState: CountdownState,
    onRestClicked: () -> Unit,
    onStartClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Counter(countdownState = countdownState)

        Spacer(modifier = Modifier.height(16.dp))

        CounterController(
            counterState = countdownState.counterState,
            onRestClicked = { onRestClicked() },
            onStartClicked = { onStartClicked() },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CountDownScreenPreview() {
    ComposeBreakTheme {
        Surface {
            CountdownScreen(
                countdownState = CountdownState(),
                onRestClicked = {},
                onStartClicked = {},
            )
        }
    }
}