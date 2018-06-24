package com.kotlindemo.base.utils

import android.bluetooth.BluetoothA2dp
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

/**
 * 绘图工具类
 */
interface PaintUtils {
    //白色
    val WHITE:Int get() = Color.parseColor("#ffffff")
    val BLUE:Int get() = Color.BLUE

    fun Paint.color(color:Int):Paint{
        setColor(color)
        return this
    }

    fun Paint.color(color:String):Paint{
        setColor(Color.parseColor(color))
        return this
    }

    fun Paint.antiAlias(anti:Boolean):Paint{
        isAntiAlias = anti
        return this
    }

    fun Paint.dither(dither:Boolean):Paint{
        isDither = dither
        return this
    }

    fun Paint.isStroke(stroke:Boolean):Paint{
        style = if(stroke)
            Paint.Style.STROKE
        else
            Paint.Style.FILL
        return this
    }

    fun Paint.strokeWidth(width:Number):Paint{
        strokeWidth = width.toFloat()
        return this
    }
    fun Paint.strokeJoin(join:Paint.Join):Paint{
        strokeJoin = join
        return this
    }


    fun Paint.textSize(size:Float):Paint{
        textSize =  size
        return this
    }

    fun Paint.reset(size:Float):Paint{
        reset()
        return this
    }

    fun Path.move_to(x:Number,y:Number):Path{
        moveTo(x.toFloat(),y.toFloat())
        return this
    }

    fun Path.line_to(x:Number,y:Number):Path{
        lineTo(x.toFloat(),y.toFloat())
        return this
    }

}