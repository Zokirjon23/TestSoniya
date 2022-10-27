package com.example.testsoniya.data.source.local.converter

import androidx.room.TypeConverter
import com.example.testsoniya.data.source.local.entity.Location
import com.example.testsoniya.data.source.local.entity.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ResultTypeConverter {

    @TypeConverter
    fun originToString(origin: Origin) : String{
        val gson = Gson()
        return gson.toJson(origin)
    }

    @TypeConverter
    fun jsonToOrigin(json : String) : Origin{
        val gson = Gson()
        return gson.fromJson(json,Origin::class.java)
    }

    @TypeConverter
    fun locationToString(location: Location) : String{
        val gson = Gson()
        return gson.toJson(location)
    }

    @TypeConverter
    fun locationToOrigin(json : String) : Location{
        val gson = Gson()
        return gson.fromJson(json,Location::class.java)
    }

    @TypeConverter
    fun episodesToString(list: List<String>) : String{
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun jsonToEpisodes(json : String) : List<String>{
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json,type)
    }
}