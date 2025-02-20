package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.ui.components.HistoryItem
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme

class HistoryScreen : Screen {
    @Composable
    override fun Content() {

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
                }
            )

            Column(
                modifier = Modifier
                    .constrainAs(historyList) {
                        top.linkTo(appBar.bottom, 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                repeat(5) {
                    HistoryItem()
                }
            }

            TextButton(onClick = {}, modifier = Modifier.constrainAs(clearHistoryBtn){
                top.linkTo(historyList.bottom, 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                Text(text = "Clear history", style = LocalTextStyle.current.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ))
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