package com.example.dinein.presentation

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.MainViewModel
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.models.DataX
import com.example.dinein.presentation.home.items_fragment.Items_Fragment
import com.example.dinein.presentation.home.subcats_frament.SubCats_Fragment

class Handler {

    @RequiresApi(Build.VERSION_CODES.N)
    fun SwitchToPackages(context: Context, comid :Int) {
        val bundle = Bundle()
        //  bundle.putParcelable("cliObj" ,clients[position] )
        val frag = Items_Fragment()
        frag.arguments = bundle
        bundle.putInt("cat_id" , comid)
        ( context as MainActivity).supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.ttb, 0, 0,0)
            .replace(R.id.My_Container_3_ID, frag)
            .addToBackStack(null)
            .commit()
    }

    fun AddToCart(viewmodel: SubCategoryModel, data : DataX) {

         viewmodel.GetItemsData(data)

        //  bundle.putParcelable("cliObj" ,clients[position] )


    }
}