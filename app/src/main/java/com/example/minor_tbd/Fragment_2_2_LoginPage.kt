package com.example.minor_tbd

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

    private lateinit var tvLogin: TextView
    private lateinit var tvLoginButton: TextView
    private lateinit var tvClickHereButton: TextView
    private lateinit var neumorphbutton: NeumorphButton
    private lateinit var etemailid: EditText
    private lateinit var etpassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_2_2_login_page, container, false)
        v.apply {
            tvLogin = findViewById(R.id.tv_Login)
            tvLoginButton = findViewById(R.id.tv_loginButton)
            tvClickHereButton = findViewById(R.id.tv_clickHereButton)
            neumorphbutton = findViewById(R.id.btnLogin)
            etemailid = findViewById(R.id.et_email_id)
            etpassword = findViewById(R.id.et_password)

            var tv_gradient = mutableListOf(tvLogin, tvLoginButton, tvClickHereButton)
            MainActivity.textShader(tv_gradient)

            neumorphbutton.setOnClickListener() {
                val readEmailId = etemailid.text.toString()
                val readPassword = etpassword.text.toString()

                if (readEmailId == "") {
                    Toast.makeText(context, "Please enter a valid email-ID", Toast.LENGTH_SHORT)
                        .show()
                } else if (readPassword == "") {
                    Toast.makeText(context, "Please enter the correct password", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    parentFragmentManager.beginTransaction().apply {
                        addToBackStack("main screen loading")
                        replace(R.id.FragmentHolder, Fragment_MainScreen()).commit()
                    }
                }
            }
        }
        return v
    }
}