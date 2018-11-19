package com.creolestudios.di.builder

import com.creolestudios.rest.URLFactory
import com.creolestudios.rest.apiinterface.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun providesOkHttpClient():OkHttpClient= OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit=Retrofit.Builder().baseUrl(URLFactory.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()


    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit):ApiInterface=retrofit.create(ApiInterface::class.java)


}