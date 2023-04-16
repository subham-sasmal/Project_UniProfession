package com.example.minor_tbd

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.FragmentHolder, Fragment_1_GreetingScreen()).commit()
        }
    }

    companion object textView_Gradient {
        fun textShader(txtGradient: List<TextView>) {
            for (tv_gradient in txtGradient) {
                val paint = tv_gradient.paint
                val width = paint.measureText(tv_gradient.text.toString())
                val textShader: Shader = LinearGradient(
                    0f, 0f, width, tv_gradient.textSize, intArrayOf(
                        Color.parseColor("#9CF877"),
                        Color.parseColor("#DDFF9C"),
                    ), null, Shader.TileMode.REPEAT
                )
                tv_gradient.paint.setShader(textShader)
                tv_gradient.setTextColor(Color.parseColor("#9CF877"))
            }
        }
    }
}