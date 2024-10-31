package com.example.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.android_lab.ui.theme.Android_LABTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_LABTheme (darkTheme = true) {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {

    val noteList = remember { mutableStateListOf(Note("Do this", Category.Task, "Yeah all of this."), Note("Do that", Category.Task, "Yeah all of that.")) }


    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        NotePreviewList(noteList, innerPadding)
        NewNoteButton(noteList, innerPadding)
    }
}