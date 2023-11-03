package ke.ac.emerg.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.HorizontalPagerIndicator
import ke.ac.emerg.App
import ke.ac.emerg.ui.navigation.AppScreens
import ke.ac.emerg.ui.screens.PagerObject.*
import ke.ac.emerg.ui.theme.navy_blue
import ke.ac.emerg.util.SIGNUP
import ke.ac.emerg.util.autoScrollInterval
import kotlinx.coroutines.delay

@Preview
@Composable
fun OnPrev() {
    App {
        OnBoarding(navController = rememberNavController())
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoarding(navController: NavController) {

    val pages = listOf(
        PAGER_1,
        PAGER_2,
        PAGER_3,
        PAGER_4,
        PAGER_5,
        PAGER_6
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        HorizontalPager(state = pagerState, modifier = Modifier, pageSize = PageSize.Fill) {

            LaunchedEffect(pagerState.currentPage) {
                while (true) {
                    delay(autoScrollInterval)
                    val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                    pagerState.animateScrollToPage(nextPage)
                }
            }
            PagerScreen(pagerObject = pages[it])

        }

        HorizontalPagerIndicator(pagerState = pagerState, pageCount = pagerState.pageCount)

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .padding(10.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = Color.White)
                .padding(8.dp)
                .clickable { navController.navigate(route = "${AppScreens.SIGN_UP_LOGIN.name}/$SIGNUP") }
        ) {

            Icon(
                imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "get started",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(5.dp)
                    ,
                tint = Color.Black
            )

            Text(
                text = "Get Started",
                modifier = Modifier
                    .align(Alignment.Center)
            )

        }

    }
}

@Composable
fun PagerScreen(pagerObject: PagerObject) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = pagerObject.image),
            contentDescription = pagerObject.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x00000000), // Start color
                            Color(0xB0000000) // Transparent black (start color)
                        ),
                        startY = 0f,
                        endY = 1f
                    )
                )
//                .alpha(0.1f)
        )

        Column(
            horizontalAlignment = Alignment.Start, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {

            Text(
                text = pagerObject.title,
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = pagerObject.title,
                style = MaterialTheme.typography.displaySmall,
                color = Color.White
            )
        }

    }
}