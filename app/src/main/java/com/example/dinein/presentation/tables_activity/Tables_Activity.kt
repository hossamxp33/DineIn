package com.example.dinein.presentation.tables_activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dinein.R

import com.example.dinein.databinding.TablesActivityBinding
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory

import kotlinx.android.synthetic.main.items_fragment.*


class Tables_Activity : AppCompatActivity() {
    lateinit var MainAdapter: TablesAdapter
    lateinit var viewModel: MainViewModel

    var orderId:Int?=null

    private fun getMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<TablesActivityBinding>(this, R.layout.tables_activity)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        PreferenceHelper(this)

        viewModel = ViewModelProviders.of(this, getMainViewModelFactory()).get(MainViewModel::class.java)







        /////////     Get Tables
        viewModel.Get_Tables()
        viewModel.TablesResponseLD?.observe(this , Observer {
            MainAdapter = TablesAdapter(viewModel,this, it.data)
            categories_recycle.adapter = MainAdapter;
            categories_recycle.layoutManager = GridLayoutManager(this, 3)




        })


        /////////////

        viewModel.AddOrderResponseLD?.observe(this, Observer {

            val homeIntent = Intent(this, MainActivity()::class.java)
            homeIntent.putExtra("order_id",it.query.get(0).id)
            startActivity(homeIntent)



        })


    }


}
