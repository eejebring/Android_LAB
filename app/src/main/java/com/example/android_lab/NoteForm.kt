package com.example.android_lab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun NoteForm(newNote: MutableState<Note>) {

    val expandedDropdown = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = newNote.value.title,
            onValueChange = { newNote.value = newNote.value.copy(title = it) },
            label = { Text("Title") },
            isError = !newNote.value.isTitleValid(),
            supportingText = {
                if (!newNote.value.isTitleValid()) {
                    Text("Must have a title between 1 and 128 characters long.")
                } else {
                    Text("")
                }
            },
        )
        Column {
            /*TextButton(
                onClick = { expandedDropdown.value = !expandedDropdown.value },
                modifier = Modifier
                    .padding(Dp(5F))
            ) {
                Text("Category: " + newNote.value.category.toString())
            }*/
            OutlinedTextField(
                value = newNote.value.category.toString(),
                onValueChange = {},
                label = { Text("Category") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { expandedDropdown.value = !expandedDropdown.value }) {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = "Dropdown")
                    }
                },
                isError = !newNote.value.isCategoryValid(),
                supportingText = {
                    if (!newNote.value.isCategoryValid()) {
                        Text("Must have a category.")
                    } else {
                        Text("")
                    }
                },
                modifier = Modifier
                    .clickable { expandedDropdown.value = !expandedDropdown.value }
            )
            DropdownMenu(
                expanded = expandedDropdown.value,
                onDismissRequest = { expandedDropdown.value = false },
            ) {
                Category.entries.forEach { category ->
                    if (category == Category.None) {
                        return@forEach
                    }

                    DropdownMenuItem(
                        { Text(category.toString()) },
                        onClick = {
                            newNote.value = newNote.value.copy(category = category)
                            expandedDropdown.value = false
                        }
                    )
                }
            }
        }
        OutlinedTextField(
            value = newNote.value.description,
            onValueChange = { newNote.value = newNote.value.copy(description = it) },
            label = { Text("Description") },
            isError = !newNote.value.isDescriptionValid(),
            supportingText = {
                if (!newNote.value.isDescriptionValid()) {
                    Text("The description can be at most 1024 characters.")
                }
            },
        )
    }
}