package com.kotlindemo.base.utils

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions


interface RxPermissionUtils {

    fun Activity.reqPerm(yes:()->Unit,no:()->Unit,vararg perm:String){
        var rx = RxPermissions(this)
//                .request(*perm)
//                .request(*perm)
//                .subscribe { granted ->
//                    if (granted) {
//                        yes.invoke()
//                    } else {
//                        no.invoke()
//                    }
//                }
    }

}