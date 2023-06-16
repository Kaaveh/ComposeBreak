package ir.kaaveh.countdown.model

data class CountdownState(
    val counterState: CounterState = CounterState.INITIAL,
    val workingState: WorkingState = WorkingState.WORK,
    val remainTime: Int = WORKING_DURATION,
)