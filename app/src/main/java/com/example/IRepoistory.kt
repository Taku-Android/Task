package com.example

import android.util.Log
import com.ahmedtaku.mafqoud.api.ApiManager
import com.example.route.api.model.Product

interface IRepository {

    suspend fun getProducts(
    ): List<Product?>?

}

class ProductRepository : IRepository {

    override suspend fun getProducts(): List<Product?>? {

        try {

            val response = ApiManager.getApis().getProducts()

            if (response.isSuccessful){
                return response.body()?.products
            }else{
                return emptyList<Product>()
                Log.e("not success", "getAllProduct: ${response.errorBody()?.string()} ", )
            }
        }catch (e:java.lang.Exception){

            Log.e("not success", "getAllProduct: ${e.localizedMessage} ", )

        }
        return emptyList<Product>()

    }

}