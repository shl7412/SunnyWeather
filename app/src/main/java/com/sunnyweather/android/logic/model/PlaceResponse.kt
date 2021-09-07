package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @author shl
 * 按照API返回的JSON数据格式定义的数据类型和属性
 */

//请求状态和参数
data class PlaceResponse(val status: String, val places: List<Place>)

//请求城市名地理位置和详细地址
data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String//通过@SerializedName该注解让json字段与kotlin字段之间建立映射关系
)

//经纬度
data class Location(val lng: String, val lat: String)
