package com.laninim.dependencyinjectionwithhilt

import androidx.lifecycle.ViewModel
import com.laninim.dependencyinjectionwithhilt.data.repository.MyDogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val myDogRepository: MyDogRepository
) : ViewModel() {

    private var _urlImage = MutableStateFlow("")
    val urlImage = _urlImage

    fun getRandomDog(){
        CoroutineScope(Dispatchers.IO).launch{
           val result =  myDogRepository.doNetworkCall()
            _urlImage.value = result.message
        }
    }
}