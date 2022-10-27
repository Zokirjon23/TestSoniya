package com.example.testsoniya.data.model

data class Location (
    val name: String,
    val url: String
)

fun Location.toEntity() = com.example.testsoniya.data.source.local.entity.Location(name,url)