package com.example.dinein.helper;

public interface EditCallbacks {

    public void onPlusProduct(int index);
    public void onRemoveProduct(int index, int count, float itemprice);
    public void onMinusProduct(int index);

}
