package com.example.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.android_lab.ui.theme.Android_LABTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_LABTheme {
                val notes = remember { mutableListOf(Note("Do this", Category.Task, "yeah all of this"), Note("Do that", Category.Task, "yeah all of that")) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    NotePreviewList(notes)
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
fun NotePreviewList(notes: List<Note>) {
    LazyColumn( modifier = Modifier.padding(top = Dp(100F))) {
        items(notes) { note ->
            NotePreview(note)
        }
    }
}

@Composable
fun NotePreview(note: Note) {
    Row {
        Text(note.title)
        Text(note.description)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_LABTheme {
        Greeting("Android")
    }
}