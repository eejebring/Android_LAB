package com.example.android_lab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.android_lab.ui.theme.LargeFontSize

@Composable
fun EditNoteView(noteList: MutableList<Note>, editingNote: Int, navController: NavController) {
    val note = noteList[editingNote]
    val newNote = remember { mutableStateOf(note) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            "Editing Note",
            fontWeight = FontWeight.Bold,
            fontSize = LargeFontSize,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Button(
            onClick = {
                noteList.removeAt(editingNote)
                navController.navigate("main")
            },
            modifier = Modifier.align(Alignment.TopEnd),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Delete", fontSize = LargeFontSize)
        }

        NoteForm(newNote)

        Button(
            onClick = {
                noteList[editingNote] = newNote.value
                navController.navigate("main")
            },
            modifier = Modifier.align(Alignment.BottomStart),
            enabled = newNote.value.isValid()
        ) {
            Text("Save", fontSize = LargeFontSize)
        }

        Button(
            onClick = {
                //noteList.removeAt(editingNote)
                navController.navigate("main")
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("Cancel", fontSize = LargeFontSize)
        }
    }
}