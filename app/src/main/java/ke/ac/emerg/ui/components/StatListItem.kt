package ke.ac.emerg.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appWhite
import kotlin.random.Random

sealed class StatItem(
    var statType: String = "",
    var statValue: String = "${Random.nextInt(12, 45)}",
) {
    companion object {
        object BMI : StatItem(statType = "BMI")
        object BMR : StatItem(statType = "BMR")
        object BoneDensity : StatItem(statType = "Bone Density")
        object BloodPressure : StatItem(statType = "Blood Pressure")
        object Temperature : StatItem(statType = "Temperature")
        object Height : StatItem(statType = "Height")
        object Weight : StatItem(statType = "Weight")

        val basicStatus = listOf(
            BMI, BMR, BoneDensity, BloodPressure, Temperature, Height, Weight
        )
    }

}

data class Stat(val `val`: List<StatItem> = StatItem.basicStatus)

@Composable
fun StatListItem(
    modifier: Modifier = Modifier,
    description: String = LoremIpsum(6).values.joinToString(),
    stats: Stat = Stat(),
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = description,
                style = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(80.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
//                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items(stats.`val`) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(2.dp)
                            .background(color = appWhite, shape = RoundedCornerShape(16.dp))
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "${it.statType}:${it.statValue}",
                            style = LocalTextStyle.current.copy(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Center,
                                color = Color.LightGray
                            )
                        )

                        /*
                        Spacer(Modifier.width(12.dp))


Text(
                            text = "·",
                            style = LocalTextStyle.current.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                        )

                        Spacer(Modifier.width(6.dp))
                        */


                    }
                }
            }


            Text(
                text = LoremIpsum(8).values.joinToString(),
                style = LocalTextStyle.current.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.LightGray
                )
            )

        }

        IconButton(onClick = {}) {
            Icon(painter = painterResource(R.drawable.delete), contentDescription = "delete item")
        }

    }

}


@Preview
@Composable
private fun StatListItemPrev() {
    EmergTheme {
        StatListItem(description = LoremIpsum(4).values.joinToString())
    }
}