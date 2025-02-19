package ke.ac.emerg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            App {
//                Navigator(consultationViewModel)
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    EmergTheme {
        content()
    }
}

val backgroundBrush = Brush.verticalGradient(
    colors = listOf(
        appWhite,
        appRed
    )
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = backgroundBrush))
}