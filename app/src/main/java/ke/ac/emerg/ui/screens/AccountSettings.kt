package ke.ac.emerg.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.ac.emerg.App
import ke.ac.emerg.R

@Composable
@Preview(showSystemUi = true)
fun AccPrev() {
    App {
        AccountSettings(navController = rememberNavController())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettings(navController: NavController) {


    Scaffold(

        topBar = {
            Row {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "previous",
                    modifier = Modifier
                        .defaultMinSize(48.dp)
                        .clickable { navController.popBackStack() }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Image(
                painter = painterResource(id = R.drawable.pager1),
                contentScale = ContentScale.Crop,
                contentDescription = "user profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = CircleShape)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Text(text = "abc@def.co.ke")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "P101/1400G/20")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                shape = RoundedCornerShape(corner = CornerSize(50))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                        contentDescription = "reminder"
                    )

                    Switch(checked = false, onCheckedChange = {})
                }


            }


        }
    }
}