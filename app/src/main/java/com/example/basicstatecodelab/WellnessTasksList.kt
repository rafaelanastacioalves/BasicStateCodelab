package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun TaskList(
    modifier: Modifier,
    list: List<WellnessTask> ,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChange : (WellnessTask) -> Unit
){
    LazyColumn(modifier = Modifier){
        items(list, key = {task -> task.id}) {task ->
                WellnessTaskItem(taskName = task.label, onClose = { onCloseTask(task) }, onCheckedChange = {
                    onCheckedChange(task)
                }, checked = task.checked)
        }
    }
}