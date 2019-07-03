package ru.skillbranch.devintensive.models

class UserView(
    val id: String,
    var fullName: String,
    var nickName: String,
    var avatar: String? = null,
    var status: String? = "offline",
    var initials: String?
)