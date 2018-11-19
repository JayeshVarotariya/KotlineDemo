package com.creolestudios.ui.activity

import android.os.Bundle
import com.creolestudios.R
import com.creolestudios.ui.base.ToolBarActivity
import dagger.android.AndroidInjection


class MainActivity : ToolBarActivity() {

  /*  @Inject
    lateinit var gitService: GithubService*/


    override fun getMainLayout(): Int =  R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
   /*     gitService.getCountry().enqueue(object: Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
             Toast.makeText(this@MainActivity,""+response.body()!!.string(),Toast.LENGTH_SHORT).show()
            }

        })*/


    }



}