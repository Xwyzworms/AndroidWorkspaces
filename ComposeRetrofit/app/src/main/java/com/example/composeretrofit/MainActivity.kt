package com.example.composeretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composeretrofit.data.Character
import com.example.composeretrofit.network.RetrofitInstance
import com.example.composeretrofit.ui.theme.ComposeRetrofitTheme
import com.example.composeretrofit.viewmodel.MainPotterViewModel
import com.example.composeretrofit.viewmodel.MainRepository
import kotlinx.coroutines.flow.asFlow

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel : MainPotterViewModel
    private lateinit var mainRepository: MainRepository

    private lateinit var mainStateCharacter : State<List<Character>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRetrofitTheme {
                MainScreen()
            }
        }
    }

    private fun setupViewModel()
    {
        mainRepository = MainRepository(RetrofitInstance().getHarryPotterService())
        mainViewModel = MainPotterViewModel(mainRepository)
    }

    @Composable
    fun MainScreen()
    {
        setupViewModel()
        mainStateCharacter = mainViewModel.state.collectAsState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(mainStateCharacter.value) {
                    CreateCard(it)
                }
            })
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CreateCard(character: Character)
{
    Column()
    {
        GlideImage(model = character.image , contentDescription = "Nah Bro",
        modifier =  Modifier.width(70.dp).height(90.dp))
        Text(character.name)
    }
}

