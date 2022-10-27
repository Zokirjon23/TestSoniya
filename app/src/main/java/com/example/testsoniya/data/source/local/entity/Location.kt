package com.example.testsoniya.data.source.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Location (
    @PrimaryKey
    val url: String,
    val name: String,
    val resultId : Long = 0,
)

fun Location.toModel() = com.example.testsoniya.data.model.Location(name,url)