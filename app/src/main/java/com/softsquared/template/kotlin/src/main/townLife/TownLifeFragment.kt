package com.softsquared.template.kotlin.src.main.townLife

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentTownLifeBinding
import com.softsquared.template.kotlin.src.main.myPage.MyPageProfileActivity

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

        townLifeDataList.apply {
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
            add(TownLifeArticleItemHolder("이건 내용입니다", "닉네임" + "·" + "지역", "카테고리"))
        }

        townLifeArticleAdapter.notifyItemInserted(townLifeDataList.size)
        binding.mainPost.adapter = townLifeArticleAdapter
        binding.mainPost.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)

    }
}