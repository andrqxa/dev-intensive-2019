package ru.skillbranch.devintensive.extensions

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
    val regex = """^\s*<.*\s*>([a-zA-Zа-яА-Я0-9\-.,!?\s'":]+)<\s*.*\s*>""".toRegex()
    val matchResult = regex.find(this)
//    val matchedResults = Regex(pattern = """^.*\s*>([a-zA-Zа-яА-Я0-9\-.,!?\s'":]+)<\s*.*$""").findAll(input = this)
//    val result = StringBuilder()
//    for (matchedText in matchedResults) {
//        result.append(matchedText.value + " ")
//    }
    val resultList = matchResult?.groupValues
    val reg = """\s{2,}""".toRegex()
    val result = resultList?.get(1)?.replace(reg, " ")
    return result ?: ""
}