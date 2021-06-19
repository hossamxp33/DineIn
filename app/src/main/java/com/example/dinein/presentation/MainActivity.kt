package com.example.dinein.presentation

import android.annotation.TargetApi
import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel
import com.example.dinein.R
import com.example.dinein.databinding.ActivityMainBinding
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.presentation.home.category_fragment.Categories_Fragment
import com.example.dinein.presentation.home.subcats_frament.SubCats_Fragment
import com.example.dinein.presentation.home.cart_fragment.CartFragment
import com.example.dinein.presentation.home.items_fragment.Items_Fragment
import com.example.dinein.presentation.home.viewmodel.MainViewModel
import com.example.dinein.presentation.home.viewmodel.MainViewModelFactory
import com.example.dinein.presentation.home.viewmodel.SubViewModelFactory
import com.example.dinein.presentation.searchfragment.SearchAdapter
import com.example.dinein.presentation.searchfragment.SearchFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.activityManager


class MainActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val companiesAdapter:SearchAdapter ? =null
        lateinit   var viewModel: MainViewModel
        var orderId:Int?=null

        fun getViewModelFactory(): MainViewModelFactory {
            return MainViewModelFactory(this.application)
        }

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, com.example.dinein.R.layout.activity_main)
       // binding.context = this

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(
            MainViewModel::class.java)
        orderId  = intent.getIntExtra("order_id",0);
        val frg =
            CartFragment()//create the fragment instance for the top fragment
        val frg1 =
            Categories_Fragment()//create the fragment instance for the middle fragment
        val frg2 =
            SubCats_Fragment()//create the fragment instance for the bottom fragment

        val frg3 =
            SearchFragment()//create the fragment instance for the bottom fragment
        val bundle = Bundle()
        bundle.putInt("order_id",orderId)
        frg.setArguments(bundle)

        val manager = supportFragmentManager//create an instance of fragment manager

        val transaction = manager.beginTransaction()//create an instance of Fragment-transaction
        transaction.replace(com.example.dinein.R.id.My_Container_1_ID, frg)
        transaction.replace(com.example.dinein.R.id.My_Container_2_ID, frg1)
        transaction.replace(com.example.dinein.R.id.My_Container_3_ID, frg2)

        search_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

           //     manager.beginTransaction().remove(frg1).commit()
                manager.beginTransaction().replace(R.id.My_Container_3_ID,frg3).commit()
                viewModel.SendSearhKey(s.toString());

            }
            override fun afterTextChanged(s: Editable) {
//                if (companiesAdapter != null)
//                    companiesAdapter.getFilter().filter(s.toString())
                Log.d("", "afterTextChanged: s$s")
            }
        })


        orderId = PreferenceHelper.getCOUNTRY_ID()
        transaction.commit()


    }
}
