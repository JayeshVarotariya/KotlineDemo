package com.creolestudios.di.builder

import com.creolestudios.data.URLFactory
import com.creolestudios.data.datasource.CryptocurrencyDataSource
import com.creolestudios.data.repository.CryptocurrencyRepository
import com.creolestudios.data.source.remote.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()


    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): ApiInterface =retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun providesCryptocurrencyRepository(cryptocurrencyDataSource : CryptocurrencyDataSource): CryptocurrencyRepository = cryptocurrencyDataSource

}