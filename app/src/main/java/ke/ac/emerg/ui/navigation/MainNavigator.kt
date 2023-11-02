package ke.ac.emerg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navigator(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.ONBOARDING.name){

        composable(route = AppScreens.ONBOARDING.name){

        }

        composable(route = AppScreens.SIGN_UP_LOGIN.name){

        }

        composable(route = AppScreens.HOME.name){

        }

        composable(route = AppScreens.ACCOUNT_SETTINGS.name){

        }
    }

}