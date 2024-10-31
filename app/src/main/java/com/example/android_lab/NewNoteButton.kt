package com.example.android_lab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.android_lab.ui.theme.LargeFontSize

@Composable
fun NewNoteButton(noteList: MutableList<Note>, innerPadding: PaddingValues) {
    Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Button(
            onClick = {noteList.add(Note("New note", Category.Note, "New stuff to remember."))},
            modifier = Modifier.padding(Dp(5F))
        ) {
            Text("New Note", fontSize = LargeFontSize)
        }
    }
}