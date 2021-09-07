package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.model
 * @ClassName: RealtimeResponse
 * @Description: 实时天气信息数据类json格式如下:
    status: ok
    result:
        realtime:                                   # 实况模块返回状态
            temperature: 28.0                                  # 温度
            skycon: RAIN                                       # 主要天气现象
            air_quality:
                aqi:
                    chn: 8                                     # AQI（中国标准）
 * @Author:shl
 * @CreateDate: 2021/8/31 13:34
 * @UpdateUser:
 * @UpdateDate: 2021/8/31 13:34
 * @UpdateRemark:
 * @Version:
 */
data class RealtimeResponse(val status: String, val result: Result) {

    data class Result(val realtime: Realtime)

    data class Realtime(
        val temperature: Float,
        val skycon: String,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}
