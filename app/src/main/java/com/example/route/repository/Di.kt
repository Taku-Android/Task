package com.example.route.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductModule{

    @Binds
    abstract fun getProductRepo(productRepository: ProductRepositoryImpl):ProductsRepository

}

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDataSourceModule{

    @Binds
    abstract fun getProductDataSource(productsRemoteDataSourceImpl: ProductsRemoteDataSourceImpl)
    :RemoteDataSource

}