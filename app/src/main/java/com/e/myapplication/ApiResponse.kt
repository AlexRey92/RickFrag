package com.e.myapplication

data class ApiResponse (
    val results:MutableList<character>

        )

data class character(
    val id: String,
    val name: String,
    val status: String,
    val species:String,
    val type:String,
    val gender: String,
    val origin:Origin,
    val location:Location,
    val image:String,
    val episode:List<String>


)

data class Origin (
    val name:String,
    val url:String

        )



class Location (
    val name: String,
    val url:String

        )




