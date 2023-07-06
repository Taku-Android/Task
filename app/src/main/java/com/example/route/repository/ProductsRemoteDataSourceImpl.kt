package com.example.route.repository

import com.ahmedtaku.mafqoud.api.WebServices
import com.example.route.api.model.Product
import javax.inject.Inject


class ProductsRemoteDataSourceImpl @Inject constructor(private val services: WebServices) : RemoteDataSource {

    override suspend fun getProducts(): List<Product?>? {

        val response = services.getProducts()
        return response.body()?.products

    }

}
