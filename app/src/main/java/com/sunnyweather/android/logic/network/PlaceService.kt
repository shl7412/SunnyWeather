package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeartherApplication
import com.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author shl
 * 访问城市搜索的API的Retrofit接口
 */

interface PlaceService {
    //利用@GET注解向指定位置发送get请求
    @GET("v2/place?token=${SunnyWeartherApplication.TOKEN}&lang=zh_CN")
    //@Query需要动态指定的参数
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}