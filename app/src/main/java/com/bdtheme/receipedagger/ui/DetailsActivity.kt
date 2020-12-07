package com.bdtheme.receipedagger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bdtheme.receipedagger.R
import com.bdtheme.receipedagger.databinding.ActivityDetailsBinding
import com.bdtheme.receipedagger.model.ReceipeModel
import dagger.android.support.DaggerAppCompatActivity

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val recepe = intent.getParcelableExtra<ReceipeModel>("Recepe")
        binding.receipe = recepe
    }
}