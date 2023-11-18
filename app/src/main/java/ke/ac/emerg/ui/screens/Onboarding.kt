package ke.ac.emerg.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.ac.emerg.App
import ke.ac.emerg.ui.navigation.AppScreens
import ke.ac.emerg.ui.screens.PagerObject.*
import ke.ac.emerg.ui.theme.ptsans
import ke.ac.emerg.util.CONSTANTS.SIGNUP
import ke.ac.emerg.util.CONSTANTS.autoScrollInterval
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

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            userScrollEnabled = false,

            ) {
            PagerScreen(pagerObject = pages[it], it, modifier = Modifier.fillMaxSize())
        }

        LaunchedEffect(pagerState.currentPage) {
            while (true) {
                delay(autoScrollInterval)
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.animateScrollToPage(nextPage, animationSpec = tween(300))
            }
        }


//        HorizontalPagerIndicator(pagerState = pagerState, pageCount = pagerState.pageCount, modifier = Modifier.align(
//            Alignment.TopCenter
//        ).padding(top = 5.dp))


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
                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                contentDescription = "get started",
                modifier = Modifier
                    .align(
                        if (pagerState.currentPage == pagerState.pageCount - 1)
                            Alignment.CenterEnd
                        else
                            Alignment.CenterStart
                    )
                    .padding(5.dp),
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
fun PagerScreen(pagerObject: PagerObject, i: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(), contentAlignment = Alignment.Center
    ) {
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
        )

        Column(
            horizontalAlignment = Alignment.Start, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {

            Text(
                text = pagerObject.title,
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                fontFamily = ptsans
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = pagerObject.content,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                fontFamily = ptsans
            )

//            }
        }

    }
}