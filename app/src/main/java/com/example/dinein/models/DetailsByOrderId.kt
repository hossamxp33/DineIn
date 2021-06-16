package com.example.dinein.models

data class DetailsByOrderId(
    var query: List<Query>
)

data class Query(
    var billing_address_id: Int,
    var branch_id: Int,
    var created: String,
    var discount: Int,
    var id: Int,
    var marketer_id: Int,
    var modified: String,
    var orderdetails: List<Orderdetail>,
    var paymenttype_id: Int,
    var platform_id: Int,
    var service: Int,
    var subtotal: Int,
    var table_id: Int,
    var taxes: Int,
    var total: Int,
    var typeorder: String,
    var user: UserX,
    var user_id: Int,
    var waiter_id: Int
)
data class Orderdetail(
    var created: String,
    var id: Int,
    var item: Item,
    var item_id: Int,
    var itemamount: Int,
    var itemtotal: Int,
    var modified: String,
    var order_id: Int
)