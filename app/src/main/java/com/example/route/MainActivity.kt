package com.example.route

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.route.api.model.Product
import com.example.route.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.vm = viewModel

        initRecyclerView()
        viewModel.getAllProduct()
        subscribeToLiveData()


    }

    private val productAdapter = ProductAdapter(null)
    private fun initRecyclerView() {
        binding.rv.adapter = productAdapter
    }

    private fun bindNewsList(products: List<Product?>?) {
        productAdapter.changeData(products)
    }

    private fun subscribeToLiveData() {
        viewModel.products.observe(this) {
            bindNewsList(it)
        }

    }

}