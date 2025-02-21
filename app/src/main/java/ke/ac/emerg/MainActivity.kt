package ke.ac.emerg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.Navigator
import ke.ac.emerg.ui.screens.LandingPageScreen
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite
import ke.ac.emerg.ui.theme.karla

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            App {
                Navigator(LandingPageScreen())
            }
        }
    }
}


val backgroundBrush = Brush.verticalGradient(
    colors = listOf(
        appWhite,
        appRed
    )
)

val defaultkarlaTextStyle = TextStyle(
    fontFamily = karla,
    fontSize = 16.sp,
    color = Color.White
)

val LocalBackgroundBrush = staticCompositionLocalOf { backgroundBrush }
val LocalTextStyle = staticCompositionLocalOf { defaultkarlaTextStyle }

@Composable
fun App(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalBackgroundBrush provides backgroundBrush,
        LocalTextStyle provides defaultkarlaTextStyle,
    ) {
        EmergTheme {
            content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = LocalBackgroundBrush.current))
}