package com.example.dinein.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TablesData(
    val `data`: List<Tables>
)
@Parcelize
data class Tables(
    val branch_id: Int,
    val created: String,
    val id: Int,
    val modified: String,
    val number: Int,
    val orders: List<Order>,
    val position: Int,
    val user_id: Int
): Parcelable {

}



@Parcelize
data class Order(
    val billing_address_id: Int,
    val branch_id: Int,
    val created: String,
    val discount: Int,
    val id: Int,
    val marketer_id: Int,
    val modified: String,
    val paymenttype_id: Int,
    val platform_id: Int,
    val service: Int,
    val subtotal: Int,
    val table_id: Int,
    val taxes: Int,
    val total: Int,
    val typeorder: String,
    val user_id: Int,
    val waiter_id: Int
): Parcelable {

}
