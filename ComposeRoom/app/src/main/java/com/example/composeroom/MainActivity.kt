package com.example.composeroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composeroom.data.BookEntity
import com.example.composeroom.database.MainBookDatabase
import com.example.composeroom.ui.theme.ComposeRoomTheme
import com.example.composeroom.viewmodels.MainBookRepository
import com.example.composeroom.viewmodels.MainBookViewModel
import kotlinx.coroutines.flow.Flow

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel : MainBookViewModel
    private lateinit var mainBookRepository: MainBookRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRoomTheme {
                setup()
                MainScreen(mainViewModel)
            }
        }
    }


    private fun setup()
    {
        mainBookRepository = MainBookRepository(MainBookDatabase.getInstance(this).bookDao())
        mainViewModel = MainBookViewModel(mainBookRepository)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainBookViewModel)
{
    val currentState by viewModel.getBooks().collectAsState(emptyList())
    var insertBookState by remember {  mutableStateOf("") }

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Insert Books in ROOM DB")
                OutlinedTextField(
                    value = insertBookState, onValueChange = {insertBookState = it},
                    placeholder = { Text("Enter Book Name") },
                    label = {Text("Book")}

                )
                Button(onClick = {
                    viewModel.insertBook(BookEntity(0, insertBookState))
                })
                {
                    Text("insert Book into DB")
                }

                Text("My Library : ")

                LazyColumn {
                    items(currentState) {item->
                        BookView(bookEntity = item, viewModel =viewModel )
                    }
                }
            }
    }

}


@Composable
fun BookView(bookEntity: BookEntity, viewModel: MainBookViewModel)
{
    Card()
    {
        Row()
        {
            Text(text=  bookEntity.id.toString())
            Text(text = bookEntity.bookName)

            IconButton(onClick = { viewModel.deleteBook(bookEntity) }) {
                Image(painter =painterResource(id = R.drawable.delete_24), contentDescription = "")
            }

            IconButton(onClick= { /* TODO */ } )
            {
                Image(painter = painterResource(id = R.drawable.edit_24), contentDescription = "")
            }
        }
    }
}

fun deleteHandler(bookEntity: BookEntity, mainViewModel : MainBookViewModel)
{
    mainViewModel.deleteBook(bookEntity)
}

fun insertHandler(bookEntity: BookEntity, mainViewModel: MainBookViewModel)
{
    mainViewModel.insertBook(bookEntity)
}

fun getBooks(mainViewModel: MainBookViewModel) : Flow<List<BookEntity>>
{
    return mainViewModel.getBooks()
}






