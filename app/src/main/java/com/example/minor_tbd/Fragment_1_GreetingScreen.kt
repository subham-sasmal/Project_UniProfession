package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import soup.neumorphism.NeumorphButton

class Fragment_1_GreetingScreen : Fragment() {

    lateinit var heading1 : TextView
    lateinit var clickRegisterNow: TextView
    lateinit var loginText: TextView
    lateinit var btnLogin: NeumorphButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View =  inflater.inflate(R.layout.fragment_1_greeting_screen, container, false)
        v.apply {

            heading1 = findViewById(R.id.headingTop_Working)
            clickRegisterNow = findViewById(R.id.tv_clickRegisterNow)
            loginText = findViewById(R.id.btnLoginText)

            var tv_gradient = mutableListOf(heading1,clickRegisterNow,loginText)
            MainActivity.textShader(tv_gradient)

            btnLogin = findViewById(R.id.btnLogin)

            btnLogin.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    addToBackStack("Login")
                    setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                    replace(R.id.FragmentHolder,Fragment_2_2_LoginPage()).commit()
                }
            }

            clickRegisterNow.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    addToBackStack("RegisterNow")
                    setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                    replace(R.id.FragmentHolder,Fragment_2_1_RegistrationScreen()).commit()
                }

            }

        }
        return v
    }

}