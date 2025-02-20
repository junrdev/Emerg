package ke.ac.emerg.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import java.time.LocalDateTime

@Composable
fun HistoryItem(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {

            Text(text = "#334", style = LocalTextStyle.current)
            Text(
                text = "Action : ${LoremIpsum(3).values.joinToString()}",
                style = LocalTextStyle.current
            )
            Text(
                text = "At : ${LocalDateTime.now()}",
                style = LocalTextStyle.current.copy(fontSize = 12.sp)
            )
        }


        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.delete),
                contentDescription = "more"
            )
        }
    }
}


@Preview
@Composable
private fun HistoryItemPrev() {
    EmergTheme {
        HistoryItem()
    }
}