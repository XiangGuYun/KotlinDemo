package com.kotlindemo.base.utils

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ActionMenuView
import android.widget.FrameLayout

interface ViewUtils {

    val MP:Int get() = ViewGroup.LayoutParams.MATCH_PARENT
    val WC:Int get() = ViewGroup.LayoutParams.WRAP_CONTENT

    /**
     * View类扩展
     */
    fun <T:View> T.click(function: () -> Unit):T {
        setOnClickListener { function.invoke() }
        return this
    }

    fun <T:View> T.alpha(a:Float):T{
        alpha = a
        return this
    }

    fun <T:View> T.background(b:Drawable):T{
        background = b
        return this
    }

    fun <T:View> T.lp(params:ViewGroup.LayoutParams):T{
        layoutParams = params
        return this
    }

    fun  <T:View> T.child(childId:Int):T{
            return findViewById(childId)
    }

    data class SizeMode(var widthSize:Int,var widthMode:Int,var heightSize:Int,
                        var heightMode:Int)

    fun View.getSizeMode(widthSpec:Int,heightSpec:Int):SizeMode{
        var widthSize = View.MeasureSpec.getSize(widthSpec)
        var widthMode = View.MeasureSpec.getMode(widthSpec)
        var heightSize = View.MeasureSpec.getSize(heightSpec)
        var heightMode = View.MeasureSpec.getMode(heightSpec)
        return SizeMode(widthSize,widthMode,heightSize,heightMode)
    }

    fun View.getTypeArray(styleId:IntArray,attr:AttributeSet):TypedArray{
        return context.obtainStyledAttributes(attr,styleId)
    }

    fun View.getTypeArray(styleId:IntArray):TypedArray{
        return context.obtainStyledAttributes(styleId)
    }

}