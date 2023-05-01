package com.example.minor_tbd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class FeedRecyclerAdapter: RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var iv_profilePic: ShapeableImageView = itemView.findViewById(R.id.iv_profilePic)
        var tv_profileName: TextView = itemView.findViewById(R.id.tv_profileName)
        var tv_uploadTime: TextView = itemView.findViewById(R.id.tv_uploadTime)
        var bookmark: View = itemView.findViewById(R.id.bookmark)
        var iv_bannerImage: ShapeableImageView = itemView.findViewById(R.id.iv_bannerPic)
        var blurBg: View = itemView.findViewById(R.id.blur_text_bg)
        var tv_projectTitle: TextView = itemView.findViewById(R.id.tv_projectTitle)
        var tv_projectDescription: TextView = itemView.findViewById(R.id.tv_projectDescription)
        var linearLayoutTagHolder: LinearLayout = itemView.findViewById(R.id.linearLayout_TagHolder)
        var linearLayoutTechStackHolder: LinearLayout = itemView.findViewById(R.id.linearLayout_TechStackHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        var layout:View = LayoutInflater.from(parent.context).inflate(R.layout.project_item_cards,parent,false)
        return FeedViewHolder(layout)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}