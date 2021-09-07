package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place
import java.util.ArrayList

/**
 *
 * @ProjectName: SunnyWeather
 * @Package: com.sunnyweather.android.ui.place
 * @ClassName: PlaceViewModel
 * @Description: 将城市数据返回到界面并进行缓存
 * @Author: shl
 * @CreateDate: 2021/8/30 9:12
 * @UpdateUser:
 * @UpdateDate: 2021/8/30 9:12
 * @UpdateRemark:
 * @Version:
 */
class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    //对界面上显示的城市数据进行缓存
    val placeList = ArrayList<Place>()

    //将传入的参数值赋值给searchLiveData对象,并使用Transformations的switchMap()方法来观察该对象(LiveData对象的转换)
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place)=Repository.savePlace(place)

    fun getSavedPlace()=Repository.getSavedPlace()

    fun isPlaceSaved()=Repository.isPlaceSaved()

}