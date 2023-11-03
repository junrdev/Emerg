package ke.ac.emerg.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ke.ac.emerg.App
import ke.ac.emerg.ui.theme.navy_blue


@Preview(showSystemUi = true)
@Composable
fun DefPreview() {
    val fv = remember {
        mutableStateOf("")
    }
    App {
        FilledTextField(fieldValue = fv, placeholder = "P108/1445F/24")
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
        placeholder = { Text(text = placeholder, fontSize = 12.sp, color = Color.White, textAlign = TextAlign.Center)},
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(corner = CornerSize(15)))
            ,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Center)
    )

}