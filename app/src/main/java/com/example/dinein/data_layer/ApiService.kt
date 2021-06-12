package com.codesroots.mac.firstkotlon.DataLayer.ApiService


import com.example.dinein.models.Items
import com.example.dinein.models.sub_categories
import io.reactivex.Observable
import retrofit2.http.*


interface APIServices {



@GET("Categories/getitemcategories.json")/*{company_id}*/
    fun GetData():
        Observable <sub_categories>

    @GET("items/getitemsbytype/{id}/1.json")/*{company_id}*/
    fun GetItemsData(@Path("id") id: Int):
            Observable<Items>

}


