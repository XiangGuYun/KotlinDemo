package com.kotlindemo.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kotlindemo.base.utils.*


abstract class KotlinActivity : AppCompatActivity(), SPUtils, TextViewUtils, StringUtils, BundleUtils,
        DensityUtils, ViewUtils,CollectUtils, BmpUtils,RxPermissionUtils, NetUtils,
        RVInterface{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutId()
        setContentView(layoutId())
        init(savedInstanceState)
    }

    fun Int.view():ViewGroup {
        return findViewById(this)
    }

    abstract fun layoutId(): Int

    abstract fun init(bundle: Bundle?)

    val Context.SDPATH: String
        get() = Environment.getExternalStorageDirectory().toString()

    /**
     * 土司提示
     * @param isLong 是否显示更长时间
     */
    fun Any.t(isLong: Boolean=false){
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

    fun Number.px2sp():Int{
        return px2sp(this@KotlinActivity,this.toFloat())
    }

    fun Number.sp2px():Int{
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


}