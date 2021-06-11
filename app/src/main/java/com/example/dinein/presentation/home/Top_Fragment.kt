package com.example.dinein.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dinein.R
import com.example.dinein.databinding.TopFragmentBinding

class Top_Fragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: TopFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.top_fragment, container, false
            )



        return view.root
}
}