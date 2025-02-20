package ke.ac.emerg.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme

@Composable
fun AddContactForm(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        TextButton(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.resource_import),
                    contentDescription = "resource_import",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(Modifier.width(24.dp))

                Column {
                    Text(
                        text = "Import Contact",
                        style = LocalTextStyle.current.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "From google contacts, or local",
                        style = LocalTextStyle.current.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }

            }
        }

        Spacer(Modifier.height(12.dp))


    }


}

@Preview
@Composable
private fun AddContactFormPrev() {
    EmergTheme {
        AddContactForm()
    }
}