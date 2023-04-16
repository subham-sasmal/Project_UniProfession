package com.example.minor_tbd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_Professional_Entry_Details : Fragment() {

    lateinit var spinner_domain: Spinner
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_professional_entry_details, container, false)
        var domain_list = mutableListOf("Android App Development","Artificial Intelligence","Cloud", "Data Science","DevOps","Game Development", "Data Analytics", "Machine Learning", "Natural Language Processing", "Web Development")
        v.apply {
            val adapter = ArrayAdapter(context,R.layout.spinner_selected_text_bg,domain_list)
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_bg)
            spinner_domain = findViewById(R.id.spinner_domain)
            spinner_domain.adapter = adapter

        }
        return v
    }
}