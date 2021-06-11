package com.codesroots.mac.firstkotlon.DataLayer.ApiService


import com.example.dinein.models.Data
import com.example.dinein.models.item_categories
import io.reactivex.Observable
import retrofit2.http.*


interface APIServices {



@GET("Categories/getitemcategories.json")/*{company_id}*/
    fun GetData():
        Observable <item_categories>


}


