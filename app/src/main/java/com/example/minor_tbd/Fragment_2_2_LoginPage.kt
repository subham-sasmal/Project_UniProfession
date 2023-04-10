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


class Fragment_2_2_LoginPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v =  inflater.inflate(R.layout.fragment_2_2_login_page, container, false)
        v.apply {
            var tvLogin = findViewById<TextView>(R.id.tv_Login)
            var tvLoginButton = findViewById<TextView>(R.id.tv_loginButton)
            var tvClickHereButton = findViewById<TextView>(R.id.tv_clickHereButton)
            textShader(tvLogin)
            textShader(tvLoginButton)
            textShader(tvClickHereButton)
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