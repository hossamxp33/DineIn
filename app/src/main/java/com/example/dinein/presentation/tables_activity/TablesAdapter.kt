package com.example.dinein.presentation.tables_activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.dinein.R
import com.example.dinein.R.color.green
import com.example.dinein.R.color.red
import com.example.dinein.databinding.CatsItemBinding
import com.example.dinein.databinding.TablesAdapterBinding
import com.example.dinein.models.Data
import com.example.dinein.models.Tables
import com.example.dinein.models.TablesData
import com.example.dinein.presentation.Handler
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import org.jetbrains.anko.backgroundColor

class TablesAdapter (var viewModel: MainViewModel, var context : Context?, var data:List<Tables>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {

        return  data.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(viewModel,context,data.get(p1))
        p0.binding.table.setOnClickListener {

            viewModel.SwtichingCategories(p1)

            val homeIntent = Intent(context,MainActivity()::class.java)
            (context as Tables_Activity).startActivity(homeIntent)

            viewModel.AddOrder(data.get(p1).branch_id,data.get(p1).number,0,0,data.get(p1).user_id,1)

        }

        if (data.get(p1).orders.isNotEmpty()){
           p0.binding.table.backgroundColor = R.drawable.linear_background_for_choice

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

    fun bind(viewModel: MainViewModel, context: Context?, data: Tables) {

        binding.data = data
        binding.context = context as Tables_Activity?
        binding.listener = Handler()
        binding.viewmodel = viewModel
    }

}