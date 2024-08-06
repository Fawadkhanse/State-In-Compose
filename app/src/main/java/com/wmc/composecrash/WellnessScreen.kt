package com.wmc.composecrash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()
                   ) {
    Column(Modifier.padding(8.dp)) {
        StatefulCounter(modifier, increment = {
            wellnessViewModel.add()
        }, clear = {
            wellnessViewModel.clearList()
        })
       // val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTaskItemList(list =wellnessViewModel.tasks, onClose = {task->
            wellnessViewModel.remove(task)
        }, onCheckedChange = {task,onChange->
            wellnessViewModel.changeTaskChecked(task,onChange)
        })
    }
}
@Composable
fun StatefulCounter(modifier: Modifier=Modifier,increment:()->Unit,clear:()->Unit){

        var count by rememberSaveable { mutableStateOf(0) }
               StatelessCounter(count = count, increment = increment, clear = clear)

//          var count2 by rememberSaveable { mutableStateOf(0) }
//        StatelessCounter(count = count2, increment = { count2++}, clear = {count2=0})



}
@Preview(showBackground = true)
@Composable
fun StatefulCounterPreview(){
    StatefulCounter( increment = {}, clear = {} )
}