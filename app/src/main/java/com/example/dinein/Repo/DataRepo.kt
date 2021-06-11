package com.codesroots.mac.firstkotlon.DataLayer.Repo

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.data_layer.ApiClient
import com.example.dinein.models.Data
import com.example.dinein.models.item_categories

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class  DataRepo {




    //GetTextSliderData
    @SuppressLint("CheckResult")
    fun Get_Data_Categories(livedata: MutableLiveData<item_categories>?) {
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



    @SuppressLint("CheckResult")
    fun getServergetway () : APIServices
    {
        return ApiClient.getClient().create(APIServices::class.java)
    }
}

