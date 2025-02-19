package ke.ac.emerg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ke.ac.emerg.di.ConsultationViewModel
import ke.ac.emerg.ui.navigation.Navigator
import ke.ac.emerg.ui.theme.EmergTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val consultationViewModel   = viewModel<ConsultationViewModel>()
            App {
                Navigator(consultationViewModel)
            }
        }
    }
}

@Composable
fun App(
    content : @Composable () -> Unit
) {
    EmergTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}