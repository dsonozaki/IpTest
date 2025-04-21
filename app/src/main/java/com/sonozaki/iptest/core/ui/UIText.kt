package com.sonozaki.iptest.core.ui

import android.content.Context

class UIText(val id: Int, vararg val args: Any) {
    fun asString(context: Context): String {
        return context.getString(id, *args)
    }
}