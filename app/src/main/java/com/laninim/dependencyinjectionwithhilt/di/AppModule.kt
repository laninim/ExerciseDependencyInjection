package com.laninim.dependencyinjectionwithhilt.di

import com.laninim.dependencyinjectionwithhilt.data.remote.DogApi
import com.laninim.dependencyinjectionwithhilt.data.repository.MyDogRepository
import com.laninim.dependencyinjectionwithhilt.domain.repository.MyRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDogApi() : DogApi{
        return Retrofit
            .Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api : DogApi) : MyRemoteRepository {
        return MyDogRepository(api)
    }



}