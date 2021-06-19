package com.example.dinein.presentation.home.category_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.CategoriesFragmentBinding
import com.example.dinein.models.Data
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory
import kotlinx.android.synthetic.main.items_fragment.*

class Categories_Fragment : Fragment(){
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: CategoriesAdapter
    private fun getViewModelFactory(): SubViewModelFactory {
        return SubViewModelFactory(this.activity!!.application)
    }
    private fun getMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }
    var data: List<Data>? = null
    var index : Int =  0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: CategoriesFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.categories_fragment, container, false)

        return view.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity(), getMainViewModelFactory()).get(MainViewModel::class.java)

        viewModel.Get_Categories()

        viewModel.subCategoriesResponseLD?.observe(this , Observer {
            MainAdapter = CategoriesAdapter(viewModel,context, it.data)
            categories_recycle.adapter = MainAdapter;
            categories_recycle.layoutManager = LinearLayoutManager(context)

        })


        viewModel.ItemIndex.observe(this.viewLifecycleOwner,androidx.lifecycle.Observer {

            index = it



        })


    }
}