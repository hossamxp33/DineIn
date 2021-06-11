package com.codesroots.mac.cards.presentaion.mainfragment.viewmodel

import android.annotation.SuppressLint
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
import kotlin.collections.ArrayList
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BaseObservable
import android.graphics.Color
import com.example.dinein.R
import com.example.dinein.models.Data
import com.example.dinein.models.item_categories


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

class MainViewModel : ViewModel() {

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