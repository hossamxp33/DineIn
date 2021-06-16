package com.example.dinein.presentation.home.cart_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.TopFragmentBinding
import com.example.dinein.helper.AddorRemoveCallbacks
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.models.DataX
import com.example.dinein.models.Orderdetail
import com.example.dinein.models.Subcategory
import com.example.dinein.models.sub_categories
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory

class CartFragment : Fragment(){


    lateinit var viewModel: MainViewModel
        lateinit var MainAdapter: CartAdapter
    private var cart_count = 0
    private var preferenceHelper: PreferenceHelper? = null
    var index : Int =  0

    var data: ArrayList<Subcategory>? = null
    var order_data = ArrayList<Orderdetail>()
        var dataray = ArrayList<DataX>()
        var mainData: DataX? = null
        private fun getViewModelFactory(): MainViewModelFactory {
            return MainViewModelFactory(this.activity!!.application)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            var view: TopFragmentBinding =
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.top_fragment, container, false
                )

            viewModel = ViewModelProviders.of(requireActivity(), getViewModelFactory()).get(MainViewModel::class.java)

             preferenceHelper = PreferenceHelper(activity)
val OrderId = arguments!!.getInt("order_id")


          viewModel.getDetailsByOrderId(OrderId)
        viewModel.ItemIndex.observe(this.viewLifecycleOwner,androidx.lifecycle.Observer {

            index = it

        })
             viewModel.OrdersByIdResponesLD?.observe(this, Observer {

                 order_data = it.query.get(index).orderdetails as ArrayList

                for (order_datas in order_data) {
                    dataray.add(DataX(price = order_datas.item.price,name = order_datas.item.name))

                }
                 MainAdapter = CartAdapter( viewModel,context, dataray)

                 view.departments.adapter = MainAdapter;

                 view.departments.layoutManager = GridLayoutManager(context,1)

             })



        viewModel.ItemData.observe(this , androidx.lifecycle.Observer  {

            dataray.add(it)

                MainAdapter = CartAdapter( viewModel,context, dataray)

                view.departments.adapter = MainAdapter;

                view.departments.layoutManager = GridLayoutManager(context,1)

                 mainData  = it

                MainAdapter.notifyDataSetChanged()


            })


        return view.root

}

}