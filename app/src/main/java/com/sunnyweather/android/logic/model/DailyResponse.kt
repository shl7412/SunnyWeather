package com.sunnyweather.android.logic.model

import androidx.work.Data
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.model
 * @ClassName: DailyResponse
 * @Description:获取天级天气预报 格式如下:
    status: ok                                         #返回状态
    result:
        daily:
            skycon:                                         #天气状态
                - date: 2020-04-07T00:00+08:00
                value: CLOUDY
            temperature:                                    #温度，最大值，平均值，最小值
                max: 20.0
                min: 17.0
            life_index:
                carWashing:                                   #洗车指数
                    desc: 较不适宜
                coldRisk:                                     #感冒指数
                    desc: 易发
                dressing:                                     #穿衣指数
                    desc: 凉爽
                ultraviolet:                                  #紫外线指数
                    desc: 最弱
 * @Author:shl
 * @CreateDate: 2021/8/31 13:50
 * @UpdateUser:
 * @UpdateDate: 2021/8/31 13:50
 * @UpdateRemark:
 * @Version:
 */
data class DailyResponse(val status: String, val result: Result) {
    data class Result(val daily: Daily)

    data class Daily(
        val skycon: List<Skycon>,
        val temperature: List<Temperature>,
        @SerializedName("life_index") val lifeIndex: LifeIndex
    )

    data class Skycon(val date: Date, val value: String)

    data class Temperature(val max: Float, val min: Float)

    data class LifeIndex(
        val carWashing: List<LifeDescription>,
        val coldRisk: List<LifeDescription>,
        val dressing: List<LifeDescription>,
        val ultraviolet: List<LifeDescription>
    )

    data class LifeDescription(val desc: String)
}
