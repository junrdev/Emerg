package ke.ac.emerg.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.LinkedAccountCard
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite

class LinkedAccountScreens : Screen {
    @Composable
    override fun Content() {
        
        
        val navigator = LocalNavigator.currentOrThrow


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            val (appBar, accountList, addAccount) = createRefs()


            RowWithTitleSubTitleIcon(
                title = "Account & Backup",
                subTitle = "Backup your history and contacts",
                modifier = Modifier.constrainAs(appBar){
                    top.linkTo(parent.top, 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onNavigationClick = {navigator.pop()}
            )


            Column(
                modifier = Modifier.constrainAs(accountList){
                    top.linkTo(appBar.bottom, 60.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ){
                repeat(3){
                    LinkedAccountCard()
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(addAccount){
                        top.linkTo(accountList.bottom, 60.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(appRed, appWhite),
                        ), shape = RoundedCornerShape(24.dp)
                    )
                    .padding(12.dp)
            ){

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(12.dp).padding(horizontal = 8.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.add_user),
                        contentDescription = "add account",
                        modifier = Modifier
                            .size(40.dp)
                    )


                    Text(
                        text = "Add Account",
                        style = LocalTextStyle.current.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }


            }


        }
    }
}

@Preview
@Composable
private fun LinkedAccountScreensPrev() {
    EmergTheme {
        LinkedAccountScreens().Content()
    }
}