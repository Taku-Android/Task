package com.example.route.repository

import com.example.route.api.model.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val remoteDataSourceImpl: ProductsRemoteDataSourceImpl) : ProductsRepository {
    override suspend fun getProducts(): List<Product?>? {
       return remoteDataSourceImpl.getProducts()
    }
}