package com.wmc.composecrash

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(modifier: Modifier=Modifier, taskName:String,checked:Boolean,onCheckedChange:(Boolean)-> Unit,onClose:()->Unit){
    Row (modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
        Text(text = taskName ,modifier = Modifier
            .weight(8f)
            .padding(horizontal = 16.dp))
        Checkbox(checked =checked, onCheckedChange = onCheckedChange)
        IconButton(onClick =  onClose ) {
            Icon(imageVector = Icons.Filled.Close, contentDescription ="close" )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview2() {
//    WellnessTaskItem(taskName = "item") {
//
//    }
}
@Composable
fun WellnessTaskItemList(
    modifier: Modifier= Modifier,
    list: List<WellnessTask>,
    onClose: (WellnessTask) -> Unit,
    onCheckedChange: (WellnessTask,onCheckedChange:Boolean) -> Unit
){
    LazyColumn {
        items(list,
            key = { task -> task.id }
            ){item->
            WellnessTaskItem(name = item.label, taskChecked = item.checked,onClose = { onClose(item) },
                onCheckedChange = { onChecked -> onCheckedChange(item, onChecked) }
            )
        }

    }

}

fun getWellnessTasks() = List(10) { i -> WellnessTask(i, "Task # $i") }