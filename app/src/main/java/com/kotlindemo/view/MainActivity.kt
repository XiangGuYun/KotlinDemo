package com.kotlindemo.view
import android.os.Bundle
import com.kotlindemo.R
import com.kotlindemo.base.KotlinActivity
import com.kotlindemo.base.LayoutId
import com.kotlindemo.presenter.MainPt
import kotlinx.android.synthetic.main.activity_main.*

@LayoutId(R.layout.activity_main)
class MainActivity : KotlinActivity(), IMain{
    override fun show(msg: String) {
        runOnUiThread {tvTest1.text(msg)}
    }

    override fun init(bundle: Bundle?) {
        val mainPt = MainPt(this)
        tvTest1.setTextColor("#ff12ea".color())
        mainPt.requestData()
    }

}

interface IMain{
    fun show(msg:String)
}



