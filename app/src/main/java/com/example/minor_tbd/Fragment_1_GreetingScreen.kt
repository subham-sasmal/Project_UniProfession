package com.example.minor_tbd

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Fragment_1_GreetingScreen : Fragment() {

    lateinit var login : Button
    lateinit var registerNow : TextView
    lateinit var heading1 : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View =  inflater.inflate(R.layout.fragment_1_greeting_screen, container, false)
        v.apply {
            heading1 = findViewById(R.id.headingTop_Working)
            textShader(heading1)

            var clickRegisterNow : TextView = findViewById(R.id.tv_clickRegisterNow)
            textShader(clickRegisterNow)

            var loginText: TextView = findViewById(R.id.btnLoginText)
            textShader(loginText)

            registerNow = findViewById(R.id.tv_clickRegisterNow)
            registerNow.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    addToBackStack(null)
                    setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                    add(R.id.FragmentHolder,Fragment_2_1_RegistrationScreen()).commit()
                }

            }

        }
        return v
    }

    fun textShader(txtGradient : TextView)
    {
        val paint = txtGradient.paint
        val width = paint.measureText(txtGradient.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, txtGradient.textSize, intArrayOf(
            Color.parseColor("#9CF877"),
            Color.parseColor("#DDFF9C"),
        ), null, Shader.TileMode.REPEAT)
        txtGradient.paint.setShader(textShader)
    }


}