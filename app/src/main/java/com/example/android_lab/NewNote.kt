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

    val newTitle = remember { mutableStateOf("") }
    val newCategory = remember { mutableStateOf(Category.None) }
    val newDescription = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            "New Note",
            fontWeight = FontWeight.Bold,
            fontSize = LargeFontSize,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        NoteForm(newTitle, newCategory, newDescription)

        Button(
            onClick = {
                noteList.add(Note(newTitle.value, newCategory.value, newDescription.value))
                navController.navigate("main")
            },
            modifier = Modifier.align(Alignment.BottomStart),
            enabled = noteValidations(newTitle.value, newCategory.value, newDescription.value)
        ) {
            Text("Save", fontSize = LargeFontSize)
        }

        Button(
            onClick = {
                navController.navigate("main")
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("Cancel", fontSize = LargeFontSize)
        }
    }
}