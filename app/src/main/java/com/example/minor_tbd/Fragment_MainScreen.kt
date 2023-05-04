package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Fragment_MainScreen : Fragment() {
    lateinit var chatscreen: View

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var v = inflater.inflate(R.layout.fragment_main_screen, container, false)

         v.apply {
             chatscreen = findViewById(R.id.btn_ChatTab)

             chatscreen.setOnClickListener() {
                 parentFragmentManager.beginTransaction().apply {
                     addToBackStack("Chat screen")
                     setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                     replace(R.id.frameLayout, Fragment_Chat_Screen()).commit()
                 }
             }
         }

         return v
    }

}