package com.example.android_lab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android_lab.ui.theme.LargeFontSize

@Composable
fun NewNoteButton(noteList: MutableList<Note>, editingNote: MutableIntState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Button(
            onClick = {newNote(noteList, editingNote)}
        ) {
            Text("New Note", fontSize = LargeFontSize)
        }
    }
}

fun newNote (noteList: MutableList<Note>, editingNote: MutableIntState) {
    val index = noteList.count()
    noteList.add(Note("New note", Category.None, "New stuff to remember."))
    editingNote.intValue = index
}