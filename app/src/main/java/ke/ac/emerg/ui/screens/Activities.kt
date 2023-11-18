package ke.ac.emerg.ui.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.ac.emerg.App
import ke.ac.emerg.di.ConsultationViewModel
import ke.ac.emerg.ui.components.LinedTextField
import ke.ac.emerg.ui.navigation.AppScreens
import ke.ac.emerg.ui.theme.trans_sheet
import ke.ac.emerg.util.CONSTANTS.getShimmerBrush

@Preview(showSystemUi = true)
@Composable
fun Prev2() {
    App {
//        Activities()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Activities(navController: NavController, consultationViewModel: ConsultationViewModel) {

    val TAG = "Activities"

    val brush = getShimmerBrush()

    val consultation = consultationViewModel.consultationList

    if (consultation!!.isNotEmpty())
        consultation.forEach {
            Log.d(TAG, "Activities: $it")
        }

    val showCreateSheet = remember {
        mutableStateOf(false)
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            Icon(
                imageVector = if (showCreateSheet.value) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.AddCircle,
                contentDescription = "add consultation",
                modifier = Modifier
                    .padding(bottom = 30.dp, end = 30.dp)
                    .size(50.dp)
                    .clickable { showCreateSheet.value = !showCreateSheet.value }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
                .padding(it)
                .padding(10.dp)
        ) {

            Text(text = "consultations", modifier = Modifier.padding(start = 10.dp, bottom = 5.dp))

            LazyColumn(modifier = Modifier.weight(0.4f)) {
                items(count = 5) {
                    ConsultationItem(it, brush, navController = rememberNavController())
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 5.dp, end = 10.dp)
                            .height(2.dp)
                            .background(color = Color.LightGray)
                    )
                }
            }

            Text(
                text = "history",
                modifier = Modifier.padding(start = 10.dp, bottom = 5.dp, top = 5.dp)
            )

            LazyColumn(modifier = Modifier.weight(0.4f)) {
                items(count = 5) {
                    ConsultationItem(it, brush, navController = rememberNavController())
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 5.dp, end = 10.dp)
                            .height(2.dp)
                            .background(color = Color.LightGray)
                    )
                }
            }


            AnimatedVisibility(visible = showCreateSheet.value) {
                ShowFullScreenSheet {
                    Log.d("TAG", "Activities: $it")
                    showCreateSheet.value = false
                }
            }
        }
    }
}

@Composable
fun ShowFullScreenSheet(onSaveClick: (description: String) -> Unit) {

    val description = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = trans_sheet,
                shape = RoundedCornerShape(bottomStart = 60.dp, topEnd = 60.dp)
            )
            .alpha(0.7f)
            .clickable { onSaveClick(description.value) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp)
        ) {

            Text(text = "Create Consultation")

            LinedTextField(value = description, placeholder = "describe your condition here")

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp)
                ) {

                    Text(text = "Save", modifier = Modifier)
                }

            }
        }

    }
}

@Composable
fun ConsultationItem(it: Int, brush: Brush, navController: NavController) {

    val showActionMenu = remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp)))
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Text(
                    text = "",
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.8f)
                        .height(15.dp)
                        .background(brush, shape = RoundedCornerShape(corner = CornerSize(15.dp)))
                )

                Spacer(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(brush)
                )

            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.5f)
                        .height(15.dp)
                        .background(brush, shape = RoundedCornerShape(corner = CornerSize(15.dp)))
                )

                Row {

                    Icon(
                        imageVector = if (!showActionMenu.value) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
                        contentDescription = "show actions",
                        modifier = Modifier.clickable {
                            showActionMenu.value = !showActionMenu.value
                        }
                    )

                    DropdownMenu(
                        expanded = showActionMenu.value,
                        onDismissRequest = { showActionMenu.value = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "update") },
                            onClick = { navController.navigate(route = "${AppScreens.VIEW_CREATE_UPDATE_CONSULTATION}/update/$it") })
                        DropdownMenuItem(
                            text = { Text(text = "delete") },
                            onClick = { navController.navigate(route = "${AppScreens.VIEW_CREATE_UPDATE_CONSULTATION}/delete/$it") })
                    }
                }


            }
        }


    }
}
