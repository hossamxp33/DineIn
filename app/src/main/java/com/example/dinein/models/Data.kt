package com.example.dinein.models

data class Data(
    val created: String,
    val id: Int,
    val modified: String,
    val name: String,
    val photo: String,
    val subcategories: List<Subcategory>,
    val type: String
)
data class Subcategory(
    val active: Int,
    val category_id: Int,
    val created: String,
    val id: Int,
    val modified: String,
    val name: String,
    val name_en: String,
    val photo: String
)