package ir.kaaveh.countdown

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.kaaveh.countdown.model.CountdownState
import ir.kaaveh.countdown.model.CounterState
import ir.kaaveh.countdown.model.REST_DURATION
import ir.kaaveh.countdown.model.SECOND
import ir.kaaveh.countdown.model.WorkingState
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountdownViewModel @Inject constructor(
    @ApplicationContext val applicationContext: Context
) : ViewModel() {

    private val _countdownState = mutableStateOf(CountdownState())
    val countdownState: State<CountdownState> = _countdownState

    private var timerJob: Job = Job()

    fun startCountdown() {

        _countdownState.value = _countdownState.value.copy(
            counterState = CounterState.PLAY,
        )

        timerJob = viewModelScope.launch {
            while (true) {
                delay(SECOND)

                if (_countdownState.value.remainTime > 0)
                    _countdownState.value = _countdownState.value.copy(
                        remainTime = _countdownState.value.remainTime - 1,
                    )
                else {
                    when (_countdownState.value.workingState) {
                        WorkingState.WORK -> {
                            _countdownState.value = _countdownState.value.copy(
                                workingState = WorkingState.REST,
                                remainTime = REST_DURATION,
                            )
                        }

                        WorkingState.REST -> {
                            resetCountdownState()
                            this.cancel()
                        }
                    }

                    playAlarmSound()

                }
            }
        }
    }

    private fun playAlarmSound() {
        val mediaPlayer =
            MediaPlayer.create(applicationContext, ir.kaaveh.designesystem.R.raw.alarm)
        mediaPlayer.start()
    }

    fun resetCountdown() {
        if (timerJob.isActive) {
            resetCountdownState()
            timerJob.cancel()
        }
    }

    private fun resetCountdownState() {
        _countdownState.value = CountdownState()
    }

}