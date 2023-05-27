package com.example.minor_tbd

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.minor_tbd.R
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(
    var chatLayout: List<ChatScreenValues>
): RecyclerView.Adapter<ChatAdapter.chatViewHolder>() {
    inner class chatViewHolder(chatItems: View): RecyclerView.ViewHolder(chatItems) {
        val profilePic = chatItems.findViewById<ShapeableImageView>(R.id.imageview_profile_photo)!!
        val contactname = chatItems.findViewById<TextView>(R.id.tv_contact_name)
        val messageContent = chatItems.findViewById<TextView>(R.id.tv_message_content)
        val dateandTime = chatItems.findViewById<TextView>(R.id.tv_time_or_date)
        val maindomain = chatItems.findViewById<TextView>(R.id.tv_main_domain)
        val studentorpro = chatItems.findViewById<TextView>(R.id.studentOrPro_Tag)
        val messagesent = chatItems.findViewById<View>(R.id.message_sent)
        val studentOrProSelectedColor = chatItems.findViewById<View>(R.id.pro_or_student_selected_color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatViewHolder {
        val chatview = LayoutInflater.from(parent.context).inflate(R.layout.individual_chat_layout, parent, false)
        return chatViewHolder(chatview)
    }

    override fun getItemCount(): Int {
        return chatLayout.size
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: chatViewHolder, position: Int) {
        holder.apply {
            val context = holder.itemView.context

            contactname.text = chatLayout[position].contactName
            messageContent.text = chatLayout[position].messageContent
            dateandTime.text = chatLayout[position].dateAndTime
            maindomain.text = chatLayout[position].mainDomain
            studentorpro.text = chatLayout[position].proOrStudent
            profilePic.setImageResource(chatLayout[position].profileImage)
            messagesent.setBackgroundResource(chatLayout[position].messageSentOrReceived)
            studentorpro.setTextColor(chatLayout[position].colorHolder)
            studentOrProSelectedColor.setBackgroundResource(chatLayout[position].colorHolder)
        }
    }
}