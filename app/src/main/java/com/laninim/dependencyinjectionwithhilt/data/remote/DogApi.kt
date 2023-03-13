package com.laninim.dependencyinjectionwithhilt.data.remote

import com.laninim.dependencyinjectionwithhilt.data.remote.dto.Dog
import retrofit2.http.GET

interface DogApi  {

    @GET("api/breeds/image/random")
    suspend fun getRandomDog() : Dog

}