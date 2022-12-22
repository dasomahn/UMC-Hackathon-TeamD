package com.softsquared.template.kotlin.src.main.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemArticleBinding
import com.softsquared.template.kotlin.databinding.ItemChattingBinding
import java.util.*

class ChatAdapter(val items: ArrayList<ChatModel>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>(){


    inner class ViewHolder(val binding: ItemChattingBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChattingBinding.inflate(LayoutInflater.from(parent.context),  parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            context.text = items[position].contxt.toString()
            loc.text = items[position].location.toString()
            days.text = items[position].date.toInt().toString()+"일 전"
            userName.text = items[position].name.toString()
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }


}


