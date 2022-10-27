package com.example.testsoniya.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ResultAndOrigin(
    @Embedded val location: Location,
    @Relation(
        parentColumn = "id",
        entityColumn = "locationId"
    )
    val result: Result
)