package com.example.testsoniya.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class EpisodeAndResult(
    @Embedded val result: Result,
    @Relation(
        parentColumn = "id",
        entityColumn = "episodeId"
    )
    val episodes: List<Episode>


)