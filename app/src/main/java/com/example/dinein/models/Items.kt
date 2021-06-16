package com.example.dinein.models

data class Items(
    val `data`: List<DataX>
)

data class DataX(
    val created: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val item_photo: List<Any>? = null,
    val modified: String? = null,
    val name: String? = null,
    val name_en: String? = null,
    val photo: String? = null,
    val price: Int? = null,
    val subcategory_id: Int? = null,
    val tax: Tax? = null,
    val tax_id: Int? = null
)
