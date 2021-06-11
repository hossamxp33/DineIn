package com.example.dinein.presentation.home.subcats_frament

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.MainViewModel
import com.example.dinein.R
import com.example.dinein.databinding.CatsItemBinding
import com.example.dinein.databinding.SubcategoriesItemBinding
import com.example.dinein.models.Data
import com.example.dinein.models.Subcategory
import com.example.dinein.presentation.MainActivity

class SubCategoriesAdapter(var viewModel: MainViewModel, var context : Context?, var data:List<Subcategory>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,viewModel,context,data.get(p1))

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val  binding: SubcategoriesItemBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.subcategories_item,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    private val binding: SubcategoriesItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(position:Int,viewModel: MainViewModel, context: Context?, data: Subcategory) {

        binding.data = data
        binding.context = context as MainActivity?
        binding.index = position
    }

}