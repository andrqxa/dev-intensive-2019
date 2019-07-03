package ru.skillbranch.devintensive.extensions


import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val WEEK = 7 * DAY
const val DECADE = 10 * DAY


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy", locale : String = "ru"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(locale))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    this.time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        TimeUnits.WEEK -> value * WEEK
        TimeUnits.DECADE -> value * DECADE
    }
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY,
    WEEK,
    DECADE
}