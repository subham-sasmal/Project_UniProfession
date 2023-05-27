package com.example.minor_tbd

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import soup.neumorphism.NeumorphButton


class Fragment_2_2_LoginPage : Fragment() {
    private lateinit var etemail_id: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: NeumorphButton

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
            btnlogin = findViewById(R.id.btn_BeginJourney)
            etemail_id = findViewById(R.id.et_login_email_id)
            etpassword = findViewById(R.id.et_password)

            btnlogin.setOnClickListener() {
                if (etemail_id.text.toString().isEmpty()) {
                    Toast.makeText(context, "Invalid email-id entered!", Toast.LENGTH_SHORT).show()
                } else if (etpassword.text.toString().isEmpty()) {
                    Toast.makeText(context, "Invalid password entered!", Toast.LENGTH_SHORT).show()
                } else {
                    parentFragmentManager.beginTransaction().apply {
                        addToBackStack("")
                        replace(R.id.FragmentHolder, Fragment_MainScreen()).commit()
                    }
                }
            }

            var tv_gradient = mutableListOf(tvLogin,tvLoginButton,tvClickHereButton)
            MainActivity.textShader(tv_gradient)
        }
        return v
    }
}