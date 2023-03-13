package com.laninim.dependencyinjectionwithhilt.data.repository

import com.laninim.dependencyinjectionwithhilt.data.remote.DogApi
import com.laninim.dependencyinjectionwithhilt.data.remote.dto.Dog
import com.laninim.dependencyinjectionwithhilt.domain.repository.MyRemoteRepository
import javax.inject.Inject

class MyDogRepository @Inject constructor(
    private val dogApi: DogApi
) : MyRemoteRepository {

    override suspend fun doNetworkCall(): Dog {
        return dogApi.getRandomDog()
    }
}