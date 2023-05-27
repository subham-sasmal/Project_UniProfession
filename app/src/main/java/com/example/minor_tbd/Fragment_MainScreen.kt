package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment_MainScreen : Fragment() {
    private lateinit var btnchattab: View
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var v = inflater.inflate(R.layout.fragment_main_screen, container, false)
         v.apply {
             btnchattab =findViewById(R.id.btn_ChatTab)
             val appName = findViewById<TextView>(R.id.tv_AppName)

             val textGradient = listOf<TextView>(appName)
             MainActivity.textShader(textGradient)

             btnchattab.setOnClickListener() {
                 parentFragmentManager.beginTransaction().apply {
                     addToBackStack("Chat Tab")
                     replace(R.id.Fragment_NavBar_Tab_layout_holder, Fragment_Chat_Screen()).commit()
                 }
             }
         }
         parentFragmentManager.beginTransaction().apply {
             replace(R.id.Fragment_NavBar_Tab_layout_holder,Fragment_Feed())
             commit()
         }
         return v
    }

}