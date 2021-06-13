package com.example.dinein.presentation.home.items_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.ItemsAdapterBinding
import com.example.dinein.databinding.OrderItemsBinding
import com.example.dinein.databinding.SubcategoriesItemBinding
import com.example.dinein.models.DataX
import com.example.dinein.models.Subcategory
import com.example.dinein.presentation.Handler
import com.example.dinein.presentation.MainActivity
import io.socket.engineio.client.HandshakeData

class ItemsAdapter(var viewModel: SubCategoryModel, var context : Context?, var data:List<DataX>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,viewModel,context,data.get(p1))


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val  binding: ItemsAdapterBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.items_adapter,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    public val binding: ItemsAdapterBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(position:Int, viewModel: SubCategoryModel, context: Context?, data: DataX) {

        binding.data = data
        binding.context = context as MainActivity?
        binding.listener = Handler()
        binding.viewmodel = viewModel
    }

}