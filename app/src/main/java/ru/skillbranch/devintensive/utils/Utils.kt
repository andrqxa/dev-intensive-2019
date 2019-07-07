package ru.skillbranch.devintensive.utils

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

    fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName0: String?, lastName0: String?): String? {
        val firstName1 = firstName0?.replace("\\s*".toRegex(), "")
        val firstName = firstName1?.trim()
        val lastName1 = lastName0?.replace("\\s*".toRegex(), "")
        val lastName = lastName1?.trim()
        return when {
            (firstName.isNullOrEmpty() || firstName.isNullOrBlank()) && (lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> null
            (firstName.isNullOrEmpty() || firstName.isNullOrBlank()) && !(lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> lastName.toUpperCase().substring(
                0,
                1
            )
            !(firstName.isNullOrEmpty() || firstName.isNullOrBlank()) && (lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> firstName.toUpperCase().substring(
                0,
                1
            )
            !(firstName.isNullOrEmpty() || firstName.isNullOrBlank()) && !(lastName.isNullOrEmpty() || lastName.isNullOrBlank()) -> {
                val (fName, lName) = parseFullName("$firstName $lastName")
                "${fName?.substring(0, 1)?.toUpperCase()}${lName?.substring(0, 1)?.toUpperCase()}"
            }
            else -> throw IllegalArgumentException("Not parsable")
        }
    }
}