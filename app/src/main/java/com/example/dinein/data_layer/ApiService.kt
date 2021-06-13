package com.codesroots.mac.firstkotlon.DataLayer.ApiService


import com.example.dinein.models.Items
import com.example.dinein.models.TablesData
import com.example.dinein.models.User
import com.example.dinein.models.sub_categories
import io.reactivex.Observable
import retrofit2.http.*


interface APIServices {



@GET("Categories/getitemcategories.json")/*{company_id}*/
    fun GetData():
        Observable <sub_categories>
//// Table

    @GET("http://wokhouse.codesroots.com/api/restables/gettablesdata/2.json")/*{company_id}*/
    fun GetTablesData():
            Observable <TablesData>

    @GET("items/getitemsbytype/{id}/1.json")/*{company_id}*/
    fun GetItemsData(@Path("id") id: Int):
            Observable<Items>

    @FormUrlEncoded
    @POST("users/token.json")
    abstract fun userlogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<User>
    @FormUrlEncoded
    @POST("users/token.json")
    abstract fun LoginFirstTime(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<User>



}


