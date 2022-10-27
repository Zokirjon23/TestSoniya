package com.example.testsoniya.data.model


data class Result (
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : java.io.Serializable

fun Result.toModel() = com.example.testsoniya.data.source.local.entity.Result(id, name, status, species, type, gender, origin.toEntity(), location.toEntity(), image, episode, url, created)