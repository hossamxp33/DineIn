package com.example.dinein.models

data class Tax(
    var created: Any,
    var id: Int,
    var modified: String,
    var name: String,
    var percentage: Int,
    var service: Int
)