package com.example.pharamacy.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pharamacy.R;
import com.example.pharamacy.adapters.ShopListAdapter;
import com.example.pharamacy.databinding.FragmentShopBinding;
import com.example.pharamacy.models.Product;
import com.example.pharamacy.viewmodels.ShopViewModel;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

 FragmentShopBinding fragmentShopBinding;
 private ShopListAdapter shopListAdapter;
 private ShopViewModel shopViewModel;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       fragmentShopBinding = fragmentShopBinding.inflate(inflater, container, false);
       return fragmentShopBinding.getRoot();
    }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      shopListAdapter = new ShopListAdapter();
      fragmentShopBinding.shopRecyclerview.setAdapter(shopListAdapter);
      fragmentShopBinding.shopRecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
      fragmentShopBinding.shopRecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

      shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
      shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
          @Override
          public void onChanged(List<Product> products) {
              shopListAdapter.submitList(products);
          }
      });
   }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}