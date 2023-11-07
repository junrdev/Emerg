package ke.ac.emerg.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ke.ac.emerg.ui.screens.Activities
import ke.ac.emerg.ui.screens.HomeScreen
import ke.ac.emerg.ui.screens.OnBoarding
import ke.ac.emerg.ui.screens.Register
import ke.ac.emerg.ui.screens.SignIn
import ke.ac.emerg.util.LOGIN
import ke.ac.emerg.util.SIGNUP


@Composable
fun Navigator(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.ONBOARDING.name){

        composable(route = AppScreens.ONBOARDING.name){
            OnBoarding(navController = navController)
        }


        composable(
            route = "${AppScreens.SIGN_UP_LOGIN.name}/{screen}",
            arguments = listOf(navArgument("screen"){type = NavType.StringType})
        ){

//            Log.d("TAG", "Navigator: ${it.toString()}")

            val t_rout = it.arguments?.getString("screen")

            when(t_rout){
                SIGNUP -> Register(navController = navController)
                LOGIN -> SignIn(navController = navController)
            }
        }

        composable(route = "${AppScreens.HOME.name}/{userid}"){
            it.arguments?.getString("userid").let {
                if (it != null) {
                    HomeScreen(navController = navController, uid = it)
                }
            }
        }

        composable(route = AppScreens.ACTIVITIES.name){
            Activities(navController)
        }

        composable(route = AppScreens.ACCOUNT_SETTINGS.name){

        }
    }

}