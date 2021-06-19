package com.example.dinein.presentation.home.product_details

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.CategoriesFragmentBinding
import com.example.dinein.databinding.ItemsFragmentBinding
import com.example.dinein.databinding.ProductDetailsFragmentBinding
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.models.Data
import com.example.dinein.models.DataX
import com.example.dinein.models.ProductDetails
import com.example.dinein.models.ProductdetailsBean
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.cart_fragment.CartAdapter
import com.example.dinein.presentation.home.category_fragment.CategoriesAdapter
import com.example.dinein.presentation.home.product_details.adapter.RelatedAdapter
import com.example.dinein.presentation.home.subcats_frament.SubCategoriesAdapter
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory
import kotlinx.android.synthetic.main.items_fragment.*
import kotlinx.android.synthetic.main.product_details_fragment.*
import java.lang.Exception

class Product_details_Fragment : Fragment(){
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: RelatedAdapter

    private fun getMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }
    var data: ProductdetailsBean? = null
    var dataX : DataX? = null
    var index : Int =  0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: ProductDetailsFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.product_details_fragment, container, false
            )

        viewModel = ViewModelProviders.of(requireActivity(), getMainViewModelFactory()).get(MainViewModel::class.java)

        val item_id  = arguments!!.getInt("item_id")

        view.viewmodel = viewModel
        view.listener = com.example.dinein.presentation.Handler()
        view.context = context as MainActivity
        view.data = data

        view.dataa = dataX

        viewModel.getProductDetails(item_id,PreferenceHelper.getUserId())

        viewModel.ProductDetailsResponesLD?.observe(this , Observer {
            data = it.item

            try {
                view.productName.text = data!!.name

            }catch (e:Exception){

            }

            MainAdapter = RelatedAdapter( viewModel,context, it.related!!)

            view.recommendedProducts.adapter = MainAdapter;

            view.recommendedProducts.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        })

        return view.root
    }


}