package com.codesroots.mac.firstkotlon.DataLayer.Repo

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.data_layer.ApiClient
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.models.Items
import com.example.dinein.models.TablesData
import com.example.dinein.models.User
import com.example.dinein.models.sub_categories

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

    @SuppressLint("CheckResult")
    fun getServergetway () : APIServices
    {
        return ApiClient.getClient().create(APIServices::class.java)
    }
}

