package com.ahmedtaku.mafqoud.api

import com.example.route.api.model.ProductsModel
import retrofit2.Response
import retrofit2.http.GET


interface WebServices {

    @GET("products")
    suspend fun getProducts(
    ): Response<ProductsModel>

}

