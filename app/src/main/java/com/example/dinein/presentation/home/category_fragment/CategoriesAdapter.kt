package com.example.dinein.presentation.home.category_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.CatsItemBinding
import com.example.dinein.models.Data
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.items_fragment.Items_Fragment
import com.example.dinein.presentation.home.subcats_frament.SubCats_Fragment
import com.example.dinein.presentation.home.viewmodel.MainViewModel

class CategoriesAdapter (var viewModel: MainViewModel, var context : Context?, var data:List<Data>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(viewModel,context,data.get(p1))
        p0.binding.name.setOnClickListener {
            viewModel.SwtichingCategories(p1)
            //  bundle.putParcelable("cliObj" ,clients[position] )
            val frag = SubCats_Fragment()
            ( context as MainActivity).supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.ttb, 0, 0,0)
                .replace(R.id.My_Container_3_ID, frag)
                .addToBackStack(null)
                .commit()

        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

          val  binding: CatsItemBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.cats_item,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    public val binding: CatsItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(viewModel: MainViewModel, context: Context?, data: Data) {

        binding.data = data
        binding.context = context as MainActivity?
    }

}