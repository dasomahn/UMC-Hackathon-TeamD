package com.softsquared.template.kotlin.src.main.townLife

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemKeywordBinding

class KeywordRVAdapter(private val dataList: ArrayList<KeywordItemHolder>):
    RecyclerView.Adapter<KeywordRVAdapter.ItemViewHolder>()  {

    private lateinit var keywordClickListener: KeywordClickListener

    interface KeywordClickListener {
        fun onKeywordClick(position: Int)
    }

    fun setKeywordClickListener(story: KeywordClickListener){
        keywordClickListener = story
    }

    inner class ItemViewHolder(private val binding: ItemKeywordBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: KeywordItemHolder) {
            binding.itemKeywordTxt.text = data.keyword
            if(data.image != 0)
                binding.itemKeywordImg.setImageResource(data.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemKeywordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int = dataList.size
}