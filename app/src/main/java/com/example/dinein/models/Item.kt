package com.example.dinein.models

data class Item(
    var created: String,
    var description: String,
    var id: Int,
    var modified: String,
    var name: String,
    var name_en: String,
    var photo: String,
    var price: Int,
    var subcategory_id: Int,
    var tax: Tax,
    var tax_id: Int
)