package ru.skillbranch.devintensive.extensions


import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy", locale : String = "ru"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(locale))
    return dateFormat.format(this)
}