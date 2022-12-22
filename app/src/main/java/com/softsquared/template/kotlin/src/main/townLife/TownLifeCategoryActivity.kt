package com.softsquared.template.kotlin.src.main.townLife

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityTownLifeCategoryBinding
import com.softsquared.template.kotlin.src.main.myPage.MyPageProfileActivity

class TownLifeCategoryActivity  :
    BaseActivity<ActivityTownLifeCategoryBinding>(ActivityTownLifeCategoryBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        binding.mainStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        keywordRVAdapter.setKeywordClickListener(object : KeywordRVAdapter.KeywordClickListener {
            override fun onKeywordClick(position: Int) {
                val intent = Intent(this@TownLifeCategoryActivity, MyPageProfileActivity::class.java)

                startActivity(intent)
            }
        })

        val townLifeArticleDataList: ArrayList<TownLifeCategoryArticleItemHolder> = arrayListOf()
        val townLifeArticleAdapter = TownLifeCategoryArticleRVAdapter(townLifeArticleDataList)

        townLifeArticleDataList.apply {
            add(
                TownLifeCategoryArticleItemHolder("이건 내용입니다", "지역" + "·", "시간"
                    , 1 , 2 , "" , "카테고리")
            )
        }

        townLifeArticleAdapter.notifyItemInserted(townLifeArticleDataList.size)
        binding.mainPost.adapter = townLifeArticleAdapter
        binding.mainPost.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}