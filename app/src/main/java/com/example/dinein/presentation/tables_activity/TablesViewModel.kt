package com.example.dinein.presentation.tables_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.models.DataX
import com.example.dinein.models.Items
import com.example.dinein.models.TablesData
import com.example.dinein.models.sub_categories


public class TablesViewModel(apiService: APIServices) : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()

     var mCompositeDisposable = CompositeDisposable()


    var TablesResponseLD : MutableLiveData <TablesData>? = null


    init {
        TablesResponseLD = MutableLiveData()

    }



    fun  Get_Tables(){
        DateRepoCompnay.Get_Tables(TablesResponseLD)
    }





}