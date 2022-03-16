package com.example.countdowntimerjc.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.countdowntimerjc.ui.components.PomodoroButton
import com.example.countdowntimerjc.utils.Utility.LONG_PAUSE_COUNTDOWN
import com.example.countdowntimerjc.utils.Utility.POMODORO_COUNTDOWN
import com.example.countdowntimerjc.utils.Utility.SHORT_PAUSE_COUNTDOWN
import com.example.countdowntimerjc.viewmodel.PomodoroViewModel


@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: PomodoroViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val time by viewModel.time.observeAsState("Set Timer")
    val isStarted by viewModel.isStarted.observeAsState(true)
    Surface {
        Column {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(
                    text = time,
                    style = MaterialTheme.typography.h2,
                )

            }
            Box(
                modifier = Modifier
                    .weight(2f)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    PomodoroButton(
                        enabled = isStarted,
                        text = "Tomato",
                        clickEvent = {
                            viewModel.startTimer(
                                POMODORO_COUNTDOWN
                            )
                        }
                    )


                    PomodoroButton(
                        enabled = isStarted,
                        text = "Short Brake", clickEvent = {
                            viewModel.startTimer(
                                SHORT_PAUSE_COUNTDOWN
                            )
                        })

                    PomodoroButton(
                        enabled = isStarted,
                        text = "Long Brake", clickEvent = {
                            viewModel.startTimer(
                                LONG_PAUSE_COUNTDOWN
                            )
                        })


                    PomodoroButton(text = "Cancel", clickEvent = {
                        viewModel.stopTimer()
                    })

                    PomodoroButton(text = "Stats", clickEvent = {
                        navHostController.navigate("statistics")
                    })
                }
            }
        }
    }
}

/*
@Preview
@Composable
fun PreviewHomeScreen() {
    Surface {
        HomeScreen()
    }
}*/
