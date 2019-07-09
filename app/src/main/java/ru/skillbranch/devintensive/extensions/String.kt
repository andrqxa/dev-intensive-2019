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