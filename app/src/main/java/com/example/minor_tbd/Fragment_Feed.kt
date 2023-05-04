package com.example.minor_tbd

import android.content.Context
import android.graphics.PixelFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment_Feed : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_feed, container, false)
        v.apply {

            var tempCheckingList = mutableListOf<ProjectPost_Elements>()
            recyclerView = findViewById(R.id.RecyclerView)
            tempCheckingList.add(ProjectPost_Elements(R.drawable.profile_placeholder1,"Matt Stones","10 mins ago",0,R.drawable.placeholder_image1,"Weather Forecast App","A simple weather forecasting app that can forecast the weather for the next 5 days",
                listOf("Android App Development","Firebase"),
                listOf("Kotlin","XML","Firebase"))
            )
            tempCheckingList.add(ProjectPost_Elements(R.drawable.profile_placeholder2,"Arthur Henson","1 hr ago",0,R.drawable.placeholder_image2,"Defect Detection System","A ML project that uses openCV to detect defects in objects",
                listOf("Machine Learning","OpenCV"),
                listOf("Python","OpenCV"))
            )
            tempCheckingList.add(ProjectPost_Elements(R.drawable.profile_placeholder3,"Scott LeBlanc","8 hrs ago",0,R.drawable.placeholder_image3,"E-Commerce Website","An e-commerce website specialising in selling daily amenities and other goods",
                listOf("MERN"),
                listOf("MongoDB","Express","React","Node"))
            )
            tempCheckingList.add(ProjectPost_Elements(R.drawable.profile_placeholder4,"Kevin White","1 day ago",0,R.drawable.placeholder_image4,"Outdoor Arena","A website that searches for nearby locations for an outdoor game of any sort",
                listOf("Web Development","MongoDB"),
                listOf("HTML","CSS","Javascript","MongoDB","REST API"))
            )
            var projectItemAdapter = FeedRecyclerAdapter(tempCheckingList)
            recyclerView.adapter = projectItemAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        return v
    }




}