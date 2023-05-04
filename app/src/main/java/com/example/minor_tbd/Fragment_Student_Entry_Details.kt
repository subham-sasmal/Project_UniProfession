package com.example.minor_tbd

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class Fragment_Student_Entry_Details : Fragment() {
    lateinit var sp_CoursesSpinner: Spinner
    lateinit var sp_BranchesSpinner: Spinner
    lateinit var et_RollNo: EditText
    lateinit var et_YearOfPassing: EditText
    lateinit var tv_dob: TextView

    val cal = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var isCoursesSpinnerSelected = false
        var isBranchSpinnerSelected = false
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment__student__entry__details, container, false)

        val courses_list = mutableListOf<String>("Courses" , "B.Tech/BE", "B.Sc", "BCA" , "M.Tech", "Phd")

        val branch_list = mutableListOf<String>("Branch" , "CSE", "IT", "Mechanical" , "Electrical" , "Civil")
        v.apply {

            et_RollNo = findViewById(R.id.et_student_rollno)
            et_YearOfPassing = findViewById(R.id.et_student_passingYear)
            tv_dob = findViewById(R.id.tv_student_dob)

            val coursesAdapter = SpinnerHintAdapter(context, R.layout.spinner_selected_text_bg, courses_list)
            coursesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            sp_CoursesSpinner = findViewById(R.id.spinner_student_courses)
            sp_CoursesSpinner.adapter = coursesAdapter

            val branchesAdapter = SpinnerHintAdapter(context, R.layout.spinner_selected_text_bg, branch_list)
            branchesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            sp_BranchesSpinner = findViewById(R.id.spinner_student_branch)
            sp_BranchesSpinner.adapter = branchesAdapter

            //code to show the popup calendar when clicking on the DOB section
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DATE, dayOfMonth)
                    updateDateInView()
                }

            tv_dob.setOnClickListener() {
                DatePickerDialog(context,
                    dateSetListener,
                    cal.get(Calendar.DATE),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.YEAR)).show()
            }

            sp_CoursesSpinner.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    isCoursesSpinnerSelected = true
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    isCoursesSpinnerSelected = false
                }
            }

            sp_BranchesSpinner.onItemSelectedListener = object : OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    isBranchSpinnerSelected = true
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    isBranchSpinnerSelected = false
                }
            }

//            if(!isCoursesSpinnerSelected)
//            {
//                Toast.makeText(context,"Select the course you are enrolled in",Toast.LENGTH_SHORT).show()
//            }
//            else if(!isBranchSpinnerSelected)
//            {
//                Toast.makeText(context,"Select the branch of your field of study",Toast.LENGTH_SHORT).show()
//            }
//            else if(et_RollNo.text.toString()=="")
//            {
//                Toast.makeText(context,"Enter your university roll number",Toast.LENGTH_SHORT).show()
//            }
//            else if(et_YearOfPassing.toString()=="")
//            {
//                Toast.makeText(context,"Enter the year you are expected to pass-out from your University",Toast.LENGTH_SHORT).show()
//            }
//            else if(tv_dob.toString() == "Date Of Birth")
//            {
//                Toast.makeText(context,"Enter your date of birth",Toast.LENGTH_SHORT).show()
//            }
//            else{
//                IncompleteValue.isIncomplete = 2
//            }


        }

        return v
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tv_dob.text = sdf.format(cal.getTime())
    }
}