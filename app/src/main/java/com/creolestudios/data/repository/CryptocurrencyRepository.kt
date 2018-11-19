package com.creolestudios.data.repository

import com.creolestudios.data.pojo.CryptocurrencyEntity
import io.reactivex.Observable

interface CryptocurrencyRepository {

    fun getCryptocurrenciesFromApi(): Observable<List<CryptocurrencyEntity>>

}