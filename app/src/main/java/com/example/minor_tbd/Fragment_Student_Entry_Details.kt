package com.example.minor_tbd

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class Fragment_Student_Entry_Details : Fragment() {
    lateinit var coursesspinner: Spinner
    lateinit var branchesspinner: Spinner

    lateinit var dob: TextView
    lateinit var spinnerStudentCourses: Spinner

    val cal = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment__student__entry__details, container, false)

        val courses_list = mutableListOf<String>("Courses" , "B.Tech/BE", "B.Sc", "BCA" , "M.Tech", "Phd")

        val branch_list = mutableListOf<String>("Branch" , "CSE", "IT", "Mechanical" , "Electrical" , "Civil")
        v.apply {

            dob = findViewById<TextView>(R.id.tv_student_dob)
            spinnerStudentCourses = findViewById<Spinner>(R.id.spinner_student_courses)

            val coursesAdapter = SpinnerHintAdapter(context, R.layout.spinner_selected_text_bg, courses_list)
            coursesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            coursesspinner = findViewById(R.id.spinner_student_courses)
            coursesspinner.adapter = coursesAdapter

            val branchesAdapter = SpinnerHintAdapter(context, R.layout.spinner_selected_text_bg, branch_list)
            branchesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            branchesspinner = findViewById(R.id.spinner_student_branch)
            branchesspinner.adapter = branchesAdapter

            //code to show the popup calendar when clicking on the DOB section
            val dateSetListener =
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DATE, dayOfMonth)

                    updateDateInView()
                }

            dob.setOnClickListener() {
                DatePickerDialog(context,
                    dateSetListener,
                    cal.get(Calendar.DATE),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.YEAR)).show()
            }
        }

        return v
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        dob.text = sdf.format(cal.getTime())
    }
}