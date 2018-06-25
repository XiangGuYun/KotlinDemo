package com.kotlindemo.base.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.view.LayoutInflater

interface ContextUtils {

    val Context.inflater: LayoutInflater get()=LayoutInflater.from(this)

    fun FragmentActivity.fragUtils(frag: Fragment, rootId:Int=ResUtils.getId(this,"root")):FragmentUtils{
        return FragmentUtils(this, frag, rootId)
    }

    fun FragmentActivity.fragUtils(list: ArrayList<Fragment>,rootId:Int=ResUtils.getId(this,"root")):FragmentUtils{
        return FragmentUtils(this, list, rootId)
    }

    fun <T:Fragment> FragmentActivity.fragPagerUtils():FragPagerUtils<T>{
        return FragPagerUtils(this)
    }

    fun <T:Fragment> FragmentActivity.fragPagerUtils(vp:ViewPager,fragments:ArrayList<T>):FragPagerUtils<T>{
        return FragPagerUtils<T>(this,vp,fragments)
    }

}