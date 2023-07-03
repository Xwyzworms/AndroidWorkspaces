package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                MainApp {
                    MainNav()
                    }
                }
            }
        }
    }

@Composable
fun MainNav()
{
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background))
    {
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination =  Path.Home.name) {

            composable(route = Path.Home.name,) {

                HomeScreen(onDetailClick = { title, navController ->
                    onDetailClick(
                        title = title,
                        navController = navController
                    )
                }, onAboutClick = { navController ->
                    onAboutClick(navController)
                }, navController = navigationController)
            }

            composable(route = Path.About.name) {
                AboutScreen( onNavigateUp = {navigationController.popBackStack()})
            } // Go To About

            composable(route = Path.Detail.name + "/title={title}",
                arguments = listOf(navArgument("title") {
                    type = NavType.StringType
                    nullable = false
                })
            )
            {
                val arguments = requireNotNull(it.arguments)
                val title = arguments.getString("title")
                val course = courses.first {first -> title == first.title}

                DetailScreen(item = course, navController = navigationController)
            }

        }

    }
}

fun onDetailClick(title : String, navController: NavController)
{

    navController.navigate(Path.Detail.name + "/title=$title")
}

fun onAboutClick(navController : NavController)
{
    navController.navigate(Path.About.name)
}


@Composable
fun MainApp( content  : @Composable () -> Unit)
{
    content()
}
