package com.example.luckynumberapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luckynumberapp.ui.theme.LuckyNumberAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuckyNumberAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComponent("Android")
                }
            }
        }
    }
    private fun gotoAnotherActivity()
    {
        val intent : Intent = Intent(baseContext, SecondActivity::class.java)
        startActivity(intent)

    }

    @Composable
    fun MainComponent (name: String, modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Welcome to Lucky Number! $name",
            )
            CustomEditText()
            Button(onClick = ::gotoAnotherActivity, )
            {
                Text("Sign in Bro")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomEditText()
    {
        val inputValue  : MutableState<TextFieldValue> = remember {mutableStateOf(TextFieldValue())}
        Column() {
            TextField(
                value = inputValue.value,
                onValueChange = { inputValue.value = it },
                placeholder = { Text(text="Enter your name")},
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth(),
                keyboardOptions =  KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                maxLines = 2,
                singleLine=true,
                leadingIcon = { Icon(Icons.Filled.AccountCircle,"bro", tint= colorResource(id = R.color.purple_500)) },
                trailingIcon = {Icon(Icons.Filled.Info,"Bro", tint= colorResource(id = R.color.purple_500))}

            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LuckyNumberAppTheme {
            MainComponent("Android")
        }
    }
}
