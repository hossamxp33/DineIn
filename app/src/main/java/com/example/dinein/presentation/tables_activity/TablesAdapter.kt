package com.example.dinein.presentation.tables_activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.dinein.R
import com.example.dinein.databinding.CatsItemBinding
import com.example.dinein.databinding.TablesAdapterBinding
import com.example.dinein.models.Data
import com.example.dinein.models.Tables
import com.example.dinein.models.TablesData
import com.example.dinein.presentation.Handler
import com.example.dinein.presentation.MainActivity

class TablesAdapter (var viewModel: TablesViewModel, var context : Context?, var data:List<Tables>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(viewModel,context,data.get(p1))
        p0.binding.name.setOnClickListener {

        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

          val  binding: TablesAdapterBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.tables_adapter,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    public val binding: TablesAdapterBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(viewModel: TablesViewModel, context: Context?, data: Tables) {

        binding.data = data
        binding.context = context as Tables_Activity?
        binding.listener = Handler()
    }

}