package ke.ac.emerg.ui.screens

import androidx.annotation.DrawableRes
import ke.ac.emerg.R

sealed class PagerObject(
    val title :String,
    val content :String,

    @DrawableRes
    val image :Int
){

    object PAGER_1 : PagerObject("Dial *318*5318#", "Access the services when offline. Bringing a wide user outreach.", R.drawable.pager1)
    object PAGER_2 : PagerObject("24/7 Access", "Get help from our 24/7 emergency help line.", R.drawable.pager2)
    object PAGER_3 : PagerObject("Easy Customer Experience", "Recieve response from our active Customer care group", R.drawable.pager3)
    object PAGER_4 : PagerObject("Tracking", "Keep digital records of health records including payments", R.drawable.pager4)
    object PAGER_5 : PagerObject("Reminders", "Recieve daily, weekly, monthly or even yearly reminders for health checkups,, dosages and much more", R.drawable.pager5)
    object PAGER_6 : PagerObject("Join Us", "Join us today to ensure your health is on the radar", R.drawable.pager6)
}
