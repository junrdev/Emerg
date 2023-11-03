package ke.ac.emerg

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ke.ac.emerg.ui.navigation.Navigator
import ke.ac.emerg.ui.theme.EmergTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //splash screen configuration
        installSplashScreen().setKeepOnScreenCondition{
            !true
        }

        setContent {

            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(scrim = Color.TRANSPARENT, darkScrim = Color.TRANSPARENT)
            )

            App {
                Navigator()
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