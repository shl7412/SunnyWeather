package com.sunnyweather.android.logic.model

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.model
 * @ClassName: Weather
 * @Description: 封装Realtime和Daily对象
 * @Author: shl
 * @CreateDate: 2021/8/31 14:24
 * @UpdateUser:
 * @UpdateDate: 2021/8/31 14:24
 * @UpdateRemark:
 * @Version:
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)