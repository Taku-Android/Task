package com.example.route.repository

import com.example.route.api.model.Product

interface ProductsRepository {

    suspend fun getProducts(
    ): List<Product?>?

}

interface RemoteDataSource {

    suspend fun getProducts(
    ): List<Product?>?

}