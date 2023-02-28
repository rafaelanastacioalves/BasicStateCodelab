package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks : List<WellnessTask> = _tasks

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

    fun remove(task: WellnessTask) = _tasks.remove(task)

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}
