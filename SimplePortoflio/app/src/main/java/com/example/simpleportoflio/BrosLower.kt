/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simpleportoflio

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleportoflio.ui.theme.SimplePortoflioTheme

@Composable
fun Content()
{
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp).background(Color.White),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            border = BorderStroke(1.dp, Color.Gray)
        )
        {
            Portofolio(data = listOf("Project1","Project2","Project3"))
        }
}

@Composable
fun Portofolio(data : List<String>)
{
    LazyColumn {
        items(data) {item ->
            run {
                PortofolioContent(data = item)
            }
        }
    }

}

@Composable
fun PortofolioContent(data : String)
{
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(10.dp)
            .background(Color.White),
        color = Color.White,
        shadowElevation = 2.dp,
        shape= RectangleShape
    )
    {
        Row( verticalAlignment= Alignment.CenterVertically,
            modifier =  Modifier.padding(20.dp)) {
            HeadProfileImage(Modifier.size(50.dp))

            Column(Modifier.padding(start=5.dp))
            {
                Text(data)
                Text("A great project brah")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun showTheContentBrah()
{
    SimplePortoflioTheme() {
        Content()
    }
}