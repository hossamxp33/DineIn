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
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.ItemsFragmentBinding
import com.example.dinein.models.Subcategory
import com.example.dinein.models.sub_categories
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory

class SubCats_Fragment : Fragment(){
    lateinit var viewModel: SubCategoryModel
    lateinit var MainAdapter: SubCategoriesAdapter

    var data: ArrayList<Subcategory>? = null
    var dataray = ArrayList<Subcategory>()
     var mainData: sub_categories? = null
    var id : Int ? = null
    private fun getViewModelFactory(): SubViewModelFactory {
        return SubViewModelFactory(this.activity!!.application)
    }
    var index : Int =  0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: ItemsFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.items_fragment, container, false
            )



        viewModel = ViewModelProviders.of(requireActivity(), getViewModelFactory()).get(SubCategoryModel::class.java)


        viewModel.Get_Categories()




        viewModel.subCategoriesResponseLD?.observe(this , Observer {

            dataray.addAll(it!!.data.get(index).subcategories)

            MainAdapter = SubCategoriesAdapter( viewModel,context, dataray)

            view.categoriesRecycle.adapter = MainAdapter;

            view.categoriesRecycle.layoutManager = GridLayoutManager(context,4)

            mainData  = it

            MainAdapter.notifyDataSetChanged()

        })

        SwitchingCategories()

        return view.root
}


    fun SwitchingCategories(){
        viewModel.ItemIndex.observe(this,androidx.lifecycle.Observer {
            dataray.clear()
            dataray.addAll(mainData!!.data.get(it).subcategories)
            MainAdapter.notifyDataSetChanged()

        })
    }
}