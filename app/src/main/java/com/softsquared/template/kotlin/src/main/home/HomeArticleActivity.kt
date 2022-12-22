package com.softsquared.template.kotlin.src.main.home

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHomeArticleBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.time.Year

class HomeArticleActivity :
    BaseActivity<ActivityHomeArticleBinding>(ActivityHomeArticleBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extras = intent.extras

        val idx = extras!!["idx"] as Int

        val join = Retrofit.Builder()
            .baseUrl("http://3.38.32.124/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        join.create(HomeFragmentInterface::class.java)
            .getHomeArticle(idx)
            .enqueue(object : Callback<HomeArticleResponse> {
                override fun onResponse(call: Call<HomeArticleResponse>, response: Response<HomeArticleResponse>) {
                    Log.d(
                        ContentValues.TAG, "onResponse: \n${response.body()}"
                    )

                    if(response.body() != null && response.body()!!.isSuccess) {
                        val result = response.body()!!.result
                        binding.apply {
                            nickname.text = result.nickname
                            region.text = result.region
                            title.text = result.title
                            manner.text = result.manner.toString()
                            category.text = result.cateName
                            content.text = result.content
                            price.text = result.price.toString()
                            time.text = SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분").format(result.createdAt)
                        }
                        if(result.wantNego == "Y")
                            binding.nego.text = "가격제안 가능"
                    }
                }

                override fun onFailure(call: Call<HomeArticleResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                }
            })
    }
}