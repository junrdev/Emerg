package ke.ac.emerg.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ke.ac.emerg.ui.components.FilledTextField
import ke.ac.emerg.ui.components.RegistrationNumberTextField
import ke.ac.emerg.ui.navigation.AppScreens
import ke.ac.emerg.util.CONSTANTS.LOGIN


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Register(navController: NavController) {

    val registrationNumber = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current
    val Kbcontroller = LocalSoftwareKeyboardController.current


    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sign Up",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp, bottom = 5.dp),
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(25.dp))

            //email
//            Text(
//                text = "institution email",
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(start = 15.dp, bottom = 5.dp),
//                style = MaterialTheme.typography.labelMedium
//            )
            FilledTextField(
                fieldValue = email,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                keyboardActions = KeyboardActions(onNext = {

                }),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                placeholder = "email e.g. abc.def@s.karu.ac.ke"
            )

            Spacer(modifier = Modifier.height(15.dp))

            //regno
//            Text(
//                text = "registration number",
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(start = 15.dp, bottom = 5.dp),
//                style = MaterialTheme.typography.labelMedium
//            )
            FilledTextField(
                fieldValue = registrationNumber,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                placeholder = "Reg No. e.g. P108/1445F/24"
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(15.dp)))
                    .padding(10.dp)
            ) {
                Text(text = "Sign Up")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Already a user?")
                TextButton(onClick = {
                    navController.navigate(route = "${AppScreens.SIGN_UP_LOGIN.name}/$LOGIN")
                }) {
                    Text(text = "Sign In")
                }
            }


        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController) {

    val registrationNumber = remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current
    val Kbcontroller = LocalSoftwareKeyboardController.current

    val p1 = remember { mutableStateOf("") }
    val p2 = remember { mutableStateOf("") }
    val p3 = remember { mutableStateOf("") }


    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sign In",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp, bottom = 5.dp),
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(25.dp))


            Spacer(modifier = Modifier.height(15.dp))

            //regno
            RegistrationNumberTextField(p1 , p2 , p3, modifier = Modifier.padding(10.dp))

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {

                    if (p1.value.isNotBlank() && p2.value.isNotBlank() && p3.value.isNotBlank())
                        navController.navigate(
                            route = "${AppScreens.HOME.name}/${p1.value}_${p2.value}_${p3.value}"
                        )

                }, modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(15.dp)))
                    .padding(10.dp)
            ) {
                Text(text = "Sign In")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Not a user?")
                TextButton(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Sign Up")
                }
            }


        }
    }
}