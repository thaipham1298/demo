package com.example.language1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.language1.RvAdapter

class RvAdapter (val languagelist:List<OutData>):RecyclerView.Adapter<RvAdapter.LanguageViewHolder>() {
    inner class LanguageViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvAdapter.LanguageViewHolder {
        return LanguageViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.language_item_layout,parent,false)
        )

    }

    override fun onBindViewHolder(holder: RvAdapter.LanguageViewHolder, position: Int) {
        val language = languagelist[position]
        holder.itemView.apply {
            findViewById<ImageView>(R.id.img_flag).setImageResource(language.image)
            findViewById<TextView>(R.id.text_language).setText(language.text)
        }
    }

    override fun getItemCount(): Int {
        return languagelist.size
    }
}