package com.example.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.android_lab.ui.theme.Android_LABTheme
import com.example.android_lab.ui.theme.LargeFontSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_LABTheme (darkTheme = false) {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {

    val noteList = remember { mutableStateListOf(Note("Do this", Category.Task, "Yeah all of this."), Note("Do that", Category.Task, "Yeah all of that.")) }
    val editingNote = remember { mutableIntStateOf(-1) } // Enters the edit view when there is a valid index given.

    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            Text("Total amount of notes: " + noteList.count(), fontSize = LargeFontSize)

            if (editingNote.intValue < 0) {
                NotePreviewList(noteList, editingNote)
                NewNoteButton(noteList, editingNote)
            } else {
                EditView(noteList.get(editingNote.intValue), editingNote)
            }
        }
    }
}