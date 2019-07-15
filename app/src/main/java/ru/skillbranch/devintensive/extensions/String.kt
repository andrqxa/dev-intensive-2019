package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.Bender
import ru.skillbranch.devintensive.models.Bender.Question.*

fun String.truncate(len: Int = 16): String {
    val str = this.trim()
    return when {
        len < 0 -> ""
        len >= str.length -> str
        len in 0 until str.length -> {
            val result0 = str.substring(0 until len)
            val result = if (result0.last() == ' ') result0.substring(0 until result0.length - 1) else result0
            "$result..."
        }
        else -> ""
    }
}

fun String.stripHtml(): String {
    val regCRLF = """\r*\n""".toRegex()
    val regexAmp = """&[a-zA-z0-9#]+;""".toRegex()
    val regexTag = """<[a-zA-Z0-9="\s.,\/':;-]*>""".toRegex()
    val regBlank = """\s{2,}""".toRegex()
    val res0 = this.replace(regCRLF, "~")
    val res1 = res0.replace(regexAmp, "")
    val res2 = res1.replace(regexTag, "")
    val res3 = res2.replace(regBlank, " ")
    return res3.replace("~", "\n")
}

fun String.answerValidation(question: Bender.Question): String {
    return when (question) {
        NAME -> {
            val result: String
            val regFirstUpperCase = """[A-ZА-Я]+[\wа-яА-Я\s]*""".toRegex()
            result = if (this.matches(regFirstUpperCase)) {
                this
            } else {
                "Имя должно начинаться с заглавной буквы"
            }
            result
        }
        PROFESSION -> {
            val result: String
            val regFirstLowCase = """[a-zа-я]+[\wа-яА-Я\s.,]*""".toRegex()
            result = if (this.matches(regFirstLowCase)) {
                this
            } else {
                "Профессия должна начинаться со строчной буквы"
            }
            result
        }
        MATERIAL -> {
            val result: String
            val regNotDigit = """\d""".toRegex()
            result = if (!regNotDigit.containsMatchIn(this)) {
                this
            } else {
                "Материал не должен содержать цифр"
            }
            result
        }
        BDAY -> {
            val result: String
            val regOnlyDigits = """\d+""".toRegex()
            result = if (this.matches(regOnlyDigits)) {
                this
            } else {
                "Год моего рождения должен содержать только цифры"
            }
            result
        }
        SERIAL -> {
            val result: String
            val regOnlySevenDigit = """\d{7}""".toRegex()
            result = if (this.matches(regOnlySevenDigit)) {
                this
            } else {
                "Серийный номер содержит только цифры, и их 7"
            }
            result
        }
        IDLE -> {
            this
        }
    }
}