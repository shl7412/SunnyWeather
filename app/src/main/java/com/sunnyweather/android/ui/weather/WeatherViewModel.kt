package com.sunnyweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Location

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.ui.weather
 * @ClassName: WeatherViewModel
 * @Description:将天气数据返回到界面并进行缓存
 * @Author: shl
 * @CreateDate: 2021/9/5 17:30
 * @UpdateUser:
 * @UpdateDate: 2021/9/5 17:30
 * @UpdateRemark:
 * @Version:
 */
class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    //对显示在界面上的数据进行缓存
    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    //将传入的参数值赋值给searchLiveData对象,并使用Transformations的switchMap()方法来观察该对象(LiveData对象的转换)
    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refleshWearther(
            location.lng,
            location.lat
        )
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

}