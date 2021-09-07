package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.network
 * @ClassName: ServiceCreator
 * @Description: retrofit构建器为了能调用相应的功能API创建相应的Retrofit对象(相应的服务动态代理对象)
 * @Author: shl
 * @CreateDate: 2021/8/30 8:00
 * @UpdateUser:
 * @UpdateDate: 2021/8/30 8:00
 * @UpdateRemark:
 * @Version:
 */
object ServiceCreator {

    //指定Retrofit的根路径
    private const val BASE_URL = "https://api.caiyunapp.com"

    //构建一个Retrofit对象
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)

}