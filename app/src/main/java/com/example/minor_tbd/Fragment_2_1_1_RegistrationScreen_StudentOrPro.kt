package com.example.minor_tbd

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import soup.neumorphism.NeumorphButton

class Fragment_2_1_1_RegistrationScreen_StudentOrPro : Fragment() {

    //Variable to store TextView Objects
    lateinit var tv_HeadingARE: TextView
    lateinit var tv_btnNext: TextView
    lateinit var btn_Student: NeumorphButton
    lateinit var btn_Professional: NeumorphButton
    lateinit var btn_cancel: Button
    lateinit var btn_next: NeumorphButton
    lateinit var progressBar: ProgressBar
    lateinit var completionTrack: TextView

    //Variable to store Button objects
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var studentOrProClicked = 0 //Default state is 0 when neither is clicked. Value 1 denotes a student and value 2 denotes a professional
        var studentOrProScreen = 0 //This variable defines which fragment the user has selected.Student is 1 and Professional is 2. 0 is when neither of them are clicked.

        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_2_1_1_registration_screen_student_or_pro, container,false)
        v.apply {
            tv_HeadingARE = findViewById(R.id.tv_HeadingARE)
            tv_btnNext = findViewById(R.id.tv_btnNxt)

            val tv_gradient = mutableListOf(tv_HeadingARE,tv_btnNext) //Adding TextViews on which gradient will be applied to a list
            MainActivity.textShader(tv_gradient) //Applying gradient on TextViews present in the list. The function changing TextViews to a gradient is present in MainActivity

            btn_Student = findViewById(R.id.btn_Student)
            btn_Professional = findViewById(R.id.btn_Professional)
            completionTrack = findViewById(R.id.completion_percentage)
            progressBar = findViewById(R.id.progressBar)
            progressBar.max = 100

            //Following Buttons will execute certain actions on click.
            btn_Student.setOnClickListener {
                progressBar.setProgress((200/3),true)
                completionTrack.text = "2/3"
                btn_Student.setShapeType(1) //1 stands for pressed state of the button. 0 is flat and 2 is basin
                btn_Student.setTextColor(ContextCompat.getColor(context, R.color.gradient_green))
                btn_Professional.setShapeType(0)
                btn_Professional.setTextColor(ContextCompat.getColor(context,R.color.bluish_white))

                //call the student editText fragment
                if(studentOrProClicked == 0 || studentOrProClicked == 1)
                {
                    parentFragmentManager.beginTransaction().apply {
                        setCustomAnimations(R.anim.slide_in_from_left,R.anim.fade_out)
                        replace(R.id.FragmentHolder_StudentOrPro, Fragment_Student_Entry_Details())
                        commit()
                    }
                    studentOrProClicked = 2 //2 so that it registers only when professional tab is clicked again
                    studentOrProScreen = 1
                }
            }

            btn_Professional.setOnClickListener {
                progressBar.setProgress((98),true)
                completionTrack.text = "3/3..Almost Done"
                btn_Professional.setShapeType(1)
                btn_Professional.setTextColor(Color.parseColor("#BDFC8A"))
                btn_Student.setShapeType(0)
                btn_Student.setTextColor(ContextCompat.getColor(context,R.color.bluish_white))

                //call the professional editText fragment
                if (studentOrProClicked == 0 || studentOrProClicked==2)
                {
                    parentFragmentManager.beginTransaction().apply {
                        setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out)
                        replace(R.id.FragmentHolder_StudentOrPro,Fragment_Professional_Entry_Details())
                        commit()
                    }
                    studentOrProClicked = 1 //1 so that it registers only when student tab is clicked again
                    studentOrProScreen = 2
                }

            }

            btn_next = findViewById(R.id.btn_Next)
            btn_next.setOnClickListener() {
                if(studentOrProScreen==1) {
                    parentFragmentManager.beginTransaction().apply {
                        addToBackStack("Select_Interests")
                        setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                        replace(R.id.FragmentHolder, Fragment_Student_Interest()).commit()
                    }
                }
                else if(studentOrProScreen == 2)
                {
                    parentFragmentManager.beginTransaction().apply {
                        addToBackStack("Registration Complete Welcome String")
                        setCustomAnimations(R.anim.slide_in_from_right,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out_from_left)
                        replace(R.id.FragmentHolder, Fragment_RegistrationComplete_Welcome()).commit()
                    }
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

object IncompleteValue{
    var isIncomplete = 0 //0 default when both are incomplete, 1 is when student is complete and 2 is when professional is complete
}