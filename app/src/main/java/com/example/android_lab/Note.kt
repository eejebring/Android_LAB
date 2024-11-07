package com.example.android_lab

data class Note(
    val title: String,
    val category: Category,
    val description: String
) {
    fun isTitleValid(): Boolean {
        return title.isNotEmpty() && title.length <= 128
    }

    fun isCategoryValid(): Boolean {
        return category != Category.None
    }

    fun isDescriptionValid(): Boolean {
        return description.length <= 1024
    }

    fun isValid(): Boolean {
        return isTitleValid() && isCategoryValid() && isDescriptionValid()
    }
}