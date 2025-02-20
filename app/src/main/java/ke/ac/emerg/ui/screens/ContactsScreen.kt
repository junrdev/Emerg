package ke.ac.emerg.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.ContactCard
import ke.ac.emerg.ui.theme.EmergTheme

class ContactsScreen:Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        ConstraintLayout {

            val (topBar, contactList, addContactBtn) = createRefs()

            CenterAlignedTopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Your contacts",
                            style = LocalTextStyle.current.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        )
                        Text(text = "Emergency contacts", style = LocalTextStyle.current)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.pop() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = null
                        )
                    }
                },
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Column(
                modifier = Modifier.constrainAs(contactList) {
                    top.linkTo(topBar.bottom, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(addContactBtn.top)
                }
            ) {/*todo : resolve if to use Lazy column/column*/
                repeat(10) {
                    ContactCard()
                }
            }


            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(addContactBtn) {
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.more),
                        contentDescription = "add contact",
                        modifier = Modifier.size(30.dp)
                    )

                    Text(text = "Add contact", style = LocalTextStyle.current)

                }


            }
        }

    }

}

@Preview
@Composable
private fun ContactsScreenPrev() {
    EmergTheme {
        ContactsScreen().Content()
    }
}