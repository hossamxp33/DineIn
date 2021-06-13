package com.example.dinein.models

data class TablesData(
    val `data`: List<Tables>
)
data class Tables(
    val branch_id: Int,
    val created: String,
    val id: Int,
    val modified: String,
    val number: Int,
    val orders: List<Any>,
    val position: Int,
    val user_id: Int
)