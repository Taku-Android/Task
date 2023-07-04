package com.example.route

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.route.api.model.Product
import com.example.route.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
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