package com.example.dinein.presentation.home.subcats_frament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.MainViewModel
import com.example.dinein.R
import com.example.dinein.databinding.CategoriesFragmentBinding
import com.example.dinein.databinding.ItemsFragmentBinding
import com.example.dinein.databinding.TopFragmentBinding
import com.example.dinein.models.Data
import com.example.dinein.models.Subcategory
import com.example.dinein.models.item_categories
import com.example.dinein.presentation.home.cat_fragment.CategoriesAdapter

class Items_Fragment : Fragment(){
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: SubCategoriesAdapter

    var data: ArrayList<Subcategory>? = null
    var dataray = ArrayList<Subcategory>()
     var MainData: item_categories? = null

    var index : Int =  0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: ItemsFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.items_fragment, container, false
            )

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        viewModel.ItemIndex.observe(this,androidx.lifecycle.Observer {
            println("iniTEMIINDEX")


        })
        viewModel.Get_Categories()




        viewModel.ItemCategoriesResponseLD?.observe(this , Observer {

            dataray.addAll(it!!.data.get(index).subcategories)

            MainAdapter = SubCategoriesAdapter( viewModel,context, dataray)

            view.categoriesRecycle.adapter = MainAdapter;

            view.categoriesRecycle.layoutManager = GridLayoutManager(context,4)

            MainData  = it
            MainAdapter.notifyDataSetChanged()

        })

        SwitchingCategories()

        return view.root
}

    fun SwitchingCategories(){


    }
}