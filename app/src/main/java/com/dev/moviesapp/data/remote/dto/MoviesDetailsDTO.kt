package com.dev.moviesapp.data.remote.dto

data class MoviesDetailsDTO(
    var id : Int,
    var title : String,
    var subTitle : String,
    var image : String,
    var rating : Double,
    var synopsis : String,
    var video : String
)