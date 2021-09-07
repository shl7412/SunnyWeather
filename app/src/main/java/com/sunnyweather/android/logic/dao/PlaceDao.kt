package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeartherApplication
import com.sunnyweather.android.logic.model.Place

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.logic.dao
 * @ClassName: PlaceDao
 * @Description: 使用SharedPreferences存储数据
 * @Author: shl
 * @CreateDate: 2021/9/6 9:06
 * @UpdateUser:
 * @UpdateDate: 2021/9/6 9:06
 * @UpdateRemark:
 * @Version:
 */
object PlaceDao {

    fun savePlace(place: Place) {
        sharePreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        val placeJson = sharePreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharePreferences().contains("place")

    private fun sharePreferences() =
        SunnyWeartherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}