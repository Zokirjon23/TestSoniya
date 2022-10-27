package com.example.testsoniya.data.model

data class Origin(
    val name: String,
    val url: String
)

fun Origin.toEntity() = com.example.testsoniya.data.source.local.entity.Origin(name,url)
