package com.example.android_lab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp


@Composable
fun NotePreview(note: Note, index: Int) {
    //HorizontalDivider()
    Column ( modifier = Modifier
        .padding(Dp(2F))
        .background(color = MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(10))
        .fillMaxWidth()
        .padding(Dp(2F))
    ) {
        Text(note.title, fontWeight = FontWeight.Bold)
        Box (modifier = Modifier.fillMaxWidth()){
            Text(note.description)
            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
                Text("" + index)
                Icon(Icons.Filled.Edit, contentDescription = "Edit note")
            }
        }
    }
}