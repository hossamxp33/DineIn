package com.codesroots.mac.firstkotlon.DataLayer.Repo

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.data_layer.ApiClient
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.models.*

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class  DataRepo {




    //GetTextSliderData
    @SuppressLint("CheckResult")
    fun Get_Data_Categories(livedata: MutableLiveData<sub_categories>?) {
        getServergetway().GetData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }
    //GetTextSliderData
    @SuppressLint("CheckResult")
    fun GetDataForSearch(livedata: MutableLiveData<AllData>?) {
        getServergetway().GetAllDataForSearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }

    //// GetTables
    @SuppressLint("CheckResult")
    fun Get_Tables(livedata: MutableLiveData<TablesData>?) {
        getServergetway().GetTablesData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }
    @SuppressLint("CheckResult")
    fun GetItemsData(id:Int,livedata: MutableLiveData<Items>?) {

        getServergetway().GetItemsData(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->
                    print(error)
                }
            )
    }
    @SuppressLint("CheckResult")
    fun getDetailsByOrderId(id:Int,livedata: MutableLiveData<DetailsByOrderId>?) {

        getServergetway().getDetailsByOrderId(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->
                    print(error)
                }
            )
    }
    /////////getDetailsByOrderId

    fun Login(username:String,password:String,livedata: MutableLiveData<User>?) {

        getServergetway().userlogin(username,password)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }
    fun LoginFirstTime(username:String,password:String,livedata: MutableLiveData<User>?) {

        getServergetway().LoginFirstTime(username,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }


    //AddOrder
    fun AddOrder(branch_id:Int,table_id:Int,total:Int,typeorder:Int,user_id:Int,waiter_id:Int,livedata: MutableLiveData<DetailsByOrderId>?) {

        getServergetway().AddOrder(branch_id,table_id,total,typeorder,user_id,waiter_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }

    @SuppressLint("CheckResult")
    fun getServergetway () : APIServices
    {
        return ApiClient.getClient().create(APIServices::class.java)
    }
}

