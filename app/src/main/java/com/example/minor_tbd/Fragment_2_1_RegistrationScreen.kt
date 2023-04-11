package com.example.minor_tbd

import android.app.FragmentManager
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
import androidx.appcompat.widget.AppCompatButton

class Fragment_2_1_RegistrationScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View =  inflater.inflate(R.layout.fragment_2_1_registration_screen, container, false)
        v.apply {
            var headingHey = findViewById<TextView>(R.id.heading_Hey)
            textShader(headingHey)

            var btn_Next_Text = findViewById<TextView>(R.id.btn_Next_Txt)
            textShader(btn_Next_Text)

            var btn_cancel = findViewById<Button>(R.id.btn_Cancel)
            btn_cancel.setOnClickListener {
                parentFragmentManager.popBackStack()
                parentFragmentManager.beginTransaction().apply {
                    remove(this@Fragment_2_1_RegistrationScreen)
                    commit()
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