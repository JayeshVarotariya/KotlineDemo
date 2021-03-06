package com.creolestudios.ui.activity

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.creolestudios.R
import com.creolestudios.data.pojo.CryptocurrencyEntity
import com.creolestudios.data.repository.CryptocurrencyRepository
import com.creolestudios.ui.base.ToolBarActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector

import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainActivity : ToolBarActivity(),HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    @Inject
    lateinit var cryptocurrencyRepository: CryptocurrencyRepository

    override fun getMainLayout(): Int =  R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

                cryptocurrencyRepository.getCryptocurrenciesFromApi()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .debounce(400, TimeUnit.MILLISECONDS)
                    .subscribe(object : DisposableObserver<List<CryptocurrencyEntity>>(){
                        override fun onComplete() {

                        }

                        override fun onNext(t: List<CryptocurrencyEntity>) {
                        }

                        override fun onError(e: Throwable) {
                        }

                    })




    }



}