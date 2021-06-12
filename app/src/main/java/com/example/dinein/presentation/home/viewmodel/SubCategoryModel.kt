package com.codesroots.mac.cards.presentaion.mainfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.models.DataX
import com.example.dinein.models.Items
import com.example.dinein.models.sub_categories


class SubCategoryModel(apiService: APIServices) : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()
     var mCompositeDisposable = CompositeDisposable()

    var SpinnerData : Currency? = null

    var subCategoriesResponseLD : MutableLiveData <sub_categories>? = null
    var ItemIndex = MutableLiveData<Int>()
    var ItemsResponesLD : MutableLiveData<Items>? = null
    var ItemData= MutableLiveData <DataX>()


    init {
        ItemIndex = MutableLiveData()
        subCategoriesResponseLD = MutableLiveData()
        ItemsResponesLD = MutableLiveData()
        ItemData = MutableLiveData()
    }



    fun  Get_Categories(){
        DateRepoCompnay.Get_Data_Categories(subCategoriesResponseLD)
    }
    fun  Get_Items(id : Int){
        DateRepoCompnay.GetItemsData(id,ItemsResponesLD)
    }



    fun SwtichingCategories(index: Int?) {
        ItemIndex.postValue(index)
    }


fun GetItemsData(dataX: DataX){

    ItemData?.postValue(dataX)
}

}