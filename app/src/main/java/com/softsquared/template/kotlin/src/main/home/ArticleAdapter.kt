package com.softsquared.template.kotlin.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemArticleBinding
import com.softsquared.template.kotlin.src.main.townLife.KeywordRVAdapter
import java.util.*

class ArticleAdapter(private val items: ArrayList<ArticleModel>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    private lateinit var articleClickListener: ArticleClickListener

    interface ArticleClickListener {
        fun onArticleClick(position: Int)
    }

    fun setArticleClickListener(article: ArticleClickListener){
        articleClickListener = article
    }

    inner class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context),  parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            context.text = items[position].contxt.toString()
            location.text = items[position].loc.toString()
            price.text = items[position].cost.toInt().toString()+"원"
        }

        holder.binding.root.setOnClickListener {
            articleClickListener.onArticleClick(holder.adapterPosition)
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }


}


