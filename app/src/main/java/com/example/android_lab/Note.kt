package com.example.android_lab

import android.icu.text.CaseMap.Title

data class Note (
    val title: String,
    val category: Category,
    val description: String
    )