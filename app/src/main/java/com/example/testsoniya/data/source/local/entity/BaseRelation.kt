package com.example.testsoniya.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BaseRelation(
    @Embedded val result: Result,
    @Relation(
        parentColumn = "id",
        entityColumn = "resultId"
    )
    val location: Location,

    @Relation(
        parentColumn = "id",
        entityColumn = "resultId"
    )
    val origin: Origin,

    @Relation(
        parentColumn = "id",
        entityColumn = "resultId"
    )
    val episode: List<Episode>,
)

//fun RelationResult.toModel() = Result(
//    result.id,
//    result.name,
//    result.status,
//    result.species,
//    result.type,
//    result.gender,
//    origin.toModel(),
//    location.toModel(),
//    result.image,
//    arrayListOf(),
//    result.url,
//    result.created
//)