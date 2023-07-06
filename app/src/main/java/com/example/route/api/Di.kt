package com.example.route.api

import android.util.Log
import com.ahmedtaku.mafqoud.api.ApiManager
import com.ahmedtaku.mafqoud.api.WebServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule{


    @Provides
    fun getLogging():HttpLoggingInterceptor{
        return HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger {
                Log.e("api", it )
            })
    }



    @Provides
    fun getOkHttp(logging:HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    fun getGson():GsonConverterFactory{
        return  GsonConverterFactory.create()
    }

    @Provides
    fun getRetrofit(gson:GsonConverterFactory , okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiManager.EndPoint)
            .addConverterFactory(gson)
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun getServices(
        retrofit: Retrofit
    ):WebServices{
        return  retrofit.create(WebServices::class.java)
    }

}