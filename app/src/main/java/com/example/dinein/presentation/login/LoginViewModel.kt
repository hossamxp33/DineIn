package com.codesroots.hossam.mandoobapp.presentation.login.ViewModel



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo
import com.example.dinein.models.User

import java.util.ArrayList

class LoginViewModel : ViewModel() {


    var DateRepoCompnay: DataRepo = DataRepo()

    private val error = MutableLiveData<String>()

    var loginResponseLD = MutableLiveData<User>()

    init {

        loginResponseLD = MutableLiveData()

    }
    fun LoginFirstTime(username:String,password:String) {
        DateRepoCompnay.LoginFirstTime(username,password,loginResponseLD)
    }
    fun Login(username:String,password:String) {
        DateRepoCompnay.Login(username,password,loginResponseLD)
  }



}