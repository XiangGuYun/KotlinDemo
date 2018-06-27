package com.kotlindemo.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.kotlindemo.base.utils.*
import com.kotlindemo.base.utils.DensityUtils.Companion.dip2px
import com.kotlindemo.base.utils.DensityUtils.Companion.px2dip
import com.kotlindemo.base.utils.DensityUtils.Companion.px2sp
import com.kotlindemo.base.utils.DensityUtils.Companion.sp2px

/**
 * i want to create a strongest activity for base-using, so you can
 * write codes simply and gracefully as far as possible.
 */
abstract class KotlinActivity : AppCompatActivity(),BaseInterface{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewInject = this::class.annotations[0] as LayoutId
        setContentView(viewInject.id)
        init(savedInstanceState)
        actList.add(this)
    }

    companion object {
        //this list store all child activities
        var actList = ArrayList<Activity>()
    }


    override fun onDestroy() {
        actList.remove(this)
        super.onDestroy()
    }

    protected abstract fun init(bundle: Bundle?)

    /**
     * 土司提示
     * @param isLong 是否显示更长时间
     */
    fun Any.toast(isLong: Boolean=false){
        if(isLong)
            Toast.makeText(this@KotlinActivity,this.toString(),
                    Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this@KotlinActivity,this.toString(),
                    Toast.LENGTH_LONG).show()
    }

    /**
     * 尺寸单位转换
     */
    fun Number.px2dp():Int{
        return px2dip(this@KotlinActivity,this.toFloat())
    }

    fun Number.dp2px():Int{
        return dip2px(this@KotlinActivity,this.toFloat())
    }

    fun Number.sp():Int{
        return px2sp(this@KotlinActivity,this.toFloat())
    }

    fun Number.px():Int{
        return sp2px(this@KotlinActivity,this.toFloat())
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


    /**
     * Activity类扩展
     */
    fun Activity.go(cls:Class<Activity>,bundle: Bundle= Bundle()){
        startActivity(Intent(this,cls).putExtras(bundle))
    }

    override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
        // old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
        // 现在认为只要控件将Activity向上推的高度超过了1/5屏幕高，就认为软键盘弹起
        val keyHeight = this.windowManager.defaultDisplay.height / 5
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