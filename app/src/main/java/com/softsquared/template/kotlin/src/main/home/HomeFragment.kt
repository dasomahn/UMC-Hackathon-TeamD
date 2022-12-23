package com.softsquared.template.kotlin.src.main.home

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment(R.layout.fragment_home) {

        private lateinit var binding: FragmentHomeBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                val fragmentHomeBinding = FragmentHomeBinding.bind(view)
                binding = fragmentHomeBinding

                val dataList: ArrayList<ArticleModel> = arrayListOf()
                val articleAdapter = ArticleAdapter(dataList)

                val join = Retrofit.Builder()
                        .baseUrl("http://3.38.32.124/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                join.create(HomeFragmentInterface::class.java)
                        .getHomeArticleList()
                        .enqueue(object : Callback<HomeArticleListResponse> {
                                override fun onResponse(call: Call<HomeArticleListResponse>, response: Response<HomeArticleListResponse>) {
                                        Log.d(
                                                ContentValues.TAG, "onResponse: \n${response.body()}"
                                        )

                                        if(response.body() != null && response.body()!!.isSuccess) {
                                                for(data in response.body()!!.result)
                                                {
                                                        dataList.add(ArticleModel(data.idx, data.title, data.region, data.price))
                                                        articleAdapter.notifyItemInserted(dataList.size)
                                                }
                                        }
                                }

                                override fun onFailure(call: Call<HomeArticleListResponse>, t: Throwable) {
                                        Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                                }
                        })

                binding.rvData.adapter = articleAdapter
                binding.rvData.layoutManager = LinearLayoutManager(activity)

                articleAdapter.setArticleClickListener(object : ArticleAdapter.ArticleClickListener {
                        override fun onArticleClick(position: Int) {
                                val intent = Intent(this@HomeFragment.context, HomeArticleActivity::class.java)

                                intent.putExtra("idx", dataList[position].idx)

                                startActivity(intent)
                        }
                })
        }
}