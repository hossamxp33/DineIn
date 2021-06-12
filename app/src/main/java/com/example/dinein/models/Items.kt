package com.example.dinein.models

data class Items(
    val `data`: List<DataX>
)

data class DataX(
    val created: String,
    val description: String,
    val id: Int,
    val item_photo: List<Any>,
    val modified: String,
    val name: String,
    val name_en: String,
    val photo: String,
    val price: Int,
    val subcategory_id: Int,
    val tax: Tax,
    val tax_id: Int
)
data class Tax(
    val created: Any,
    val id: Int,
    val modified: String,
    val name: String,
    val percentage: Int,
    val service: Int
)