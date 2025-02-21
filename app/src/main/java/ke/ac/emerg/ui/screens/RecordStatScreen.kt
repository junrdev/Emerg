package ke.ac.emerg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ke.ac.emerg.LocalBackgroundBrush
import ke.ac.emerg.ui.components.InputFieldWithLabelAndInfo
import ke.ac.emerg.ui.components.RowWithTitleSubTitleIcon
import ke.ac.emerg.ui.theme.EmergTheme

class RecordStatScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
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
        ) {

            RowWithTitleSubTitleIcon(
                title = "Keep Track",
                subTitle = "Record your stats, keep track of your vitals.",
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                    }
                }
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                    placeHolder = "calculated field",
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

}


@Preview
@Composable
private fun RecordStatScreenPrev() {
    EmergTheme {
        RecordStatScreen().Content()
    }
}

