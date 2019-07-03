package ru.skillbranch.devintensive.extensions


import java.lang.IllegalArgumentException
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

fun Date.add(value : Int, inputUnits : String) : Date{
    val units = inputUnits.toLowerCase()
    this.time += when(units){
        "second", "seconds", "sec", "secs" -> value * SECOND
        "minute", "minutes", "min", "mins" -> value * MINUTE
        "hour", "hours", "hr", "hrs" -> value * HOUR
        "day", "days" -> value * DAY
        "week", "weeks" -> value * WEEK
        "decade", "decades" -> value * DECADE
        else -> throw IllegalArgumentException("invalid unit")
    }
    return this
}