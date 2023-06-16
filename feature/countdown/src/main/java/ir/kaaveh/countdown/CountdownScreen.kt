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
import ir.kaaveh.countdown.component.Counter
import ir.kaaveh.countdown.component.CounterController
import ir.kaaveh.countdown.model.CountdownState
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel,
) {
    val state = viewModel.countdownState.value
    CountdownScreen(
        countdownState = state,
        onRestClicked = { viewModel.resetCountdown() },
    ) { viewModel.startCountdown() }
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