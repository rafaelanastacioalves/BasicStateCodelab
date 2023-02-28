package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()

) {

    Column(modifier = modifier){
        WaterCounter(modifier)
        val list = remember{ wellnessViewModel.tasks }
        TaskList(modifier = modifier, list = list, onCloseTask = {task -> wellnessViewModel.remove(task)}, {task -> wellnessViewModel.changeTaskChecked(task, task.checked.not())})
    }
}