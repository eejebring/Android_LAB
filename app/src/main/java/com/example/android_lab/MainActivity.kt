package com.example.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.android_lab.ui.theme.Android_LABTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_LABTheme {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {
    val notes = remember { mutableListOf(Note("Do this", Category.Task, "yeah all of this"), Note("Do that", Category.Task, "yeah all of that")) }

    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Total amount of notes: " + notes.count())
            LazyColumn() {
                items(notes) { note ->
                    NotePreview(note)
                }
            }
        }
    }
}

@Composable
fun NotePreview(note: Note) {
    //HorizontalDivider()
    Column ( modifier = Modifier
        .padding(Dp(2F))
        .background(color = Color.LightGray, shape = RoundedCornerShape(10))
        .fillMaxWidth()
        .padding(Dp(2F))
    ) {
        Text(note.title, fontWeight = FontWeight.Bold)
        Text(note.description)
    }
}