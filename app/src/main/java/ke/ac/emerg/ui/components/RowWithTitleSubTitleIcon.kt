package ke.ac.emerg.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme


@Composable
fun RowWithTitleSubTitleIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = R.drawable.back,
    title: String,
    subTitle: String,
    actions : @Composable () -> Unit = {},
    onNavigationClick: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        IconButton(onClick = onNavigationClick) {
            Icon(
                painter = painterResource(icon),
                contentDescription = title,
                modifier = Modifier.size(50.dp)
            )
        }

        Column {
            Text(
                text = title,
                style = LocalTextStyle.current.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )

            Text(
                text = subTitle,
                style = LocalTextStyle.current.copy(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }

        actions()

    }
}


@Preview
@Composable
private fun AppBarWithTitleSubTitleNavigationIconPrev() {
    EmergTheme {
        RowWithTitleSubTitleIcon(
            title = LoremIpsum(3).values.joinToString(),
            subTitle = LoremIpsum(6).values.joinToString()
        )
    }
}