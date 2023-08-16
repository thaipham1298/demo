package com.example.language1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IntroslideAdapter(private val introSlide: List<IntroData>): RecyclerView.Adapter<IntroslideAdapter.IntroslideViewHolder>(){


    private val hasData=introSlide.isNotEmpty()
    inner class IntroslideViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroslideViewHolder {
        return IntroslideViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.intro_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: IntroslideViewHolder, position: Int) {
        val slide=introSlide[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.textTitle).text = context.getString(slide.title)
            findViewById<ImageView>(R.id.image_intro).setImageResource(slide.imageResourceId1)
        }
    }

    override fun getItemCount(): Int {
        return if(hasData) introSlide.size else 0
    }

}