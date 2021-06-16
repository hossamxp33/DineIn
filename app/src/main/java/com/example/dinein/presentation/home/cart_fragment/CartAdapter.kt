package com.example.dinein.presentation.home.cart_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.OrderItemsBinding
import com.example.dinein.models.DataX
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.viewmodel.MainViewModel

class CartAdapter(var viewModel: MainViewModel, var context : Context?, var data:List<DataX>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,viewModel,context,data.get(p1))

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val  binding: OrderItemsBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.order_items,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    private val binding: OrderItemsBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(position:Int, viewModel: MainViewModel, context: Context?, data: DataX) {

        binding.data = data
        binding.viewmodel = viewModel

        binding.context = context as MainActivity?
    }

}