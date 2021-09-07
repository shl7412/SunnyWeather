package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author shl
 * 为项目提供获取全局Context方式
 */

class SunnyWeartherApplication : Application() {

    //定义一个单例至全项目中只会存在一份context实例
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        //天气预报API key值
        const val TOKEN = "JV1Jb93os3QZuApu"
    }

    //重写onCreate方法,默认调用了getApplicationContext()并将返回值赋给context使外部可以以静态变量的方式获取Context对象
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}