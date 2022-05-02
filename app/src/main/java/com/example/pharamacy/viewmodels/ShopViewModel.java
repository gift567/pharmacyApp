package com.example.pharamacy.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pharamacy.models.Product;
import com.example.pharamacy.repositries.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

 ShopRepo shopRepo = new ShopRepo();


 public LiveData<List<Product>> getProducts () {
  return shopRepo.getProducts();

 }
}
