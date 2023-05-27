package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minor_tbd.R

class Private_Chat_Screen : Fragment() {
    private lateinit var chatholderlayout: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_private_chat_screen, container, false)

        v.apply {
            chatholderlayout = findViewById(R.id.rv_chat_holder)

            var chatcontentlist = mutableListOf<ChatScreenValues>()
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_mai_san,
                    "Mai Sakurajima",
                    "Ohio Konichiwa",
                    R.drawable.message_sent,
                    "9:56 pm",
                    "Game Development",
                    "Pro",
                    R.drawable.student_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_zerotwo,
                    "Zero Two",
                    "Yume-O akiramete Shinde kure",
                    R.drawable.message_read,
                    "6:30 pm",
                    "Android App Development",
                    "Student",
                    R.drawable.pro_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_faye_valentine,
                    "Feya Valentine",
                    "Mada konose kaye wa",
                    R.drawable.message_read,
                    "Yesterday",
                    "Game Development",
                    "Student",
                    R.drawable.pro_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_ichigo,
                    "Ichigo San",
                    "Ore wa ichigo ga hi",
                    R.drawable.message_sent,
                    "Yesterday",
                    "Android App Development",
                    "Student",
                    R.drawable.student_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_kaguyachan,
                    "Kaguya Chan",
                    "Maccdo-onardo Kitto-katto",
                    R.drawable.message_read,
                    "Yesterday",
                    "Web Development",
                    "Pro",
                    R.drawable.pro_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_raiden,
                    "Raiden Shogun",
                    "Ware Ware Wa Ningen Des",
                    R.drawable.message_sent,
                    "21/04/2023",
                    "Game Development",
                    "Pro",
                    R.drawable.student_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_yaemiko,
                    "Yae Miko",
                    "Ware Ware Wa Ningen Des",
                    R.drawable.message_read,
                    "21/04/2023",
                    "Game Development",
                    "Pro",
                    R.drawable.student_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_ayaka,
                    "Ayaka Chan",
                    "Ware Ware Wa Ningen Des",
                    R.drawable.message_read,
                    "16/03/2023",
                    "Android App Development",
                    "Student",
                    R.drawable.pro_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_ichinose,
                    "Ichinose San",
                    "Ware Ware Wa Ningen Des",
                    R.drawable.message_sent,
                    "11/03/2023",
                    "Game Development",
                    "Student",
                    R.drawable.pro_selected_color_scheme
                )
            )
            chatcontentlist.add(
                ChatScreenValues(
                    R.drawable.profile_pic_mitsuha,
                    "Mitsuha Chan",
                    "Ware Ware Wa Ningen Des",
                    R.drawable.message_read,
                    "04/3/2023",
                    "Android App Development",
                    "Pro",
                    R.drawable.student_selected_color_scheme
                )
            )

            val chatadapter = ChatAdapter(chatcontentlist)
            chatholderlayout.adapter = chatadapter
            chatholderlayout.layoutManager = LinearLayoutManager(context)
        }

        return v
    }
}