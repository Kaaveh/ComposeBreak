package ir.kaaveh.countdown.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ir.kaaveh.designesystem.ThemePreviews
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@Composable
fun Counter(minutes: String, seconds: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CounterText(text = minutes)

        Text(text = " : ")

        CounterText(text = seconds)
    }
}

@ThemePreviews
@Composable
private fun CounterPreview() {
    ComposeBreakTheme {
        Surface {
            Counter(minutes = "19", seconds = "39")
        }
    }
}