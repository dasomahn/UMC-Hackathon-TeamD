package com.softsquared.template.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMyPageProfileBinding

class MyPageProfileActivity :
    BaseActivity<ActivityMyPageProfileBinding>(ActivityMyPageProfileBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.myPageProfileBtnUpdate.setOnClickListener {
            val intent = Intent(this, MyPageProfileUpdateActivity::class.java)

            startActivity(intent)
        }

    }
}