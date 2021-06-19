package com.example.dinein.presentation.searchfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.CatsItemBinding
import com.example.dinein.databinding.SearchAdapterBinding
import com.example.dinein.models.Data
import com.example.dinein.models.SearchData
import com.example.dinein.presentation.Handler
import com.example.dinein.presentation.MainActivity
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import java.util.ArrayList

class SearchAdapter (var viewModel: MainViewModel, var context : Context?, var data:List<SearchData>) : RecyclerView.Adapter<CustomViewHolder>(),Filterable {
    private val allData: ArrayList<SearchData> = data as ArrayList<SearchData>
    private var search: ArrayList<SearchData> = data as ArrayList<SearchData>

      var not : FrameLayout ? = null

    override fun getItemCount(): Int {
        return  search.size
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                search.clear()
                    Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();

                } else {
                    val filteredList = ArrayList<SearchData>()
                    for (row in allData) {
                        if (row.name.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    search = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = search
                return filterResults
            }
            override fun publishResults( charSequence: CharSequence, filterResults: FilterResults)
            {
                search = filterResults.values as ArrayList<SearchData>
                notifyDataSetChanged()
            }
        }
    }
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(viewModel,context,search.get(p1))



    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

          val  binding: SearchAdapterBinding = DataBindingUtil.inflate (
            LayoutInflater.from(p0.context),
            R.layout.search_adapter,p0,false)



        return  CustomViewHolder(binding)

    }


}
class CustomViewHolder (
    public val binding: SearchAdapterBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(viewModel: MainViewModel, context: Context?, data: SearchData) {

        binding.data = data
        binding.context = context as MainActivity?
        binding.listener = Handler()
        binding.viewmodel = viewModel

    }

}