package ke.ac.emerg.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite


@Composable
fun AppModalDialog(
    modifier: Modifier = Modifier,
    @DrawableRes supportIcon: Int = R.drawable.information,
    supportText: String = LoremIpsum(2).values.joinToString(),
    mainText: AnnotatedString = buildAnnotatedString { withStyle(SpanStyle()) { append(LoremIpsum(12).values.joinToString()) } },
    buttonText: String = LoremIpsum(3).values.joinToString(),
    buttonClickAction: () -> Unit = {},
) {


    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = LocalBackgroundBrush.current,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {

        val (support, main, button) = createRefs()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(support) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(supportIcon),
                contentDescription = supportText,
                modifier = Modifier.size(35.dp)
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = supportText,
                style = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier
            )


            Spacer(Modifier.weight(1f))
        }

        Text(
            text = mainText,
            style = LocalTextStyle.current.copy(fontSize = 24.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .constrainAs(main) {
                    top.linkTo(support.bottom, 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


        Button(
            onClick = buttonClickAction,
            colors = ButtonDefaults.buttonColors(
                containerColor = appWhite,
                contentColor = appRed
            ),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(main.bottom, 48.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = buttonText,
                style = LocalTextStyle.current.copy(fontSize = 20.sp)
            )
        }

    }


}

@Preview
@Composable
private fun AppModalDialogPrev() {
    EmergTheme {
        AppModalDialog()
    }
}