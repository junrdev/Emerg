package ke.ac.emerg.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme

class LinkToGoogleAccount : Screen {
    @Composable
    override fun Content() {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            val (appBar, supportText, logo) = createRefs()


            RowWithTitleSubTitleIcon(
                title = "Account & Backup",
                subTitle = "Backup your history and contacts",
                modifier = Modifier.constrainAs(appBar) {
                    top.linkTo(parent.top, 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )


            Column(
                modifier = Modifier.constrainAs(supportText) {
                    top.linkTo(appBar.bottom, 120.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
//                    bottom.linkTo(logo.top)
                },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Google Account", style = LocalTextStyle.current.copy(fontSize = 24.sp))
                Text(
                    text = "Link your Google account",
                    style = LocalTextStyle.current.copy(fontSize = 20.sp)
                )
            }


            Box(
                modifier = Modifier
                    .constrainAs(logo) {
                        top.linkTo(supportText.bottom, 120.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
//                        bottom.linkTo(parent.bottom)
                    }
                    .background(color = Color.LightGray, shape = CircleShape)
                    .padding(24.dp)
                ,
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(R.drawable.google_logo),
                    contentDescription = "google sign in",
                    modifier = Modifier
                        .size(40.dp)
                )

            }

        }


    }
}


@Preview
@Composable
private fun LinkToGoogleAccountPrev() {
    EmergTheme {
        LinkToGoogleAccount().Content()
    }
}

