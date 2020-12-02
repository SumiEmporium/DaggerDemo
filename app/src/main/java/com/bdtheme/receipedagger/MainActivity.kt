package com.bdtheme.receipedagger

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bdtheme.receipedagger.adapter.ReceipeAdapter
import com.bdtheme.receipedagger.databinding.ActivityMainBinding
import com.bdtheme.receipedagger.model.ReceipeModel
import com.bdtheme.receipedagger.viewmodel.RetroViewModel
import com.bdtheme.receipedagger.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var retroViewModel: RetroViewModel
    lateinit var adapter: ReceipeAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = ReceipeAdapter(this)
        retroViewModel = ViewModelProvider(this, viewModelFactory).get(RetroViewModel::class.java)

        retroViewModel.recipeLiveData.observe(this, object : Observer<List<ReceipeModel>> {
            override fun onChanged(t: List<ReceipeModel>?) {
                binding.recycleview.adapter = adapter
                t?.let { adapter.setAdapterList(it) }
            }

        })
    }


}