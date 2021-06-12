package com.example.dinein.presentation

import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.dinein.R
import com.example.dinein.databinding.ActivityMainBinding
import com.example.dinein.presentation.home.category_fragment.Categories_Fragment
import com.example.dinein.presentation.home.subcats_frament.SubCats_Fragment
import com.example.dinein.presentation.home.cart_fragment.CartFragment


class MainActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
       // binding.context = this
        val frg =
            CartFragment()//create the fragment instance for the top fragment
        val frg1 =
            Categories_Fragment()//create the fragment instance for the middle fragment
        val frg2 =
            SubCats_Fragment()//create the fragment instance for the bottom fragment

        val manager = supportFragmentManager//create an instance of fragment manager

        val transaction = manager.beginTransaction()//create an instance of Fragment-transaction
        transaction.replace(R.id.My_Container_1_ID, frg, "Frag_Top_tag")
        transaction.replace(R.id.My_Container_2_ID, frg1, "Frag_Middle_tag")
        transaction.replace(R.id.My_Container_3_ID, frg2, "Frag_Bottom_tag")


        transaction.commit()


    }
}
