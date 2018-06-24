package com.kotlindemo.base.utils

import android.graphics.Color
import android.text.Html
import android.widget.TextView

interface TextViewUtils {

    fun <T:TextView> T.text(text:String): T {
        this.text = text
        return this
    }

    fun TextView.color(color:Int): TextView {
        setTextColor(color)
        return this
    }

    fun TextView.color(color:String): TextView {
        setTextColor(Color.parseColor(color))
        return this
    }

    fun TextView.size(size:Int): TextView {
        textSize = size.toFloat()
        return this
    }

    fun TextView.html(text:String):TextView{
        setText(Html.fromHtml(text))
        return this
    }

}