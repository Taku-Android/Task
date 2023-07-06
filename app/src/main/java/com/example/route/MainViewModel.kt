package com.example.route

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedtaku.mafqoud.api.ApiManager
import com.example.route.api.model.Product
import com.example.route.repository.ProductRepositoryImpl
import com.example.route.repository.ProductsRemoteDataSourceImpl
import com.example.route.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {

    //private val productDataSource = ProductsRemoteDataSourceImpl(ApiManager.getApis())
    //private val repository = ProductRepositoryImpl(productDataSource)


    private val _products = MutableLiveData<List<Product?>?>()
    val products: LiveData<List<Product?>?> get() = _products



    fun getAllProduct() {


        viewModelScope.launch(Dispatchers.Main) {
           _products.value = repository.getProducts()
        }


    }

}