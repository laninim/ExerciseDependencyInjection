package com.laninim.dependencyinjectionwithhilt.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)