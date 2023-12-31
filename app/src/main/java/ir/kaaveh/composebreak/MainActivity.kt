package ir.kaaveh.composebreak

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import ir.kaaveh.countdown.CountdownRoute
import ir.kaaveh.countdown.CountdownService
import ir.kaaveh.countdown.DATA
import ir.kaaveh.countdown.model.Action
import ir.kaaveh.designesystem.theme.ComposeBreakTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBreakTheme {

                val context = LocalContext.current
                var hasNotificationPermission by rememberSaveable {
                    mutableStateOf(
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.POST_NOTIFICATIONS,
                            ) == PackageManager.PERMISSION_GRANTED
                        else
                            true
                    )
                }

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = { isGrand ->
                        hasNotificationPermission = isGrand
                    }
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountdownRoute(
                        onCounterUpdate = { time ->
                            if (!hasNotificationPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                            } else {
                                showNotification(notificationContent = time)
                            }
                        }
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        stopService()
        super.onDestroy()
    }

    private fun showNotification(notificationContent: String) {
        Intent(applicationContext, CountdownService::class.java).apply {
            action = Action.SHOW_MESSAGE.toString()
            putExtra(DATA, notificationContent)
            startService(this)
        }
    }

    private fun stopService() {
        Intent(applicationContext, CountdownService::class.java).apply {
            action = Action.STOP.toString()
            startService(this)
        }
    }

}