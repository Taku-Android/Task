package com.example.route.repository

import com.example.route.api.model.Product

class ProductRepository(private val remoteDataSourceImpl: ProductsRemoteDataSourceImpl) : ProductsRepository {
    override suspend fun getProducts(): List<Product?>? {
       return remoteDataSourceImpl.getProducts()
    }
}