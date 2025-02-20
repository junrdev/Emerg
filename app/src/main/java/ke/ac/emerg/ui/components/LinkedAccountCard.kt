package ke.ac.emerg.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite


@Composable
fun LinkedAccountCard(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(appRed, appWhite),
                ), shape = RoundedCornerShape(24.dp)
            )
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,

            ) {


            Box(
                modifier = modifier
                    .size(70.dp)
                    .background(color = Color.LightGray, shape = CircleShape)
            )/*todo : content is user profile pic*/


            Spacer(Modifier.width(13.dp))

            Column {
                Text(
                    text = LoremIpsum(3).values.joinToString(),
                    style = LocalTextStyle.current.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = LoremIpsum(3).values.joinToString(), style = LocalTextStyle.current.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                )

                Text(
                    text = "Linked At : " + LoremIpsum(2).values.joinToString(),
                    style = LocalTextStyle.current.copy(
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp
                    )
                )
            }


            Spacer(Modifier.weight(1f))


            Box(
                modifier = modifier
                    .size(70.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = "logout",
                    modifier = Modifier
                        .size(40.dp)
                )
            }
        }


    }


}

@Preview
@Composable
private fun LinkedAccountCardPrev() {
    EmergTheme {
        LinkedAccountCard()
    }
}