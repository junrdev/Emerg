package ke.ac.emerg.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ke.ac.emerg.LocalTextStyle
import ke.ac.emerg.R
import ke.ac.emerg.ui.theme.EmergTheme
import ke.ac.emerg.ui.theme.appRed
import ke.ac.emerg.ui.theme.appWhite

@Composable
fun AddContactForm(modifier: Modifier = Modifier) {

    var isPrimaryContact by remember { mutableStateOf(true) }
    val (fullName, setFullName) = remember { mutableStateOf("") }
    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
    val (email, setEmail) = remember { mutableStateOf("") }
    val (relationShip, setRelationShip) = remember { mutableStateOf("") }
    var showInfoDialog by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        TextButton(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.resource_import),
                    contentDescription = "resource_import",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(Modifier.width(24.dp))

                Column {
                    Text(
                        text = "Import Contact",
                        style = LocalTextStyle.current.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "From google contacts, or local",
                        style = LocalTextStyle.current.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }

            }
        }

        Spacer(Modifier.height(12.dp))


        InputFieldWithLabel(
            label = "Full names",
            value = fullName,
            onValueChange = setFullName,
            placeHolder = "john doe",
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
        )


        InputFieldWithLabel(
            label = "Phone number",
            value = phoneNumber,
            onValueChange = setPhoneNumber,
            placeHolder = "254 xxx ...",
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            ),
        )



        InputFieldWithLabel(
            label = "Email",
            value = email,
            onValueChange = setEmail,
            placeHolder = "jd@dev.io",
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)

            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
        )


        Box {
            InputFieldWithLabel(
                label = "Relationship",
                value = relationShip,
                onValueChange = setRelationShip,
                placeHolder = "pal",
                keyboardActions = KeyboardActions(onNext = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.align(Alignment.Center)
            )


            IconButton(onClick = {
                showInfoDialog = !showInfoDialog
            }, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "Define how you are related to the above contact."
                )
            }

            if (showInfoDialog){
                Dialog(onDismissRequest = {
                    showInfoDialog = !showInfoDialog
                }) {
                    AppModalDialog(
                        supportText = "Info",
                        mainText = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight(300),
                                    fontStyle = FontStyle.Italic
                                )
                            ) {
                                append("Define \n")
                            }

                            withStyle(SpanStyle()) {
                                append("How are you related to the above contact.")
                            }

                        },
                        buttonText = "Hide me",
                        buttonClickAction = {
                            showInfoDialog = !showInfoDialog
                        }
                    )

                }
            }

        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .clickable { isPrimaryContact = !isPrimaryContact }
        ) {

            Text(
                text = "Make primary contact",
                style = LocalTextStyle.current,
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = isPrimaryContact,
                onCheckedChange = { isPrimaryContact = !isPrimaryContact },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = appRed,
                    uncheckedThumbColor = appRed,
                    uncheckedTrackColor = appWhite,
                    checkedThumbColor = appWhite,
                    uncheckedBorderColor = Color.Transparent,
                    checkedBorderColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                )
            )
        }


        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = appWhite,
            contentColor = appRed
        ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = ButtonDefaults.TextButtonContentPadding
        ) {
            Text(text = "Save Contact", style = LocalTextStyle.current)
        }

    }


}

@Preview
@Composable
private fun AddContactFormPrev() {
    EmergTheme {
        AddContactForm()
    }
}