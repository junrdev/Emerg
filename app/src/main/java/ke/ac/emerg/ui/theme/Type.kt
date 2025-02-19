package ke.ac.emerg.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ke.ac.emerg.R

// Set of Material typography styles to start with
val karla = FontFamily(
    listOf(
        Font(R.font.karlabold),
        Font(R.font.karlabolditalic),
        Font(R.font.karlaextrabold),
        Font(R.font.karlaextrabolditalic),
        Font(R.font.karlaextralight),
        Font(R.font.karlaextralightitalic),
        Font(R.font.karlaitalic),
        Font(R.font.karlalight),
        Font(R.font.karlalightitalic),
        Font(R.font.karlamedium),
        Font(R.font.karlamediumitalic),
        Font(R.font.karlaregular),
        Font(R.font.karlasemibold),
        Font(R.font.karlasemibolditalic),
    )
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)