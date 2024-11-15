package com.example.android_lab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController

@Composable
fun noteColours(category: Category): Color {
    return when (category) {
        Category.Reminder -> Color.Yellow
        Category.Task -> MaterialTheme.colorScheme.primaryContainer
        Category.Other -> MaterialTheme.colorScheme.tertiaryContainer
        else -> Color.LightGray
    }
}

@Composable
fun NotePreview(note: Note, index: Int, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(Dp(2F))
            .background(color = noteColours(note.category), shape = RoundedCornerShape(10))
            .fillMaxWidth()
            .padding(Dp(2F))
    ) {
        Text(note.title, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { navController.navigate("detail/$index") })
        ) {
            Text(note.description.take(35))
            Button(
                onClick = { navController.navigate("edit/$index") },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit note")
            }
        }
    }
}

@Composable
fun NotePreviewList(noteList: MutableList<Note>, navController: NavController) {
    LazyColumn() {
        itemsIndexed(noteList) { index, note ->
            NotePreview(note, index, navController)
        }
    }
}