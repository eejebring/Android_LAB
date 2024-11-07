package com.example.android_lab

data class Note (
    val title: String,
    val category: Category,
    val description: String
    )


fun noteValidations(newTitle: String, newCategory: Category, newDescription: String): Boolean {
    return newTitle.isNotEmpty()
            && newTitle.length <= 128
            && newCategory != Category.None
            && newDescription.length <= 1024
}