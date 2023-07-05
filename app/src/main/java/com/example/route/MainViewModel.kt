package com.example.route

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedtaku.mafqoud.api.ApiManager
import com.example.ProductRepository
import com.example.route.api.model.Product
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    val repository = ProductRepository()
    private val _products = MutableLiveData<List<Product?>?>()
    val products: LiveData<List<Product?>?> get() = _products



    fun getAllProduct() {


        viewModelScope.launch(Dispatchers.Main) {
           _products.value = repository.getProducts()
        }


    }

}