package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment_MainScreen : Fragment() {
    lateinit var chatscreen: View

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var v = inflater.inflate(R.layout.fragment_main_screen, container, false)
         v.apply {
             val appName = findViewById<TextView>(R.id.tv_AppName)
             val textGradient = listOf<TextView>(appName)
             MainActivity.textShader(textGradient)
             
             chatscreen = findViewById(R.id.btn_ChatTab)

             chatscreen.setOnClickListener() {
                 parentFragmentManager.beginTransaction().apply {
                     addToBackStack("Chat screen")
                     setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                     replace(R.id.frameLayout, Fragment_Chat_Screen()).commit()
                 }
             }
         }
         parentFragmentManager.beginTransaction().apply {
             replace(R.id.frameLayout,Fragment_Feed())
             commit()
         }

         return v
    }

}