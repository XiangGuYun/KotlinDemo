package com.kotlindemo.base.utils

import com.mylibrary.RVUtils
import com.yuyh.easyadapter.recyclerview.EasyRVHolder

interface RVInterface {

    fun <T> RVUtils.setAdapter(data:ArrayList<T>,
                               fun1:(holder: EasyRVHolder, pos:Int)->Unit,
                               itemId:Int):RVUtils{
        adapter(data, RVUtils.onBindData(fun1),
                RVUtils.SetMultiCellView { 0 },itemId)
        return this
    }

    fun <T> RVUtils.setMultiAdapter(data:ArrayList<T>,
                                    fun1:(holder: EasyRVHolder, pos:Int)->Unit,
                                    fun2:(Int)->Int,
                                    vararg itemId:Int):RVUtils{
        adapter(data, RVUtils.onBindData(fun1),
                RVUtils.SetMultiCellView(fun2),*itemId)
        return this
    }


}