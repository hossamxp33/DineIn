package com.example.dinein.presentation.home.cat_fragment

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
import com.example.dinein.R
import com.example.dinein.databinding.CategoriesFragmentBinding
import com.example.dinein.models.Data

class Categories_Fragment : Fragment(){
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: CategoriesAdapter

    var data: List<Data>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: CategoriesFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.categories_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.Get_Categories()


        viewModel.ItemCategoriesResponseLD?.observe(this , Observer {
            MainAdapter = CategoriesAdapter( viewModel,context, it.data)
            view.categoriesRecycle.adapter = MainAdapter;
            view.categoriesRecycle.layoutManager = LinearLayoutManager(context)

        })
        return view.root
}
}