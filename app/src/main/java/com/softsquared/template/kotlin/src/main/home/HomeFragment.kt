package com.softsquared.template.kotlin.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse

class HomeFragment : Fragment(R.layout.fragment_home) {

        private lateinit var binding: FragmentHomeBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                val fragmentHomeBinding = FragmentHomeBinding.bind(view)
                binding = fragmentHomeBinding

                val dataList: ArrayList<ArticleModel> = arrayListOf()
                val articleAdapter = ArticleAdapter(dataList)

                dataList.apply {
                        add(ArticleModel("게시글 내용입니다.","강남", 2000))
                        add(ArticleModel("게시글 내용2", "개포", 3000))
                        add(ArticleModel("게시글 내용3", "개포", 2000))
                        add(ArticleModel("게시글 내용4", "개포", 2000))
                        add(ArticleModel("게시글 내용5", "개포",2000))
                        add(ArticleModel("게시글 내용..", "개포",2000))

                }
                articleAdapter.notifyItemInserted(dataList.size)

                binding.rvData.adapter = articleAdapter
                binding.rvData.layoutManager = LinearLayoutManager(activity)
        }
}