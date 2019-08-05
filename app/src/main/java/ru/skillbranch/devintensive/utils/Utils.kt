package ru.skillbranch.devintensive.utils

import android.content.Context
import android.util.DisplayMetrics

object Utils {
    fun parseFullName(inputFullName: String?): Pair<String?, String?> {
        val name1 = inputFullName?.replace("\\s+".toRegex(), " ")
        val fullName = name1?.trim()
        if (fullName.isNullOrEmpty() || fullName.isNullOrBlank()) {
            return null to null
        }
        val parts: List<String> = fullName.split(" ")
        val firstName = parts.getOrNull(0)
        val lastName = parts.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload0: String?, divider: String = " "): String {
        if (payload0.isNullOrEmpty() || payload0.isNullOrBlank()) {
            return ""
        }
        val translate = mapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh'",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya",
            'А' to "A",
            'Б' to "B",
            'В' to "V",
            'Г' to "G",
            'Д' to "D",
            'Е' to "E",
            'Ё' to "E",
            'Ж' to "Zh",
            'З' to "Z",
            'И' to "I",
            'Й' to "I",
            'К' to "K",
            'Л' to "L",
            'М' to "M",
            'Н' to "N",
            'О' to "O",
            'П' to "P",
            'Р' to "R",
            'С' to "S",
            'Т' to "T",
            'У' to "U",
            'Ф' to "F",
            'Х' to "H",
            'Ц' to "C",
            'Ч' to "Ch",
            'Ш' to "Sh",
            'Щ' to "Sh'",
            'Ъ' to "",
            'Ы' to "I",
            'Ь' to "",
            'Э' to "E",
            'Ю' to "Yu",
            'Я' to "Ya"
        )
        val payload = payload0.trim()
        val result = StringBuilder()
        for (ch in payload) {
            if (ch == ' ') {
                result.append(divider)
            } else {
                if (ch in translate.keys) {
                    result.append(translate[ch])
                } else {
                    result.append(ch)
                }
            }

        }
        return result.toString()
    }

    fun toInitials(firstName0: String?, lastName0: String?): String? {
        val firstName1 = firstName0?.replace("\\s*".toRegex(), "")
        val firstName = firstName1?.trim()
        val lastName1 = lastName0?.replace("\\s*".toRegex(), "")
        val lastName = lastName1?.trim()
        return when {
            (firstName.isNullOrEmpty() || firstName.isNullOrBlank())
                    && (lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> null
            (firstName.isNullOrEmpty() || firstName.isNullOrBlank())
                    && !(lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> lastName.toUpperCase().substring(0, 1)
            !(firstName.isNullOrEmpty() || firstName.isNullOrBlank())
                    && (lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> firstName.toUpperCase().substring(0, 1)
            !(firstName.isNullOrEmpty() || firstName.isNullOrBlank())
                    && !(lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> {
                val (fName, lName) = parseFullName("$firstName $lastName")
                "${fName?.substring(0, 1)?.toUpperCase()}${lName?.substring(0, 1)?.toUpperCase()}"
            }
            else -> throw IllegalArgumentException("Not parsable")
        }
    }

    fun pixels2Dp(cntx: Context, px: Int): Int {
        val displayMetrics = cntx.resources.displayMetrics
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun dp2Pixels(cntx: Context, dp: Float): Int {
        val displayMetrics = cntx.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun sp2Pixels(context: Context, i: Int): Int {
        return i * context.resources.displayMetrics.scaledDensity.toInt()
    }
}