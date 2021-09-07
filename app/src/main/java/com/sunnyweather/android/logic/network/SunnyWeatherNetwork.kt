package com.sunnyweather.android.logic.network

import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import java.lang.RuntimeException
import kotlin.coroutines.resumeWithException

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.network
 * @ClassName: SunnyWeatherNetwork
 * @Description: 统一的数据源访问入口,对所有网络请求的API进行封装
 * @Author: shl
 * @CreateDate: 2021/8/30 7:57
 * @UpdateUser:
 * @UpdateDate: 2021/8/30 7:57
 * @UpdateRemark:
 * @Version: 1.0
 */
object SunnyWeatherNetwork {

    //创建WeartherService接口的动态代理对象
    private val weartherService = ServiceCreator.create(WeatherService::class.java)

    //调用WeartherService接口的getRealtimeWearther()方法请求获取实时天气
    suspend fun getRealtimeWearther(lng: String, lat: String) =
        weartherService.getRealtimeWearther(lng, lat).await()

    //调用WeartherService接口的getDailyWearther()方法请求获取未来几天天气
    suspend fun getDailyWearther(lng: String, lat: String) =
        weartherService.getDailyWearther(lng, lat).await()

    //创建了PlaceService接口的动态代理对象
    private val placeService = ServiceCreator.create<PlaceService>()

    //调用PlaceService接口的searchPlaces()方法发起搜索城市数据请求(利用await()函数将该函数声明成挂起函数)
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    //使用await()方法在Retrofit发起网络请求时阻塞当前协程直到服务器响应,然后返回
    private suspend fun <T> Call<T>.await(): T {
        return suspendCancellableCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null)
                        continuation.resume(body)
                    else
                        continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}