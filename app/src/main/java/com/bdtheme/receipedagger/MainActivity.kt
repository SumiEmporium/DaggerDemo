package com.bdtheme.receipedagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bdtheme.receipedagger.model.ReceipeResponse
import com.bdtheme.receipedagger.viewmodel.RetroViewModel
import com.bdtheme.receipedagger.viewmodel.RetroViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var retroViewModel: RetroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retroViewModelFactory = RetroViewModelFactory()
        retroViewModel =
            ViewModelProvider(this, retroViewModelFactory).get(RetroViewModel::class.java)

        retroViewModel.recipeLiveData.observe(this, object : Observer<List<ReceipeResponse>> {
            override fun onChanged(t: List<ReceipeResponse>?) {
                Log.e("LIst", "empty" + (t?.get(0)?.title))
            }

        })
    }


}