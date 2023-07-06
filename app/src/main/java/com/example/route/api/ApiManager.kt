package com.ahmedtaku.mafqoud.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiManager {

    companion object{
        const val EndPoint = "https://dummyjson.com/"
        var retrofit : Retrofit?=null
        @Synchronized fun getInstance():Retrofit{
            if (retrofit == null){

                val logging = HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger {
                        Log.e("api", it )
                    }
                )
                logging.setLevel(Level.BODY);
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(EndPoint)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return  retrofit!!
        }

        fun getApis():WebServices{
            return  getInstance().create(WebServices::class.java);
        }

    }

}