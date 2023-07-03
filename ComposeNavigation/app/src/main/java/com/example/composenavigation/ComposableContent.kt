/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composenavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HometopBar (onAboutClick : () -> Unit)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text("My Udemy Courses", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { onAboutClick() }) {
            Text(text="About", fontSize = 24.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrosCard( item : Course, onDetailClick : () -> Unit )
{
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 10.dp),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        onClick = onDetailClick
        )
    {
        Column{
            Image(  painter = painterResource(item.thumbnail),
                contentDescription = "Bang Udah Bang",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
            {
                Text(text = item.title, fontSize = 24.sp )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.body, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HometopBarPreview ()
{
    val onAboutClick :  () -> Unit = {}
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text("My Udemy Courses", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { onAboutClick() }) {
            Text(text="About", fontSize = 24.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun showBrosCard( )
{
    val item : Course = course1
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(CornerSize(10.dp)))
    {
        Column{
            Image(  painter = painterResource(item.thumbnail),
                    contentDescription = "Bang Udah Bang",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.Crop
                )
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
            {
                Text(text = item.title, fontSize = 24.sp )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.body, fontSize = 12.sp)
            }
        }
    }
}
