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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_lab.ui.theme.Android_LABTheme
import com.example.android_lab.ui.theme.LargeFontSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val noteList = remember { mutableStateListOf(Note("Do this", Category.Task, "Yeah all of this."), Note("Do that", Category.Task, "Yeah all of that.")) }

            Android_LABTheme (darkTheme = false) {Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding).padding(Dp(5F))) {

                    Text("Total amount of notes: " + noteList.count(), fontSize = LargeFontSize)

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainView(noteList, navController)
                        }
                        composable("edit/{noteId}") {
                            val noteId = it.arguments?.getString("noteId")?.toInt() ?: -1
                            EditView(noteList, noteId, navController)
                        }
                    }
                    /*if (editingNote.intValue < 0) {
                    } else {
                        EditView(noteList, editingNote)
                    }*/
                }
            }
            }
        }
    }
}

@Composable
fun MainView(noteList: MutableList<Note>, navController: NavHostController) {
    NotePreviewList(noteList, navController)
    NewNoteButton(noteList, navController)
}