/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simpleportoflio

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.simpleportoflio.ui.theme.SimplePortoflioTheme

@Composable
fun HeadProfileImage(modifier : Modifier = Modifier
    .size(150.dp)
    .padding(5.dp))
{
    Surface(modifier= modifier,
        shape = CircleShape,
        border= BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = Dp(4f),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha=0.01f)
    )
    {
        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription =  "Bros Head",
            contentScale = ContentScale.Crop)
    }
}


@Composable
@Preview(showBackground = true)
fun previewSomeShit()
{
    SimplePortoflioTheme {
        HeadProfileImage()
    }
}

