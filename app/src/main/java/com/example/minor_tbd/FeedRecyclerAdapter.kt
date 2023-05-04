package com.example.minor_tbd

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import android.widget.LinearLayout.LayoutParams;

class FeedRecyclerAdapter(var projectPost : MutableList<ProjectPost_Elements>): RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var iv_profilePic: ShapeableImageView = itemView.findViewById(R.id.iv_profilePic)
        var tv_profileName: TextView = itemView.findViewById(R.id.tv_profileName)
        var tv_uploadTime: TextView = itemView.findViewById(R.id.tv_uploadTime)
        var bookmark: View = itemView.findViewById(R.id.bookmark)
        var iv_bannerImage: ShapeableImageView = itemView.findViewById(R.id.iv_bannerPic)
        var blurBg: ConstraintLayout = itemView.findViewById(R.id.blur_text_bg)
        var tv_projectTitle: TextView = itemView.findViewById(R.id.tv_projectTitle)
        var tv_projectDescription: TextView = itemView.findViewById(R.id.tv_projectDescription)
        var linearLayoutTagHolder: LinearLayout = itemView.findViewById(R.id.linearLayout_TagHolder)
        var linearLayoutTechStackHolder : LinearLayout = itemView.findViewById(R.id.linearLayout_TechStackHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        var layout:View = LayoutInflater.from(parent.context).inflate(R.layout.project_item_cards,parent,false)
        return FeedViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return projectPost.size
    }


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.apply {

            iv_profilePic.setImageResource(projectPost[position].profilePic)

            tv_profileName.text = projectPost[position].profileName

            tv_uploadTime.text = projectPost[position].uploadTime

            if(projectPost[position].bookmarkState == 0){
                bookmark.setBackgroundResource(R.drawable.bookmark)
            }
            else if(projectPost[position].bookmarkState == 1){
                bookmark.setBackgroundResource(R.drawable.bookmark_clicked)
            }

            iv_bannerImage.setImageResource(projectPost[position].bannerImage)

            tv_projectTitle.text = projectPost[position].projectTitle

            tv_projectDescription.text = projectPost[position].projectDescription

            val context: Context = holder.itemView.context
            for (i in 0 until projectPost[position].tag.size)
            {
                val tv = TextView(holder.itemView.context)
                val params = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
                params.setMargins(0,0,pixelsToDp(8,context),0)
                tv.layoutParams = params
                val tvString = "#${projectPost[position].tag[i]}"
                tv.text = tvString
                tv.setTextAppearance(R.style.itemCards_tags)
                linearLayoutTagHolder.addView(tv)
            }

            for (i in 0 until projectPost[position].techStacks.size)
            {
                val tv = TextView(holder.itemView.context)
                val params = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
                params.setMargins(0,0,pixelsToDp(6,context),0)
                tv.layoutParams = params
                val tvString = projectPost[position].techStacks[i]
                tv.text = tvString
                tv.setPadding(pixelsToDp(10,context),pixelsToDp(4,context),pixelsToDp(10,context),pixelsToDp(3,context))
                tv.gravity = Gravity.CENTER
                tv.setBackgroundResource(R.drawable.project_item_cards_techstack_bg)
                tv.setTextAppearance(R.style.techStack_bg)
                linearLayoutTechStackHolder.addView(tv)
            }

        }
    }

    fun pixelsToDp(paddingValue: Int, context: Context): Int {
        val density: Float = context.resources.displayMetrics.density
        return (paddingValue * density).toInt()
    }
}