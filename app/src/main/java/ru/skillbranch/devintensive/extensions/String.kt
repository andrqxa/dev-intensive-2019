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
//    val str = this.trim()
//    val length = when{
//        len <=0 -> 0
//        len > str.length -> str.length
//        else -> len
//    }
//    val result0 = str.substring(0 until length)
//    val result = if(result0.last() == ' ') result0.substring(0 until result0.length) else result0
//    return "${if(result.length <= length) result else "$result..."}"
}

fun String.stripHtml(): String {
    return this
}