/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simpleportoflio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleportoflio.ui.theme.SimplePortoflioTheme

@Composable
fun BodyContent(modifier : Modifier = Modifier)
{
    Column(modifier=Modifier.padding(5.dp))
    {
        Text("Miles U.",
            fontSize = 25.sp,
            color = Color.Magenta,
            style = MaterialTheme.typography.titleLarge)
        Text("Android compose Programmer",
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodySmall)
        Text("@theMilesCompose",
            fontSize = 12.sp, style = MaterialTheme.typography.bodySmall)
    }
}


@Composable
@Preview(showBackground=true)
fun showBro()
{
    SimplePortoflioTheme {
        BodyContent()
    }
}