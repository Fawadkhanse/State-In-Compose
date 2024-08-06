package com.wmc.composecrash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmc.composecrash.ui.theme.ComposeCrashTheme
import java.sql.Blob

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   //     enableEdgeToEdge()
        setContent {
            ComposeCrashTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   WellnessScreen()
                }
            }
        }
    }
}


@Composable
fun StatelessCounter(count:Int,increment:()->Unit,clear:()->Unit,modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = modifier
            .padding(8.dp)) {
       // var count by rememberSaveable { mutableStateOf(0) }

        if (count >0){
            Text(
                text = "You've had ${count} glasses.",
                modifier = modifier.padding(8.dp)
            )
        }
        Row(modifier= Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = increment,
                enabled = count < 10
            ) {
                Text(text = "Add")

            }

            Button(onClick = clear,modifier = Modifier.padding(8.dp)) {
                Text(text = "Clear Water")

            }

        }

    }

}
@Composable
fun WellnessTaskItem(name:String,modifier: Modifier=Modifier,onClose:()->Unit,taskChecked:Boolean,onCheckedChange: (Boolean) -> Unit){
    var checkedState by remember { mutableStateOf(false) }
    WellnessTaskItem(onClose = onClose, onCheckedChange = onCheckedChange, checked = taskChecked,
        taskName =  name)
}
@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    ComposeCrashTheme {
        WellnessScreen()
    }
}
@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    WellnessTaskItem(onClose = {

    }, onCheckedChange = {}, checked = false,
        taskName =  "Have you taken your 15 minute walk today?")
}

