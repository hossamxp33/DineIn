package com.codesroots.mac.firstkotlon.DataLayer.ApiService


import com.example.dinein.models.*
import io.reactivex.Observable
import retrofit2.http.*


interface APIServices {



@GET("Categories/getitemcategories.json")/*{company_id}*/
    fun GetData():
        Observable <sub_categories>
//// Table

    @GET("restables/gettablesdata/2.json")/*{company_id}*/
    fun GetTablesData():
            Observable <TablesData>

/////////////  Product Details

    @GET("items/view/{item_id}/{user_id}.json")
    abstract fun getProductDetails(

        @Path("item_id") item_id: Int,
        @Path("user_id") user_id: Int
    ): Observable<ProductDetails>


    @GET("items/getitemsbytype/{id}/1.json")/*{company_id}*/
    fun GetItemsData(@Path("id") id: Int):
            Observable<Items>


    @GET("items/getitemsbyname.json")/*{company_id}*/
    fun GetAllDataForSearch():
            Observable <AllData>

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

  /////  ِAdd Order

    //branch_id: "2"
    //table_id: 13
    //total: 0
    //typeorder: 0
    //user_id: "1085"
    //waiter_id: 1

    @FormUrlEncoded
    @POST("orders/add.json")
    abstract fun AddOrder(

        @Field("branch_id") branch_id: Int,
        @Field("table_id") table_id: Int,
        @Field("total") total: Int,
        @Field("typeorder") typeorder: Int,
        @Field("user_id") user_id: Int,
        @Field("waiter_id") waiter_id: Int

    ): Observable<DetailsByOrderId>

/////// http://wokhouse.codesroots.com/api/orderdetails/getDetailsByOrderId/1334.json

    @GET("orderdetails/getDetailsByOrderId/{id}.json")/*{company_id}*/
    fun getDetailsByOrderId(@Path("id") id: Int):
            Observable<DetailsByOrderId>


}


