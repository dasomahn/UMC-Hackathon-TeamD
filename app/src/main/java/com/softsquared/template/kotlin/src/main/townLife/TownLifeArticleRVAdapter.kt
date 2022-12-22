package com.softsquared.template.kotlin.src.main.townLife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemTownLifeArticleBinding

class TownLifeArticleRVAdapter(private val dataList: ArrayList<TownLifeArticleItemHolder>):
    RecyclerView.Adapter<TownLifeArticleRVAdapter.ItemViewHolder>()  {

    inner class ItemViewHolder(private val binding: ItemTownLifeArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TownLifeArticleItemHolder) {
            binding.itemTownLifeArticleContent.text = data.content
            binding.itemTownLifeArticleInfo.text = data.info
            binding.itemTownLifeArticleCategory.text = data.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemTownLifeArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}