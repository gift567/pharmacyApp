package com.example.pharamacy.repositries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pharamacy.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();

        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Panado", 12, true));
        mutableProductList.setValue(productList);
    }
}
