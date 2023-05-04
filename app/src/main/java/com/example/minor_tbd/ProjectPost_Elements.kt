package com.example.minor_tbd

import com.google.android.material.imageview.ShapeableImageView

data class ProjectPost_Elements(
    var profilePic : Int,
    var profileName : String,
    var uploadTime : String,
    var bookmarkState : Int,
    var bannerImage : Int,
    var projectTitle : String,
    var projectDescription : String,
    var tag : List<String>,
    var techStacks : List<String>
)
