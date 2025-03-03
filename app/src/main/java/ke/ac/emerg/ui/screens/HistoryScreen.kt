package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.ui.components.AppModalDialog
import ke.ac.emerg.ui.components.HistoryItem
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme

class HistoryScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        var showDialog by remember { mutableStateOf(false) }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            val (appBar, historyList, clearHistoryBtn) = createRefs()

            RowWithTitleSubTitleIcon(
                title = "History",
                subTitle = "All your actions on emerge",
                modifier = Modifier.constrainAs(appBar) {
                    top.linkTo(parent.top, 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onNavigationClick = { navigator.pop() }
            )
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .constrainAs(historyList) {
                        top.linkTo(appBar.bottom, 48.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .verticalScroll(scrollState)
            ) {
                repeat(30) {
                    HistoryItem()
                }
            }

            TextButton(onClick = {
                showDialog = !showDialog
            }, modifier = Modifier.constrainAs(clearHistoryBtn) {
//                top.linkTo(historyList.bottom, 24.dp)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }) {
                Text(text = "Clear history", style = LocalTextStyle.current.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ))
            }

            if (showDialog)
                Dialog(onDismissRequest = {
                    showDialog = !showDialog
                }) {
                    AppModalDialog(
                        buttonClickAction = { showDialog = !showDialog }
                    )
                }

        }


    }
}

@Preview
@Composable
private fun HistoryScreenPrev() {
    EmergTheme {
        HistoryScreen().Content()
    }
}