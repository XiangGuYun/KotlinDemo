package com.kotlindemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import com.kotlindemo.base.DrawView
import com.kotlindemo.base.utils.PaintUtils
import com.kotlindemo.base.utils.StringUtils

class SineView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        DrawView(context, attrs, defStyleAttr),StringUtils,PaintUtils {

    var x:Int = 0
    var y:Int = 0
    var path:Path ?= null
    var paint:Paint ?=null

    init {
        path = Path().move_to(0, height/2)
        paint = Paint().color(BLUE).isStroke(true)
                .strokeWidth(10).strokeJoin(Paint.Join.ROUND)
    }

    override fun drawing(canvas: Canvas) {
        canvas.drawColor(WHITE)
        x+=1
        y = (100*Math.sin(x*2*Math.PI/180)+400).toInt()
        canvas.drawPath(path!!.line_to(x,y), paint)
    }

}