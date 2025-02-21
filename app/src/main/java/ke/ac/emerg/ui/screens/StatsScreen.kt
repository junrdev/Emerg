package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.components.StatListItem
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite

class StatsScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        /*todo : insert graph, this data is saved locally*/
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            val (appBar, trackList, addStatsBtn) = createRefs()

            RowWithTitleSubTitleIcon(
                title = "Keep Track",
                subTitle = "Record your stats, keep track.",
                onNavigationClick = { navigator.pop() },
                modifier = Modifier.constrainAs(appBar) {
                    top.linkTo(parent.top, 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },

                )


            val verticalScroll = rememberScrollState()

            Column(
                modifier = Modifier
                    .constrainAs(trackList) {
                        top.linkTo(appBar.bottom, 48.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .verticalScroll(verticalScroll)
            ) {
                repeat(30) {
                    StatListItem()
                }
            }


            Button(
                onClick = {
                    navigator push RecordStatScreen()
                },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = appWhite,
                    contentColor = appRed
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 4.dp
                ),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                modifier = Modifier.constrainAs(addStatsBtn) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.more),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Add stats"
                    )
                }

            }

        }


    }
}

@Preview
@Composable
private fun StatsScreenPrev() {
    EmergTheme {
        StatsScreen().Content()
    }
}