package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.AddContactForm
import ke.ac.emerg.ui.components.ContactCard
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed

class ContactsScreen:Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        var isAddContactSheetShown by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        ConstraintLayout(
            modifier = Modifier
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {
            val (topBar, contactList, addContactBtn) = createRefs()

            RowWithTitleSubTitleIcon(
                title = "Your contacts",
                subTitle = "Emergency contacts",
                icon = R.drawable.back,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = null
                        )
                    }
                },
                onNavigationClick = {
                    navigator.pop()
                },
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            val verticallyScrollable = rememberScrollState()

            Column(
                modifier = Modifier
                    .constrainAs(contactList) {
                        top.linkTo(topBar.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .verticalScroll(verticallyScrollable)
            ) {/*todo : resolve if to use Lazy column/column*/
                repeat(10) {
                    ContactCard()
                }
                Spacer(Modifier.height(30.dp))
            }


            Button(
                onClick = { isAddContactSheetShown = !isAddContactSheetShown },
                modifier = Modifier.constrainAs(addContactBtn) {
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = appRed
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier.padding(8.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.more),
                        contentDescription = "add contact",
                        modifier = Modifier.size(30.dp)
                    )

                    Text(text = "Add contact", style = LocalTextStyle.current.copy(color = appRed))

                }


            }


            if (isAddContactSheetShown) {
                val sheetState = rememberModalBottomSheetState()
                ModalBottomSheet(
                    onDismissRequest = {},
                    sheetState = sheetState,
                    containerColor = appRed,
                    contentColor = Color.White
                ) {
                    AddContactForm()
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