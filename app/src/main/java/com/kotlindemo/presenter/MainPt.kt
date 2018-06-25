package com.kotlindemo.presenter

import com.kotlindemo.base.KotlinActivity
import com.kotlindemo.view.IMain

class MainPt(val act: KotlinActivity) {

    val iMain: IMain = act as IMain

    /**
     * 请求数据
     */
    fun requestData() {
        Thread{
            iMain.show(act.getUrlContent("https://www.baidu.com"))
        }.start()
    }


}