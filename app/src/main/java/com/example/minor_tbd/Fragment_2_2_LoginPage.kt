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

    lateinit var tvLogin: TextView
    lateinit var tvLoginButton: TextView
    lateinit var tvClickHereButton: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v =  inflater.inflate(R.layout.fragment_2_2_login_page, container, false)
        v.apply {
            tvLogin = findViewById(R.id.tv_Login)
            tvLoginButton = findViewById(R.id.tv_loginButton)
            tvClickHereButton = findViewById(R.id.tv_clickHereButton)

            var tv_gradient = mutableListOf(tvLogin,tvLoginButton,tvClickHereButton)
            MainActivity.textShader(tv_gradient)
        }
        return v
    }
}