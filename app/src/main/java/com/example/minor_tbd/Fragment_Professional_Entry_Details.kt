package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class Fragment_Professional_Entry_Details : Fragment() {

    lateinit var sp_spinner_domain: Spinner
    lateinit var et_CurrentCompany: EditText
    lateinit var et_Experience: EditText
    lateinit var et_PassoutYear: EditText
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        var isSpinnerSelected = false
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_professional_entry_details, container, false)
        var domain_list = mutableListOf("Domain / Field of Work","Android App Development","Artificial Intelligence","Cloud", "Data Science","DevOps","Game Development", "Data Analytics", "Machine Learning", "Natural Language Processing", "Web Development")
        v.apply {
            val adapter = SpinnerHintAdapter(context, R.layout.spinner_selected_text_bg, domain_list)
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            sp_spinner_domain = findViewById(R.id.spinner_domain)
            sp_spinner_domain.adapter = adapter

            //Listener on the spinner object to check whether any item is selected or not
            sp_spinner_domain.onItemSelectedListener = object : OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    isSpinnerSelected = true
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    isSpinnerSelected = false
                }
            }

            et_CurrentCompany = findViewById(R.id.et_currentCompany)
            et_Experience = findViewById(R.id.et_Experience)
            et_PassoutYear = findViewById(R.id.et_PassoutYear)

//            if(et_CurrentCompany.text.toString()=="")
//            {
//                Toast.makeText(context,"Enter the current company you are working at",Toast.LENGTH_SHORT).show()
//            }
//            else if(!isSpinnerSelected)
//            {
//                Toast.makeText(context,"Select the domain of your work in the company",Toast.LENGTH_SHORT).show()
//            }
//            else if(et_Experience.text.toString()=="")
//            {
//                Toast.makeText(context,"You are somewhat experienced,right?.......right??",Toast.LENGTH_SHORT).show()
//            }
//            else if(et_PassoutYear.text.toString()=="")
//            {
//                Toast.makeText(context,"Enter your year of pass-out from your college...or are you uneducated",Toast.LENGTH_SHORT).show()
//            }
//            else
//            {
//                IncompleteValue.isIncomplete = 2
//            }

        }
        return v
    }

}