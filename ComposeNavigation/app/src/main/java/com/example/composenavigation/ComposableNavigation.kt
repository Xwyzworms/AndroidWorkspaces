/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composenavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onDetailClick : (String, NavController) -> Unit,
    onAboutClick : (NavController) -> Unit,
    navController: NavController
)
{

    Scaffold() {
        LazyColumn(contentPadding = it) {
            item {
                HometopBar {
                    onAboutClick(navController)
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            items(courses) {
                    item -> BrosCard(item) { onDetailClick(item.title, navController) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen( onNavigateUp : () -> Unit )
{
    Scaffold(
        modifier = Modifier.padding(20.dp)
    ) {

        Column(Modifier.padding(it)) {
            Row(Modifier.padding(it),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                IconButton(onClick = onNavigateUp) {
                    Image(painter = painterResource(id = R.drawable.arrow_back_24), contentDescription = "Arrow back",
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
                Text("About", style= MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(20.dp))
            Column()
            {
                Text(text = "This app is demonstration about the navigation android Jetpack compose")
                Spacer(modifier = Modifier.height(15.dp))
                val localUri = LocalUriHandler.current
                Button(onClick = {
                    localUri.openUri("https://www.udemy.com")

                }) {
                    Text("View Our udemy courses")
                }
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(item : Course, navController: NavController)
{
    Scaffold()
    {
        Column(modifier = Modifier.padding(it))
        {
            Row(modifier = Modifier.padding(7.dp))
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {

                    Image(  painter = painterResource(id = R.drawable.arrow_back_24),
                        contentDescription = "Arrow Back",
                        modifier = Modifier.padding(5.dp),
                    )
                }
            }
            Column()
            {
                Image( painter = painterResource(id = item.thumbnail),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(15.dp))
                {
                    Text(item.title, style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(item.body, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }


}