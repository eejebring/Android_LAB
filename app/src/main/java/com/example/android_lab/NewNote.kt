package com.example.android_lab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.android_lab.ui.theme.LargeFontSize

@Composable
fun NewNoteView(noteList: MutableList<Note>, navController: NavController) {

    val newNote = remember { mutableStateOf(Note("", Category.None, "")) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            "New Note",
            fontWeight = FontWeight.Bold,
            fontSize = LargeFontSize,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        NoteForm(newNote)

        Button(
            onClick = {
                noteList.add(newNote.value)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.BottomStart),
            enabled = newNote.value.isValid()
        ) {
            Text("Save", fontSize = LargeFontSize)
        }

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("Cancel", fontSize = LargeFontSize)
        }
    }
}