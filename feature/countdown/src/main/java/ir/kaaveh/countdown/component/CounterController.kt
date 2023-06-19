package ir.kaaveh.countdown.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.kaaveh.countdown.model.CounterState
import ir.kaaveh.designesystem.ThemePreviews
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@Composable
fun CounterController(
    counterState: CounterState,
    onRestClicked: () -> Unit,
    onStartClicked: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 0.3F),
            onClick = {
                when (counterState) {
                    CounterState.INITIAL -> onStartClicked()
                    CounterState.PLAY -> onRestClicked()
                    CounterState.PAUSE -> onRestClicked()
                }
            }
        ) {
            Icon(
                imageVector = when (counterState) {
                    CounterState.INITIAL -> Icons.Default.PlayArrow
                    CounterState.PLAY -> Icons.Filled.Stop
                    CounterState.PAUSE -> Icons.Default.PlayArrow
                },
                contentDescription = null,
            )
        }
    }
}

@ThemePreviews
@Composable
fun CounterControllerPreview() {
    ComposeBreakTheme {
        Surface {
            Column {
                CounterController(
                    counterState = CounterState.INITIAL,
                    onRestClicked = {},
                    onStartClicked = {},
                )

                CounterController(
                    counterState = CounterState.PLAY,
                    onRestClicked = {},
                    onStartClicked = {},
                )
            }
        }
    }
}
