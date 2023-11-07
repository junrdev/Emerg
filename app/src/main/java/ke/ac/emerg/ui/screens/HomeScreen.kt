package ke.ac.emerg.ui.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import ke.ac.emerg.App
import ke.ac.emerg.ui.navigation.AppScreens
import ke.ac.emerg.ui.theme.dutch_white
import ke.ac.emerg.ui.theme.platinum
import ke.ac.emerg.util.TESTING_PHONE_NUMBER

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(navController: NavHostController, uid: String) {

    val context = LocalContext.current as ComponentActivity

    val callPermissionState =
        rememberPermissionState(permission = android.Manifest.permission.CALL_PHONE);

    Scaffold(bottomBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 15.dp, bottom = 10.dp)
                .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            IconButton(onClick = {
                Log.d("TAG", "HomeScreen: ${navController.currentDestination?.id}")
            }) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "Activities",
                    modifier = Modifier.size(25.dp)
                )
            }

            IconButton(onClick = {

                if (callPermissionState.status.isGranted) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:$TESTING_PHONE_NUMBER")
                    context.startActivity(intent)
                } else
                    callPermissionState.launchPermissionRequest()


            }) {
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = "Sos",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color.Green
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Column {
                    Text(text = "Good afternoon", style = MaterialTheme.typography.displaySmall)

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Explore emergency and health services",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(bottom = 5.dp)
                ) {

                    Text(text = "Hello world")

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = "This is a reminder or a quote on a card display")
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "services",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp, bottom = 10.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = dutch_white,
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .padding(15.dp)
            ) {
                Text(text = "Call for help", modifier = Modifier.align(Alignment.CenterStart))

                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "open",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .border(width = 1.5.dp, color = Color.Black)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = dutch_white,
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .padding(15.dp)
                    .clickable { navController.navigate(route = "${AppScreens.ACTIVITIES}") }
            ) {
                Text(text = "Consultation", modifier = Modifier.align(Alignment.CenterStart))

                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "open",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .border(width = 1.5.dp, color = Color.Black)
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = dutch_white,
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .padding(15.dp)
            ) {
                Text(text = "Health Check up", modifier = Modifier.align(Alignment.CenterStart))

                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "open",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .border(width = 1.5.dp, color = Color.Black)
                )
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomePrev() {
    App {
        HomeScreen(navController = rememberNavController(), uid = "")
    }
}