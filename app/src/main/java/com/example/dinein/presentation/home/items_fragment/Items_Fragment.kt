package com.example.dinein.presentation.home.items_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.ItemsFragmentBinding
import com.example.dinein.models.DataX
import com.example.dinein.models.Subcategory
import com.example.dinein.models.sub_categories
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory

class Items_Fragment : Fragment(){

    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: ItemsAdapter

    var data: ArrayList<Subcategory>? = null
    var dataray = ArrayList<DataX>()
    var mainData: sub_categories? = null
    private fun getViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }
    var index : Int =  8
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: ItemsFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.items_fragment, container, false
            )

        val subCategoryeId = arguments?.getInt("cat_id")

        viewModel = ViewModelProviders.of(requireActivity(), getViewModelFactory()).get(MainViewModel::class.java)

        viewModel.Get_Items(subCategoryeId!!)


        viewModel.ItemsResponesLD?.observe(this , Observer {

            dataray.addAll(it!!.data)

            MainAdapter = ItemsAdapter( viewModel,context, dataray)

            view.categoriesRecycle.adapter = MainAdapter;

            view.categoriesRecycle.layoutManager = GridLayoutManager(context,4)

            //      mainData  = it
            MainAdapter.notifyDataSetChanged()

        })

        return view.root
    }
}