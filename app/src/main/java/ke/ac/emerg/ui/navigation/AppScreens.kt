package ke.ac.emerg.ui.navigation

enum class AppScreens {

    HOME, ONBOARDING, SIGN_UP_LOGIN, ACCOUNT_SETTINGS, ACTIVITIES;

    companion object {

        fun fromRoute(route: String): AppScreens = when (route?.substringBefore("/")) {
            HOME.name -> HOME
            ONBOARDING.name -> ONBOARDING
            SIGN_UP_LOGIN.name -> SIGN_UP_LOGIN
            ACCOUNT_SETTINGS.name -> ACCOUNT_SETTINGS
            ACTIVITIES.name -> ACTIVITIES
            else -> throw IllegalStateException("Failed to parse route $route")
        }
    }
}