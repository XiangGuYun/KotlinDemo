package com.kotlindemo.base.utils

import android.app.Activity
import android.util.Log
import android.view.View
import com.kotlindemo.base.KotlinActivity
import java.lang.reflect.Method
import java.lang.reflect.Modifier


@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME) //这一行也可以省略
annotation class ViewInject(val id:Int)

object FindId {

    fun findByid(activity: KotlinActivity) {

        //获取每个activity对应的类类型
        val aClass = activity.javaClass
        //获取该类型中所有的属性信息
        val clazzs = aClass.declaringClass

        Log.d("def", "size is ${clazzs == null}")

        //遍历所以得属性
//        for (clazz in clazzs) {
//            //判断该属性上是否有ViewInject这个注解的类类型
//            val viewid = clazz.getAnnotation(ViewInject::class.java)
//            //如果有就会拿到对应的注解信息，没有就会返回空
//
//            if (viewid != null) {
//                //判断该属性是否是属于View的子类类型，并且不是静态属性
//                try {
//                    //拿到注解上的ID
//                    val id = viewid!!.id
//                    Log.d("def","id is $id")
//                    //拿到该类中的findViewById方法，对应传参为int类型
//                    var byId: Method? = aClass.getMethod("setContentView", Int::class.javaPrimitiveType)
//                    //然后执行该findViewById的方法
//                    val invoke = byId!!.invoke(activity, id)
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//
//            }
//
//        }

    }
}
