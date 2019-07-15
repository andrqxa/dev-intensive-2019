package ru.skillbranch.devintensive.extensions

import android.R
import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

const val HEIGHT = 200

fun Activity.hideKeyboard(): Unit {
    // Check if no view has focus:
    val view = this.currentFocus
    view?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
    }
}

private fun Activity.heightOfView(): Int {
    val r = Rect()
    //r will be populated with the coordinates of your view that area still visible.

    val activityRoot = findViewById<ViewGroup>(R.id.content).getChildAt(0)
    activityRoot.getWindowVisibleDisplayFrame(r)
    return activityRoot.rootView.height - (r.bottom - r.top)
}

fun Activity.isKeyboardOpen() = heightOfView() > HEIGHT


fun Activity.isKeyboardClosed() = heightOfView() <= HEIGHT