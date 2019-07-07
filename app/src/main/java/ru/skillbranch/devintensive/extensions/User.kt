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
    val current = Date().time
    val previous = date.time
    val diff = (current - previous) * SECOND
    return when {
        diff in 0..1 -> "только что"
        diff in 2..45 -> "несколько секунд назад"
        diff in 46..75 -> "минуту назад"
//        diff in 76..45* MINS -> "N минут назад"
        diff in 46 * MINS..75 * MINS -> "час назад"
//        diff in 76*MINS..22* HOURS -> "N часов назад"
        diff in 23 * HOURS..26 * HOURS -> "день назад"
//        diff in 27*HOURS..360 * DAYS -> "N дней назад"
        diff > (360 * DAYS) -> "более года назад"
//        else -> IllegalArgumentException("Illegal time difference")
        else -> "неизвестно"
    }
}
