qpackage com.example.android_state_management_tutorial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_state_management_tutorial.WaterCounter
import com.example.android_state_management_tutorial.components.WellnessTasksList
import com.example.android_state_management_tutorial.presentation.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        WaterCounter(modifier)

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            modifier = modifier,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            }
        )
    }
}
