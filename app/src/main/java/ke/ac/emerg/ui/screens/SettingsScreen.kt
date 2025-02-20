package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme

class SettingsScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            RowWithTitleSubTitleIcon(
                title = "Setting & Preferences",
                subTitle = "Customize your experience.",
                onNavigationClick = {
                    navigator.pop()
                }
            )

            Spacer(Modifier.height(50.dp))

            RowWithTitleSubTitleIcon(
                modifier = Modifier.clickable { },
                icon = R.drawable.add_user,
                title = "The sos button",
                subTitle = "Customize the behavior of the your button.",
            )
            Spacer(Modifier.height(24.dp))


            RowWithTitleSubTitleIcon(
                modifier = Modifier.clickable { },
                icon = R.drawable.add_user,
                title = "Emergency contacts",
                subTitle = "Manage your emergency contacts.",
            )
            Spacer(Modifier.height(24.dp))


            RowWithTitleSubTitleIcon(
                modifier = Modifier.clickable { },
                icon = R.drawable.user,
                title = "Account & Profile",
                subTitle = "Link & manage account.",
            )
            Spacer(Modifier.height(24.dp))


            RowWithTitleSubTitleIcon(
                modifier = Modifier.clickable { },
                icon = R.drawable.history,
                title = "History",
                subTitle = "View your time on Emerge.",
            )
            Spacer(Modifier.height(24.dp))

            RowWithTitleSubTitleIcon(
                modifier = Modifier.clickable { },
                icon = R.drawable.stats,
                title = "Your Medical stats",
                subTitle = "Keep track of your medical vitals.",
            )
            Spacer(Modifier.height(24.dp))


            Spacer(Modifier.weight(1f))


            Text(
                text = "Version 1.001",
                style = LocalTextStyle.current.copy(
                    color = Color.LightGray
                )
            )


        }


    }

}

@Preview
@Composable
private fun SettingsScreenPrev() {
    EmergTheme {
        SettingsScreen().Content()
    }
}


