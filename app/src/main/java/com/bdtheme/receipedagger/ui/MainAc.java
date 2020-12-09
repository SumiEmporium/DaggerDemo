package com.bdtheme.receipedagger.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bdtheme.receipedagger.R;
import com.bdtheme.receipedagger.adapter.ReceipeAdapter;
import com.bdtheme.receipedagger.databinding.ActivityMainBinding;
import com.bdtheme.receipedagger.model.ReceipeModel;
import com.bdtheme.receipedagger.viewmodel.RetroViewModel;
import com.bdtheme.receipedagger.viewmodel.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainAc extends DaggerAppCompatActivity {
    ActivityMainBinding binding;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       ReceipeAdapter adapter = new ReceipeAdapter(this);
      RetroViewModel retroViewModel = new ViewModelProvider(this, viewModelFactory).get(RetroViewModel.class);
      retroViewModel.getRecipeLiveData().observe(this, new Observer<List<ReceipeModel>>() {
          @Override
          public void onChanged(List<ReceipeModel> receipeModels) {
              adapter.setAdapterList(receipeModels);
              binding.recycleview.setAdapter(adapter);
          }
      });
    }
}
