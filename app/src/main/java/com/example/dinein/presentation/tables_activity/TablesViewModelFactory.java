package com.example.dinein.presentation.tables_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codesroots.hossam.mandoobapp.presentation.login.ViewModel.LoginViewModel;
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel;
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices;
import com.example.dinein.data_layer.ApiClient;

public class TablesViewModelFactory implements ViewModelProvider.Factory {


    private Application application;
    int userid;//// for getorder to this user



    public TablesViewModelFactory(Application application1) {
        application = application1;
    }


    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

         if (modelClass == TablesViewModel.class)
        {
            return (T) new TablesViewModel(getApiService());
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }



    private APIServices getApiService() {
        return ApiClient.getClient().create(APIServices.class);
    }


}
