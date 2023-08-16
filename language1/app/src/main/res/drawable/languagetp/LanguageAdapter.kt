package com.example.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.languagetp.R

class LanguageAdapter(private val languagelist: List<Outdata>):RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    //class ViewHolder
    inner class LanguageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.language_item_layout,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return languagelist.size

    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languagelist[position]
        holder.itemView.apply {
            findViewById<ImageView>(R.id.flag_id).setImageResource(language.image)
            findViewById<TextView>(R.id.txtlanggue).text=language.text
        }
    }
}