package com.codesroots.mac.cards.presentaion.mainfragment.viewmodel

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BaseObservable
import android.graphics.Color
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import com.example.dinein.R
import com.example.dinein.models.item_categories







class SubCategoryModel(apiService: APIServices) : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()
     var mCompositeDisposable = CompositeDisposable()

    var SpinnerData : Currency? = null

    var ItemCategoriesResponseLD : MutableLiveData <item_categories>? = null
    var ItemIndex = MutableLiveData<Int>()


    init {
        ItemIndex = MutableLiveData()
        ItemCategoriesResponseLD = MutableLiveData()
    }



    fun  Get_Categories(){
        DateRepoCompnay.Get_Data_Categories(ItemCategoriesResponseLD)
    }

    fun SwtichingCategories(index: Int?) {

        ItemIndex.postValue(index)

    }



}