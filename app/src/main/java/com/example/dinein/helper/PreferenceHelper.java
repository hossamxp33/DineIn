package com.example.dinein.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PreferenceHelper {

    private static SharedPreferences app_prefs;
    private static String app_ref = "userdetails";
    private static String photo = "photo";
    private static String Token = "token";
    private static String UserId = "userid";
    private static String FirstForCountryy = "FirstForCountryy";
    private static String Language = "language";
    private static String CURRENCY = "CURRENCY";
    private static String CURRENCY_ARABIC = "CURRENCY_ARABIC";
    private static String CURRENCY_VALUE = "CURRENCY_VALUE";
    private static final String USER_GROUP_ID = "USERGROUPID";
    private static final String COUNTRY_ID = "COUNTRY_ID";
    private final static String USER_NAME = "USERNAME";
    private final static String CART_ARRAY = "CART_ARRAY";
    private final static String Color_ARRAY = "Color_ARRAY";
    private final static String URL_Base = "URL_Base";
    private final static String PHONE_NUM = "PHONE_NUM";

    private final static String Doller_value = "Doller_value";
    private final static String IN_OMAN = "IN_OMAN";
    private final static String OUT_OMAN = "OUT_OMAN";
    private final static String MIN_CHIPPING = "MIN_CHIPPING";
    private final static String PaymentToken = "PaymentToken";
    private final static String PaymentMerchatId = "PaymentMerchatId";

    private final static  ArrayList arrPackage = new ArrayList<>();
    private final static  ArrayList ColorPackage = new ArrayList<>();

    private Context context;

    public PreferenceHelper(Context context) {
        this.context = context;
        try {
            app_prefs = context.getSharedPreferences(app_ref, Context.MODE_PRIVATE);
        } catch (NullPointerException e) {

        }
    }

    public static void setPaymentMerchatId(String API_TOKEN) {
        Editor edit = app_prefs.edit();
        edit.putString(PaymentMerchatId, API_TOKEN);
        edit.commit();
    }
    public static String getPaymentMerchatId() {

        return app_prefs.getString(PaymentMerchatId,"1");
    }

    public static void setPaymentToken(String API_TOKEN) {
        Editor edit = app_prefs.edit();
        edit.putString(PaymentToken, API_TOKEN);
        edit.commit();
        edit.apply();
    }
    public static String getPaymentToken() {

        return app_prefs.getString(PaymentToken,"1");
    }
    public static void setUSER_GROUP_ID(int group) {
        Editor edit = app_prefs.edit();
        edit.putInt(USER_GROUP_ID, group);
        edit.apply();
    }

    public static void setCountryId(int countryId) {
        Editor edit = app_prefs.edit();
        edit.putInt(COUNTRY_ID, countryId);
        edit.apply();
    }
    public static void setURL_Base(String API_TOKEN) {
        Editor edit = app_prefs.edit();
        edit.putString(URL_Base, API_TOKEN);
        edit.commit();
    }
    public static String getURL_Base() {

        return app_prefs.getString(URL_Base,"1");
    }
    public static void setPhoneNum(String PHONE_NUM) {
        Editor edit = app_prefs.edit();
        edit.putString(PHONE_NUM, PHONE_NUM);
        edit.commit();
    }
    public static String getPhoneNum() {

        return app_prefs.getString(PHONE_NUM,"1");
    }

    public static void setCURRENCY_VALUE(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(CURRENCY_VALUE, value);
        edit.apply();
    }
    public static void setFirstForCountry(int value) {
        Editor edit = app_prefs.edit();
        edit.putInt(FirstForCountryy, value);
        edit.apply();
    }

    public static void setCURRENCY(String currency) {
        Editor edit = app_prefs.edit();
        edit.putString(CURRENCY, currency);
        edit.apply();
    }

    public static void setDoller_value(float doller_value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(Doller_value, doller_value);
        edit.apply();
    }
    public static void setInOman(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(IN_OMAN, value);
        edit.apply();
    }



    public static void setMinChipping(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(MIN_CHIPPING, value);
        edit.apply();
    }


    public static void setOutOman(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(OUT_OMAN, value);
        edit.apply();
    }

    public static void setCURRENCYArabic(String Currencyar) {
        Editor edit = app_prefs.edit();
        edit.putString(CURRENCY_ARABIC, Currencyar);
        edit.apply();
    }

    public static float getDoller() {
        return app_prefs.getFloat(Doller_value, 1);
    }

    public static float getMIM_CHIPPING() {
        return app_prefs.getFloat(MIN_CHIPPING, 0);
    }

    public static int getCOUNTRY_ID() {
        return app_prefs.getInt(COUNTRY_ID, 1);
    }

    public static int getFirstForCountryy() {
        return app_prefs.getInt(FirstForCountryy,1);
    }

    public static float getCurrencyValue() {
        return app_prefs.getFloat(CURRENCY_VALUE, 1);
    }
    public static float getIN_OMAN() {
        return app_prefs.getFloat(OUT_OMAN, 0);
    }

    public static float getOUT_OMAN() {
        return app_prefs.getFloat(OUT_OMAN, 0);
    }


    public static String getCurrencyArabic() {
        return app_prefs.getString(CURRENCY_ARABIC,null);
    }

    public static String getCurrency() {
        return app_prefs.getString(CURRENCY, null);
    }

    public static void addColorstoCart(int product_id)
    {
        Set<String> set ;
        set = app_prefs.getStringSet(Color_ARRAY, null);
        if (set==null)
            set = new HashSet<String>();
        set.add(String.valueOf(product_id));
        Editor editor = app_prefs.edit();
        editor.putStringSet(Color_ARRAY, set);
        editor.apply();
    }
    public static ArrayList GETColorstoCart()
    {
        Set<String> set = app_prefs.getStringSet(Color_ARRAY, null);
        if (set == null)
            return null;
        else
            ColorPackage.addAll(set);
        return ColorPackage;
    }


    public static void addItemtoCart(int product_id)
    {
        Gson gson = new Gson();
        String json = app_prefs.getString(CART_ARRAY, "");
        Type type = new TypeToken<List<String>>() {}.getType();

        List<String> arrayList = gson.fromJson(json,type);
        if (arrayList==null)
            arrayList = new ArrayList<>();
        //  arrayList.(String.valueOf(product_id));
        Editor editor = app_prefs.edit();
        arrayList.add(String.valueOf(product_id));
        String newdata = gson.toJson(arrayList,type);
        editor.putString(CART_ARRAY, newdata);
        editor.apply();
        editor.commit();
    }

    public static ArrayList retriveCartItemsValue() {
        arrPackage.clear();
        Gson gson = new Gson();
        String json = app_prefs.getString(CART_ARRAY, "");
        Type type = new TypeToken<List<String>>() {}.getType();

        List<String> arrayList = gson.fromJson(json,type);
        if (arrayList == null)
            return null;
        else
            arrPackage.addAll(arrayList);
        return arrPackage;
    }

    public static int  retriveCartItemsSize() {
        Gson gson = new Gson();
        String json = app_prefs.getString(CART_ARRAY, null);
        Type type = new TypeToken<List<String>>() {}.getType();
        List<String> arrayList = gson.fromJson(json,type);
        if (arrayList == null)
            return 0;
        else
            return arrayList.size();
    }


    public static  void removeItemFromCart(int product_id)
    {
        Gson gson = new Gson();
        Editor editor = app_prefs.edit();
        String json = app_prefs.getString(CART_ARRAY, null);
        Type type = new TypeToken<List<String>>() {}.getType();
        List<String> arrayList = gson.fromJson(json,type);
        arrayList.remove(String.valueOf(product_id));
        String newdata = gson.toJson(arrayList,type);
        editor.putString(CART_ARRAY, newdata);
        editor.apply();
        arrPackage.clear();
        arrPackage.addAll(arrayList);
        arrayList.remove(String.valueOf(product_id));

    }

    public static  void clearCart()
    {
        Editor editor = app_prefs.edit();
        editor.remove(Color_ARRAY);
        editor.remove(CART_ARRAY);

        editor.apply();
        editor.commit();
        String json = app_prefs.getString(CART_ARRAY, "");

    }

    public static int getUSER_GROUP_ID() {
        return app_prefs.getInt(USER_GROUP_ID, 0);
    }

    public static void setUserName(String name) {
        Editor edit = app_prefs.edit();
        edit.putString(USER_NAME, name);
        edit.apply();
    }

    public static String getUserName() {
        return app_prefs.getString(USER_NAME,null);
    }



    public static void setToken(String API_TOKEN) {
        Editor edit = app_prefs.edit();
        edit.putString(Token, API_TOKEN);
        edit.commit();
    }
    public static String getToken() {

        return app_prefs.getString(Token,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImV4cCI6MTU3Mzk2ODg3MH0.w45qrjLBSXaGfHRATa33EwGG-IfPkhKbnZSbflWRLSo");

    }

    public static int getUserId() {
        if (app_prefs!=null)
        return app_prefs.getInt(UserId, 0);
        else
            return 0;
    }

    public void setLanguage(String language) {
        Editor edit = app_prefs.edit();
        edit.putString(Language, language);
        edit.commit();
    }

    public String getLanguage() {
        return app_prefs.getString(Language, null);
    }


    public static void setUserId(int user_id) {
        Editor edit = app_prefs.edit();
        edit.putInt(UserId, user_id);
        edit.apply();
    }


    public void Logout() {
        setToken(null);
        setUserId(0);
    }

    public void clearRequestData() {
    }

}
