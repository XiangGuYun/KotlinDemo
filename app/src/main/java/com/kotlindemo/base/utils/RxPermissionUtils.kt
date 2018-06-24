package com.kotlindemo.base.utils

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions


interface RxPermissionUtils {

    fun Activity.reqPerm(yes:()->Unit,no:()->Unit,vararg perm:String){
        RxPermissions(this)
                .request(*perm)
                .subscribe { granted ->
                    if (granted) {
                        yes.invoke()
                    } else {
                        no.invoke()
                    }
                }
    }

}