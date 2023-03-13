package com.laninim.dependencyinjectionwithhilt.domain.repository

import com.laninim.dependencyinjectionwithhilt.data.remote.dto.Dog

interface MyRemoteRepository {

    suspend fun doNetworkCall() : Dog
}