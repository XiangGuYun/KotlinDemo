package com.kotlindemo.base.utils

import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ActionMenuView
import android.widget.FrameLayout

interface ViewUtils {

    val MP:Int get() = ViewGroup.LayoutParams.MATCH_PARENT

    /**
     * View类扩展
     */
    fun View.click(function: () -> Unit):View {
        setOnClickListener { function.invoke() }
        return this
    }

    fun View.alpha(a:Float):View{
        alpha = a
        return this
    }

    fun View.background(b:Drawable):View{
        background = b
        return this
    }

    fun View.lp(params:ViewGroup.LayoutParams):View{
        layoutParams = params
        return this
    }


}