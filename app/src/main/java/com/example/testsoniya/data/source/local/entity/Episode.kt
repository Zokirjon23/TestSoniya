package com.example.testsoniya.data.source.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Episode(
    @PrimaryKey
    val episode: String,
    val resultId: Long,
)