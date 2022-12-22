package com.softsquared.template.kotlin.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemArticleBinding
import java.util.*

class ArticleAdapter(val items: ArrayList<ArticleModel>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){


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
    }


    override fun getItemCount(): Int {
        return items.size
    }


}


