package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.ui.components.InputFieldWithLabelAndInfo

class RecordStatScreen : Screen {

    @Composable
    override fun Content() {

        val (weight, setWeight) = remember { mutableStateOf("") }
        val (height, setHeight) = remember { mutableStateOf("") }
        val (bmi, setBmi) = remember { mutableStateOf("") }

        LaunchedEffect(weight, height) {
            setBmi("${weight.toDouble() * height.toDouble()}")
        }


        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalBackgroundBrush.current)
                .padding(12.dp)
        ) {

            InputFieldWithLabelAndInfo(
                value = weight,
                label = "Weight",
                placeHolder = "e.g 34",
                onValueChange = setWeight,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Decimal
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                })
            )

            InputFieldWithLabelAndInfo(
                value = height,
                label = "Height",
                placeHolder = "e.g 134",
                onValueChange = setHeight,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Decimal
                ),
                keyboardActions = KeyboardActions(onNext = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                })
            )

            InputFieldWithLabelAndInfo(
                value = bmi,
                label = "BMI",
                enabled = false,
                placeHolder = "e.g 134",
                onValueChange = { /*setBmi*/ },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Decimal
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                })
            )


        }


    }

}
