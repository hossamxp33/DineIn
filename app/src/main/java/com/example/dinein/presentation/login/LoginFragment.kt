package com.example.dinein.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.codesroots.hossam.mandoobapp.presentation.login.ViewModel.LoginViewModel
import com.codesroots.mac.cards.DataLayer.usecases.checkUserLogin
import com.example.dinein.R
import com.example.dinein.databinding.ActivityMainBinding
import com.example.dinein.databinding.LoginFragmentBinding
import com.example.dinein.helper.PreferenceHelper
import com.example.dinein.isInternetConnectionAvailable
import com.example.dinein.models.User
import com.example.dinein.presentation.MainActivity
import com.example.dinein.snack
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : AppCompatActivity() {
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_fragment)
        PreferenceHelper(this)

//        if (checkUserLogin(this)) {
//            startActivity(Intent(this, MainActivity::class.java))
//        }

        login.setOnClickListener {

            if (PreferenceHelper.getToken() != "0" ) {
                "تاني مرة".snack(window.decorView.rootView)
                if (!isInternetConnectionAvailable(this)) "رجاء تأكد من اتصالك بالانترنت".snack(window.decorView.rootView)
                viewModel.Login(username.text.toString(),password.text.toString())
            }else {
                if (!isInternetConnectionAvailable(this)) "رجاء تأكد من اتصالك بالانترنت".snack(window.decorView.rootView)
                viewModel.LoginFirstTime(username.text.toString(),password.text.toString())
                "اول مرة".snack(window.decorView.rootView)
            }
        }

        viewModel.loginResponseLD?.observe(this , Observer {
            "سجل".snack(window.decorView.rootView)



//                PreferenceHelper.setToken(it.taken,this)
             PreferenceHelper.setToken(it.data!!.token)

                startActivity(Intent(this, MainActivity::class.java))

        })



    }


}
