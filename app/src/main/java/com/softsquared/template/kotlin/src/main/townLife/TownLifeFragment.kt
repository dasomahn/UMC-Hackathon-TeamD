package com.softsquared.template.kotlin.src.main.townLife

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentTownLifeBinding
import com.softsquared.template.kotlin.src.main.home.ArticleModel
import com.softsquared.template.kotlin.src.main.home.HomeArticleListResponse
import com.softsquared.template.kotlin.src.main.home.HomeFragmentInterface
import com.softsquared.template.kotlin.src.main.myPage.MyPageProfileActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TownLifeFragment :
    BaseFragment<FragmentTownLifeBinding>(FragmentTownLifeBinding::bind,
        R.layout.fragment_town_life
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList: ArrayList<KeywordItemHolder> = arrayListOf()
        val keywordRVAdapter = KeywordRVAdapter(dataList)

        dataList.apply {
            add(KeywordItemHolder(R.drawable.ic_category, "주제"))
            add(KeywordItemHolder(0, "반짝모임"))
            add(KeywordItemHolder(0, "동네소식"))
            add(KeywordItemHolder(0, "동네질문"))
            add(KeywordItemHolder(0, "동네맛집"))
            add(KeywordItemHolder(0, "취미생활"))
            add(KeywordItemHolder(0, "일상"))
            add(KeywordItemHolder(0, "분실/실종센터"))
            add(KeywordItemHolder(0, "동네사건사고"))
            add(KeywordItemHolder(0, "해주세요"))
            add(KeywordItemHolder(0, "동네사진전"))
        }
        keywordRVAdapter.notifyItemInserted(dataList.size)
        binding.mainStory.adapter = keywordRVAdapter
        binding.mainStory.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        keywordRVAdapter.setKeywordClickListener(object : KeywordRVAdapter.KeywordClickListener {
            override fun onKeywordClick(position: Int) {
                val intent = Intent(this@TownLifeFragment.context, TownLifeCategoryActivity::class.java)

                startActivity(intent)
            }
        })

        val townLifeDataList: ArrayList<TownLifeArticleItemHolder> = arrayListOf()
        val townLifeArticleAdapter = TownLifeArticleRVAdapter(townLifeDataList)

        val join = Retrofit.Builder()
            .baseUrl("http://3.38.32.124/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        join.create(TownLifeRetrofitInterface::class.java)
            .getTownLifeArticleList()
            .enqueue(object : Callback<TownLifeArticleListResponse> {
                override fun onResponse(call: Call<TownLifeArticleListResponse>, response: Response<TownLifeArticleListResponse>) {
                    Log.d(
                        ContentValues.TAG, "onResponse: \n${response.body()}"
                    )

                    if(response.body() != null && response.body()!!.isSuccess) {
                        for(data in response.body()!!.result)
                        {
                            townLifeDataList.add(TownLifeArticleItemHolder(data.content, data.nickname + "·" + data.region, data.cateName))
                            townLifeArticleAdapter.notifyItemInserted(dataList.size)
                        }
                    }
                }

                override fun onFailure(call: Call<TownLifeArticleListResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                }
            })

        binding.mainPost.adapter = townLifeArticleAdapter
        binding.mainPost.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)

    }
}