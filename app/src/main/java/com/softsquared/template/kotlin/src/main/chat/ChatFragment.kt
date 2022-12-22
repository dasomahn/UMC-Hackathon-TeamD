package com.softsquared.template.kotlin.src.main.chat

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentChatBinding
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse

class ChatFragment : Fragment(R.layout.fragment_chat) {

        private lateinit var binding: FragmentChatBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                val fragmentChatBinding = FragmentChatBinding.bind(view)
                binding = fragmentChatBinding

                val dataList: ArrayList<ChatModel> = arrayListOf()
                val chatAdapter = ChatAdapter(dataList)

                dataList.apply {
                        add(ChatModel("대화 내용입니다","강남", "MC", 2))
                        add(ChatModel("대화 내용2입니다", "개포", "D조", 3))
                        add(ChatModel("대화 내용3입니다", "개포", "채니", 3))
                        add(ChatModel("대화 내용4입니다", "개포", "솜", 3))
                        add(ChatModel("대화 내용5입니다", "개포","마라",3))
                        add(ChatModel("대화 내용6입니다", "개포","라마",3))
                        add(ChatModel("대화 내용7입니다", "개포", "솜솜", 3))
                        add(ChatModel("대화 내용8입니다", "개포","마라",3))
                        add(ChatModel("대화 내용9입니다", "개포","가가",3))

                }
                chatAdapter.notifyItemInserted(dataList.size)

                binding.rvData.adapter = chatAdapter
                binding.rvData.layoutManager = LinearLayoutManager(activity)
        }
}