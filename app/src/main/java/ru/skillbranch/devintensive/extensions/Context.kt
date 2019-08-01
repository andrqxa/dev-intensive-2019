package ru.skillbranch.devintensive.extensions

import android.content.Context

fun Context.pixels2Dp(px: Int): Int {
    val scale = this.resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

fun Context.dp2Pixels(dp: Int): Int {
    val scale = this.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun Context.sp2Pixels(sp: Int): Int {
    return sp * this.resources.displayMetrics.scaledDensity.toInt()
}