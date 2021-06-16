package com.example.dinein.models

data class AllData(
    val `data`: List<SearchData>
)
data class SearchData(
    val created: String,
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val name_en: String,
    val photo: String,
    val price: Int,
    val subcategory_id: Int,
    val tax: Tax,
    val tax_id: Int
)

