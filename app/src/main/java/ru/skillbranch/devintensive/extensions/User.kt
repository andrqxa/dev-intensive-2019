package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

const val MINS = 60
const val HOURS = 60 * MINS
const val DAYS = 24 * HOURS


fun User.toUserView(): UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Ещё ни разу не был"
        else
            if (isOnline) "online"
            else "Последний раз был ${lastVisit.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        avatar = avatar,
        status = status,
        initials = initials
    )
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val current = this.time
    val previous = date.time
    val diff = (previous - current) / SECOND
    return when {
        //вперед
        diff < -(360 * DAYS) -> "более чем через год"
        diff in -360 * DAYS..-27 * HOURS -> {
            val days = (diff / DAYS).toInt()
            "через ${TimeUnits.DAY.plural(days)}"
        }
        diff in -26 * HOURS..-23 * HOURS -> "через день"
        diff in -22 * HOURS..-76 * MINS -> {
            val hours = (diff / HOURS).toInt()
            "через ${TimeUnits.HOUR.plural(hours)}"
        }
        diff in -75 * MINS..-46 * MINS -> "через час"
        diff in -45 * MINS..-76 -> {
            val mins = (diff / MINS).toInt()
            "через ${TimeUnits.MINUTE.plural(mins)}"
        }
        diff in -75..-46 -> "через минуту"
        diff in -45..-2 -> "через несколько секунд"
        diff in -1..0 -> "только что"
        // назад
        diff in 0..1 -> "только что"
        diff in 2..45 -> "несколько секунд назад"
        diff in 46..75 -> "минуту назад"
        diff in 76..45 * MINS -> {
            val mins = (diff / MINS).toInt()
            "${TimeUnits.MINUTE.plural(mins)} назад"
        }
        diff in 46 * MINS..75 * MINS -> "час назад"
        diff in 76 * MINS..22 * HOURS -> {
            val hours = (diff / HOURS).toInt()
            "${TimeUnits.HOUR.plural(hours)} назад"
        }
        diff in 23 * HOURS..26 * HOURS -> "день назад"
        diff in 27 * HOURS..360 * DAYS -> {
            val days = (diff / DAYS).toInt()
            "${TimeUnits.DAY.plural(days)} назад"
        }
        diff > (360 * DAYS) -> "более года назад"
        else -> "неизвестно"
    }
}
