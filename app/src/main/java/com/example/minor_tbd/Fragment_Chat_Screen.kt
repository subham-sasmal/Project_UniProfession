package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minor_tbd.R

class Fragment_Chat_Screen : Fragment() {
    private lateinit var privateChatTab: TextView
    private lateinit var discussionChatTab: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment__chat__screen, container, false)

        v.apply {
            privateChatTab = findViewById(R.id.tv_private_tab)
            discussionChatTab = findViewById(R.id.tv_discussion_tab)

            parentFragmentManager.beginTransaction().apply {
//                addToBackStack("private chat screen")
                setCustomAnimations(R.anim.slide_in_from_left,R.anim.fade_in,R.anim.fade_out,R.anim.slide_out_from_right)
                replace(R.id.chat_layout_holder, Private_Chat_Screen()).commit()
            }

            privateChatTab.setBackgroundResource(R.drawable.selected_chat_tab_background)
            privateChatTab.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.raisin_black_medium
                )
            )

            privateChatTab.setOnClickListener() {
                parentFragmentManager.beginTransaction().apply {
//                    addToBackStack("private chat screen")
                    setCustomAnimations(R.anim.slide_in_from_left,R.anim.fade_in,R.anim.fade_out,R.anim.slide_out_from_right)
                    replace(R.id.chat_layout_holder, Private_Chat_Screen()).commit()
                }

                privateChatTab.setBackgroundResource(R.drawable.selected_chat_tab_background)
                privateChatTab.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.raisin_black_medium
                    )
                )

                discussionChatTab.setBackgroundResource(R.drawable.private_or_discussion_background)
                discussionChatTab.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.bluish_white
                    )
                )
            }

            discussionChatTab.setOnClickListener() {
                discussionChatTab.setBackgroundResource(R.drawable.selected_chat_tab_background)
                discussionChatTab.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.raisin_black_medium
                    )
                )

                privateChatTab.setBackgroundResource(R.drawable.private_or_discussion_background)
                privateChatTab.setTextColor(ContextCompat.getColor(context, R.color.bluish_white))
            }
        }

        return v
    }
}

