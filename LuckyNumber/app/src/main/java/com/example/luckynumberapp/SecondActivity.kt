/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.luckynumberapp
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.luckynumberapp.ui.theme.LuckyNumberAppTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            LuckyNumberAppTheme {
                Surface() {
                 MainContentSecond(getContent())
                }
            }
        }
    }
    private fun getLuckyNumber()  : String
    {
        return "400"
    }
    private fun getContent() : String
    {
        val strContent : String? = intent.getStringExtra("BRO")
        return strContent ?: "Nobody"
    }

    private fun shareEmail(email : String, subject : String?, content : String?) : Unit
    {
        val intent : Intent = Intent(Intent.ACTION_SENDTO)
        intent.data =Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject ?: "No Subject")
        intent.putExtra(Intent.EXTRA_TEXT, content ?: "No Content")
        startActivity(Intent.createChooser(intent, "Pick Email"))
    }
    @Composable
    fun MainContentSecond(userName : String)
    {
            DefineMainContent()
    }

    @Composable()
    fun DefineMainContent(){

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Your Lucky Number is ", fontSize = 20.sp)
            Text(text=getLuckyNumber(), fontSize = 25.sp)

            Button(onClick= {
                shareEmail("primitif@gmail.com", "Bro apa ini", "At laastt you knew it")
            })
            {
                Text("DO you want to share it Bro ?")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun previewSecondActivity()
    {
        LuckyNumberAppTheme {
            MainContentSecond(getContent())
        }
    }

}