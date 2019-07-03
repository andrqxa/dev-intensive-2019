package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(inputFullName: String?): Pair<String?, String?> {
        val regex = Regex("""\s*""")
        val name1 = inputFullName?.replace("\\s+".toRegex(), " ")
        val fullName = name1?.trim()
        if (fullName.isNullOrEmpty() || regex.matches(fullName)) {
            return null to null
        }
        val parts: List<String> = fullName.split(" ")
        val firstName = parts.getOrNull(0)
        val lastName = parts.getOrNull(1)
        return firstName to lastName
    }
}