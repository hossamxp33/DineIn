package com.example.dinein.presentation.home.category_fragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.MainViewModel
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.CategoriesFragmentBinding
import com.example.dinein.models.Data
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory

class Categories_Fragment : Fragment(){
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: CategoriesAdapter
    lateinit   var subCatViewModel: SubCategoryModel
    private fun getViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }
    var data: List<Data>? = null
    var index : Int =  0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: CategoriesFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.categories_fragment, container, false)

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MainViewModel::class.java)
        subCatViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(SubCategoryModel::class.java)

        viewModel.Get_Categories()


        viewModel.ItemCategoriesResponseLD?.observe(this , Observer {
            MainAdapter = CategoriesAdapter( subCatViewModel,viewModel,context, it.data)
            view.categoriesRecycle.adapter = MainAdapter;
            view.categoriesRecycle.layoutManager = LinearLayoutManager(context)

        })
        return view.root
}
}