package ke.ac.emerg.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appBlue

class LandingPageScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
        ) {

            val (settings, sosBtn, primaryContact, tAndCGroup) = createRefs()


            Image(
                painter = painterResource(R.drawable.setting),
                contentDescription = "settings",
                modifier = Modifier
                    .size(50.dp)
                    .constrainAs(settings) {
                        top.linkTo(parent.top, margin = 24.dp)
                        end.linkTo(parent.end, margin = 24.dp)
                    }
                    .clickable {
                        navigator push(SettingsScreen())
                    }
            )


            Box(
                modifier = Modifier
                    .background(
                        brush = LocalBackgroundBrush.current,
                        shape = CircleShape
                    )
                    .size(250.dp)
                    .constrainAs(sosBtn) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(settings.top)
                        bottom.linkTo(primaryContact.top)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sos",
                    style = LocalTextStyle.current.copy(
                        fontSize = 64.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(primaryContact) {
                        start.linkTo(parent.start)
                        bottom.linkTo(tAndCGroup.top)
                        end.linkTo(parent.end)
                    }
                    .background(
                        brush = LocalBackgroundBrush.current,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "edit primary contact",
                    modifier = Modifier.size(35.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = LoremIpsum(2).values.joinToString(),
                            style = LocalTextStyle.current
                        )
                        Text(
                            text = LoremIpsum(2).values.joinToString(),
                            style = LocalTextStyle.current
                        )
                    }
                    Text(
                        text = LoremIpsum(1).values.joinToString() + "@dev.io",
                        style = LocalTextStyle.current
                    )
                }
            }


            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 14.sp
                        )
                    ) {
                        append("All data is governed by our")
                    }

                    withStyle(
                        SpanStyle(
                            color = appBlue,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(" Terms & Conditions")
                    }

                },
                style = LocalTextStyle.current,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(tAndCGroup) {
                        bottom.linkTo(parent.bottom, 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .clickable { }
            )

        }


    }
}

@Preview
@Composable
private fun LandingScreenPrev() {
    EmergTheme {
        LandingPageScreen().Content()
    }
}