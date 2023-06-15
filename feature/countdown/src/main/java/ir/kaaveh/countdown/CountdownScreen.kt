package ir.kaaveh.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.countdown.component.Counter
import ir.kaaveh.countdown.component.CounterController
import ir.kaaveh.countdown.model.CountdownState
import ir.kaaveh.countdown.model.CounterState
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel,
) {
    CountdownScreen("", "")
}

@Composable
fun CountdownScreen(
    minutes: String,
    seconds: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Counter(minutes = minutes, seconds = seconds)
    }
}

@Preview(showBackground = true)
@Composable
private fun CountDownScreenPreview() {
    ComposeBreakTheme {
        Surface {
            CountdownScreen(minutes = "19", seconds = "39")
        }
    }
}