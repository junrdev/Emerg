package ke.ac.emerg.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme


@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    onEdit: () -> Unit = {},/*prefill bottom sheet*/
    onSelect: () -> Unit = {},/*todo: show context menus*/
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = LocalBackgroundBrush.current,
                shape = RoundedCornerShape(24.dp)
            ).clickable { onSelect() },
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            IconButton(onClick = onEdit) {
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "edit contact",
                    modifier = Modifier.size(35.dp)
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)){

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(LoremIpsum(3).values.joinToString(), style = LocalTextStyle.current)
                    Spacer(Modifier.width(6.dp))
                    Text(LoremIpsum(3).values.joinToString(), style = LocalTextStyle.current)
                }

                Text(
                    LoremIpsum(1).values.joinToString() + "@dev.io",
                    style = LocalTextStyle.current
                )


            }


        }

    }


}


@Preview
@Composable
private fun ContactCardPrev() {
    EmergTheme {
        ContactCard()
    }
}