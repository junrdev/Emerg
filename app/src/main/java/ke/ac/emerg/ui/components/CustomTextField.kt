package ke.ac.emerg.ui.components

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.ac.emerg.App
import ke.ac.emerg.ui.theme.navy_blue
import ke.ac.emerg.ui.theme.ptsans


@Preview(showSystemUi = true)
@Composable
fun DefPreview() {
    val fv = remember {
        mutableStateOf("")
    }
    App {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            RegistrationNumberTextField()
        }
//        FilledTextField(fieldValue = fv, placeholder = "P108/1445F/24")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilledTextField(
    fieldValue: MutableState<String>,
    modifier: Modifier = Modifier,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholder: String = "abc.def@s.karu.ac.ke"
) {
    TextField(
        value = fieldValue.value,
        onValueChange = { fieldValue.value = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            placeholderColor = Color.White,
            containerColor = navy_blue,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(corner = CornerSize(15))),
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Center)
    )

}

@Composable
fun RegistrationNumberTextField(
    p1 : MutableState<String>,
    p2 : MutableState<String>,
    p3 : MutableState<String>,
    modifier: Modifier = Modifier
) {

    val p2FocusRequester = remember { FocusRequester() }
    val p3FocusRequester = remember { FocusRequester() }

    val KbController = LocalSoftwareKeyboardController.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {


        BasicTextField(
            value = p1.value,
            onValueChange = {
                p1.value = it

                if (p1.value.isNotBlank() && p1.value.length == 4) {
                    p2FocusRequester.requestFocus()
                }
            },
            maxLines = 1,
            modifier = Modifier
                .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp)
                .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                .background(color = Color.Gray),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {}),
            textStyle = TextStyle(
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontFamily = ptsans
            )
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                it()
            }
        }


        Text(text = "/", style = MaterialTheme.typography.bodyLarge, fontFamily = ptsans)


        BasicTextField(
            value = p2.value,
            onValueChange = {
                p2.value = it

                if (p2.value.isNotBlank() && p2.value.length == 5) {
                    p3FocusRequester.requestFocus()
                }
            },
            maxLines = 1,
            modifier = Modifier
                .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp)
                .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                .background(color = Color.Gray)
                .focusRequester(p2FocusRequester),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {

                if (p2.value.isNotBlank() && p2.value.length == 5) {
                    p3FocusRequester.requestFocus()
                }

            }),
            textStyle = TextStyle(
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontFamily = ptsans
            )
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                it()
            }
        }


        Text(text = "/", style = MaterialTheme.typography.bodyLarge, fontFamily = ptsans)


        BasicTextField(
            value = p3.value,
            onValueChange = {
                p3.value = it

                if (p3.value.isNotBlank() && p3.value.length == 2) {
                    KbController?.hide()
                }
            },
            maxLines = 1,
            modifier = Modifier
                .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp)
                .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                .background(color = Color.Gray)
                .focusRequester(p3FocusRequester),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                if (p3.value.isNotBlank() && p3.value.length == 2) {
                    KbController?.hide()
                }
            }),
            textStyle = TextStyle(
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontFamily = ptsans
            )
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(minWidth = 30.dp, minHeight = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                it()
            }
        }


    }
}