package com.example.dinein.presentation.searchfragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.dinein.R
import com.example.dinein.databinding.SearchProductBinding
import com.example.dinein.models.SearchData
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.search_product.*


class SearchFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var MainAdapter: SearchAdapter
    lateinit var progress : ProgressBar
    internal lateinit var productList: ArrayList<SearchData>
    private fun getMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }
    var page = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: SearchProductBinding =
            DataBindingUtil.inflate(inflater, R.layout.search_product, container, false)


        var not = view.notfound

        viewModel =   ViewModelProviders.of(requireActivity(),getMainViewModelFactory()).get(MainViewModel::class.java)

        viewModel.Get_Search_Data()


        viewModel.SearchResponseLD?.observe(this, Observer {

            if (page == 1 ) {
                productList = ArrayList(it.data)
                if (productList.size > 0 ) {
                    MainAdapter = SearchAdapter(viewModel, context, it.data)
                    view.recyler.layoutManager = GridLayoutManager(context,3)
                    view.recyler.adapter = MainAdapter;
                    progress = prog
                    progress.setVisibility(View.GONE)
                    viewModel.SearchKey.observe(this.viewLifecycleOwner,androidx.lifecycle.Observer {
                        MainAdapter.getFilter().filter(it)

                    })
                } else {
                    progress = prog
                    progress.setVisibility(View.GONE)
                    not.visibility=View.VISIBLE

                }
            }
        })

        return view.root
}


}


