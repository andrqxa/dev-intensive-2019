package ru.skillbranch.devintensive.extensions


import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val WEEK = 7 * DAY
const val DECADE = 10 * DAY


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy", locale: String = "ru"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(locale))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    this.time += when (units) {
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
    DECADE;

    fun plural(value0: Int): String {
        val suff = "$value0".last()
        val value = abs(value0)
        return when (this.name) {
            "SECOND" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value секунд"
                    '1' -> "$value секунду"
                    '2', '3', '4' -> "$value секунды"
                    else -> ""
                }
            }
            "MINUTE" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value минут"
                    '1' -> "$value минуту"
                    '2', '3', '4' -> "$value минуты"
                    else -> ""
                }
            }
            "HOUR" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value часов"
                    '1' -> "$value час"
                    '2', '3', '4' -> "$value часа"
                    else -> ""
                }
            }
            "DAY" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value дней"
                    '1' -> "$value день"
                    '2', '3', '4' -> "$value дня"
                    else -> ""
                }
            }
            "WEEK" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value недель"
                    '1' -> "$value неделю"
                    '2', '3', '4' -> "$value недели"
                    else -> ""
                }
            }
            "DECADE" -> {
                when (suff) {
                    '0', '5', '6', '7', '8', '9' -> "$value декад"
                    '1' -> "$value декаду"
                    '2', '3', '4' -> "$value декад"
                    else -> ""
                }
            }
            else -> ""
        }
    }
}