package com.example.android_lab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.android_lab.ui.theme.LargeFontSize

@Composable
fun EditView(noteList: MutableList<Note>, editingNote: MutableIntState) {
    val note = noteList[editingNote.intValue]
    val expandedDropdown = remember { mutableStateOf(false) }

    val newTitle = remember { mutableStateOf(note.title) }
    val newCategory = remember { mutableStateOf(note.category) }
    val newDescription = remember { mutableStateOf(note.description) }

    //Text(note.title, fontWeight = FontWeight.Bold, fontSize = LargeFontSize)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            OutlinedTextField(
                value = newTitle.value,
                onValueChange = { newTitle.value = it },
                label = { Text("Title") },
            )
            Column {
                TextButton (
                    onClick = { expandedDropdown.value = !expandedDropdown.value },
                    modifier = Modifier
                        .padding(Dp(5F))
                ) {
                    Text("Category: " + newCategory.value.toString())
                }
                DropdownMenu(
                    expanded = expandedDropdown.value,
                    onDismissRequest = { expandedDropdown.value = false },
                    //modifier = Modifier.fillMaxWidth().height(Dp(20F))
                ) {
                    Category.entries.forEach { category ->
                        if (category == Category.None) {
                            return@forEach
                        }

                        DropdownMenuItem(
                            { Text(category.toString()) },
                            onClick = {
                                newCategory.value = category
                                expandedDropdown.value = false
                            }
                        )
                    }
                }
            }
            OutlinedTextField(
                value = newDescription.value,
                onValueChange = { newDescription.value = it },
                label = { Text("Description") },
            )
        }

        Button(
            onClick = {
                noteList.set(
                    editingNote.intValue,
                    Note(newTitle.value, newCategory.value, newDescription.value)
                )
                editingNote.intValue = -1
            },
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text("Save", fontSize = LargeFontSize)
        }

        Button(
            onClick = {
                noteList.removeAt(editingNote.intValue)
                editingNote.intValue = -1
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            if (note.category == Category.None) {
                Text("Cancel", fontSize = LargeFontSize)
            }
            else {
                Text("Delete", fontSize = LargeFontSize)
            }
        }
    }
}