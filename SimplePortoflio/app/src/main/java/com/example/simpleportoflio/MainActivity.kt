package com.example.simpleportoflio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleportoflio.ui.theme.SimplePortoflioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplePortoflioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateProfileCard();
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CreateProfileCard()
{
    val buttonPortfolioState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(15.dp),
             elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
             shape = RoundedCornerShape(corner = CornerSize(15.dp)),
             colors = CardDefaults.cardColors(containerColor = Color.White)
              )  {

            Column(modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
                    verticalArrangement =  Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                HeadProfileImage()
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray)
                BodyContent()
                Button(onClick = {
                        buttonPortfolioState.value = !buttonPortfolioState.value
                })
                {
                    Text("Portfolio", style= MaterialTheme.typography.bodySmall)
                }

            }
            if(buttonPortfolioState.value)
            {
                ShowContent()
            }
            else
            {
                Box() {}
            }
        }
    }
}

@Composable
fun ShowContent()
{
    Content()
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimplePortoflioTheme {
        CreateProfileCard();
    }
}