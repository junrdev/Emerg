package ke.ac.emerg.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.ac.emerg.App

@Preview
@Composable
fun OnPrev() {
    App {
        OnBoarding(navController = rememberNavController())
    }
}

@Composable
fun OnBoarding(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(text = "Hello world")
    }
}