package com.bdtheme.receipedagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bdtheme.receipedagger.adapter.ReceipeAdapter
import com.bdtheme.receipedagger.databinding.ActivityMainBinding
import com.bdtheme.receipedagger.di.AppComponent
import com.bdtheme.receipedagger.model.ReceipeModel
import com.bdtheme.receipedagger.viewmodel.RetroViewModel
import com.bdtheme.receipedagger.viewmodel.RetroViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: RetroViewModelFactory

    lateinit var retroViewModel: RetroViewModel
    lateinit var adapter: ReceipeAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        val appComponent: AppComponent = MyApplication.appComponent
        appComponent.inject(this)


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = ReceipeAdapter(this)
        retroViewModel = ViewModelProvider(this, viewModelFactory).get(RetroViewModel::class.java)

        retroViewModel.recipeLiveData.observe(this, object : Observer<List<ReceipeModel>> {
            override fun onChanged(t: List<ReceipeModel>?) {
                Log.e("LIst", "empty" + (t?.get(0)?.title))
                binding.recycleview.adapter = adapter
                t?.let { adapter.setAdapterList(it) }
            }

        })
    }


}