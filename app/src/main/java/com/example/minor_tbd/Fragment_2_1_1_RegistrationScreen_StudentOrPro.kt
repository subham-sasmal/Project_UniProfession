package com.example.minor_tbd

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import soup.neumorphism.NeumorphButton

class Fragment_2_1_1_RegistrationScreen_StudentOrPro : Fragment() {

    //Variable to store TextView Objects
    lateinit var tv_HeadingARE: TextView
    lateinit var tv_btnNext: TextView
    lateinit var btn_Student: NeumorphButton
    lateinit var btn_Professional: NeumorphButton
    lateinit var btn_cancel: Button

    //Variable to store Button objects
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var checkProfessionalFragmentClicked = true
        var checkStudentFragmentClicked = true

        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_2_1_1_registration_screen_student_or_pro, container,false)
        v.apply {
            tv_HeadingARE = findViewById(R.id.tv_HeadingARE)
            tv_btnNext = findViewById(R.id.tv_btnNxt)

            val tv_gradient = mutableListOf(tv_HeadingARE,tv_btnNext) //Adding TextViews on which gradient will be applied to a list
            MainActivity.textShader(tv_gradient) //Applying gradient on TextViews present in the list. The function changing TextViews to a gradient is present in MainActivity

            btn_Student = findViewById(R.id.btn_Student)
            btn_Professional = findViewById(R.id.btn_Professional)

            //Following Buttons will execute certain actions on click.
            btn_Student.setOnClickListener {
                btn_Student.setShapeType(1) //1 stands for pressed state of the button. 0 is flat and 2 is basin
                btn_Student.setTextColor(Color.parseColor("#BDFC8A"))
                btn_Professional.setShapeType(0)
                btn_Professional.setTextColor(ContextCompat.getColor(context,R.color.bluish_white))

                //call the student editText fragment
                if(checkStudentFragmentClicked)
                {
                    parentFragmentManager.beginTransaction().apply {
                        setCustomAnimations(R.anim.slide_in_from_left,R.anim.fade_out)
                        replace(R.id.FragmentHolder_StudentOrPro, Fragment_Student_Entry_Details())
                        commit()
                    }
                    checkStudentFragmentClicked = false
                    checkProfessionalFragmentClicked = true
                }
            }

            btn_Professional.setOnClickListener {
                btn_Professional.setShapeType(1)
                btn_Professional.setTextColor(Color.parseColor("#BDFC8A"))
                btn_Student.setShapeType(0)
                btn_Student.setTextColor(ContextCompat.getColor(context,R.color.bluish_white))

                //call the professional editText fragment
                if (checkProfessionalFragmentClicked)
                {
                    parentFragmentManager.beginTransaction().apply {
                        setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out)
                        replace(R.id.FragmentHolder_StudentOrPro,Fragment_Professional_Entry_Details())
                        commit()
                    }
                    checkProfessionalFragmentClicked = false
                    checkStudentFragmentClicked = true
                }

            }

            btn_cancel = findViewById(R.id.btn_Cancel)
            btn_cancel.setOnClickListener {
                parentFragmentManager.popBackStack()
                parentFragmentManager.beginTransaction().apply {
                    remove(this@Fragment_2_1_1_RegistrationScreen_StudentOrPro)
                    commit()
                }
            }



        }
        return v
    }
}