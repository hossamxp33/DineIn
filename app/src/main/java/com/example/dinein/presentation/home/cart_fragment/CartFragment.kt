package com.example.dinein.presentation.home.cart_fragment

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
import com.example.dinein.databinding.TopFragmentBinding
import com.example.dinein.models.DataX
import com.example.dinein.models.Subcategory
import com.example.dinein.models.sub_categories
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory

class CartFragment : Fragment(){

        lateinit var viewModel: SubCategoryModel
        lateinit var MainAdapter: CartAdapter

        var data: ArrayList<Subcategory>? = null
        var dataray = ArrayList<DataX>()
        var mainData: DataX? = null
        private fun getViewModelFactory(): SubViewModelFactory {
            return SubViewModelFactory(this.activity!!.application)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            var view: TopFragmentBinding =
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.top_fragment, container, false
                )

            viewModel = ViewModelProviders.of(activity!!, getViewModelFactory()).get(SubCategoryModel::class.java)
        viewModel.ItemData.observe(this , androidx.lifecycle.Observer  {

                dataray.add(it)

                MainAdapter = CartAdapter( viewModel,context, dataray)

                view.departments.adapter = MainAdapter;

                view.departments.layoutManager = GridLayoutManager(context,1)

                 mainData  = it
                MainAdapter.notifyDataSetChanged()

            })
        SwitchingCategories()
        return view.root

}

    fun SwitchingCategories(){

    }
}