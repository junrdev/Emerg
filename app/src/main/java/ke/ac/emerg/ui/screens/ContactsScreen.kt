package ke.ac.emerg.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import ke.ac.emerg.ui.theme.EmergTheme

class ContactsScreen:Screen {

    @Composable
    override fun Content() {

    }

}

@Preview
@Composable
private fun ContactsScreenPrev() {
    EmergTheme {
        ContactsScreen().Content()
    }
}