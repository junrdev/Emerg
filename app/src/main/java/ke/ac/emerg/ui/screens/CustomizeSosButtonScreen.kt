package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon

class CustomizeSosButtonScreen : Screen {
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
                title = "The sos button",
                subTitle = "Customize the behavior of the your button.",
                onNavigationClick = {
                    navigator.pop()
                }
            )

        }

    }

}