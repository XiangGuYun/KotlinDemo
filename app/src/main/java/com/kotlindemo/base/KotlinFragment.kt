package com.kotlindemo.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kotlindemo.base.utils.DensityUtils.Companion.dip2px
import com.kotlindemo.base.utils.DensityUtils.Companion.px2dip
import com.kotlindemo.base.utils.DensityUtils.Companion.px2sp
import com.kotlindemo.base.utils.DensityUtils.Companion.sp2px

open abstract class KotlinFragment: Fragment(),BaseInterface {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var viewInject = this::class.annotations[0] as LayoutId
        var view = inflater?.inflate(viewInject.id,container,false)
        init(view)
        return view
    }

    abstract fun init(view:View?)

    /**
     * 土司提示
     * @param isLong 是否显示更长时间
     */
    fun Any.tst(isLong: Boolean=false){
        if(isLong)
            Toast.makeText(activity,this.toString(),
                    Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(activity,this.toString(),
                    Toast.LENGTH_LONG).show()
    }

    /**
     * 尺寸单位转换
     */
    fun Number.px2dp():Int{
        return px2dip(activity,this.toFloat())
    }

    fun Number.dp2px():Int{
        return dip2px(activity,this.toFloat())
    }

    fun Number.sp():Int{
        return px2sp(activity,this.toFloat())
    }

    fun Number.px():Int{
        return sp2px(activity,this.toFloat())
    }

    /**
     * 获取屏幕宽高
     */
    fun Context.srnWidth():Int{
        return this.resources.displayMetrics.widthPixels
    }

    fun Context.srnHeight():Int{
        return this.resources.displayMetrics.heightPixels
    }


    override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
        // old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
        // 现在认为只要控件将Activity向上推的高度超过了1/5屏幕高，就认为软键盘弹起
        val keyHeight = activity.windowManager.defaultDisplay.height / 5
        // 阀值设置为屏幕高度的1/5
        if (oldBottom != 0 && bottom != 0 && oldBottom - bottom > keyHeight) {
            // 监听到软键盘弹起
            onKeyboardShow()
        } else if (oldBottom != 0 && bottom != 0
                && bottom - oldBottom > keyHeight) {
            // 监听到软件盘关闭
            onKeyboardHide()
        }
    }

    protected fun onKeyboardHide() {

    }

    protected fun onKeyboardShow() {

    }

}