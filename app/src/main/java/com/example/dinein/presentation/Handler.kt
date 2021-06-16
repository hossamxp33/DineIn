package com.example.dinein.presentation

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.models.DataX
import com.example.dinein.models.Tables
import com.example.dinein.presentation.home.items_fragment.Items_Fragment
import com.example.dinein.presentation.home.subcats_frament.SubCats_Fragment
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.tables_activity.Tables_Activity

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

    fun SwitchToMainActivity(context: Context, data: Tables, viewModel: MainViewModel) {
        val bundle = Bundle()

      //  bundle.putParcelable("data",data)
        if (data.orders.isEmpty()){
            viewModel.AddOrder(data.branch_id,data.number,0,0,data.user_id,1)



        }

        else  {




            val homeIntent = Intent(context,MainActivity()::class.java)
            homeIntent.putExtra("order_id",data.orders.get(0).id)
            (context as Tables_Activity).startActivity(homeIntent)


        }

    }


    fun AddToCart(viewmodel: MainViewModel, data : DataX) {

         viewmodel.GetItemsData(data)

        //  bundle.putParcelable("cliObj" ,clients[position] )


    }

}