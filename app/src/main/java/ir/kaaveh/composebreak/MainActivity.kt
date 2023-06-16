package ir.kaaveh.composebreak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ir.kaaveh.countdown.CountdownRoute
import ir.kaaveh.countdown.CountdownViewModel
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val countdownViewModel: CountdownViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            ComposeBreakTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountdownRoute(viewModel = countdownViewModel)
                }
            }
        }
    }
}