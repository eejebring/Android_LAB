package com.example.android_lab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun NoteForm(newTitle: MutableState<String>, newCategory: MutableState<Category>, newDescription: MutableState<String>) {

    val expandedDropdown = remember { mutableStateOf(false) }

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
}