package com.example.minor_tbd

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment_2_1_RegistrationScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View =  inflater.inflate(R.layout.fragment_2_1__registration_screen, container, false)
        v.apply {
            var headingHey = findViewById<TextView>(R.id.heading_Hey)
            textShader(headingHey)

            var btn_Next_Text = findViewById<TextView>(R.id.btn_Next_Txt)
            textShader(btn_Next_Text)
        }
        return v
    }

    fun textShader(text : TextView)
    {
        val paint = text.paint
        val width = paint.measureText(text.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, text.textSize, intArrayOf(
            Color.parseColor("#9CF877"),
            Color.parseColor("#DDFF9C"),
        ), null, Shader.TileMode.REPEAT)
        text.paint.setShader(textShader)
    }
}