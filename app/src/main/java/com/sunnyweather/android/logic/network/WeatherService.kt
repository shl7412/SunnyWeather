package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.http.GET
import com.sunnyweather.android.SunnyWeartherApplication
import com.sunnyweather.android.logic.model.DailyResponse
import com.sunnyweather.android.logic.model.RealtimeResponse
import retrofit2.http.Path

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.network
 * @ClassName: WeatherService
 * @Description: 访问天气API的retrofit接口
 * @Author: shl
 * @CreateDate: 2021/8/31 14:27
 * @UpdateUser:
 * @UpdateDate: 2021/8/31 14:27
 * @UpdateRemark:
 * @Version:
 */
interface WeatherService {

    //以下两方法用于获取相应的天气信息使用@GET注解声明要访问的API 使用@Path注解来向接口中动态传入经纬度
    @GET("v2.5/${SunnyWeartherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWearther(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeartherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWearther(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

}