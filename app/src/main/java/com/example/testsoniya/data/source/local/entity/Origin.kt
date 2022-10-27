package com.example.testsoniya.data.source.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity
data class Origin(
    @PrimaryKey
    val url: String,
    val name: String,
    val resultId : Long = 0
)

fun Origin.toModel() = com.example.testsoniya.data.model.Origin(name,url)