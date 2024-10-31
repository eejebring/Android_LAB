package com.example.android_lab

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState

@Composable
fun EditView(note: Note, editingNote: MutableIntState) {
    Text("this is the edit view")
    Button(onClick = {editingNote.intValue = -1}) { }
}