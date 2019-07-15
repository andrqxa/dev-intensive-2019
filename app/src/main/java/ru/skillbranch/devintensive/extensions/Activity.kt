package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.app.Activity.*
import android.content.Context
import android.graphics.Rect
import android.view.inputmethod.InputMethodManager
import android.opengl.ETC1.getHeight
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.R



fun Activity.hideKeyboard(): Unit {
    // Check if no view has focus:
    val view = this.currentFocus
    view?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    return true
}

fun Activity.isKeyboardClosed(): Boolean {
    return false
}

//fun Activity.isKeyboardOpen(): Boolean {
//    val activityRootView = activityRoot
//    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
//        override fun onGlobalLayout() {
//            val heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight()
//            if (heightDiff > dpToPx(this, 200)) { // if more than 200 dp, it's probably a keyboard...
//                // ... do something here
//            }
//        }
//    })
//
//
//
//    val actionRootView = activityRoor
//}

//fun Activity.isKeyboardClosed(): Boolean {
//    return !Activity.isKeyboardOpen()
//}



//final View activityRootView = findViewById(R.id.activityRoot);
//activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//    @Override
//    public void onGlobalLayout() {
//        Rect r = new Rect();
//        //r will be populated with the coordinates of your view that area still visible.
//        activityRootView.getWindowVisibleDisplayFrame(r);
//
//        int heightDiff = activityRootView.getRootView().getHeight() - (r.bottom - r.top);
//        if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
//            ... do something here
//        }
//    }
//});

