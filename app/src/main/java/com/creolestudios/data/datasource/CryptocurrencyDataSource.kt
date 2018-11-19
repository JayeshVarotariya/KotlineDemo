package com.creolestudios.data.datasource

import android.util.Log
import com.creolestudios.data.pojo.CryptocurrencyEntity
import com.creolestudios.data.repository.CryptocurrencyRepository
import com.creolestudios.data.source.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject

class CryptocurrencyDataSource   @Inject constructor(val apiInterface: ApiInterface) :CryptocurrencyRepository {

    override fun getCryptocurrenciesFromApi(): Observable<List<CryptocurrencyEntity>> {
        return apiInterface.getCryptocurrencies("0")
            .doOnNext {
                Log.e("REPOSITORY API * ", it.size.toString())
            }
    }

}