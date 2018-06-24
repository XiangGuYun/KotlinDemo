package com.kotlindemo
import android.Manifest
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.kotlindemo.base.KotlinActivity

class MainActivity : KotlinActivity(){
    override fun layoutId(): Int { return R.layout.activity_main }

    lateinit var btn:Button

    override fun init(bundle: Bundle?) {
       reqPerm({},{},Manifest.permission.WRITE_EXTERNAL_STORAGE,
               Manifest.permission.CAMERA)
    }




}


