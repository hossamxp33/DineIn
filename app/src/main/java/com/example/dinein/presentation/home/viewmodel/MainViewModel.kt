package com.example.dinein.presentation.home.viewmodel

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
import com.example.dinein.models.*


class BindedValue : BaseObservable() {

    var value: Double = 0.toDouble()


    var setValue: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

     override   fun afterTextChanged(s: Editable) {
            value = java.lang.Double.parseDouble(s.toString())
        }
    }
}
/////// set Stock image statue /////
@BindingAdapter("app:imageStock")

fun setimageStock(imageView: AppCompatImageView, resource: String?) {
    when (resource){
        "-1" ->   imageView.setImageDrawable(
            ContextCompat.getDrawable(
                imageView.context!!, // Context
               R.drawable.img_load // Drawable
            )
        )
        "1" ->   imageView.setImageDrawable(
            ContextCompat.getDrawable(
                imageView.context!!, // Context
               R.drawable.img_load // Drawable
            )
        )
        else -> { // Note the block
            // Display an image on image view from drawable
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    imageView.context!!, // Context
                    R.drawable.img_no_net // Drawable
                )
            )   }
    }

}



@BindingAdapter("text_color")
/////// set Stock image statue /////
fun setTextStock(text: TextView, color: String?) {
    when (color){
        "-1" ->
         text.setTextColor(Color.parseColor("#ef1919"))


        "1" ->           text.setTextColor(Color.parseColor("#1E75DE"))

        else -> { // Note the block
            // Display an image on image view from drawable
            text.setTextColor(Color.parseColor("#9C9898"))
        }
    }

}
@BindingAdapter("app:imageResource")
fun setImageResource(imageView: AppCompatImageView, resource: String?) {
    Glide.with(imageView.context).load(resource).into(imageView)
}

@BindingAdapter("app:imageResourcee")
fun setImageResourcee(imageView: AppCompatImageView, resource: String?) {
    Glide.with(imageView.context).load(resource).into(imageView)
}
@BindingAdapter("app:datetext")
fun setDatetext(text:TextView,resource: String?) {

    val myFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

    val dateObj: Date

    dateObj = myFormat.parse(resource)
    val timestamp = dateObj.getTime().toString()//  //Example -> in ms
    val fromServer = SimpleDateFormat("yyyy-MM-dd")
    val dateString = fromServer.format(Date(java.lang.Long.parseLong(timestamp)))


    text.text = dateString

}

class MainViewModel(apiService: APIServices) : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()
     var mCompositeDisposable = CompositeDisposable()

    var SpinnerData : Currency? = null

    var subCategoriesResponseLD : MutableLiveData <sub_categories>? = null
    var SearchResponseLD : MutableLiveData <AllData>? = null
    var ItemData= MutableLiveData <DataX>()
    var SearchKey = MutableLiveData<String>()
    var AddOrderResponseLD : MutableLiveData <DetailsByOrderId>? = null
    var TablesResponseLD : MutableLiveData <TablesData>? = null
    var ItemsResponesLD : MutableLiveData<Items>? = null
    var OrdersByIdResponesLD : MutableLiveData<DetailsByOrderId>? = null
    var ItemIndex = MutableLiveData<Int>()
    var ProductDetailsResponesLD : MutableLiveData<ProductDetails>? = null


    init {
        subCategoriesResponseLD = MutableLiveData()
        SearchResponseLD = MutableLiveData()
        ItemData = MutableLiveData()
        SearchKey = MutableLiveData()
        AddOrderResponseLD = MutableLiveData()
        TablesResponseLD = MutableLiveData()
        ItemsResponesLD = MutableLiveData()
        OrdersByIdResponesLD= MutableLiveData()
        ItemIndex = MutableLiveData()
        ProductDetailsResponesLD= MutableLiveData()


    }




    fun  Get_Categories(){
        DateRepoCompnay.Get_Data_Categories(subCategoriesResponseLD)
    }

    fun  Get_Search_Data(){
        DateRepoCompnay.GetDataForSearch(SearchResponseLD)
    }

    fun  Get_Tables(){
        DateRepoCompnay.Get_Tables(TablesResponseLD)
    }

    fun  Get_Items(id : Int){
        DateRepoCompnay.GetItemsData(id,ItemsResponesLD)
    }
////////////getProductDetails

    fun  getProductDetails(item_id : Int,user_id: Int){
        DateRepoCompnay.getProductDetails(item_id,user_id,ProductDetailsResponesLD)
    }
    ///AddOrder
    fun AddOrder(branch_id:Int,table_id:Int,total:Int,typeorder:Int,user_id:Int,waiter_id:Int) {
        DateRepoCompnay.AddOrder(branch_id,table_id,total,typeorder,user_id,waiter_id,AddOrderResponseLD)
    }

    //////getDetailsByOrderId

    fun  getDetailsByOrderId(id : Int){
        DateRepoCompnay.getDetailsByOrderId(id,OrdersByIdResponesLD)
    }


    fun GetItemsData(dataX: DataX){

        ItemData.postValue(dataX)
    }

    fun  SendSearhKey(id : String){
        SearchKey.postValue(id)
    }


    fun SwtichingCategories(index: Int?) {
        ItemIndex.postValue(index)
    }

}