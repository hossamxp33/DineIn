package com.example.dinein.presentation.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.MainViewModel;
import com.codesroots.mac.cards.presentaion.mainfragment.viewmodel.SubCategoryModel;
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices;
import com.example.dinein.data_layer.ApiClient;

public class SubViewModelFactory implements ViewModelProvider.Factory {


    private Application application;


    public SubViewModelFactory(Application application1) {
        application = application1;

    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
   if(modelClass == SubCategoryModel.class)
         {
             return (T) new SubCategoryModel(getApiService());
         }

else   {
        throw new IllegalArgumentException("Invalid view model class type");
    }
    }


    private APIServices getApiService() {
        return ApiClient.getClient().create(APIServices.class);
    }

}
