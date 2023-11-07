package ke.ac.emerg.util

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

val autoScrollInterval = 8000L
val LOGIN = "login"
val SIGNUP = "signup"
val regexPattern = """\b[\w.-]+@s\.karu\.ac\.ke\b""".toRegex()
val TESTING_PHONE_NUMBER = "0740848165"
val BASE_URL = "https://2381-41-89-230-156.ngrok-free.app"
val API = "$BASE_URL/api/v1"
val CONSULTATIONS_URL = "$API/consultations"


enum class CONSULTATION_STATUS {
    Cleared, Pending, Assigned_doctor, Postponed;

}

@Composable
fun getShimmerBrush () : Brush{
    val shimmerColors = listOf(
        Color.LightGray.copy(0.6f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.6f),
    )

    val transition = rememberInfiniteTransition()

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    return brush
}