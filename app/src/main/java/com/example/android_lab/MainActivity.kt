package com.example.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.android_lab.ui.theme.Android_LABTheme
import com.example.android_lab.ui.theme.LargeFontSize


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

    val noteList = remember { mutableStateListOf(Note("Do this", Category.Task, "Yeah all of this."), Note("Do that", Category.Task, "Yeah all of that.")) }

    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Total amount of notes: " + noteList.count(), fontSize = LargeFontSize)
            LazyColumn() {
                itemsIndexed(noteList) { index, note ->
                    NotePreview(note, index)
                }
            }
        }

        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
            Button(
                onClick = {noteList.add(Note("New note", Category.Note, "New stuff to remember."))},
                modifier = Modifier.padding(Dp(5F))
            ) {
                Text("New Note", fontSize = LargeFontSize)
            }
        }
    }
}