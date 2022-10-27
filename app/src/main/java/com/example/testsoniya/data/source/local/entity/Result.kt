package com.example.testsoniya.data.source.local.entity

import androidx.room.*
import com.example.testsoniya.data.model.Location
import com.example.testsoniya.data.model.Origin
import com.example.testsoniya.data.source.local.converter.ResultTypeConverter

@Entity
//    (
//    primaryKeys = ["originId", "locationId","id"],
//    foreignKeys = [
//       ForeignKey(entity = Origin::class, parentColumns = ["id"], childColumns = ["locationId"]),
//       ForeignKey(entity = Location::class, parentColumns = ["id"], childColumns = ["locationId"]),
//    ])
//data class Result (
//    @PrimaryKey
//    val id: Long,
//    val name: String,
//    val status: String,
//    val species: String,
//    val type: String,
//    val gender: String,
//    val image: String,
//    val url: String,
//    val created: String
//)

data class Result (
    @PrimaryKey
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @TypeConverters(ResultTypeConverter::class)
    val origin: com.example.testsoniya.data.source.local.entity.Origin,
    @TypeConverters(ResultTypeConverter::class)
    val location: com.example.testsoniya.data.source.local.entity.Location,
    val image: String,
    @TypeConverters(ResultTypeConverter::class)
    val episode: List<String>,
    val url: String,
    val created: String
)

fun Result.toModel() = com.example.testsoniya.data.model.Result(id,name,status,species,type,gender,origin.toModel(),location.toModel(),image,episode,url,created)

//fun Result.toModel() = com.example.testsoniya.data.model.Result(id,name,status,species,type,gender,origin.toModel())
