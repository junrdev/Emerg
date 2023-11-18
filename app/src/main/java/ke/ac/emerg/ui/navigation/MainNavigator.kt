package ke.ac.emerg.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ke.ac.emerg.di.ConsultationViewModel
import ke.ac.emerg.ui.screens.Activities
import ke.ac.emerg.ui.screens.HomeScreen
import ke.ac.emerg.ui.screens.OnBoarding
import ke.ac.emerg.ui.screens.Register
import ke.ac.emerg.ui.screens.SignIn
import ke.ac.emerg.ui.screens.ViewUpdateDeleteConstultation
import ke.ac.emerg.util.CONSTANTS.LOGIN
import ke.ac.emerg.util.CONSTANTS.SIGNUP


@Composable
fun Navigator(consultationViewModel: ConsultationViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.ONBOARDING.name) {

        composable(route = AppScreens.ONBOARDING.name) {
            OnBoarding(navController = navController)
        }


        composable(
            route = "${AppScreens.SIGN_UP_LOGIN.name}/{screen}",
            arguments = listOf(navArgument("screen") { type = NavType.StringType })
        ) {

            val t_rout = it.arguments?.getString("screen")

            when (t_rout) {
                SIGNUP -> Register(navController = navController)
                LOGIN -> SignIn(navController = navController)
            }
        }

        composable(route = "${AppScreens.HOME.name}/{userid}") {
            it.arguments?.getString("userid").let {
                if (it != null) {
                    HomeScreen(navController = navController, uid = it)
                }
            }
        }

        composable(route = AppScreens.ACTIVITIES.name) {
            Activities(navController = navController, consultationViewModel= consultationViewModel)
        }


        composable(
            route = "${AppScreens.VIEW_CREATE_UPDATE_CONSULTATION.name}/{action}/{id}",
            arguments = listOf(navArgument("action"){type = NavType.StringType}, navArgument("id"){type = NavType.IntType})
        ) {

            Log.d("TAG", "Navigator: $route")

            it.arguments?.getString("action").let { act ->

                when (act) {
                    "update" -> it.arguments?.getInt("id")?.let { id ->
                        ViewUpdateDeleteConstultation(
                            action = act,
                            consId = "$id"
                        )
                    }

                    "update" -> it.arguments?.getInt("id")?.let { id ->
                        ViewUpdateDeleteConstultation(
                            action = act,
                            consId = "$id"
                        )
                    }
                }

            }

        }

        composable(route = AppScreens.ACCOUNT_SETTINGS.name) {

        }


    }

}