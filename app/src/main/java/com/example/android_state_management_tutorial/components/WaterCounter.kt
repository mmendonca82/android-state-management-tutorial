package com.example.android_state_management_tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    StatefulCounter(modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column {
        if (count > 0) {
            Text(
                text = stringResource(R.string.water_counter_count_glasses, count),
                modifier = modifier.padding(16.dp)
            )
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(8.dp),
            enabled = count < 10
        ) {
            Text(stringResource(R.string.water_counter_add_one_button))
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    val count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count.value, { count.value++ }, modifier)
}
