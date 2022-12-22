package com.softsquared.template.kotlin.src.main.townLife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemTownLifeCategoryArticleBinding

class TownLifeCategoryArticleRVAdapter(private val dataList: ArrayList<TownLifeCategoryArticleItemHolder>):
    RecyclerView.Adapter<TownLifeCategoryArticleRVAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemTownLifeCategoryArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TownLifeCategoryArticleItemHolder) {
            binding.itemTownLifeArticleContent.text = data.content
            binding.itemTownLifeArticleRegion.text = data.region
            binding.itemTownLifeArticleTime.text = data.time

            if(data.commentNum > 0)
            {
                binding.itemTownLifeArticleComment.visibility = View.VISIBLE
                binding.itemTownLifeArticleCommentNum.visibility = View.VISIBLE
                binding.itemTownLifeArticleCommentNum.text = data.commentNum.toString()
            }
            if(data.likeNum > 0)
            {
                binding.itemTownLifeArticleLike.visibility = View.VISIBLE
                binding.itemTownLifeArticleLikeNum.visibility = View.VISIBLE
                binding.itemTownLifeArticleLikeNum.text = data.likeNum.toString()
            }
            if(data.category == "분실/실종")
            {
                binding.itemTownLifeArticleCategory.visibility = View.VISIBLE
            }
            if(data.image != "")
            {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemTownLifeCategoryArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}